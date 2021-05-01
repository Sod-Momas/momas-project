package cc.momas.housetenacy.web.interceptor;

import java.util.Map;

import cc.momas.housetenacy.entity.Users;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		Users user = (Users) session.get("LOGIN_USER");
		if (user == null) {
			return Action.LOGIN;
		}
		return invocation.invoke();
	}

}
