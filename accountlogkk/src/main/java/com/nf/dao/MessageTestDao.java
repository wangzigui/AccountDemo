package com.nf.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nf.entity.Customer;
import com.nf.entity.MessageTest;


@CacheConfig(cacheNames = "messageTests")
public interface MessageTestDao  extends JpaRepository<MessageTest,String>{
	
	@Cacheable
	public List<MessageTest> findByName(String name);
	
	
	@Cacheable
	public List<MessageTest> findAll();
}
