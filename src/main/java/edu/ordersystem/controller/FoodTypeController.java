package edu.ordersystem.controller;

import edu.ordersystem.dto.ValueDto;
import edu.ordersystem.entity.FoodType;
import edu.ordersystem.exception.UserException;
import edu.ordersystem.service.IFoodTypeService;
import edu.ordersystem.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 处理食品类型请求的控制器
 */
@Controller
@RequestMapping("/foodTypeController")
public class FoodTypeController {

    //声明业务层
    @Resource
    private IFoodTypeService foodTypeService;

    /**
     * 处理新增食品类型的请求
     * @param foodType
     * @return
     */
    @ResponseBody
    @RequestMapping("/doSaveFoodType")
    public ValueDto doSaveFoodType(FoodType foodType){
        ValueDto dto = new ValueDto();
        try {
            foodTypeService.saveFoodType(foodType);
            dto.setMessage("新增食品类型成功.");
        } catch (UserException e) {
            dto.setCode(400);
            dto.setMessage(e.getMessage());
        } finally {
            return dto;
        }
    }

    /**
     * 处理分页查询食品类型的请求
     * @param pageBean
     * @return
     */
    @ResponseBody
    @RequestMapping("/doFindFoodTypeForPage")
    public PageBean doFindFoodTypeForPage(PageBean pageBean){
        return foodTypeService.findFoodTypeForPage(pageBean);
    }

    public void setFoodTypeService(IFoodTypeService foodTypeService) {
        this.foodTypeService = foodTypeService;
    }
}
