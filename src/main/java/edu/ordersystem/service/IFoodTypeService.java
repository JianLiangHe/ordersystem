package edu.ordersystem.service;

import edu.ordersystem.entity.FoodType;
import edu.ordersystem.util.PageBean;

/**
 * 定义食品类型相关业务的接口
 */
public interface IFoodTypeService {

    //根据name查询食品类型
    FoodType findFoodTypeByName(String name);

    //新增食品类型
    void saveFoodType(FoodType foodType);

    //分页查询食品类型
    PageBean findFoodTypeForPage(PageBean pageBean);

    //更新食品类型状态
    void updateFoodTypeStatus(int no,int statusNum);

}
