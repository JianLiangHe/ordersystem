package edu.ordersystem.dao;

import edu.ordersystem.entity.VIPCard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * 处理VIPCard相关数据操作的Dao
 */
public interface VIPCardDao {

    /**
     * 新增VIPCard
     * @param card
     */
    @Insert("INSERT INTO ordersystem_vipcard(vipcard_account,vipcard_password,vipcard_integral,vipcard_usecount,vipcard_createtime,vipcard_status,vipcard_tel,vipcard_email)" +
            " VALUES(#{account},#{password},#{integral},#{useCount},#{createtime},#{status},#{tel},#{email})")
    void saveVIPCard(VIPCard card) throws RuntimeException;

    /**
     * 根据账号查询VIPCard
     * @param account
     * @return
     */
    @ResultMap("edu.ordersystem.dao.VIPCardDao.vipCardMap")
    @Select("SELECT * FROM ordersystem_vipcard WHERE vipcard_account=#{account}")
    VIPCard findVIPCardByAccount(String account);

}
