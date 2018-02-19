package edu.ordersystem.test;

import edu.ordersystem.entity.User;
import edu.ordersystem.service.ILoginService;
import edu.ordersystem.service.impl.LoginServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;

public class TestLogin extends TestCase {

    @Test
    public void testLogin(){
        User user = new User();
        user.setAccount("admins");
        ILoginService loginService = new LoginServiceImpl();
        loginService.excute(user);
    }

}
