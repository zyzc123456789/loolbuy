package com.loolbuy.global;

import javax.sql.DataSource;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.loolbuy.global.jdbc.SqlExecutor;
import com.loolbuy.global.util.CharsetExt;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class WebConfig extends WebMvcConfigurerAdapter 
{
 

//  @Value("${jdbc.username}")
//  private String username;
//  @Value("${jdbc.password}") 
//  private String password;
//  @Value("${jdbc.url}") 
//  private String url;
//  @Value("${jdbc.driverClassName}") 
//  private String driverClassName;


    
//  @Bean
//  public static PropertySourcesPlaceholderConfigurer properties(){
//      System.out.println("PropertySourcesPlaceholderConfigurer: ");
//    PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
//    Resource[] resources = new ClassPathResource[]{ new ClassPathResource("jdbc.properties") };
//    pspc.setLocations(resources);
//    return pspc;
//  }
    
    @Bean(destroyMethod="close")
    @Autowired 
    public DataSource basicDataSource(Environment env) {
        BasicDataSource dbcp = new BasicDataSource();
        
        dbcp.setDriverClassName("org.jdbcdslog.DriverLoggingProxy");
        dbcp.setUrl("jdbc:jdbcdslog:" + env.getProperty("jdbc.url") + ";targetDriver=" + env.getProperty("jdbc.driverClassName"));
        dbcp.setUsername(env.getProperty("jdbc.username"));
        dbcp.setPassword(env.getProperty("jdbc.password"));
        
        return dbcp;
    }
    
    @Bean
    @Autowired 
    public SqlExecutor sqlExecutor(DataSource dataSource) {
        return new SqlExecutor(dataSource);
    }
    

    @Bean
    @Autowired 
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource message = new ResourceBundleMessageSource();
        message.setDefaultEncoding(CharsetExt.UTF8);
        message.setBasename("messages");
        return message;
    }
}