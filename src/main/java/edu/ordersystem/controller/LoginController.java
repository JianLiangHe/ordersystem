package edu.ordersystem.controller;

import edu.ordersystem.entity.User;
import edu.ordersystem.exception.LoginException;
import edu.ordersystem.service.ILoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 处理登陆的控制层
 */
@Controller
@RequestMapping("/loginController")
public class LoginController {

    //声明业务层
    @Resource
    private ILoginService loginService;

    @RequestMapping("/doLogin")
    public String doLogin(User user, HttpSession session ,Model model){
        try {
            user = loginService.excute(user);
            session.setAttribute("loginUser",user);
        } catch (LoginException e) {
            System.out.println("login :"+e.getMessage());
            model.addAttribute("message",e.getMessage());
            return "redirect:/login.jsp";
        }
        System.out.println("index");
        return "redirect:/index.jsp";
    }

    public void setLoginService(ILoginService loginService) {
        this.loginService = loginService;
    }
}
