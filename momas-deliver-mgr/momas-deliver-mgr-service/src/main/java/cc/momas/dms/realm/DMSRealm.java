package cc.momas.dms.realm;

import cc.momas.dms.mapper.AuthFunctionMapper;
import cc.momas.dms.mapper.TUserMapper;
import cc.momas.dms.pojo.AuthFunction;
import cc.momas.dms.pojo.TUser;
import cc.momas.dms.pojo.TUserExample;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DMSRealm extends AuthorizingRealm {

    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private AuthFunctionMapper funcmapper;

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("执行登录");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登录用户对象
        TUser user = (TUser) SecurityUtils.getSubject().getPrincipal();
        //根据当前登录用户查询数据库,获取实际对应的权限
        List<AuthFunction> list = null;
        if ("admin".equals(user.getUsername())) {
            //内置的超级管理员,查询所有数据
            list = funcmapper.selectByExample(null);
        } else {
            list = funcmapper.selectAllFunctionByUserId(user.getUserId());
        }
        for (AuthFunction authFunction : list) {
            info.addStringPermission(authFunction.getCode());
        }
        return info;
    }

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("自定义的realm中认证方法执行了");
        UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
        //获得页面输入的用户名
        String username = passwordToken.getUsername();
        //根据用户名查询数据库中的密码
        TUserExample userExample = new TUserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<TUser> list = userMapper.selectByExample(userExample);
        if (list == null || list.size() == 0) {
            //页面输入的用户名不存在
            return null;
        }
        //简单认证信息对象
        AuthenticationInfo info = new SimpleAuthenticationInfo(list.get(0), list.get(0).getPassword(), this.getName());
        //框架负责比对数据库中的密码和页面输入的密码是否一致
        return info;
    }


}
