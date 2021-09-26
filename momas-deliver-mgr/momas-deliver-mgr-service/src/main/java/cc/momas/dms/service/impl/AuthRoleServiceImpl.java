package cc.momas.dms.service.impl;

import cc.momas.dms.mapper.AuthRoleMapper;
import cc.momas.dms.mapper.RoleFunctionMapper;
import cc.momas.dms.pojo.AuthRole;
import cc.momas.dms.pojo.AuthRoleExample;
import cc.momas.dms.pojo.RoleFunctionKey;
import cc.momas.dms.service.IAuthRoleService;
import cc.momas.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthRoleServiceImpl implements IAuthRoleService {

    @Autowired
    private AuthRoleMapper arMapper;
    @Autowired
    private RoleFunctionMapper rfMapper;

    @Override
    public int add(AuthRole role, List<Integer> functionIds) {
        int count = 0;
        count += arMapper.insert(role);
        RoleFunctionKey rfKey = null;
        for (Integer id : functionIds) {
            rfKey = new RoleFunctionKey();
            rfKey.setRoleId(role.getRoleId());
            rfKey.setRoleFunctionId(id);
            count += rfMapper.insert(rfKey);
        }
        return count;
    }

    @Override
    public Pager<AuthRole, AuthRoleExample> queryByPager(Pager<AuthRole, AuthRoleExample> pager) {
        pager.setTotalRecordCount(arMapper.countByExample(pager.getEntityExample()));
        pager.setList(arMapper.selectByExample(pager.getEntityExample()));
        return pager;
    }

    @Override
    public List<AuthRole> queryAll() {
        return arMapper.selectByExample(null);
    }

}
