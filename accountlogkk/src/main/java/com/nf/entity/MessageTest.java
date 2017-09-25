package com.nf.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name ="MESSAGETEST")
public class MessageTest {

	private String accountid;
	
	private String addre;
	
	@Id	
	private String name;

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getAddre() {
		return addre;
	}

	public void setAddre(String addre) {
		this.addre = addre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MessageTest [accountid=" + accountid + ", addre=" + addre + ", name=" + name + "]";
	}
	
}
