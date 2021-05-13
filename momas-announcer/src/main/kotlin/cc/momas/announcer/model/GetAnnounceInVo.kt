package cc.momas.announcer.model

import java.sql.Date

/**
 * @author Sod-Momas
 * @since 2019.12.19
 */
data class GetAnnounceInVo(
  val id: Int? = null,
  val title: String? = null,
  val titleImageUrl: String? = null,
  val content: String? = null,
  val isShow: Boolean? = null,
  val sortNo: Int? = null,
  val senderName: String? = null,
  val deprecateDatetime: Date? = null,
  val tag: String? = null,
  val insertUserId: Long? = null,
  val updateUserId: Long? = null,
  val insertDatetime: Date? = null,
  val updateDatetime: Date? = null
)