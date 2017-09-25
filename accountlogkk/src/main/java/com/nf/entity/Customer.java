package com.nf.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "t_customer")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "only_test", procedureName = "proc3", parameters = {
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "s", type = String.class) })})
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "name")
	private String name;

	@Column(name = "addre")
	private String addre;

	@Column(name = "accountid")
	private Integer accountId;

//	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, optional = true)
//	@JoinColumn(name = "accountId")
//	private Account account;
//
//	public Account getAccount() {
//		return account;
//	}
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddre() {
		return addre;
	}

	public void setAddre(String addre) {
		this.addre = addre;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", addre=" + addre 
				+ "]";
	}


}
