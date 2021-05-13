package cc.momas.announcer.service.impl

import cc.momas.announcer.dao.AnnounceRepository
import cc.momas.announcer.model.*
import cc.momas.announcer.service.AnnounceService
import org.springframework.stereotype.Service

/**
 * @author Sod-Momas
 * @since 2019.12.19
 */
@Service
class AnnounceServiceImpl(private val repository: AnnounceRepository) : AnnounceService {

  override fun add(inVo: AddAnnounceInVo?): AddAnnounceOutVo {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun get(inVo: GetAnnounceInVo?): GetAnnounceOutVo {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun count(inVo: ListAnnounceInVo?): Long {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun list(inVo: ListAnnounceInVo?): List<AnnounceOutVo> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun edit(inVo: EditAnnounceInVo?): EditAnnounceOutVo {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun delete(inVo: DeleteAnnounceInVo?): DeleteAnnounceOutVo {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}