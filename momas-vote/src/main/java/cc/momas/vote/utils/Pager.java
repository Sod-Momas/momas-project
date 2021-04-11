package cc.momas.vote.utils;

import java.util.List;

public class Pager<T> {

	private int pageNo; //当前页面
	private int pageSize;//当前页面大小
	private int firstIndex; //首记录索引
	private int totalRecordCount; //总记录数
	private int totalPageCount; //总页数
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
	public int getFirstIndex() {
		return firstIndex = (this.getPageNo()-1)*this.getPageSize();
	}
	public int getTotalRecordCount() {
		return totalRecordCount;
	}
	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}
	public int getTotalPageCount() {
		return totalPageCount = (this.getTotalRecordCount() - 1) / this.getPageSize();
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	
}
