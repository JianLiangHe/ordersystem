package edu.ordersystem.entity;

import java.io.Serializable;

/**
 * 封装VIP卡信息的实体类
 */
public class VIPCard implements Serializable {

    private int no;//编号
    private String account;//账号
    private String password;//密码
    private double integral = 0;//积分
    private int useCount = 0;//使用总次数
    private String createtime;//创建时间
    private int status = 1;//状态 1:启用 0:禁用
    private String tel;//电话号码
    private String email;//邮箱

    public VIPCard() {
    }

    public VIPCard(int no, String account, String password, double integral, int useCount, String createtime, int status, String tel, String email) {
        this.no = no;
        this.account = account;
        this.password = password;
        this.integral = integral;
        this.useCount = useCount;
        this.createtime = createtime;
        this.status = status;
        this.tel = tel;
        this.email = email;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getIntegral() {
        return integral;
    }

    public void setIntegral(double integral) {
        this.integral = integral;
    }

    public int getUseCount() {
        return useCount;
    }

    public void setUseCount(int useCount) {
        this.useCount = useCount;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

