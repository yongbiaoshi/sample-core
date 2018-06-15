-- 创建表
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` char(32) NOT NULL COMMENT '用户唯一编号',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `age` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '年龄',
  `mobile_num` char(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(100) NOT NULL DEFAULT '' COMMENT 'email地址',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '地址',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `last_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



