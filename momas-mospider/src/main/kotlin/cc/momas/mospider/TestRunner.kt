package cc.momas.mospider

import org.jsoup.Jsoup
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors
import java.util.stream.IntStream


//fun main(args: Array<String>) {
//    TestRunner().run(null)
//}

//@Component
class TestRunner() : ApplicationRunner {
    val log: Logger = LoggerFactory.getLogger(TestRunner::class.java)

    @Autowired
    private lateinit var repo: SpiderDataRepository;

    override fun run(args: ApplicationArguments?) {
        val lastPage = getLastPage()
        log.info("last page =$lastPage")
        val urls = generateUrl(lastPage)
        log.info("ready to fetch")
        submitToFetch(urls)
    }

    fun submitToFetch(urls: List<String>) {
        for (url in urls) {
            log.info("prepare get url=$url")
            val doc = Jsoup.connect(url).get()
            log.info("get from $url done, doc=$doc")
            val elements = doc.select(".post.post-last li")
            for (element in elements) {
                log.info(" url=$url,doc=$element")
                val href = element.selectFirst("a")?.attr("href")
                if (href == null || href.startsWith("/open.php")) {
                    continue
                }
                val base64 =
                    element.selectFirst("script")?.data()?.replace("document.write(d('", "")?.replace("'));", "")
                val title = String(Base64.getDecoder().decode(base64))

                val completeHref = "http://bthy.xyz$href"
                val entity = SpiderData(completeHref, title)
                log.info("url={},title={}", completeHref, title)
                repo.save(entity)
            }
            TimeUnit.SECONDS.sleep(Random().nextInt(20).toLong())
        }

    }

    fun generateUrl(lastPage: Int): List<String> {
        return IntStream.range(1, lastPage)
            .mapToObj() { "http://bthy.xyz/list.php?class=guochan&page=$it" }
            .collect(Collectors.toList())
    }


    private fun getLastPage(): Int {
        val url = "http://bthy.xyz/list.php?class=guochan"
        val html = Jsoup.connect(url).get()
//        Jsoup.parse(page)
        val cssSelector = "#content ul.pagination li:last-child a"
        val element = html.selectFirst(cssSelector)
        val href = element?.attr("href")
        log.info(href)
        val page = parameterMap(href)?.get("page")
        return Integer.parseInt(page)
    }

    fun parameterMap(url: String?): Map<String, String>? {
        if (url == null) {
            return Collections.emptyMap()
        }
        val map: MutableMap<String, String> = HashMap()
        val index = url.indexOf("?")
        if (index == -1) {
            return map
        }
        val param = url.substring(index + 1)
        if (param.isNotBlank()) {
            val params = param.split("&").toTypedArray()
            for (item in params) {
                val kv = item.split("=").toTypedArray()
                if (kv.isNotEmpty()) {
                    if (kv[0].isNotBlank()) {
                        var value = ""
                        if (kv[1].isNotBlank()) {
                            val kv1Index = kv[1].indexOf("#")
                            value = if (kv1Index != -1) {
                                kv[1].substring(0, kv1Index)
                            } else {
                                kv[1]
                            }
                        }
                        map[kv[0]] = value
                    }
                }
            }
        }
        return map
    }
}