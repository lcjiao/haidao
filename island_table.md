##1. 区域表
------

    CREATE TABLE `area` (
    `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name` varchar(50) DEFAULT NULL COMMENT '区域名称',
    `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
    `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
    `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
    `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
    `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8
    
------

##2. 岛屿表
-------

    CREATE TABLE `island` (
    `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `area_id` int(8) DEFAULT NULL COMMENT '归属区域编号',
    `name` varchar(50) DEFAULT NULL COMMENT '岛屿名称',
    `country` varchar(50) DEFAULT NULL COMMENT '归属国家',
    `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
    `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
    `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
    `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
    `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8

------

##3. 全站推荐表
------
  
    CREATE TABLE `recommend` (
    `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `module_id` int(4) NOT NULL COMMENT '模块编号 页面得每一个推荐位设定1个编号 前端展示时候根据编号获取推荐数据',
    `module_desc` varchar(50) DEFAULT NULL COMMENT '模块描述 如 首页大图推荐 ',
    `title` varchar(200) DEFAULT NULL COMMENT '主题',
    `content` varchar(500) DEFAULT NULL COMMENT '内容',
    `desc` varchar(500) DEFAULT NULL COMMENT '备注',
    `img_url` varchar(500) DEFAULT NULL COMMENT '图片地址',
    `link_url` varchar(500) DEFAULT NULL COMMENT '链接地址',
    `price` varchar(50) DEFAULT NULL COMMENT '价格',
    `tel` varchar(50) DEFAULT NULL COMMENT '联系电话',
    `area_id` int(4) DEFAULT NULL COMMENT '区域编号',
    `area_name` varchar(50) DEFAULT NULL COMMENT '区域名称',
    `island_id` int(4) DEFAULT NULL COMMENT '岛屿编号',
    `island_name` varchar(50) DEFAULT NULL COMMENT '岛屿名称',
    `index` int(4) DEFAULT NULL COMMENT '排序',
    `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
    `big_img_url` varchar(500) DEFAULT NULL COMMENT '大图地址',
    `small_img_url` varchar(500) DEFAULT NULL COMMENT '小图图地址',
    `link_obligate` varchar(500) DEFAULT NULL COMMENT '链接地址预留',
    `price_big` varchar(50) DEFAULT NULL COMMENT '旺季价格',
    `price_small` varchar(50) DEFAULT NULL COMMENT '淡季价格',
    `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
    `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
    `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
    `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
    `type_id` int(4) DEFAULT NULL COMMENT '推荐类型',
    `type_name` varchar(50) DEFAULT NULL COMMENT '推荐类型名称',
    `view_link` varchar(500) DEFAULT NULL COMMENT '视频地址',
    PRIMARY KEY (`id`),
    UNIQUE KEY `module_key` (`module_id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8
    
--------

##4. 图片表
--------

    CREATE TABLE `image` (
    `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `img_url` varchar(500) DEFAULT NULL COMMENT '图片地址',
    `desc` varchar(100) DEFAULT NULL COMMENT '备注',
    `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
    `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
    `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
    `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
    `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8
    
---------


##5.套餐表
---------

    CREATE TABLE `package` (
    `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `package_type` int(2) DEFAULT NULL COMMENT '套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐         5:自由行套餐',
    `title` varchar(200) DEFAULT NULL COMMENT '套餐标题',
    `content` varchar(10000) DEFAULT NULL COMMENT '套餐内容',
    `default_img` varchar(500) DEFAULT NULL COMMENT '默认图',
    `package_imgs` varchar(500) DEFAULT NULL COMMENT '套餐图片集  图片id 以逗号间隔',
    `price_big` varchar(50) DEFAULT NULL COMMENT '旺季价格',
    `price_small` varchar(50) DEFAULT NULL COMMENT '淡季价格',
    `area_id` int(4) DEFAULT NULL COMMENT '区域编号',
    `area_name` varchar(50) DEFAULT NULL COMMENT '区域名称',
    `island_id` int(4) DEFAULT NULL COMMENT '岛屿编号',
    `island_name` varchar(50) DEFAULT NULL COMMENT '岛屿名称',
    `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
    `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
    `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
    `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
    `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`id`),
    KEY `title` (`title`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8
    
---------


##6.
    
