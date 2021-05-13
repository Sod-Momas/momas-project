package cc.momas.news.web.filter;

import cc.momas.news.common.JsonUtil;
import cc.momas.news.web.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * News项目过滤器, 所有请求都会先经过过滤器再经过Servlet. 这个过滤器的功能有:
 *
 * <li>编码设置, 把所有请求和响应都设置为UTF-8, 防止乱码产生
 * <li>统一处理异常, 当请求发生异常的时候, 由这个Filter拦截,然后转发给异常处理器处理
 *
 * @author Sod-Momas
 */
@WebFilter(value = {"/*"})
public class ApplicationFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(ApplicationFilter.class);

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {

        setEncoding(request, response);
        validUser();

        // 统一异常设置
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            // 转发给异常处理器处理
            ResponseEntity responseEntity = ExceptionHandler.handle(e);
            String json = JsonUtil.toJson(responseEntity);
            response.getWriter().println(json);
        }
    }

    private void validUser() {
        // TODO: 身份验证要在这里做
    }

    private void setEncoding(ServletRequest request, ServletResponse response) throws UnsupportedEncodingException {
        // 编码设置,让中文不会乱码
        request.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType("application/json;charset=utf-8");
    }

    public void destroy() {
    }

    public void init(FilterConfig fConfig) {
        log.info("filter init...");
    }

}
