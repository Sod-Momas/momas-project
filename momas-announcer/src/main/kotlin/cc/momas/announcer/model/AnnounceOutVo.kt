package cc.momas.announcer.model

import java.sql.Date

/**
 * @author Sod-Momas
 * @since 2019.12.19
 */
data class AnnounceOutVo(
  private val id: Int? = null,
  private val title: String? = null,
  private val titleImageUrl: String? = null,
  private val content: String? = null,
  private val isShow: Boolean? = null,
  private val sortNo: Int? = null,
  private val senderName: String? = null,
  private val deprecateDatetime: Date? = null,
  private val tag: String? = null,
  private val insertUserId: Long? = null,
  private val updateUserId: Long? = null,
  private val insertDatetime: Date? = null,
  private val updateDatetime: Date? = null
)