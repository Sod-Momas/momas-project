package cc.momas.eurekaserver;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class MomasTestEurekaClientApplication {

	private static final Logger log = LoggerFactory.getLogger(MomasTestEurekaClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MomasTestEurekaClientApplication.class, args);
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
