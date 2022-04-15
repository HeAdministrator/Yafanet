package cn.code.yafanet.config;

import cn.code.yafanet.interceptor.CorsInterceptor;
import cn.code.yafanet.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author AllenHe
 * @date 2022/3/26
 * @apiNote 拦截器配置
 * 不用权限可以访问url /api/v1/pub/
 * 需要权限访问的url /api/v1/pri/
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor(){
        return  new LoginInterceptor();
    }

    @Bean
    CorsInterceptor corsInterceptor(){
        return new CorsInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * 拦截全部路径，这个跨域需要放在最上面
         */
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");

        //拦截全部
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
                //不拦截哪些路径
                .excludePathPatterns("/api/v1/pri/user/register","/api/v1/pri/user/login");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}