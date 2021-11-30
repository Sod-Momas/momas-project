package cc.momas.mospider

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "spider_data")
data class SpiderData(
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "page_url")
    val pageUrl: String,
    @Column(name = "page_title")
    val pageTitle: String,
    @Column(name = "insert_time")
    val insertTime: LocalDateTime,
    @Column(name = "update_time")
    val updateTime: LocalDateTime,
) {
    constructor(url: String, title: String) : this(null, url, title, LocalDateTime.now(), LocalDateTime.now())
}