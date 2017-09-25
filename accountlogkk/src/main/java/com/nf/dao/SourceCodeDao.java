package com.nf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nf.entity.Customer;

public interface SourceCodeDao extends PagingAndSortingRepository<Customer, String> {
	 	
	@Procedure(name = "only_test")
	List<Customer> inAndOutTest();
}
