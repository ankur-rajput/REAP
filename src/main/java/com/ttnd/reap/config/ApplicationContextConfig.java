package com.ttnd.reap.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ttnd.reap.pojo.BadgeTransaction;
import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.pojo.ReceivedBadges;
import com.ttnd.reap.pojo.RemainingBadges;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.ttnd.reap.controller", "com.ttnd.reap.dao.Impl", "com.ttnd.reap.service.impl" })
public class ApplicationContextConfig extends WebMvcConfigurerAdapter {

	private BasicDataSource dataSource;

	@Bean(name = "viewResolver")
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
		return viewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

	}

	@Bean
	public DataSource getDataSource() {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/REAP");
		dataSource.setUsername("root");
		dataSource.setPassword("ankur@123");
		return dataSource;
	}

	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.archive.autodetection", "class");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.current_session_context_class", "thread");
		properties.put("hbm2ddl.auto", "update");
		return properties;
	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sesssionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sesssionBuilder.addProperties(getHibernateProperties());
		sesssionBuilder.addAnnotatedClasses(EmployeeDetails.class);
		sesssionBuilder.addAnnotatedClass(BadgeTransaction.class);
		sesssionBuilder.addAnnotatedClass(ReceivedBadges.class);
		sesssionBuilder.addAnnotatedClass(RemainingBadges.class);
		SessionFactory sessionFactory = sesssionBuilder.buildSessionFactory();
		return sessionFactory;
	}

	/*@Bean
	@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
	public static HttpSession getSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session;
	}*/
}
