package cc.momas.customer.pojo;

import java.util.List;

public class Pager<T,E> {

	private int pageNo = 1;
	private int pageSize = 5;
	/** 总记录数 */
	private int totalRecordCount;
	private int navOffset = 5;
	
//	private int page;
//	private List<T> rows;
//	private int total;
	
	
	
	private T entity;
	private E entityExample;
	
	private List<T> list;


	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**  首记录索引 */
	public int getFirstIndex() {
		// 如果数据库的索引总是从0开始,保持这样就可以(比如MySQL)
		// 如果使用的数据库的索引(第一项的索引值)是1,那就在这里最后面 +1 以保证不会选择到0
		return (this.getPageNo() - 1) * this.getPageSize();
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}
	/**
	 * 总页数
	 */
	public int getTotalPageCount() {
		return (this.getTotalRecordCount() - 1) / this.getPageSize() + 1;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getNavOffset() {
		return navOffset;
	}

	public void setNavOffset(int navOffset) {
		this.navOffset = navOffset;
	}

	public T getEntity() {
		return entity;
	}

	public E getEntityExample() {
		return entityExample;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public void setEntityExample(E entityExample) {
		this.entityExample = entityExample;
	}

	public int getPage() {
		return this.getPageNo();
	}

	public List<T> getRows() {
		return this.getList();
	}

	public int getTotal() {
		return this.getTotalRecordCount();
	}


	
}
