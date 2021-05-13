package cc.momas.announcer.controller

import cc.momas.announcer.model.*
import cc.momas.announcer.service.AnnounceService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/announce")
class AnnounceController(val service: AnnounceService) {
  /**
   * 添加公告
   */
  fun add(inVo: AddAnnounceInVo): AddAnnounceOutVo = service.add(inVo)

  /**
   * 查询一条公告
   */
  fun get(inVo: GetAnnounceInVo): GetAnnounceOutVo = service.get(inVo)

  /**
   * 查询公告列表
   */
  fun list(inVo: ListAnnounceInVo): ListAnnounceOutVo {
    val total = service.count(inVo)
    //
    if (total > 0) {
      val outList = service.list(inVo)
      return ListAnnounceOutVo(inVo.page, total, outList)
    }
    // 空列表
    return ListAnnounceOutVo(inVo.page, total, Collections.emptyList())
  }

  /**
   * 编辑公告
   */
  fun edit(inVo: EditAnnounceInVo): EditAnnounceOutVo = service.edit(inVo)

  /**
   * 删除公告
   */
  fun delete(inVo: DeleteAnnounceInVo): DeleteAnnounceOutVo = service.delete(inVo)
}