package com.nf.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nf.entity.Account;



public interface AccountDao2 extends JpaRepository<Account, Integer>,JpaSpecificationExecutor
{
	
}
