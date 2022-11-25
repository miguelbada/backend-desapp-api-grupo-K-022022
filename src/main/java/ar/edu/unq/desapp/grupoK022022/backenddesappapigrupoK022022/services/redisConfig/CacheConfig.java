package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.redisConfig;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class CacheConfig extends CachingConfigurerSupport {
    public static final String CRYPTO_CACHE = "crypto_cache";

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        redisCacheConfigurationMap.put(CRYPTO_CACHE, createConf(1, ChronoUnit.MINUTES));

        return RedisCacheManager
                .builder(redisConnectionFactory)
                .withInitialCacheConfigurations(redisCacheConfigurationMap)
                .build();
    }

    private static RedisCacheConfiguration createConf(long time, ChronoUnit temporalUnit) {
        return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.of(time, temporalUnit));
    }
}
