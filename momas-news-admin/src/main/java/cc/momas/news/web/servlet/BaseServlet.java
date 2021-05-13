package cc.momas.news.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * 所有的Servlet都以这个类为超类
 * 
 * 其实这个类也就是添加了两个取参数的方法，比较方便逻辑编写,和从HttpServlet直接继承没有太大区别
 * 
 * @author sothereer@gmail.com
 *
 */
public abstract class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected HttpServletRequest httpRequest;
	protected HttpServletResponse httpResponse;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.httpRequest = req;
		this.httpResponse = resp;
		super.service(req, resp);
	}

	/**
	 * 获取请求参数
	 * 
	 * @param key 参数名
	 * @return 参数值
	 */
	protected String getParam(String key) {
		String value = this.httpRequest.getParameter(key);
//		log.debug("request parameter: key=[%s],value=[%s]", key, value); // 记录参数值
		return StringUtils.trim(value);
	}

	/**
	 * 获取请求必选参数
	 * 
	 * @param key 参数名
	 * @return 参数值
	 * @throws ServletException 当参数找不到发生
	 */
	protected String getParamReqired(String key) throws ServletException {
		String value = getParam(key);
		if (StringUtils.isBlank(value)) {
			throw new ServletException("缺少参数  : " + key);
		}
		return value;
	}
}
