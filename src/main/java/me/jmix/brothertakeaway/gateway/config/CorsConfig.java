package me.jmix.brothertakeaway.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * zuul开启跨域
 *
 * @author JellyfishMIX
 * @date 2020/7/26 20:55
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 支持cookie跨域
        corsConfiguration.setAllowCredentials(true);
        // 设置原始域，比如www.a.com
        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        // 设置允许跨域的request headers
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        // 设置允许跨域的方法
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        // 设置缓存时间。对同一个类型的请求，在多长时间内，不检查跨域。此处设置300s
        corsConfiguration.setMaxAge(300l);

        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}
