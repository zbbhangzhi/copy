package com.sb.servlet;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2018/5/23 0023.
 */
@Configuration
public class ServletConfiguration {
    @Bean
    public ServletRegistrationBean druidStatViewServletBean(){
        //后台的路径
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> params = new HashMap<>();
        params.put("loginUsername", "admin");
        params.put("loginPassword", "admin");
        params.put("resetEnable", "true");
        bean.setInitParameters(params);
        return bean;
    }
}
