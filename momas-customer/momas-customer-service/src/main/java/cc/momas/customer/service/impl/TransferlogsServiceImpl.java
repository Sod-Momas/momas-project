package cc.momas.customer.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.momas.customer.mapper.MemcardsMapper;
import cc.momas.customer.mapper.TransferlogsMapper;
import cc.momas.customer.pojo.Memcards;
import cc.momas.customer.pojo.Transferlogs;
import cc.momas.customer.service.ITransferlogsService;

@Service
public class TransferlogsServiceImpl implements ITransferlogsService{

	@Autowired
	private TransferlogsMapper transMapper;
	@Autowired
	private MemcardsMapper memberMapper;
	
	//这个方法有缺陷,后期要删掉重写一个代替
	@Override
	public int addTransferTest(Integer outId, Integer inId, Float money, String remark) {
		int count = 0;
		Memcards out = memberMapper.selectByPrimaryKey(outId);
		Memcards in = memberMapper.selectByPrimaryKey(inId);
		if(out == null || in == null) {
			return count;
		}
		out.setMemcardsTotalmoney(out.getMemcardsTotalmoney() - money);
		in.setMemcardsTotalmoney(in.getMemcardsTotalmoney() + money);
		if(out.getMemcardsTotalmoney() < 0 ) {
			return count;
		}
		count += memberMapper.updateByPrimaryKeySelective(out);
		count += memberMapper.updateByPrimaryKeySelective(in);
		//这里本来是用来记录日志的,但这个数据表的,外键,会出验证错误
//		Transferlogs log = new Transferlogs();
//		log.setShopId(inId);
//		log.setUsersId(outId);
//		log.setTransferlogsCreatetime(new Date());
//		log.setTransferlogsRemark(remark);
//		log.setTransferlogsTransfermoney(money);
//		int count = transMapper.insert(log);
		return count;
	}
   
}