package edu.ordersystem.entity;

import java.io.Serializable;

/**
 * 封装食品类型的实体类
 */
public class FoodType implements Serializable {

    private int no;//编号
    private String name;//名称
    private String createtime;//创建时间
    private int status = 1;//状态 1:启用 0:禁用

    public FoodType() {
    }

    public FoodType(int no, String name, String createtime, int status) {
        this.no = no;
        this.name = name;
        this.createtime = createtime;
        this.status = status;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
