package cc.momas.test.newportal.utils;

import java.util.List;

public final class Pager<T> {
	//	
	//	 * 1.当前页号：		pageNo
	//	 * 2.页面内容大小：	pageSize
	//	 * 3.首页索引 		firstIndex = (pageNo - 1) * pageSize
	//	 * 4.总记录数量 		totalRecordCount = select count(0) from tableName
	//	 * 5.总页数		totalPageCount = 
	//	 * 		a) 
	//	 * 			if(tatolRecordCount % pageSize == 0){
	//	 * 				totalpageCount = totalRecordCount / pageSize;
	//	 * 			} else {
	//	 * 				totalpageCount = totalRecordCount / pageSize + 1;
	//	 * 			}
	//	 * 		b) totalPageCount = (totalRecordCount - 1) / pageSize + 1;
	//	 * 
	//	
	
	private int pageNo;
	private int pageSize;
	private int firstIndex;
	private int totalRecoredCount;
	private int totalPageCount;
	private List<T> list;

	/**
	 * 获取每一页第一项的id(索引)值
	 * 例如第 '1' 页,页面大小为 '30',
	 * 第 '1' 页第一项id为 (1-1)*30 = 0 ,
	 * 第 '2' 页第一项id为 (2-1)*30 = 30
	 * 
	 * @return firstIndex 
	 * 		获取每一页第一项的id(索引)值
	 */
	public int getFirstIndex() {
		return firstIndex = (this.getPageNo()-1) * this.pageSize ;
	}

	public List<T> getList() {
		return list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * 
	 * 如果有 '21' 条记录,页面大小为 '5'
	 * 总页数为 (21 - 1) / 5 + 1
	 * @return totalPageCount 返回计算出来的总页数
	 */
	public int getTotalPageCount() {
		return this.totalPageCount =(this.getTotalRecoredCount() - 1) / this.getPageSize() + 1;
	}
	
	public int getTotalRecoredCount() {
		return totalRecoredCount;
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

	public void setTotalRecoredCount(int totalRecoredCount) {
		this.totalRecoredCount = totalRecoredCount;
	}

}
