package cc.momas.customer.service;

public interface ITransferlogsService {

	/**
	 * 用于创建一笔转账记录
	 * 
	 * @param outId 付款人id
	 * @param inId 收款人id
	 * @param money 金额 
	 * @param remark 备注
	 * @return 数据库里受影响的行数
	 */
	int addTransferTest(Integer outId, Integer inId, Float money, String remark);
  
}