package edu.ordersystem.controller;

import edu.ordersystem.dto.ValueDto;
import edu.ordersystem.entity.User;
import edu.ordersystem.exception.UserException;
import edu.ordersystem.service.IUserService;
import edu.ordersystem.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 处理用户相关请求的控制层
 */
@Controller
@RequestMapping("/userController")
public class UserController {

    //声明业务层
    @Resource
    private IUserService userService;

    /**
     * 处理新增用户的请求
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/doSaveUser")
    public ValueDto doSaveUser(User user){
        ValueDto dto = new ValueDto();
        try {
            userService.saveUser(user);
        } catch (UserException e) {
            System.out.println(e.getMessage());
            dto.setCode(400);
            dto.setMessage(e.getMessage());
        } finally {
            return dto;
        }
    }

    /**
     * 处理分页带条件查询用户
     * @param pageBean
     * @param querys
     * @return
     */
    @ResponseBody
    @RequestMapping("/doFindUserForPage")
    public PageBean doFindUserForPage(PageBean pageBean,String[] querys){
        pageBean = userService.findUserForPage(pageBean,querys);
        return pageBean;
    }

    /**
     * 处理查询用户详细信息
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/doFindUserInfo")
    public ValueDto doFindUserInfo(User user){
        ValueDto dto = new ValueDto();
        try {
            user = userService.findUserByNo(user.getNo());
            dto.setValue(user);
        } catch (UserException e) {
            dto.setCode(400);
            dto.setMessage(e.getMessage());
        } finally {
            return dto;
        }
    }

    /**
     * 处理更新用户信息
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/doUpdateUser")
    public ValueDto doUpdateUser(User user){
        ValueDto dto = new ValueDto();
        try {
            userService.updateUser(user);
            dto.setMessage("更新用户成功.");
        } catch (UserException e) {
            dto.setCode(400);
            dto.setMessage(e.getMessage());
        } finally {
            return dto;
        }
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
