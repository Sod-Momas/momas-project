package cc.momas.dvdshop;

public interface DvdUtil {

	/** 有参数地添加DVD */
	boolean addDVD(String name, int loanCount, boolean isLoaned);

	/**
	 * 删除DVD
	 * 
	 * @param index  删除的数组下标
	 * @return 是否成功
	 */
	boolean delDVD(int index);

	/** 借DVD */
	boolean getDVD(int index);

	/** 还DVD */
	boolean returnDVD(int index);
}
