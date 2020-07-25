package me.jmix.brothertakeaway.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import me.jmix.brothertakeaway.gateway.enums.RequestUriEnum;
import me.jmix.brothertakeaway.gateway.utils.CookieUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author JellyfishMIX
 * @date 2020/7/25 23:38
 */
@Component
public class BuyerAuthFilter extends ZuulFilter {

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
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 2;
    }

    /**
     * 是否开启filter
     * 根据 requestURI 判断是否要过滤请求
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        // requestURI e.g. /brother-takeaway-order/order/finish
        return request.getRequestURI().equals(RequestUriEnum.ORDER + "/order/create");
    }

    /**
     * 需要实现的逻辑
     * /brother-takeaway-order/order/create只能在买家端访问，买家端cookies中包含key：openid
     * /brother-takeaway-order/order/finish只能在卖家端访问，卖家端cookies中包含key：token
     * 根据request cookies包含的key是openid还是token区分买家端与卖家端
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        Cookie cookie = CookieUtil.get(request, "openid");
        // 判断cookie中的openid是否存在，不存在不放行request
        if (cookie == null || StringUtils.isEmpty(cookie.getValue())) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }

        return null;
    }
}
