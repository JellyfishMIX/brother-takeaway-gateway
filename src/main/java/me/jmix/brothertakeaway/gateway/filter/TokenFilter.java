package me.jmix.brothertakeaway.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author JellyfishMIX
 * @date 2020/7/18 23:12
 */
@Component
public class TokenFilter extends ZuulFilter {
    /**
     * filter的类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * filter的排序，数值越小越靠前
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    /**
     * 是否开启filter
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 需要实现的逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // RequestContext requestContext = RequestContext.getCurrentContext();
        // HttpServletRequest request = requestContext.getRequest();
        //
        // // 这里从url中获取，也可以从header中获取
        // // 过滤掉所有没有token参数的request
        // String token = request.getParameter("token");
        // if (StringUtils.isEmpty(token)) {
        //     requestContext.setSendZuulResponse(false);
        //     requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        // }
        return null;
    }
}
