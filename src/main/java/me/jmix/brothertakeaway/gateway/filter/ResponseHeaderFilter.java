package me.jmix.brothertakeaway.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author JellyfishMIX
 * @date 2020/7/18 23:32
 */
@Component
public class ResponseHeaderFilter extends ZuulFilter {
    /**
     * filter的类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * filter的排序，数值越小越靠前
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
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
        // HttpServletResponse response = requestContext.getResponse();
        // response.setHeader("ZuulResponseHeader", UUID.randomUUID().toString());
        return null;
    }
}
