package cc.momas;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * @author Sod-Momas
 * @since 2021-01-17
 */
@SpringBootTest
public class MomasTestAppApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(MomasTestAppApplicationTests.class);
    @Value("${server.port}")
    private int localPort;

    @Test
    void contextLoads() {
        System.out.println("hello " + System.getProperty("java.version"));
    }

    @Test
    @Disabled("测试会失败，可能由于spring boot测试的时候没有监听web端口")
    public void testHello() {
        String str = "{\"test\":1}";
        URI url = URI.create("http://localhost:" + localPort + "/test/hello");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .timeout(Duration.ofSeconds(3))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(str))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(res -> {
                    System.out.println(res);
                    System.out.println(str.equals(res));
                })
                .join();
    }

}
