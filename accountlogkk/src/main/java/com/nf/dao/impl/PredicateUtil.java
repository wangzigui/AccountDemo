package com.nf.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PredicateUtil<T> {
	private Root<T> root;
	
	private CriteriaQuery<?> query;
	
//	private Join<?, T> join ;
	
	private CriteriaBuilder cb;
	
	private List<Predicate> predicatesList= new ArrayList<Predicate>();
	
	public Root<T> getRoot() {
		return root;
	}

	public void setRoot(Root<T> root) {
		this.root = root;
	}

//	public Join<?, T> getJoin() {
//		return join;
//	}

	public CriteriaQuery<?> getQuery() {
		return query;
	}

	public void setQuery(CriteriaQuery<?> query) {
		this.query = query;
	}

//	public void setJoin(Join<?, T> join) {
//		this.join = join;
//	}

	public List<Predicate> getPredicatesList() {
		return predicatesList;
	}

	public void setPredicatesList(List<Predicate> predicatesList) {
		this.predicatesList = predicatesList;
	}

	public CriteriaBuilder getCb() {
		return cb;
	}

	public void setCb(CriteriaBuilder cb) {
		this.cb = cb;
	}

	public PredicateUtil(){}
	
	public PredicateUtil(Root<T> root, CriteriaQuery<?> query2, CriteriaBuilder cb)
	{
		this.root = root;
		this.query = query2;
		this.cb = cb;
	}
	
	public void where()
	{
		query.where(predicatesList.toArray(new Predicate[predicatesList.size()]));
	}
	
	public void eq(String key ,Object value)
	{
		if(value == null)
		{
			return;
		}
		
		predicatesList.add(cb.equal(root.get(key), value));
	}
	
	public void notEq(String key ,Integer value)
	{
		if(value == null)
		{
			return;
		}
		
		predicatesList.add(cb.notEqual(root.get(key), value));
	}
	
	public void like(String key ,String value)
	{
		if(value == null)
		{
			return;
		}
		
		predicatesList.add(cb.like(root.get(key), value));
	}
	
	public Join<?, T> leftJoin(String key)
	{
		Join<?, T> join = root.join(key, JoinType.LEFT);
		return join;
	}
	
	public void eqJoin(Join<?, T> join,String key,String value)
	{
		if(value == null)
		{
			return;
		}
		
		predicatesList.add(cb.equal(join.get(key), value));
	}
	
	public void notLike(String key ,String value)
	{
		if(value == null)
		{
			return;
		}
		
		predicatesList.add(cb.notLike(root.get(key), value));
	}
	
	@SuppressWarnings("rawtypes")
	public void in(String key ,List value)
	{
		if(value == null)
		{
			return;
		}
		predicatesList.add(cb.and(root.get(key).in(value)));
	}
	
	
}
