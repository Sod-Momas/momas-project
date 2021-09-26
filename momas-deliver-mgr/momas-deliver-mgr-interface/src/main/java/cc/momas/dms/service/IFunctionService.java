package cc.momas.dms.service;

import cc.momas.dms.pojo.AuthFunction;
import cc.momas.dms.pojo.AuthFunctionExample;
import cc.momas.util.Pager;

import java.util.List;

public interface IFunctionService {

    List<AuthFunction> qeuryByUserId(Integer userId);

    List<AuthFunction> queryAll();

    Pager<AuthFunction, AuthFunctionExample> queryByPager(Pager<AuthFunction, AuthFunctionExample> pager);

    int save(AuthFunction function);

}
