package cc.momas.mospider

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.net.HttpURLConnection
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct

@Component
class GetDetailFromPageRunner {
    private val repository: VideoRepository
    private val spiderRepository: SpiderDataRepository
    private val log = LoggerFactory.getLogger(GetDetailFromPageRunner::class.java)
    private val HOST = "http://btjc.xyz"
    private val BASE_DIR = "O:/spider"
    val regex = Regex("[:/\\\\]")

    //    private val threadPool = Executors.newFixedThreadPool(2)
    private val UA =
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.55 Safari/537.36 Edg/96.0.1054.41 Android"


    init {
        val dir = Paths.get(BASE_DIR)
        if (Files.notExists(dir)) {
            Files.createDirectories(dir)
        }
    }

    @PostConstruct
    fun startTask() {
        run()
    }

    constructor(repository: VideoRepository, spiderRepository: SpiderDataRepository) {
        this.repository = repository;
        this.spiderRepository = spiderRepository;
    }

    fun run() {
        val all = spiderRepository.findAll();
//        var count = 0
        for (data in all) {
//            threadPool.submit {
            try {
//                    if (data.hadDetail) {
//                        log.info("had detail:{}", data.pageTitle)
//                        continue
//                    }
                if (!data.hadDetail) {
                    log.info("get detail page,id={},url={}", data.id, data.pageUrl)
                    val doc = Jsoup.connect(HOST + data.pageUrl).get()
                    val detail = resolveDetail(data, doc);
                    saveDetail(data, detail)

//                        count++;
//                if (count % 20 == 0) {
//                    log.info("have a rest! 1 minutes.")
//                    TimeUnit.MINUTES.sleep(1)
//                } else {
//                    log.info("prepare to next, 2 seconds.")
//                    TimeUnit.SECONDS.sleep(2)
//                }
//                if (count % 20 == 0) {
//                    log.info("prepare to next, 20 seconds.")
//                    TimeUnit.SECONDS.sleep(20)
//                }
                } else {
                    log.info("had detail:{}", data.pageTitle)
                }
            } catch (e: Exception) {
//                    log.error("throw error,sleep 1 minute.", e)
                log.error("throw error", e)
//                    TimeUnit.MINUTES.sleep(1)
            }
//            }
        }
    }

    private fun resolveDetail(listItem: SpiderData, doc: Element): VideoDetailDto {
        val content = doc.selectFirst("#content")
            ?: throw RuntimeException(String.format("#content not exist!,id=%s,url=%s", listItem.id, listItem.pageUrl))

        // 视频基
        val base64 =
            content.selectFirst("script")?.data()?.replace("document.write(d('", "")?.replace("'));", "")
        val title = String(Base64.getDecoder().decode(base64))
        val pList = content.select("p")
        val publishDate = pList[0]?.text()
        val format = pList[1]?.text()
        val size = pList[2]?.text()
        val duration = pList[3]?.text()
        val resolution = pList[4]?.text()

        val imgs = content.select("img")
        val links = imgs.map { it.attr("src") }
        val downloadPageLink = content.selectFirst(".download a")?.attr("href")

        if (downloadPageLink == null) {
            return VideoDetailDto(
                pageUrl = listItem.pageUrl,
                pageTitle = title,
                videoSize = size,
                videoDuration = duration,
                videoRevlution = resolution,
                videoFormat = format,
                videoPublishDate = publishDate,
                videoImages = links,
                videoMagnet = "",
                videoTorrentLink = ""
            )
        }
        TimeUnit.SECONDS.sleep(1)

        log.info("get download page, id={},url={}", listItem.id, downloadPageLink)
        val dpage = Jsoup.connect(HOST + downloadPageLink).get()

        val preLinks = dpage.select("a")
        if (preLinks.isEmpty()) {
            return VideoDetailDto(
                pageUrl = listItem.pageUrl,
                pageTitle = title,
                videoSize = size,
                videoDuration = duration,
                videoRevlution = resolution,
                videoFormat = format,
                videoPublishDate = publishDate,
                videoImages = links,
                videoMagnet = "",
                videoTorrentLink = ""
            )
        }
        val magnet = preLinks.get(0).attr("href")
        val torrentLinks = preLinks[1].attr("href")

        return VideoDetailDto(
            pageUrl = listItem.pageUrl,
            pageTitle = title,
            videoSize = size,
            videoDuration = duration,
            videoRevlution = resolution,
            videoFormat = format,
            videoPublishDate = publishDate,
            videoImages = links,
            videoMagnet = magnet,
            videoTorrentLink = torrentLinks
        )
    }

    private fun saveDetail(listItem: SpiderData, dto: VideoDetailDto) {
        val detail = VideoDetail(
            id = null,
            pageUrl = dto.pageUrl.orEmpty(),
            pageTitle = dto.pageTitle.orEmpty(),
            videoSize = dto.videoSize.orEmpty(),
            videoDuration = dto.videoDuration.orEmpty(),
            videoResolution = dto.videoRevlution.orEmpty(),
            videoFormat = dto.videoFormat.orEmpty(),
            videoPublishDate = dto.videoPublishDate.orEmpty(),
            videoMagnet = dto.videoMagnet.orEmpty(),
            videoTorrentLink = dto.videoTorrentLink.orEmpty()

        )
        // 如果是null就使用0L
        val itemId = listItem.id ?: 0L
        downloadFile(itemId, dto)
        repository.save(detail)
        listItem.hadDetail = true
        spiderRepository.save(listItem)
    }

    private fun downloadFile(id: Long, dto: VideoDetailDto) {
        val root = cleanRoot(id, dto)
        Files.write(root.resolve(dto.pageTitle!! + ".txt"), (dto.videoMagnet ?: "").toByteArray())

//        TimeUnit.SECONDS.sleep(1)
        try {
            if (!dto.videoTorrentLink.isNullOrBlank()) {
                // download torrent
                log.info("get torrent, id={}, url={}", id, dto.videoTorrentLink)
                val torrent = URL(HOST + dto.videoTorrentLink).openConnection() as HttpURLConnection
                torrent.apply {
                    val dest = root.resolve(filename(dto.videoTorrentLink))
                    if (Files.notExists(dest.parent)) {
                        Files.createDirectories(dest.parent)
                    }
                    this.setRequestProperty("User-Agent", UA)
                    this.readTimeout = 6000
                    this.connectTimeout = 6000
                    this.connect()
                    Files.copy(torrent.inputStream, dest)
                    this.disconnect()
                }
            }
        } catch (e: Exception) {
            log.error("torrent need catch! item id={}, url={}", id, dto.videoTorrentLink, e)
        }
        if (dto.videoImages.isEmpty()) {
            return
        }
        dto.videoImages.stream().parallel().forEach {
            // download images
            log.info("get img, id={}, url={}", id, it)
            val connect = URL(HOST + it).openConnection() as HttpURLConnection
            try {
                val dest = root.resolve(filename(it))
                if (Files.notExists(dest.parent)) {
                    Files.createDirectories(dest.parent)
                }
                connect.setRequestProperty("User-Agent", UA)
                connect.readTimeout = 6000
                connect.connectTimeout = 6000
                connect.connect()
                Files.copy(connect.inputStream, dest)
            } catch (e: Exception) {
                log.error("picture catch error, item id={}", id, e)
            } finally {
                connect.disconnect()
            }
        }
    }

    private fun cleanRoot(id: Long, dto: VideoDetailDto): Path {
        var title = dto.pageTitle ?: throw RuntimeException("title null!,id=$id")
        if (title.contains(regex)) {
            title = title.replace(regex, " ")
        }
        val dir = StringBuilder().append(id).append("_").append(title).toString()
        val root = Paths.get(BASE_DIR, dir)
        if (Files.notExists(root)) {
            Files.createDirectories(root)
        } else {
            // 说明该数据需要重新抓取，删除所有文件重新生成
            Files.walk(root).forEach {
                if (Files.isRegularFile(it)) {
                    Files.delete(it)
                }
            }
        }
        return root
    }

    private fun filename(url: String?): String {
        if (url == null) {
            return ""
        }
        val lastIndexOf = url.lastIndexOf("/")
        if (lastIndexOf == -1) {
            return ""
        }
        return url.substring(lastIndexOf + 1)
    }
}
