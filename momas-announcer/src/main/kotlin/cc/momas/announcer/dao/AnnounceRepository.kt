package cc.momas.announcer.dao

import cc.momas.announcer.model.Announce
import org.springframework.data.jpa.repository.JpaRepository

/**
 * 公告仓库
 * @author Sod-Momas
 * @since 2019.12.19
 */
interface AnnounceRepository : JpaRepository<Announce?, Int?>