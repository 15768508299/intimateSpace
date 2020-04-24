package com.blove.space.controller;

import com.blove.space.redis.RedisUtil;
import com.blove.space.service.JobPoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    JobPoService jobPoService;

    @Autowired
    RedisUtil redisUtil;



    private static final String lootKey = "key_lootNum";

    private int timeout = 30 * 1000;




    @RequestMapping("/")
    public ModelAndView showHome(){
        boolean booleanState = redisUtil.set("key_show", "测试地址");
        Object key_show = redisUtil.get("key_show");
        System.out.println(String.format("存储结果:%s,获取的值:%s",booleanState,String.valueOf(key_show)) );
        return new ModelAndView("client/login/login");
    }

    @RequestMapping("login")
    public ModelAndView goLogin(){
        System.out.println("-------------");
        return new ModelAndView("client/login/login");
    }

    @RequestMapping("index")
    public ModelAndView goindex(ModelMap map){
        map.put("dayNum","23");
//        SysJobpo jobpo = new SysJobpo();
//        jobpo.setBeanname("taskDemo");
//        jobpo.setMethodname("taskWithParams");
//        jobpo.setMethodparams("66666");
//        jobpo.setCronexpression("*/10 * * * * ?");
//        jobpo.setCreatedat(DateUtil.currentTime());
//        jobpo.setUpdatedat(0);
//        jobpo.setJobstatus((byte)SysJobStatus.NORMAL.ordinal());
//        jobPoService.insertJop(jobpo);
        return new ModelAndView("client/home");
    }

    @RequestMapping("/loot")
    @ResponseBody
    public List<String> lootInfo(){
        List<String> lootOkUser = new ArrayList<>();
        boolean booleanState = redisUtil.set(lootKey, 10);
        if (booleanState){

            //构造很多用户
            List<String> users = new ArrayList<>();
            IntStream.range(0, 100000).parallel().forEach(b -> {
                users.add("神牛-" + b);
            });

            //模拟开抢
            users.parallelStream().forEach(b -> {
                String shopUser = qiang(b);
                if (!StringUtils.isEmpty(shopUser)) {
                    lootOkUser.add(shopUser);
                }
            });
        }
        return lootOkUser;
    }


    /**
     * 模拟抢单动作
     *
     * @param b
     * @return
     */
    private String qiang(String b) {
        //用户开抢时间
        long startTime = System.currentTimeMillis();

        //未抢到的情况下，30秒内继续获取锁
        while ((startTime + timeout) >= System.currentTimeMillis()) {
            //商品是否剩余
            int nKuCuen = Integer.valueOf(String.valueOf(redisUtil.get(lootKey)));
            if (nKuCuen <= 0) {
                break;
            }
            if (redisUtil.setnx(lootKey, b)) {
                //用户b拿到锁
//                logger.info("用户{}拿到锁...", b);
                System.out.println("用户{}拿到锁..." + b);
                try {
                    //商品是否剩余
                    if (nKuCuen <= 0) {
                        break;
                    }

                    //模拟生成订单耗时操作，方便查看：神牛-50 多次获取锁记录
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //抢购成功，商品递减，记录用户
//                    nKuCuen -= 1;
                    long num = redisUtil.decr(lootKey,1);
                    System.out.println("递减后返回的值:" + num);
                    //抢单成功跳出
                    System.out.println(String.format("用户%s抢单成功跳出...所剩库存：%s", b, redisUtil.get(lootKey)));

                    return b + "抢单成功，所剩库存：" + nKuCuen;
                } finally {
                    System.out.println(String.format("用户%s释放锁...", b));
                    //释放锁
                    redisUtil.delnx(lootKey, b);
                }
            } else {
                //用户b没拿到锁，在超时范围内继续请求锁，不需要处理
//                if (b.equals("神牛-50") || b.equals("神牛-69")) {
//                    logger.info("用户{}等待获取锁...", b);
//                }
            }
        }
        return "";
    }
}
