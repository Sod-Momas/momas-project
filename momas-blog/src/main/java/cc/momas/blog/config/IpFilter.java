package cc.momas.blog.config;

import cc.momas.blog.util.IpUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 用来记录ip地址
 */
@Component
public class IpFilter implements Filter {
    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        IpUtils.setIp(servletRequest.getRemoteAddr());
        filterChain.doFilter(servletRequest, servletResponse);
        IpUtils.setIp("");
    }
}
