package cc.momas.smbms.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import cc.momas.smbms.dao.ProviderMapper;
import cc.momas.smbms.entity.Provider;
import cc.momas.smbms.service.IProviderService;
import cc.momas.smbms.util.MyBatisUtil;

@Service
public class ProviderServiceImpl implements IProviderService {

	/* (non-Javadoc)
	 * @see cc.momas.smbms.service.impl.IProviderService#queryAll()
	 */
	@Override
	public List<Provider> queryAll(){
		SqlSession session = new MyBatisUtil().getSession();  
		List<Provider> plist = session.getMapper(ProviderMapper.class).queryAll();
		session.commit();
		session.close();
		return plist;
	}

	@Override
	public Provider queryById(Integer id) {
		return new MyBatisUtil().getSession(true).getMapper(ProviderMapper.class).queryById(id);
	}

	@Override
	public int add(Provider provider) {
		SqlSession session = new MyBatisUtil().getSession();  
		int result = session.getMapper(ProviderMapper.class).add(provider);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int delete(Provider provider) {
		SqlSession session = new MyBatisUtil().getSession();  
		int result = session.getMapper(ProviderMapper.class).delete(provider);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int update(Provider provider) {
		SqlSession session = new MyBatisUtil().getSession();  
		int result = session.getMapper(ProviderMapper.class).update(provider);
		session.commit();
		session.close();
		return result;
	}
}
