package cc.momas.mospider

import org.jsoup.Jsoup
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MomasMospiderApplicationTests {

    @Autowired
    lateinit var spiderDataRepository: SpiderDataRepository

    @Test
    fun contextLoads() {
        val spiderData = SpiderData("url", "title")
        spiderDataRepository.save(spiderData);
    }

    @Test
    fun getById(): Unit {
        val byId = spiderDataRepository.getById(1L)
        println(byId)
    }

    @Test
    fun jsoupGetTest(): Unit {
        val url = "http://www.baidu.com"
        val doc = Jsoup.connect(url).get()
        println(doc);
    }
}
