package com.springCache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@EnableCaching
@Configuration
public class cacheConfig {
	//redis配置
	@Bean
	public RedisConnectionFactory redisCF() {
		JedisConnectionFactory jcf= new JedisConnectionFactory();
		jcf.setHostName("192.168.7.124");
		jcf.setPassword("111111");
		jcf.setPort(6379);
		return jcf;
	}
	//redis模板
	@Bean
	public RedisTemplate<String,String> redis(RedisConnectionFactory cf){
		RedisTemplate<String, String> redis = new RedisTemplate<String, String>();
		redis.setConnectionFactory(cf);
		redis.setKeySerializer(new StringRedisSerializer());
		redis.setValueSerializer(new StringRedisSerializer());
		return redis;
	}
	
	//获取缓存工厂
	@Bean
	public CacheManager getCacheManage(RedisTemplate rt) {
		Collection<String> list=new LinkedList<>(); 
		list.add("gsdfg");
		RedisCacheManager rcm=new RedisCacheManager(rt);
		rcm.setCacheNames(list);
		return rcm;
	}
	
	//测试一下缓存的情况
	@Bean
	public CityRepository getCity() {
		return new CityRepositoryImp();
	}
}
