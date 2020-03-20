package com.blove.space.scheduler;

import com.blove.space.common.SysJobStatus;
import com.blove.space.model.SysJobpo;
import com.blove.space.service.JobPoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class SysJobRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SysJobRunner.class);

    @Autowired
    private JobPoService sysJobRepository;

    @Autowired
    private CronTaskRegistrar cronTaskRegistrar;

    @Override
    public void run(String... args) throws Exception {
        // 初始加载数据库里状态为正常的定时任务
        List<SysJobpo> jobList = sysJobRepository.getSysJobListByStatus(SysJobStatus.NORMAL.ordinal());
        if (!CollectionUtils.isEmpty(jobList)) {
            for (SysJobpo job : jobList) {
                SchedulingRunnable task = new SchedulingRunnable(job.getBeanname(), job.getMethodname(), job.getMethodparams());
                cronTaskRegistrar.addCronTask(task, job.getCronexpression());
            }
            logger.info("定时任务已加载完毕...");
        }
    }
}
