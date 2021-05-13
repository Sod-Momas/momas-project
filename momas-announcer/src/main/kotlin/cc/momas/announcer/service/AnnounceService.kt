package cc.momas.announcer.service

import cc.momas.announcer.model.*

/**
 * @author Sod-Momas
 * @since 2019.12.19
 */
interface AnnounceService {
  fun add(inVo: AddAnnounceInVo?): AddAnnounceOutVo
  fun get(inVo: GetAnnounceInVo?): GetAnnounceOutVo
  fun count(inVo: ListAnnounceInVo?): Long
  fun list(inVo: ListAnnounceInVo?): List<AnnounceOutVo>
  fun edit(inVo: EditAnnounceInVo?): EditAnnounceOutVo
  fun delete(inVo: DeleteAnnounceInVo?): DeleteAnnounceOutVo
}