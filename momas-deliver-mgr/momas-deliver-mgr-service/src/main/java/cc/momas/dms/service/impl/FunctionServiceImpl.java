package cc.momas.dms.service.impl;

import cc.momas.dms.mapper.AuthFunctionMapper;
import cc.momas.dms.pojo.AuthFunction;
import cc.momas.dms.pojo.AuthFunctionExample;
import cc.momas.dms.service.IFunctionService;
import cc.momas.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionServiceImpl implements IFunctionService {

    @Autowired
    private AuthFunctionMapper funMapper;


    @Override
    public List<AuthFunction> qeuryByUserId(Integer userId) {
        return funMapper.selectByUserId(userId);
    }


    @Override
    public List<AuthFunction> queryAll() {
        return funMapper.selectByExample(null);
    }


    @Override
    public Pager<AuthFunction, AuthFunctionExample> queryByPager(Pager<AuthFunction, AuthFunctionExample> pager) {
        pager.setTotalRecordCount(funMapper.countByExample(pager.getEntityExample()));
        pager.setList(funMapper.selectByPager(pager));
        return pager;
    }


    @Override
    public int save(AuthFunction function) {
        return funMapper.insert(function);
    }

}
