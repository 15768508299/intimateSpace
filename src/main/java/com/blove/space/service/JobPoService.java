package com.blove.space.service;

import com.blove.space.common.SysJobStatus;
import com.blove.space.mapper.SysJobpoMapper;
import com.blove.space.model.SysJobpo;
import com.blove.space.scheduler.CronTaskRegistrar;
import com.blove.space.scheduler.SchedulingRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class JobPoService {

    @Autowired
    private SysJobpoMapper jobpoMapper;

    @Autowired
    private CronTaskRegistrar cronTaskRegistrar;

    public Integer insertJop(SysJobpo sysJob){
        int insert = this.jobpoMapper.insert(sysJob);
        if (insert == 0){
            System.out.println("定时任务新增失败");
            return insert;
        }else {
            if (sysJob.getJobstatus().equals((byte)SysJobStatus.NORMAL.ordinal())) {
                SchedulingRunnable task = new SchedulingRunnable(sysJob.getBeanname(), sysJob.getMethodname(), sysJob.getMethodparams());
                cronTaskRegistrar.addCronTask(task, sysJob.getCronexpression());
            }
        }
        return insert;
    }

    public Integer updateJop(SysJobpo sysJob){
        Example example = new Example(SysJobpo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("jobid",sysJob.getJobid());
        SysJobpo existedSysJob = jobpoMapper.selectByPrimaryKey(example);
        int insert = jobpoMapper.updateByPrimaryKey(sysJob);
        if (insert == 0)
            return insert;
        else {
            //先移除再添加
            if (existedSysJob.getJobstatus().equals((byte)SysJobStatus.NORMAL.ordinal())) {
                SchedulingRunnable task = new SchedulingRunnable(existedSysJob.getBeanname(), existedSysJob.getMethodname(), existedSysJob.getMethodparams());
                cronTaskRegistrar.removeCronTask(task);
            }

            if (sysJob.getJobstatus().equals((byte)SysJobStatus.NORMAL.ordinal())) {
                SchedulingRunnable task = new SchedulingRunnable(sysJob.getBeanname(), sysJob.getMethodname(), sysJob.getMethodparams());
                cronTaskRegistrar.addCronTask(task, sysJob.getCronexpression());
            }
        }
        return insert;
    }

    public Integer deleteJop(SysJobpo sysJobpo){
        Byte statu = sysJobpo.getJobstatus();
        sysJobpo.setJobstatus((byte)SysJobStatus.CANCELLATION.ordinal());
        int i = jobpoMapper.updateByPrimaryKey(sysJobpo);
        if (i == 0){
            //删除失败
        }else{
            //先移除再添加
            if (statu.equals((byte)SysJobStatus.NORMAL.ordinal())) {
                SchedulingRunnable task = new SchedulingRunnable(sysJobpo.getBeanname(), sysJobpo.getMethodname(), sysJobpo.getMethodparams());
                cronTaskRegistrar.removeCronTask(task);
            }
        }
        return i;
    }


    public List<SysJobpo> getSysJobListByStatus(int ordinal) {
        Example example = new Example(SysJobpo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("jobstatus",ordinal);
        return jobpoMapper.selectByExample(example);
    }
}
