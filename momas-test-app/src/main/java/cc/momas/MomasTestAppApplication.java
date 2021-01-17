package cc.momas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Sod-Momas
 * @since 2021-01-17
 */
@SpringBootApplication
public class MomasTestAppApplication {
    private static final Logger log = LoggerFactory.getLogger(MomasTestAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MomasTestAppApplication.class, args);
    }

    @RestController
    @RequestMapping(value = "test")
    static class TestController {
        @RequestMapping("hello")
        public Map<String, Object> hello(@Validated @RequestBody(required = false) Map<String, Object> req) {
            log.info("request: {}", req);
            return req;
        }
    }
}
