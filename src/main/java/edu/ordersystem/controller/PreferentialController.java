package edu.ordersystem.controller;

import edu.ordersystem.dto.ValueDto;
import edu.ordersystem.entity.VIPCard;
import edu.ordersystem.exception.UserException;
import edu.ordersystem.service.IVIPCardService;
import edu.ordersystem.validation.SaveVIPCardValidation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理优惠相关请求的控制器
 */
@Controller
@RequestMapping("/preferentialController")
public class PreferentialController {

    //声明业务层
    @Resource
    private IVIPCardService vipCardService;

    /**
     * 初始化绑定验证
     * @param binder
     */
    @InitBinder
    private void initBind(DataBinder binder){
        //为当前控制器绑定一个新增VIPCard验证器
        binder.addValidators(new SaveVIPCardValidation());
    }

    /**
     * 处理新增VIPCard的请求
     * @param card
     * @return
     */
    @ResponseBody
    @RequestMapping("/doSaveVIPCard")
    public ValueDto doSaveVIPCard(@Validated VIPCard card, BindingResult result){
        ValueDto dto = new ValueDto();
        try {
            //如果验证有错误
            if(result.hasErrors()){
                //获取错误信息
                List list = result.getAllErrors();
                dto.setMessage("error.");
                dto.setCode(401);
                dto.setValue(list);
                return dto;
            }
            //新增VIPCard
            vipCardService.saveVIPCard(card);
            dto.setMessage("新增VIPCard成功.");
        } catch (UserException e) {
            dto.setCode(400);
            dto.setMessage(e.getMessage());
        } finally {
            return dto;
        }
    }

    public void setVipCardService(IVIPCardService vipCardService) {
        this.vipCardService = vipCardService;
    }
}
