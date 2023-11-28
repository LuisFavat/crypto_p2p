package ar.edu.unq.cryptop2p.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
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
public class CacheConfig implements CachingConfigurer {

    public static final String LAST_QUOTE_CACHE = "quote-cache";

    @Bean
    public CacheManager cacheManager (RedisConnectionFactory redisConnectionFactory){
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        redisCacheConfigurationMap.put(LAST_QUOTE_CACHE, createConfig(10, ChronoUnit.MINUTES));

        return RedisCacheManager.builder(redisConnectionFactory)
                .withInitialCacheConfigurations(redisCacheConfigurationMap)
                .build();
    }

    private static RedisCacheConfiguration createConfig(long time, ChronoUnit temporalUnit)
    {
        return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.of(time, temporalUnit));
    }
}