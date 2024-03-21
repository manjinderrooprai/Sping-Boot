package com.developer.config;

import java.time.Duration;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@SuppressWarnings("null")
@EnableCaching
@Configuration
public class RedisConfig {

    /**
     * his gives us more control over the default configuration. For example, we can
     * set the desired time-to-live (TTL) values and customize the default
     * serialization strategy for in-flight cache creation.
     * Default connection to the Redis instance = localhost:6379
     */
    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(60))
                .disableCachingNullValues()
                .serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

    /*
     * To have full control over the caching setup. This helps to further fine-tune
     * the caching behavior on a per-cache basis including null values, key prefixes
     * and binary serialization
     */
    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> builder
                .withCacheConfiguration("employees",
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10)));
    }

}
