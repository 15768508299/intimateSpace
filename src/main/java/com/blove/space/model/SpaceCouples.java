package com.blove.space.model;

import javax.persistence.*;

@Table(name = "space_couples")
public class SpaceCouples {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 男性Id
     */
    private Integer boyfriend;

    /**
     * 女性Id
     */
    private Integer girlfriend;

    /**
     * 两人相遇时间
     */
    @Column(name = "knowTheTime")
    private Integer knowthetime;

    /**
     * 两人相知时间
     */
    @Column(name = "togetherTime")
    private Integer togethertime;

    /**
     * 是否逻辑删除(0：否，1：是)
     */
    @Column(name = "isLogicDel")
    private Boolean islogicdel;

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
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取男性Id
     *
     * @return boyfriend - 男性Id
     */
    public Integer getBoyfriend() {
        return boyfriend;
    }

    /**
     * 设置男性Id
     *
     * @param boyfriend 男性Id
     */
    public void setBoyfriend(Integer boyfriend) {
        this.boyfriend = boyfriend;
    }

    /**
     * 获取女性Id
     *
     * @return girlfriend - 女性Id
     */
    public Integer getGirlfriend() {
        return girlfriend;
    }

    /**
     * 设置女性Id
     *
     * @param girlfriend 女性Id
     */
    public void setGirlfriend(Integer girlfriend) {
        this.girlfriend = girlfriend;
    }

    /**
     * 获取两人相遇时间
     *
     * @return knowTheTime - 两人相遇时间
     */
    public Integer getKnowthetime() {
        return knowthetime;
    }

    /**
     * 设置两人相遇时间
     *
     * @param knowthetime 两人相遇时间
     */
    public void setKnowthetime(Integer knowthetime) {
        this.knowthetime = knowthetime;
    }

    /**
     * 获取两人相知时间
     *
     * @return togetherTime - 两人相知时间
     */
    public Integer getTogethertime() {
        return togethertime;
    }

    /**
     * 设置两人相知时间
     *
     * @param togethertime 两人相知时间
     */
    public void setTogethertime(Integer togethertime) {
        this.togethertime = togethertime;
    }

    /**
     * 获取是否逻辑删除(0：否，1：是)
     *
     * @return isLogicDel - 是否逻辑删除(0：否，1：是)
     */
    public Boolean getIslogicdel() {
        return islogicdel;
    }

    /**
     * 设置是否逻辑删除(0：否，1：是)
     *
     * @param islogicdel 是否逻辑删除(0：否，1：是)
     */
    public void setIslogicdel(Boolean islogicdel) {
        this.islogicdel = islogicdel;
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