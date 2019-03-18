package com.springRedis;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=redisConfig.class)
public class RedisTest {
	
	
	@Autowired
	private StringRedisTemplate  redis;
	
	@Autowired 
	private RedisTemplate <String ,Person> redis1;
	@Test
	public void addMessage() {
		redis.opsForValue().set("212", "fds");
	}
	@Test
	public void addMessage22() {
		Person p=new Person();
		p.setId(21);
		p.setName("dsfsdf");
		redis1.opsForValue().set("32e2", p);
	}

	
}
