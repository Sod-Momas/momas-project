package cc.momas.news.web.servlet;

import cc.momas.news.common.BeanFactory;
import cc.momas.news.constant.UserConstant;
import cc.momas.news.entity.User;
import cc.momas.news.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用于身份验证的Servlet
 *
 * @author sothe
 */
@WebServlet(value = {"/auth"}, description = "用于身份验证", displayName = "AuthServlet", name = "AuthServlet")
public class AuthServlet extends BaseServlet {

    private static final Logger log = LoggerFactory.getLogger(AuthServlet.class);
    private static final long serialVersionUID = 1;
    private static final UserService userService = (UserService) BeanFactory.getBean(BeanFactory.SERVICE_USER);

    /**
     * 用于注销登录
     * 这里本应该使用DELETE方法, 但表单提交不支持DELETE方法, 所以就妥协一下
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();
        if (session != null) {
            log.debug("user logout, session id is {}", session.getId());
            session.invalidate(); // 注销整个Session
        }
        // 相当于删除这个Cookie
        response.addCookie(new Cookie("X-LOGIN", null));
        response.sendRedirect("index.jsp");
    }

    /**
     * 用于登录
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 接收参数
        String username = getParamReqired("username");
        String password = getParamReqired("password");

        // 调用业务
        User currentUser = userService.login(username, password);// 登录失败会抛出业务异常

        log.info("user login, user id is {}, user name is {}", currentUser.getId(), username);

        // 登录成功把用户放进session里
        HttpSession session = request.getSession();
        session.setAttribute(UserConstant.LOGIN_USER, currentUser);
        // 保存用户的管理员状态
        boolean isAdmin = currentUser.getIsAdmin();
        if (isAdmin) {
            session.setAttribute(UserConstant.IS_ADMIN, isAdmin);
        }
        response.addCookie(new Cookie("X-LOGIN", "success"));
        response.sendRedirect("index.jsp");
    }


}
