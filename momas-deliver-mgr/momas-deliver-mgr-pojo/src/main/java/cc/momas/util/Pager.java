package cc.momas.util;

import java.util.List;

public class Pager<T,E> {
	
	private T entity;
	private E entityExample;
	@SuppressWarnings("unused")
	private int firstIndex;
	@SuppressWarnings("unused")
	private int lastIndex;
	private List<T> list;
	private int pageNo = 1;
	private int pageSize = 10;
	@SuppressWarnings("unused")
	private int page ;//等同于pageSize
	@SuppressWarnings("unused")
	private List<T> rows ;//等同于list
	@SuppressWarnings("unused")
	private int total;//中记录数
	
	@SuppressWarnings("unused")
	private int totalPageCount;
	private int totalRecordCount;
	
	/*
	public void setPage(int page) {
		this.setPageNo(page);
	}
	public void setRows(int rows) {
		this.setPageSize(rows);
	}*/
	
	public T getEntity() {
		return entity;
	}
	public E getEntityExample() {
		return entityExample;
	}
	public int getFirstIndex() {
		return firstIndex = (pageNo - 1) * this.getPageSize();
	}
	public int getLastIndex() {
		return lastIndex = this.getFirstIndex() + this.getPageSize() - 1;
	}
	public List<T> getList() {
		return list;
	}
	public int getPage() {
		return this.getPageNo();
	}
	public int getPageNo() {
		return pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public List<T> getRows() {
		return this.getList();
	}
	public int getTotal() {
		return this.getTotalRecordCount();
	}
	public int getTotalPageCount() {
		return totalPageCount = (this.getTotalRecordCount() - 1) / this.getPageSize() + 1;
	}
	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public void setEntityExample(E entityExample) {
		this.entityExample = entityExample;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}
}
