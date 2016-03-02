package com.learn.hr.hrserver.configuration;

import com.learn.hr.hrserver.departments.IDepartment;
import com.learn.hr.hrserver.employees.IEmployee;
import com.learn.hr.hrserver.salaries.ISalary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: angular-rest-spring-jpa-server
 * Date: 01/03/16.
 * Time: 22:29
 *
 * Spring web mvc configuration class. (No need for profile dependent config classes).
 */
//Marks the class as Spring config Java class (used instead of xml config)
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {IDepartment.class, IEmployee.class, ISalary.class})
public class HRWebConfiguration extends WebMvcConfigurerAdapter {

    /**
     * JSP view resolver.
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * By enabling DefaultServletHandlerConfigurer, DispatcherServlet forwards requests to static resources to
     * the container's default servlet.
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}