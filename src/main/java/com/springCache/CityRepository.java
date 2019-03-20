package com.springCache;

import org.springframework.cache.annotation.Cacheable;

public interface CityRepository {
	 @Cacheable("gsdfg")
	public String getMessage(String id);
	 
	 //注解的使用一般还有@CachePut  @CacheEvict
}
