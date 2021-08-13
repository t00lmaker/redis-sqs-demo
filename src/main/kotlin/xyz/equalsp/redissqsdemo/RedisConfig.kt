package xyz.equalsp.redissqsdemo

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisClusterConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import java.util.*


@Configuration
class RedisConfig {

    @Value("\${spring.redis.host}")
    lateinit var redisHost: String

    @Value("\${spring.redis.port}")
    lateinit var redisPort: String

    @Bean
    fun jedisConnectionFactory(): LettuceConnectionFactory? {
        val nodes: List<String> = Arrays.asList(
            "${redisHost}:${7001}",
            "${redisHost}:${7002}",
            "${redisHost}:${7003}",
            "${redisHost}:${7004}",
            "${redisHost}:${7005}",
            "${redisHost}:${7006}"
        )
        val clusterConfiguration = RedisClusterConfiguration(nodes)
        return LettuceConnectionFactory(clusterConfiguration)
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, Any>? {
        val template = RedisTemplate<String, Any>()
        template.setConnectionFactory(jedisConnectionFactory()!!)
        return template
    }
}