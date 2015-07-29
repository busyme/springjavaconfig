package com.yan.onetomany_bi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


@Configuration
@ComponentScan("com.yan.onetomany_bi")
@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter {
	
	@Bean
	public UrlBasedViewResolver basedViewResolver() {

		UrlBasedViewResolver basedViewResolver = new UrlBasedViewResolver();
		basedViewResolver.setPrefix("/WEB-INF/jsp/");
		basedViewResolver.setSuffix(".jsp");
		basedViewResolver.setViewClass(JstlView.class);
		return basedViewResolver;
	}

}
