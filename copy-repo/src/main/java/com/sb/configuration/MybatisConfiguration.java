package com.sb.configuration;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/23 0023.
 */
@Configuration
@MapperScan("com.sb.mapper")
public class MybatisConfiguration {
    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.driver-class-name}")
    String driverClass;

    private static String MYBATIS_CONFIG = "mybatis-config.xml";
    private static String MAPPER_PATH = "/mapper/*.xml";

    @Bean
    public SqlSessionFactoryBean createSqlSessionFactoryBean()throws IOException{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        //设置mybatis configuration扫描路径
        bean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
        //添加mapper扫描路径
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + MAPPER_PATH;
        bean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
        //设置datasource
        bean.setDataSource(dataSource());
        return bean;
    }

    private DataSource dataSource() {
        Map<String,Object> properties = new HashMap<>();
        properties.put(DruidDataSourceFactory.PROP_DRIVERCLASSNAME, driverClass);
        properties.put(DruidDataSourceFactory.PROP_USERNAME, username);
        properties.put(DruidDataSourceFactory.PROP_PASSWORD, password);
        properties.put(DruidDataSourceFactory.PROP_URL, url);
        //添加统计，sql注入，日志过滤器
        properties.put(DruidDataSourceFactory.PROP_FILTERS, "stat,wall,log4j2");
        //sql合并，慢查询定义为5s
        properties.put(DruidDataSourceFactory.PROP_CONNECTIONPROPERTIES, "durid.stat.mergeSql=true;druid.stat.slowSqlMills=5000");
        try {
            return DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
