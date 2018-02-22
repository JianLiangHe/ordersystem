package edu.ordersystem.validation;

import edu.ordersystem.entity.VIPCard;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 新增VIPCard的验证器
 */
public class SaveVIPCardValidation implements Validator {

    //手机号码验证规则
    private String telReg = "[1][34578]\\d{9}";
    //邮箱验证规则
    private String emailReg = "[a-zA-Z0-9]{0,10}@((qq)|(163))\\.((com)|(net)|(cn))";

    //是否验证VIPCard类型
    @Override
    public boolean supports(Class<?> aClass) {
        return VIPCard.class.equals(aClass);
    }

    //验证方法
    @Override
    public void validate(Object o, Errors errors) {
        //类型强转
        if(o!=null){
            VIPCard card = (VIPCard) o;
            validateInfo(errors, card);
        }
    }

    //验证信息
    private void validateInfo(Errors errors, VIPCard card) {
        //账号
        if(card.getAccount()==null||card.getAccount().length()<6||card.getAccount().length()>12){
            errors.rejectValue("account",null,"账号长度6-12范围间.");
        }
        //密码
        if(card.getPassword()==null||card.getPassword().length()<6||card.getPassword().length()>12){
            errors.rejectValue("password",null,"密码长度6-12范围间.");
        }
        //手机号码
        if(!card.getTel().matches(telReg)){
            errors.rejectValue("tel",null,"手机号码不正确.");
        }
        //电子邮箱
        if(!card.getEmail().matches(emailReg)){
            errors.rejectValue("email",null,"邮箱地址不正确.");
        }
        //创建时间
        if(card.getCreatetime().length()<=0){
            errors.rejectValue("createtime",null,"创建时间不能为空.");
        }
    }

}
