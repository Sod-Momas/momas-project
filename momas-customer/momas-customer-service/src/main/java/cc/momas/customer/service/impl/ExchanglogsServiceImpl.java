package cc.momas.customer.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cc.momas.customer.mapper.ExchanggiftsMapper;
import cc.momas.customer.mapper.ExchanglogsMapper;
import cc.momas.customer.mapper.MemcardsMapper;
import cc.momas.customer.pojo.Exchanggifts;
import cc.momas.customer.pojo.Exchanglogs;
import cc.momas.customer.pojo.ExchanglogsExample;
import cc.momas.customer.pojo.Memcards;
import cc.momas.customer.pojo.MemcardsExample;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.service.IExchanglogsService;

@Service
public class ExchanglogsServiceImpl implements IExchanglogsService {

	@Autowired
	private ExchanglogsMapper logMapper;
	@Autowired
	private ExchanggiftsMapper giftMapper;
	@Autowired
	private MemcardsMapper memberMapper;
	
	@Override
	public int addLog(Memcards card, String rows) {
		int count =0;
		Gson gson = new Gson();
		
		List<Exchanglogs> exLogList = gson.fromJson(rows, new TypeToken<List<Exchanglogs>>() {}.getType());
		List<Exchanggifts> exGiftList = gson.fromJson(rows, new TypeToken<List<Exchanggifts>>() {}.getType());
		
		int totalPoint = 0;
		for(int i = 0; i < exLogList.size(); i++) {
			Exchanggifts gift = exGiftList.get(i);
			Exchanglogs log = exLogList.get(i);
			log.setExchanglogsCreatetime(new Date());
			log.setExchanglogsPoint(gift.getExchanggiftsPoint() * log.getExchanglogsNumber());
			log.setMemcardsCardid(card.getMemcardsCardid());
			log.setMemcardsId(card.getMemcardsId());
			totalPoint += gift.getExchanggiftsPoint() * log.getExchanglogsNumber();
			count += logMapper.insert(log);
			
			Exchanggifts gift2 = new Exchanggifts();
			gift2.setExchanggiftsId(gift.getExchanggiftsId());
			gift2.setExchanggiftsInteger(gift.getExchanggiftsInteger() - log.getExchanglogsNumber());
			gift2.setExchanggiftsExchangnum(gift.getExchanggiftsExchangnum() + log.getExchanglogsNumber());
			count += giftMapper.updateByPrimaryKeySelective(gift2);
		}
		card.setMemcardsName(null);
		//card.setMemcardsId(null);
		card.setMemcardsPoint(card.getMemcardsPoint() - totalPoint);
		count += memberMapper.updateByPrimaryKeySelective(card);
		return count;
	}

	@Override
	public Pager<Exchanglogs, ExchanglogsExample> queryOrderByMemberCardInPager(String identity, int rows, int pageNo) {
		Pager<Exchanglogs, ExchanglogsExample> pager = new Pager<>();
		pager.setPageSize(rows < 1 ? 1 : rows);
		pager.setPageNo(pageNo < 1 ? 1 : pageNo);
		
		if(identity == null || "".equals(identity)) {
			//当外面并没有传标识进来的时候
			//查询全部,并且带分页
			pager.setEntityExample(new ExchanglogsExample());
			pager.setTotalRecordCount(logMapper.countByExample(new ExchanglogsExample()));
			pager.setList(logMapper.selectByPager(pager));
			return pager;
		}
		
		MemcardsExample example = new MemcardsExample();
		example.or().andMemcardsCardidEqualTo(identity);
		example.or().andMemcardsMobileEqualTo(identity);
		List<Memcards> memberCardList = memberMapper.selectByExample(example);
		if(memberCardList == null || memberCardList.size() < 1) {
			//没有查到该用户则不作后续查询
			return null;
		} 
		//查询会员-结束
		
		ExchanglogsExample example1 = new ExchanglogsExample();
		//输入查询条件,保存在Example里的Criteria中
		example1.createCriteria().andMemcardsCardidEqualTo(memberCardList.get(0).getMemcardsCardid());
		pager.setEntityExample(example1);
		int totalRecord = logMapper.countByExample(example1);
		pager.setTotalRecordCount(totalRecord);
		pager.setEntityExample(example1);
		List<Exchanglogs> list = logMapper.selectByPager(pager);
		pager.setList(list);
		return pager;
	}
   
}