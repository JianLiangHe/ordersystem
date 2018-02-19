package edu.ordersystem.service;

import edu.ordersystem.entity.User;

/**
 * 定义用户登陆相关业务的接口
 */
public interface ILoginService {

    User excute(User user);

}
