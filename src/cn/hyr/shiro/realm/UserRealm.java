package cn.hyr.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @category 自定义realm的实现。
 * @author huangyueran
 *
 */
public class UserRealm extends AuthorizingRealm {

	/**
	 * @category 授权的信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @category 完成身份认证(从数据库中取数据),并返回认证信息。如果失败返回null
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户输入的用户名
		String username = (String) token.getPrincipal(); // 获取身份信息
		System.out.println("username====" + username);
		// 根据用户名到数据库查询密码信息---模拟
		// 假定才能够数据库获取的密码为1111
		// TODO 这里查询数据库 获取用户信息
		String pwd = "1111";
		// 将从数据库中查询的信息封装到SimpleAuthenticationInfo中返回
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getPrincipal(), pwd, getName());
		return info;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "userCustomRealm";
	}

}
