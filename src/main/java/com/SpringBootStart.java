package com;

import com.wolf.core.service.SqlConfigService;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.io.IOException;

/**
 * Created by sdyang on 2016/7/15.
 */
@SpringBootApplication
public class SpringBootStart extends SpringBootServletInitializer {

    private static Logger logger = Logger.getLogger(SpringBootStart.class);

    /**
     * spring mvc默认是ISO-8859-1 编码，表单POST不支持中文，此处强制 utf-8 编码
     * Content-Type:"text/html;charset=ISO-8859-1"
     *
     * @return
     */
    @Bean
    FilterRegistrationBean charEncode() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.addUrlPatterns("/*.html");
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        bean.setFilter(filter);
        return bean;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(SpringBootStart.class);
    }

    @Bean
    public static SqlConfigService getSqlConfigService(){
        return new SqlConfigService();
    }

    public static void main(String[] args) {
        logger.info("==============  ***  开始启动系统  ***  ==============");
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootStart.class, args);
        try {
            getSqlConfigService().init();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("==============  ***  系统启动完成  ***  ==============");
    }
}
