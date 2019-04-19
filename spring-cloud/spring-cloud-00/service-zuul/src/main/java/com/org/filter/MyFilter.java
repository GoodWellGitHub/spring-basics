package com.org.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class MyFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        /**
         * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
         * pre：路由之前
         * routing：路由之时
         * post： 路由之后
         * error：发送错误调用
         */
        return "pre";
    }

    @Override
    public int filterOrder() {
        /**
         * filterOrder：过滤的顺序
         */
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        /**
         * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤
         */
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest servletRequest = requestContext.getRequest();
        logger.info(String.format("%s >>> %s", servletRequest.getMethod(), servletRequest.getRequestURI()));
        Object accessToken = servletRequest.getParameter("token");
        if (accessToken == null) {
            logger.warn("token is Empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("token is Empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
