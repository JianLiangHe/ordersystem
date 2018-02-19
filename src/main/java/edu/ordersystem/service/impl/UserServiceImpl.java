package edu.ordersystem.service.impl;

import edu.ordersystem.dao.UserDao;
import edu.ordersystem.entity.User;
import edu.ordersystem.exception.UserException;
import edu.ordersystem.service.IUserService;
import edu.ordersystem.util.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理用户相关业务的实现类
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements IUserService {

    //声明Dao层
    @Resource
    private UserDao userDao;

    /**
     * 新增用户
     * @param user
     */
    @Override
    public void saveUser(User user) {
        if(findUserByAccount(user.getAccount())!=null){
           throw new UserException("该工号已存在.");
        }
        userDao.saveUser(user);
    }

    /**
     * 根据工号查询用户
     * @param account
     * @return
     */
    @Override
    public User findUserByAccount(String account) {
        List<User> list = userDao.findUserByAccount(account);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    /**
     * 分页带条件查询用户
     * @param pageBean
     * @param querys
     * @return
     */
    @Override
    public PageBean findUserForPage(PageBean pageBean, String[] querys) {
        Map map = new HashMap();
        map.put("pageBean",pageBean);
        /*if(querys!=null&&querys.length>0){
            if(querys[0]!=null){
                map.put("account",querys[0]);
            }
            if(querys[1]!=null){
                map.put("privilege",querys[1]);
            }
            if(querys[2]!=null){
                map.put("createtime",querys[2]);
            }
            if(querys[3]!=null){
                map.put("status",querys[3]);
            }
        }*/
        pageBean.setTotalCount(userDao.findUserForPageByCount(map));
        pageBean.setResult(userDao.findUserForPage(map));
        return pageBean;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
