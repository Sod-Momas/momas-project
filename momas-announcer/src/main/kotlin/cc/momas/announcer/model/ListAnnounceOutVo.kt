package cc.momas.announcer.model

/**
 * @author Sod-Momas
 * @since 2019.12.19
 */
data class ListAnnounceOutVo(
  var page: Int = 1,
  val total: Long = 0,
  var rows: List<AnnounceOutVo>
)