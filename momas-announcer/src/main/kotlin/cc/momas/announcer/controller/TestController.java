package cc.momas.announcer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("ping")
    public Mono<String> ping() {
        return Mono.just("pong");
    }
}
