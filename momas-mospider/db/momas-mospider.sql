# MySQL
CREATE SCHEMA `momas-mospider` DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_bin;
USE momas-mospider;

CREATE TABLE `momas-mospider`.`spider_data` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `page_url` VARCHAR(512) NULL COMMENT '页面地址',
  `page_title` VARCHAR(512) NULL COMMENT '页面标题',
  `insert_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
COMMENT = '蜘蛛数据表';

CREATE TABLE `momas-mospider`.`video_detail` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `page_url` VARCHAR(128) NULL COMMENT '页面地址',
  `page_title` VARCHAR(128) NULL COMMENT '页面标题',
  `video_size` VARCHAR(45) NULL COMMENT '视频体积',
  `video_duration` VARCHAR(45) NULL COMMENT '视频时长',
  `video_revlution` VARCHAR(45) NULL COMMENT '视频分辨率',
  `video_format` VARCHAR(45) NULL COMMENT '视频格式',
  `video_publish_date` VARCHAR(45) NULL COMMENT '视频发布日期',
  `video_magnet` VARCHAR(2048) NULL COMMENT '视频磁力链接',
  `vadeo_torrent_link` VARCHAR(2048) NULL COMMENT '视频torrent文件下载地址',
  PRIMARY KEY (`id`))
COMMENT = '视频详情列表';
