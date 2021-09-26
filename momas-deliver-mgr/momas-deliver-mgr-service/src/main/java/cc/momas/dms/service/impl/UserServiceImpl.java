package cc.momas.dms.service.impl;

import cc.momas.dms.mapper.TUserMapper;
import cc.momas.dms.mapper.UserRoleMapper;
import cc.momas.dms.pojo.TUser;
import cc.momas.dms.pojo.TUserExample;
import cc.momas.dms.pojo.UserRoleKey;
import cc.momas.dms.service.IUserService;
import cc.momas.util.MD5Util;
import cc.momas.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private UserRoleMapper urMapper;

    @Override
    public TUser queryLogin(String name, String password) {
        TUserExample example = new TUserExample();
        password = MD5Util.md5(password);
        example.createCriteria()
                .andUsernameEqualTo(name)
                .andPasswordEqualTo(password);

        List<TUser> user = userMapper.selectByExample(example);
        if (null != user && user.size() > 0) {
            return user.get(0);
        }
        return null;
    }

    @Override
    public Pager<TUser, TUserExample> queryByPager(Pager<TUser, TUserExample> pager) {
        if (pager.getEntity() != null) {
            //添加条件,做条件查询
            TUserExample example = new TUserExample();
            pager.setEntityExample(example);
        }
        List<TUser> list = userMapper.selectByPager(pager);
        int totalrecord = userMapper.countByExample(pager.getEntityExample());
        pager.setList(list);
        pager.setTotalRecordCount(totalrecord);
        return pager;
    }


    @Override
    public int save(TUser user, int roleid) {
        int count = userMapper.insert(user);
        UserRoleKey ur = new UserRoleKey();
        ur.setRoleId(roleid);
        ur.setUserId(user.getUserId());
        count += urMapper.insert(ur);
        return count;
    }

}
