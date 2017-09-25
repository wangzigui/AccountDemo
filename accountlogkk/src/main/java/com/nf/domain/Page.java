package com.nf.domain;

public class Page {
	
	private Integer currentPage;
	private Integer pageSize;
	private Long total;
	
	public Page(){}
	
	public Page(Integer currentPage,Integer pageSize,Long total)
	{
		this.currentPage =currentPage;
		this.pageSize = pageSize;
		this.total = total;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", pageSize=" + pageSize + ", total=" + total + "]";
	}
	
	
}
