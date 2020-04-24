package com.blove.space.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "sys_jobPo")
public class SysJobpo implements Serializable {
    /**
     * 任务Id
     */
    @Id
    @Column(name = "jobId")
    private Integer jobid;

    /**
     * bean名称
     */
    @Column(name = "beanName")
    private String beanname;

    /**
     * 方法名称
     */
    @Column(name = "methodName")
    private String methodname;

    /**
     * 方法参数
     */
    @Column(name = "methodParams")
    private String methodparams;

    /**
     * cron表达式
     */
    @Column(name = "cronExpression")
    private String cronexpression;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态（1正常 0暂停 2作废）
     */
    @Column(name = "jobStatus")
    private Byte jobstatus;

    /**
     * 创建时间
     */
    @Column(name = "createdAt")
    private Integer createdat;

    /**
     * 更新时间
     */
    @Column(name = "updatedAt")
    private Integer updatedat;

    /**
     * 获取任务Id
     *
     * @return jobId - 任务Id
     */
    public Integer getJobid() {
        return jobid;
    }

    /**
     * 设置任务Id
     *
     * @param jobid 任务Id
     */
    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    /**
     * 获取bean名称
     *
     * @return beanName - bean名称
     */
    public String getBeanname() {
        return beanname;
    }

    /**
     * 设置bean名称
     *
     * @param beanname bean名称
     */
    public void setBeanname(String beanname) {
        this.beanname = beanname;
    }

    /**
     * 获取方法名称
     *
     * @return methodName - 方法名称
     */
    public String getMethodname() {
        return methodname;
    }

    /**
     * 设置方法名称
     *
     * @param methodname 方法名称
     */
    public void setMethodname(String methodname) {
        this.methodname = methodname;
    }

    /**
     * 获取方法参数
     *
     * @return methodParams - 方法参数
     */
    public String getMethodparams() {
        return methodparams;
    }

    /**
     * 设置方法参数
     *
     * @param methodparams 方法参数
     */
    public void setMethodparams(String methodparams) {
        this.methodparams = methodparams;
    }

    /**
     * 获取cron表达式
     *
     * @return cronExpression - cron表达式
     */
    public String getCronexpression() {
        return cronexpression;
    }

    /**
     * 设置cron表达式
     *
     * @param cronexpression cron表达式
     */
    public void setCronexpression(String cronexpression) {
        this.cronexpression = cronexpression;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取状态（1正常 0暂停 2作废）
     *
     * @return jobStatus - 状态（1正常 0暂停 2作废）
     */
    public Byte getJobstatus() {
        return jobstatus;
    }

    /**
     * 设置状态（1正常 0暂停 2作废）
     *
     * @param jobstatus 状态（1正常 0暂停 2作废）
     */
    public void setJobstatus(Byte jobstatus) {
        this.jobstatus = jobstatus;
    }

    /**
     * 获取创建时间
     *
     * @return createdAt - 创建时间
     */
    public Integer getCreatedat() {
        return createdat;
    }

    /**
     * 设置创建时间
     *
     * @param createdat 创建时间
     */
    public void setCreatedat(Integer createdat) {
        this.createdat = createdat;
    }

    /**
     * 获取更新时间
     *
     * @return updatedAt - 更新时间
     */
    public Integer getUpdatedat() {
        return updatedat;
    }

    /**
     * 设置更新时间
     *
     * @param updatedat 更新时间
     */
    public void setUpdatedat(Integer updatedat) {
        this.updatedat = updatedat;
    }
}