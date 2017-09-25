package com.nf;

import java.util.List;

import com.nf.domain.Page;

public class commonReslut<T> {
	private String code;
	private String message;
	private List<T> date;
	private Page page;
	
	public commonReslut(){}
	
	public commonReslut(String code,String message,List<T> date,Page page)
	{
		this.code= code;
		this.message= message;
		this.date = date;
		this.page =page;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getDate() {
		return date;
	}

	public void setDate(List<T> date) {
		this.date = date;
	}
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "commonReslut [code=" + code + ", message=" + message + ", date=" + date + ", page=" + page + "]";
	}

	
	
}
