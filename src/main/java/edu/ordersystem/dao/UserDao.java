package edu.ordersystem.dao;

import edu.ordersystem.entity.User;
import edu.ordersystem.util.PageBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * 处理用户相关数据操作的Dao
 */
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
    /*@Select("SELECT * FROM ordersystem_user" +
            " WHERE 1=1" +
            " AND user_account LIKE '%#{account}%'" +
            " LIMIT #{pageBean.startIndex},#{pageBean.pageSize}")*/
    @Select("SELECT * FROM ordersystem_user LIMIT #{pageBean.startIndex},#{pageBean.pageSize}")
    List<User> findUserForPage(Map map);

    //分页带条件查询用户总条数
    /*@Select("SELECT COUNT(*) FROM" +
            " WHERE 1=1" +
            " AND user_account LIKE '%#{account}%'" +
            " ordersystem_user")*/
    @Select("SELECT COUNT(*) FROM ordersystem_user")
    int findUserForPageByCount(Map map);

    //根据no查询用户
    @ResultMap("edu.ordersystem.dao.UserDao.userMap")
    @Select("SELECT * FROM ordersystem_user WHERE user_no=#{no}")
    User findUserByNo(int no);

    @Update("UPDATE ordersystem_user SET user_account=#{account},user_password=#{password}," +
            "user_privilege=#{privilege},user_createtime=#{createtime},user_status=#{status}" +
            " WHERE user_no=#{no}")
    void updateUser(User user);
}
