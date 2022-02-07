package mvn.sandbox.order.regular.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfig {
    @Bean("priceCachingManager")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("prices");
    }
}
