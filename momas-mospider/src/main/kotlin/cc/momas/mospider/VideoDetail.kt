package cc.momas.mospider

import javax.persistence.*

@Entity
@Table(name = "video_detail")
data class VideoDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "page_url")
    val pageUrl: String,
    @Column(name = "page_title")
    val pageTitle: String,
    @Column(name = "video_size")
    val videoSize: String?,
    @Column(name = "video_duration")
    val videoDuration: String?,
    @Column(name = "video_resolution")
    val videoResolution: String?,
    @Column(name = "video_format")
    val videoFormat: String?,
    @Column(name = "video_publish_date")
    val videoPublishDate: String?,
    @Column(name = "video_magnet")
    val videoMagnet: String?,
    @Column(name = "vadeo_torrent_link")
    val videoTorrentLink: String?,
)
