package edu.ordersystem.dao;

import edu.ordersystem.entity.FoodType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * 处理食品类型相关数据操作的Dao
 */
public interface FoodTypeDao {

    /**
     * 根据名称查询食品
     * @param name
     * @return
     */
    @ResultMap("edu.ordersystem.dao.FoodTypeDao.foodTypeMap")
    @Select("SELECT * FROM ordersystem_foodtype WHERE foodtype_name=#{name}")
    FoodType findFoodTypeByName(String name);

    /**
     * 新增食品类型
     * @param foodType
     */
    @Insert("INSERT INTO ordersystem_foodtype(foodtype_name,foodtype_createtime,foodtype_status)" +
            " VALUES(#{name},#{createtime},#{status})")
    void saveFoodType(FoodType foodType);

    /**
     * 分页查询食品类型
     * @param map
     * @return
     */
    @ResultMap("edu.ordersystem.dao.FoodTypeDao.foodTypeMap")
    @Select("SELECT * FROM ordersystem_foodtype LIMIT #{pageBean.startIndex},#{pageBean.pageSize}")
    List<FoodType> findFoodTypeForPage(Map map);

    /**
     * 查询食品类型的总数
     * @return
     */
    @Select("SELECT COUNT(*) FROM ordersystem_foodtype")
    int findFoodTypeByCount();

    /**
     * 更新食品类型状态
     * @param map
     */
    @Update("UPDATE ordersystem_foodtype set foodtype_status=#{statusNum} WHERE foodtype_no=#{no}")
    void updateFoodTypeStatus(Map map);
}
