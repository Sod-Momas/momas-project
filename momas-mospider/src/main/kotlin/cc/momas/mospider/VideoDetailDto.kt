package cc.momas.mospider

data class VideoDetailDto(
    val pageUrl: String?,
    val pageTitle: String?,
    val videoSize: String?,
    val videoDuration: String?,
    val videoRevlution: String?,
    val videoFormat: String?,
    val videoPublishDate: String?,
    val videoMagnet: String?,
    val videoTorrentLink: String?,
    val videoImages: List<String>
)
