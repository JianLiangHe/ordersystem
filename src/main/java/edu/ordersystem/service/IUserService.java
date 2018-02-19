package edu.ordersystem.service;

import edu.ordersystem.entity.User;
import edu.ordersystem.util.PageBean;

import java.util.List;

/**
 * 定义用户相关业务的接口
 */
public interface IUserService {

    //新增用户
    void saveUser(User user);

    //根据工号查询用户
    User findUserByAccount(String account);

    //分页带条件查询用户
    PageBean findUserForPage(PageBean pageBean,String[] querys);

}
