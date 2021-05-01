package cc.momas.housetenacy.utils;

import java.util.List;

public class Pager<T> {
	/**
	 * 当前页号
	 */
	private int pageNo = 1;
	/**
	 * 当前页
	 */
	private int pageSize = 5;
	/**
	 * 首 记录索引
	 */
	@SuppressWarnings("unused")
	private int firstIndex;
	/**
	 * 总记录数
	 */
	private int totalRecordCount;
	/**
	 * 总页数
	 */
	@SuppressWarnings("unused")
	private int totalPageCount;

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
		// 最后要不要+1看索引从0开始还是1开始
		return firstIndex = (this.getPageNo() - 1) * this.getPageSize();
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public int getTotalPageCount() {
		return totalPageCount = (this.getTotalRecordCount() - 1) / this.getPageSize() + 1;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
