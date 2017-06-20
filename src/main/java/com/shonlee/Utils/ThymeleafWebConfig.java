package com.shonlee.Utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ShonLee on 2017/6/12.
 * WebMvcConfigurerAdapter这个类可以说是SpringMVC的Java的config，
 * 它可以代替我们之前在xml中进行的一系列配置
 *
 * 自定义静态资源文件目录
 */
@Configuration
public class ThymeleafWebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // 让指定的目录文件变为模板文件目录，可以被页面访问其中的信息
        //registry.addResourceHandler("/about/**")
        //        .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/about/");

        // 让指定的目录文件变为静态资源目录，可以被页面访问其中的信息
        //方法1
        registry.addResourceHandler("/about/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/about/");

        // 方法2
        //registry.addResourceHandler("/about/**").addResourceLocations("classpath:/about/");
        super.addResourceHandlers(registry);
    }
}
