package com.nf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.nf.domain.Criteriator;
import com.nf.entity.Account;
import com.nf.entity.Customer;
import com.nf.entity.MessageTest;

@Repository
public class TestDao {
	
	@PersistenceContext
	private EntityManager entityManager;   
	
	@SuppressWarnings("unchecked")
	public List<Account> findAllCustomers()
	{
		Query query = entityManager.createQuery("select u from Account u where u.id = :id"); 
		query.setParameter("id", 3);
		List<Account> accounts = query.getResultList();
		return accounts;
	}
	
	/**
	 * 连表查询获取部分字段
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MessageTest> findMessageTest()
	{
		Query query = entityManager.createNativeQuery("SELECT m.accountid,m.addre,lg.name FROM t_account m left JOIN t_customer lg ON m.accountid = lg.accountId"); 
		List<Object> accounts = query.getResultList();
		return null;
	}
	
	/**
	 * 存储过程
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> findMessageTest111()
	{
		Query query = entityManager.createNativeQuery("{call proc3(:in_param)}",Customer.class);
		query.setParameter("in_param", "wang");
		List<Customer> result = query.getResultList();
		return result;
	}
	
	
	
	public List<Account> findCustomers()
	{
		Criteriator<Account> criteriator = new Criteriator<Account>(entityManager,Account.class);
		criteriator.eq("id", null);
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
//		criteriator.in("id", list);
//		Predicate predicate = criteriator.getCriteriaBuilder().or(criteriator.getCriteriaBuilder().notEqual(criteriator.getRoot().get("id"),3));
//		Predicate predicate1 = criteriator.getCriteriaBuilder().or(criteriator.getCriteriaBuilder().equal(criteriator.getRoot().get("name"),"wang"));
		Join<Customer,Account> join = criteriator.getRoot().join("customer", JoinType.INNER);
		criteriator.getPredicatesList().add(criteriator.getCriteriaBuilder().equal(join.get("name"),"wang"));
//		criteriator.or(predicate, predicate1);
		criteriator.getCriteriaQuery().where(criteriator.getPredicatesList().toArray(new Predicate[criteriator.getPredicatesList().size()]));
		
		List<Account> accounts = entityManager.createQuery(criteriator.getCriteriaQuery()).getResultList();
		return accounts;
	}
	
	public void save(Account a)
	{
		entityManager.persist(a);
		entityManager.flush();
	}
}
