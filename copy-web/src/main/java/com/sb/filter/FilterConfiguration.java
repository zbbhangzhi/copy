package com.sb.filter;

import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/23 0023.
 */
@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean druidStatFilterBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        List<String> urlPattern = new ArrayList<>();
        urlPattern.add("/*");
        bean.setUrlPatterns(urlPattern);
        Map<String,String > initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*png,*.css,*.ico,/druid/*");
        bean.setInitParameters(initParams);
        return bean;
    }
}
