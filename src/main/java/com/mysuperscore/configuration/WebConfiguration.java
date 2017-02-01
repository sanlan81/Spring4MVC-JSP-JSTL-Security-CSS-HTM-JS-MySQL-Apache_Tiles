package com.mysuperscore.configuration;

import com.mysuperscore.dao.SongDAO;
import com.mysuperscore.validator.FileValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mysuperscore")
public class WebConfiguration extends WebMvcConfigurerAdapter {
	
	/*
	 * Configure View Resolver
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/*
	 * Configure MessageSource to provide internationalized messages
	 * 
	 */
	
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}

	/*
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
	 * 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}


	@Bean
	public DriverManagerDataSource getMySQLDriverManagerDatasource(){

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setPassword("doublebass81");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sashas_list?useSSL=false");
		dataSource.setUsername("sanlan81");
		return dataSource;
	}
 @Bean
	public SongDAO SongDAO(){
	    SongDAO template = new SongDAO();
		DataSource dataSource = getMySQLDriverManagerDatasource();
		template.setDataSource(dataSource);
		return template;
	}

	 @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {

        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        return commonsMultipartResolver;
    }
    @Bean
    FileValidator fileValidator(){
		return  new FileValidator();
	}
}