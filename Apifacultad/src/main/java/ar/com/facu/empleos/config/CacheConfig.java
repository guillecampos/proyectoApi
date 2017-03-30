package ar.com.facu.empleos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CacheConfig {
    
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
	EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
	ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
	return ehCacheManagerFactoryBean;
    }
    
    @Bean
    @Autowired
    public EhCacheCacheManager cacheManager(EhCacheManagerFactoryBean ehcache) {
	EhCacheCacheManager cacheManager = new EhCacheCacheManager();
	cacheManager.setCacheManager(ehcache.getObject());
	return cacheManager;
    }
    
}
