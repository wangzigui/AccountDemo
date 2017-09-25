package com.nf.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class Criteriator<T> {
	
	private EntityManager em;
	
	private CriteriaBuilder criteriaBuilder;
	
	private CriteriaQuery<T> criteriaQuery;
	
	private Root<T> root;
	
	private List<Predicate> predicatesList= new ArrayList<Predicate>();
	
	public Criteriator(){}
	
	public Criteriator(EntityManager em, Class<T> clazz)
	{
		this.em = em;
		criteriaBuilder = em.getCriteriaBuilder();
		criteriaQuery =  criteriaBuilder.createQuery(clazz);
		root = criteriaQuery.from(clazz);
	}
	
	public void or(Predicate predicate ,Predicate predicate1)
	{
		if(predicate == null || predicate1 == null)
		{
			return;
		}
		Predicate orPredicate = criteriaBuilder.or(predicate, predicate1);
		predicatesList.add(orPredicate);
		
	}
	
	public void eq(String key ,Integer value)
	{
		if(value == null)
		{
			return;
		}
		
		predicatesList.add(criteriaBuilder.equal(root.get(key), value));
	}
	
	public void notEq(String key ,Integer value)
	{
		if(value == null)
		{
			return;
		}
		
		predicatesList.add(criteriaBuilder.notEqual(root.get(key), value));
	}
	
	public void like(String key ,String value)
	{
		if(value == null)
		{
			return;
		}
		
		predicatesList.add(criteriaBuilder.like(root.get(key), value));
	}
	
	public void notLike(String key ,String value)
	{
		if(value == null)
		{
			return;
		}
		
		predicatesList.add(criteriaBuilder.notLike(root.get(key), value));
	}
	
	@SuppressWarnings("rawtypes")
	public void in(String key ,List value)
	{
		if(value == null)
		{
			return;
		}
		predicatesList.add(criteriaBuilder.and(root.get(key).in(value)));
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return criteriaBuilder;
	}

	public void setCriteriaBuilder(CriteriaBuilder criteriaBuilder) {
		this.criteriaBuilder = criteriaBuilder;
	}

	public CriteriaQuery<T> getCriteriaQuery() {
		return criteriaQuery;
	}

	public void setCriteriaQuery(CriteriaQuery<T> criteriaQuery) {
		this.criteriaQuery = criteriaQuery;
	}

	public Root<T> getRoot() {
		return root;
	}

	public void setRoot(Root<T> root) {
		this.root = root;
	}

	public List<Predicate> getPredicatesList() {
		return predicatesList;
	}

	public void setPredicatesList(List<Predicate> predicatesList) {
		this.predicatesList = predicatesList;
	}
	
}
