package edu.ordersystem.dao;

import edu.ordersystem.entity.User;
import edu.ordersystem.util.PageBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserDao {

    /**
     * 根据用户工号查询
     * @param account
     * @return
     */
    @ResultMap("edu.ordersystem.dao.UserDao.userMap")
    @Select("SELECT * FROM ordersystem_user WHERE user_account=#{account}")
    List<User> findUserByAccount(String account);

    /**
     * 新增用户
     * @param user
     */
    @Insert("INSERT INTO ordersystem_user(user_account,user_password,user_privilege,user_createtime,user_status)" +
            " VALUES(#{account},#{password},#{privilege},#{createtime},#{status})")
    void saveUser(User user);

    //分页带条件查询用户
    @ResultMap("edu.ordersystem.dao.UserDao.userMap")
    @Select("SELECT * FROM ordersystem_user LIMIT #{pageBean.startIndex},#{pageBean.pageSize}")
    List<User> findUserForPage(Map map);

    //分页带条件查询用户总条数
    @Select("SELECT COUNT(*) FROM ordersystem_user")
    int findUserForPageByCount(Map map);

}
