package ar.com.facu.empleos.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ar.com.facu.empleos.config.cache.CacheControlHandlerInterceptor;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@ComponentScan(basePackages = { "ar.com.facu" })
@PropertySource({ "classpath:ar/com/agea/context/properties/config_prod.properties" })
@EnableTransactionManagement
@EnableWebMvc
@EnableCaching
@EnableAsync


public class DomainConfig extends WebMvcConfigurerAdapter {
	private static final Logger LOGGER = Logger.getLogger(DomainConfig.class);
	
	@Value("${database.driver}")
	private String driverClassName;
	
	@Value("${database.url}")
	private String url;
	
	@Value("${database.user}")
	private String username;
	
	@Value("${database.password}")
	private String password;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${hibernate.show_sql}")
	private String showSql;
	
	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass(driverClassName);
		ds.setUser(username);
		ds.setPassword(password);
		ds.setJdbcUrl(url);
		
		return ds;
	}
	
	@Bean(name = "sessionFactory")
	@DependsOn("liquibase")
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBean factoryBean = null;
		try {
			factoryBean = new LocalSessionFactoryBean();
			Properties properties = new Properties();
			properties.setProperty("hibernate.dialect", dialect);
			properties.setProperty("hibernate.show_sql", showSql);
			
			factoryBean.setDataSource(dataSource());
			// aca solo debe escanear los objetos domain...@entity
			factoryBean.setPackagesToScan(new String[] { "ar.com.facu.domain.model" });
			
			factoryBean.setHibernateProperties(properties);
			factoryBean.afterPropertiesSet();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return factoryBean.getObject();
	}
	
	@Bean(name = "liquibase")
	public SpringLiquibase liquibase() throws PropertyVetoException {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setDataSource(dataSource());
		liquibase.setChangeLog("classpath:/ar/com/agea/liquibase/db.changelog-master.xml");
		
		return liquibase;
	}
	
	@Bean(name = "transactionManager")
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public ThreadPoolTaskExecutor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(25);
		executor.setQueueCapacity(50000);
		executor.setThreadNamePrefix("EmailPoolThreads");
		executor.initialize();
		return executor;
	}
	
   @Bean
	public CacheControlHandlerInterceptor cacheControlHandlerInterceptor() {
		return new CacheControlHandlerInterceptor();
	}   
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(cacheControlHandlerInterceptor());
		super.addInterceptors(registry);

	}

}
