package com.blove.space.model;

import javax.persistence.*;

@Table(name = "space_user")
public class SpaceUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nikename;

    /**
     * 性别
     */
    private String gender;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 头像路径
     */
    @Column(name = "imgUrl")
    private String imgurl;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 是否禁用(0：禁用，1：可用)
     */
    private Byte useable;

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
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取昵称
     *
     * @return nikename - 昵称
     */
    public String getNikename() {
        return nikename;
    }

    /**
     * 设置昵称
     *
     * @param nikename 昵称
     */
    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取头像路径
     *
     * @return imgUrl - 头像路径
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * 设置头像路径
     *
     * @param imgurl 头像路径
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    /**
     * 获取电话号码
     *
     * @return phone - 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取是否禁用(0：禁用，1：可用)
     *
     * @return useable - 是否禁用(0：禁用，1：可用)
     */
    public Byte getUseable() {
        return useable;
    }

    /**
     * 设置是否禁用(0：禁用，1：可用)
     *
     * @param useable 是否禁用(0：禁用，1：可用)
     */
    public void setUseable(Byte useable) {
        this.useable = useable;
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