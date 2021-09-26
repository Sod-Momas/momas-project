package cc.momas.dms.service;

import cc.momas.dms.pojo.TUser;
import cc.momas.dms.pojo.TUserExample;
import cc.momas.util.Pager;

public interface IUserService {

    TUser queryLogin(String name, String password);

    Pager<TUser, TUserExample> queryByPager(Pager<TUser, TUserExample> pager);

    int save(TUser user, int roleid);

}
