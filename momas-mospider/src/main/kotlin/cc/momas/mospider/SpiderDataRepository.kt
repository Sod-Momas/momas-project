package cc.momas.mospider

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface SpiderDataRepository : JpaRepository<SpiderData, Long>, JpaSpecificationExecutor<SpiderData> {
}