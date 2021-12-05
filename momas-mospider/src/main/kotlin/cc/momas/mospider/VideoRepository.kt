package cc.momas.mospider

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface VideoRepository : JpaRepository<VideoDetail, Long>, JpaSpecificationExecutor<VideoDetail> {
}