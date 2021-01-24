package cc.momas.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Sod-Momas
 * @since 2021.01.24
 */
@SpringBootApplication
@EnableEurekaServer
public class MomasEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MomasEurekaServerApplication.class, args);
    }

}
