package edu.ordersystem.service.impl;

import edu.ordersystem.dao.FoodTypeDao;
import edu.ordersystem.entity.FoodType;
import edu.ordersystem.exception.UserException;
import edu.ordersystem.service.IFoodTypeService;
import edu.ordersystem.util.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理食品类型相关业务的实现类
 */
@Service("foodTypeService")
@Transactional(propagation = Propagation.REQUIRED)
public class FoodTypeServiceImpl implements IFoodTypeService {

    //声明Dao层
    @Resource
    private FoodTypeDao foodTypeDao;

    /**
     * 根据name查询食品类型
     * @param name
     * @return
     */
    @Override
    public FoodType findFoodTypeByName(String name) {
        try {
            return foodTypeDao.findFoodTypeByName(name);
        } catch (Exception e) {
            throw new UserException("没有该食品类型.");
        }
    }

    /**
     * 新增食品类型
     * @param foodType
     */
    @Override
    public void saveFoodType(FoodType foodType) {
        if(findFoodTypeByName(foodType.getName())!=null){
            throw new UserException("该食品类型已存在.");
        }
        foodTypeDao.saveFoodType(foodType);
    }

    /**
     * 分页查询食品类型
     * @param pageBean
     * @return
     */
    @Override
    public PageBean findFoodTypeForPage(PageBean pageBean) {
        Map map = new HashMap();
        map.put("pageBean",pageBean);
        pageBean.setTotalCount(foodTypeDao.findFoodTypeByCount());
        pageBean.setResult(foodTypeDao.findFoodTypeForPage(map));
        return pageBean;
    }

    @Override
    public void updateFoodTypeStatus(int no, int statusNum) {
        try {
            Map map = new HashMap();
            map.put("no",no);
            map.put("statusNum",statusNum);
            foodTypeDao.updateFoodTypeStatus(map);
        } catch (Exception e) {
            throw new UserException("更新食品类型状态失败.");
        }
    }

    public void setFoodTypeDao(FoodTypeDao foodTypeDao) {
        this.foodTypeDao = foodTypeDao;
    }
}
