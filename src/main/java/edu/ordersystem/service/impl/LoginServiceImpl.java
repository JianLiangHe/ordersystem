package edu.ordersystem.service.impl;

import edu.ordersystem.dao.UserDao;
import edu.ordersystem.entity.User;
import edu.ordersystem.exception.LoginException;
import edu.ordersystem.service.ILoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理用户登陆相关业务的实现类
 */
@Service("loginService")
@Transactional(propagation = Propagation.REQUIRED)
public class LoginServiceImpl implements ILoginService {

    //声明Dao层
    @Resource
    private UserDao userDao;

    @Override
    public User excute(User user) {
        return findUser(user);
    }

    /**
     * 查询用户
     * @param user
     * @return
     */
    private User findUser(User user){
        List<User> list = userDao.findUserByAccount(user.getAccount());
        for(User u:list){
            //验证用户信息
            return checkUser(user,u);
        }
        throw new LoginException("工号和密码不正确.");
    }

    /**
     * 验证用户信息
     * @param oldUser
     * @param newUser
     * @return
     */
    private User checkUser(User oldUser,User newUser){
        if(newUser.getPassword().equals(oldUser.getPassword())){
            if(newUser.getStatus()==1){
               return newUser;
            }
            throw new LoginException("该工号已被停用.");
        }else{
            throw new LoginException("工号和密码不正确.");
        }
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
