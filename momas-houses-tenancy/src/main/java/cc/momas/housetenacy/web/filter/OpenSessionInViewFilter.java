package cc.momas.housetenacy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import cc.momas.housetenacy.utils.HibernateSessionFactory;

public class OpenSessionInViewFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Transaction tx = null;
		try{
			//请求到达时打开session并启动事务
			tx = HibernateSessionFactory.getSession().beginTransaction();
			//执行处理链
			chain.doFilter(request, response);
			//提交事务
			tx.commit();
		}catch (HibernateException e) {
			if(tx != null){
				tx.rollback();
			}
		}
	}
	public void destroy() {
	}


	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
