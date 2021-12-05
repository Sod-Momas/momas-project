package cc.momas.mospider

import org.jsoup.Jsoup
import java.net.HttpURLConnection
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

fun main(args: Array<String>) {
//    getDetailTest()
//    downloadFile()
//    filenameFromUrl();
    deleteDirectory()
}

fun deleteDirectory() {

    val path = Paths.get("O:\\spider\\30_精品小学妹露脸制服诱惑，身材超好干净无毛的逼逼特写展示给狼友看，口交大鸡巴真刺激射她小嘴里好骚啊")
    Files.walk(path).forEach {
        println(it);
        if (Files.isRegularFile(it)) {
            Files.delete(it)
        }
    }
//    Files.deleteIfExists(path)
    println(Files.exists(path))
}

fun filenameFromUrl() {
    val url = "http://btjc.xyz/picture/4288033607/thumb/00045.jpg";
    val lastIndexOf = url.lastIndexOf("/")
    if (lastIndexOf == -1) {
        return
    }
    println(url.substring(lastIndexOf + 1))
}

fun downloadFile() {

    val img = URL("http://btjc.xyz/picture/4288033607/thumb/00045.jpg")

    val httpUrl = img.openConnection() as HttpURLConnection
    httpUrl.setRequestProperty(
        "User-Agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:68.0) Gecko/20100101 Firefox/68.0"
    )
    //读取超时时间
    //读取超时时间
    httpUrl.readTimeout = 6000
    //连接超时时间
    //连接超时时间
    httpUrl.connectTimeout = 6000
    httpUrl.connect()
    Files.copy(httpUrl.inputStream, Paths.get("dest.jpg"))
    httpUrl.disconnect()
}

fun getDetailTest() {
    val page = getPage()
    val doc = Jsoup.parse(page)
    val content = doc.selectFirst("#content")
//    println(content)

    val base64 =
        content?.selectFirst("script")?.data()?.replace("document.write(d('", "")?.replace("'));", "")
    val title = String(Base64.getDecoder().decode(base64))
    val pList = content?.select("p")
    val publishDate = pList?.get(0)?.text()
    val format = pList?.get(1)?.text()
    val size = pList?.get(2)?.text()
    val duration = pList?.get(3)?.text()
    val resolution = pList?.get(4)?.text()

//    content.selectFirst(".capture a")

    val imgs = content?.select("img")
    val links = imgs?.map { it.attr("src") }

    val downloadPageLink = content?.selectFirst(".download a")?.attr("href")

    val downLoadPage = getDownloadPage(downloadPageLink)
    val dpage = Jsoup.parse(downLoadPage)
    val preLinks = dpage.select("a")
    val magnet = preLinks.get(0).attr("href")
    val torrentLinks = preLinks.get(1).attr("href")


    println("title=$title,date=$publishDate,format=$format,size=$size,duration=$duration,resolution=$resolution,links=$links")
    println("magnet link=$magnet,torrentLinks=$torrentLinks")
}

fun getDownloadPage(downloadPageLink: String?): String {
    val file = Paths.get("C:\\Users\\sod\\Downloads\\download-mage.html")
    return String(Files.readAllBytes(file))

}

private fun getPage(): String {
    val file = Paths.get("C:\\Users\\sod\\Downloads\\view-source_bthy.xyz_html_movie_pc_2842620005831122.html")
    return String(Files.readAllBytes(file))
}