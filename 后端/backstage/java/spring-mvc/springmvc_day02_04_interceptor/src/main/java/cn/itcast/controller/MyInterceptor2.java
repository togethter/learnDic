package cn.itcast.controller;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor2 implements HandlerInterceptor {

    /**
     * 预处理，controller方法执行前
     * return true 放行，执行下一个拦截器，如果没有，执行controller中的方法
     * return fasle 不放行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor执行了...前2222");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        return true;
    }

    /**
     * 后处理方法，controller方法执行后，success.jsp执行之前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor执行了...后2222");
        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
    }

    /**
     * success.jsp页面执行后，该方法会执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("MyInterceptor执行了...最后2222");
    }
}
