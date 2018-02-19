package edu.ordersystem.entity;

import java.io.Serializable;

/**
 * 封装用户信息的实体类
 */
public class User implements Serializable {

    private int no;//编号
    private String account;//工号
    private String password;//密码
    private int privilege = 0;//权限 0:普通员工 1:经理 2:超级管理员
    private String createtime;//创建时间
    private int status = 1;//状态 0:禁用 1:启用

    public User() {

    }

    public User(int no, String account, String password, int privilege, String createtime, int status) {
        this.no = no;
        this.account = account;
        this.password = password;
        this.privilege = privilege;
        this.createtime = createtime;
        this.status = status;
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

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
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
}
