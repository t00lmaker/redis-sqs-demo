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
    fun jedisConnectionFactory(): JedisConnectionFactory? {
        val jedisConFactory = JedisConnectionFactory()
        jedisConFactory.hostName = redisHost
        jedisConFactory.port =  redisPort

        val nodes: List<String> = Collections.singletonList("****.***.****.****.cache.amazonaws.com:6379")
        val clusterConfiguration = RedisClusterConfiguration(nodes)
        LettuceConnectionFactory(clusterConfiguration)
        return jedisConFactory
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, Any>? {
        val template = RedisTemplate<String, Any>()
        template.setConnectionFactory(jedisConnectionFactory()!!)
        return template
    }
}