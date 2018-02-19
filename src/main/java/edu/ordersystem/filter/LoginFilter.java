package edu.ordersystem.filter;

import edu.ordersystem.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登陆过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    //允许不用过滤的地址
    private String allowUrl = "/login.jsp,/loginController/doLogin";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //类型转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取访问路径
        String requestPath = request.getServletPath();

        //过滤
        if(allowUrl.indexOf(requestPath)>=0||requestPath.endsWith(".css")||requestPath.endsWith(".js")||requestPath.endsWith(".jpg")||requestPath.endsWith(".png")){
            //放行
            filterChain.doFilter(request,response);
        }else{
            //获取登陆用户
            User user = (User) request.getSession().getAttribute("loginUser");
            //判断用户是否已登陆
            if(user==null){
                PrintWriter out = response.getWriter();
                String url = request.getContextPath()+"/login.jsp";
                out.println("<script>location.href='"+url+"';</script>");
                out.close();
            }
            //放行
            filterChain.doFilter(request,response);
        }
        return;
    }

    @Override
    public void destroy() {

    }
}
