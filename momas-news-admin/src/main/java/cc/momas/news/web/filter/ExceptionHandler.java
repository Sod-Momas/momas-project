package cc.momas.news.web.filter;

import cc.momas.news.NewsException;
import cc.momas.news.web.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器. 该处理器不公开, 只让Filter使用.
 *
 * @author Sod-Momas
 */
abstract class ExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    static ResponseEntity handle(Exception e) {

        // 业务异常, 数据校验错误等
        if (e instanceof NewsException) {
            log.warn("bussiness exception", e);
            return ResponseEntity.error(e.getMessage(), HttpServletResponse.SC_BAD_REQUEST);
        }

        // 不可控制的异常, 资源找不到等
        if (e instanceof RuntimeException || e instanceof ServletException) {
            log.warn("runtime exception", e);
            return ResponseEntity.error(e.getMessage(), HttpServletResponse.SC_BAD_REQUEST);
        }

        // 不可预测的异常,最终解决方案
        log.error("error", e);
        return ResponseEntity.error("server error, please wait for minutes. 服务器异常,请稍后再试");

    }
}
