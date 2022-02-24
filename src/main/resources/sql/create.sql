CREATE TABLE `user`
(
    `id`       bigint(20) auto_increment NOT NULL COMMENT '用户ID',
    `mobile`   varchar(255) NOT NULL COMMENT '手机号',
    `password` varchar(32) DEFAULT NULL COMMENT 'MD5(MD5(pass明文+固定salt) salt)',
    `salt`     varchar(45) DEFAULT NULL COMMENT '加密盐值',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
