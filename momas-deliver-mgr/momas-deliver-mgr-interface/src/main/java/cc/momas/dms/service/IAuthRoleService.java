package cc.momas.dms.service;

import cc.momas.dms.pojo.AuthRole;
import cc.momas.dms.pojo.AuthRoleExample;
import cc.momas.util.Pager;

import java.util.List;

public interface IAuthRoleService {


    int add(AuthRole role, List<Integer> functionIds);

    Pager<AuthRole, AuthRoleExample> queryByPager(Pager<AuthRole, AuthRoleExample> pager);

    List<AuthRole> queryAll();

}
