package cc.momas.mospider

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class MomasMospiderApplicationTests {

    @Autowired
    lateinit var spiderDataRepository: SpiderDataRepository

    @Test
    fun contextLoads() {
        val spiderData =
            SpiderData(null, "url", "title", LocalDateTime.now(), LocalDateTime.now())
        spiderDataRepository.save(spiderData);
    }

    @Test
    fun getById(): Unit {
        val byId = spiderDataRepository.getById(1L)
        println(byId)
    }
}
