package cc.momas.announcer.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/test")
class KotlinTestController {

  @RequestMapping("kt")
  fun hello(@RequestParam(defaultValue = "kotlin") name: String): Mono<String> {
    return Mono.just("Hello $name")
  }

}