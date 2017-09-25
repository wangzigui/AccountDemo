package com.nf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.nf.dao.AccountDao2;
import com.nf.entity.Account;
import com.nf.entity.Customer;

@Service
public class AccountDaoImpl {

	@Autowired
	private AccountDao2 accountDao2;

	@SuppressWarnings("unchecked")
	public Page<Account> findBySepc(int page, int size) {
		PageRequest page1 = new PageRequest(0, 10);
		Page<Account> list = accountDao2.findAll(new MySpec(12345, 2460), page1);
		return list;
	}

	private class MySpec implements Specification<Account> {

		private Integer accountId;

		private double money;

		public MySpec(Integer accountId, double money) {
			super();
			this.accountId = accountId;
			this.money = money;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

			// 1.混合条件查询

//			List<Predicate> predicatesList = new ArrayList<Predicate>();

//			predicatesList.add(cb.equal(root.get("accountId"), accountId));
//			predicatesList.add(cb.equal(root.get("money"), money));
			PredicateUtil<Account> predicateUtil = new PredicateUtil<Account>(root,query,cb);
			predicateUtil.eq("accountId", accountId);
			predicateUtil.eq("money", money);
			// 2.联表查询
			Join<Customer, Account> join = (Join<Customer, Account>) predicateUtil.leftJoin("customer");
			
			predicateUtil.eqJoin(join, "name", "aas");
			predicateUtil.where();
			return null;

		}
	}
}
