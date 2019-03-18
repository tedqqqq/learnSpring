package com.springRedis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;



@Configuration
public class redisConfig {
	@Bean
	public RedisConnectionFactory redisCF() {
		JedisConnectionFactory jcf= new JedisConnectionFactory();
		jcf.setHostName("192.168.7.124");
		jcf.setPassword("111111");
		jcf.setPort(6379);
		return jcf;
	}
	
//	@Bean
//	public RedisTemplate<String, Person> redisTemplate(RedisConnectionFactory cf) {
//		RedisTemplate<String, Person> redis = new RedisTemplate<String, Person>();
//		redis.setConnectionFactory(cf);
//		return redis;
//	}
	
	@Bean
	public StringRedisTemplate   redisStringTemplate(RedisConnectionFactory cf) {
		return new StringRedisTemplate(cf);
	}
	
	@Bean
	public RedisTemplate<String,Person> redis(RedisConnectionFactory cf){
		RedisTemplate<String, Person> redis = new RedisTemplate<String, Person>();
		redis.setConnectionFactory(cf);
		redis.setKeySerializer(new StringRedisSerializer());
		redis.setValueSerializer(new Jackson2JsonRedisSerializer<Person>(Person.class));
		return redis;
	}
}
