package com.nf.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="t_account")
public class Account {
	
	  @Id
	  @Column(name = "accountid")
	  private Integer accountId ;	  
	  
	  @Column(name = "money")
	  private double money;
	  
	  @Column(name = "addre")
	  private String addre;
	  
	  /**
	   * 一对多关系（外键关联注解配置） 
	   */
	  @OneToMany(cascade={ CascadeType.ALL })
	  @JoinColumn(name="accountid") //该列名要和Account的accountid一致
	  private List<Customer> customer;
	  
	  public Account(){}
	  
	  public Account(Integer accountId,String name,double money )
	  {
		  this.accountId = accountId;
		  this.money = money;
	  }
	  	 
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	public String getAddre() {
		return addre;
	}

	public void setAddre(String addre) {
		this.addre = addre;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", money=" + money + ", addre=" + addre + ", customer="
				 + customer +"]";
	}

	
}
