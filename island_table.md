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
    `package_type` int(2) DEFAULT NULL COMMENT '套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐  5:自由行套餐',
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


##6. 套餐详细信息表
---------

        CREATE TABLE `package_detail_info` (
        `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `package_id` int(8) DEFAULT NULL COMMENT '套餐编号',
        `package_type` int(2) DEFAULT NULL COMMENT '套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐 5:自由行套餐',
        `content` text COMMENT '套餐详细介绍',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        PRIMARY KEY (`id`),
        KEY `package_index` (`package_id`)
        ) ENGINE=MyISAM DEFAULT CHARSET=utf8
        
-----------

##7. 套餐图片推荐表
-----------

        CREATE TABLE `package_img_recommend` (
        `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `package_id` int(8) DEFAULT NULL COMMENT '套餐编号',
        `package_type` int(2) DEFAULT NULL COMMENT '套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐 5:自由行套餐',
        `img_url` varchar(500) DEFAULT NULL COMMENT '图片地址',
        `img_desc` varchar(500) DEFAULT NULL COMMENT '图片描述',
        `is_master` int(2) DEFAULT NULL COMMENT '是否主推 1:是  0否',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        `index` varchar(4) DEFAULT NULL COMMENT '排序',
        PRIMARY KEY (`id`),
        KEY `package_index` (`package_id`)
        ) ENGINE=MyISAM DEFAULT CHARSET=utf8
        
------------

##8. 套餐客片留影表
-----------

        CREATE TABLE `package_kepianliuying` (
        `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `package_id` int(8) DEFAULT NULL COMMENT '套餐编号',
        `package_type` int(2) DEFAULT NULL COMMENT '套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐 5:自由行套餐',
        `img` varchar(500) DEFAULT NULL COMMENT '图片地址',
        `desc` varchar(500) DEFAULT NULL COMMENT '描述',
        `link` varchar(500) DEFAULT NULL COMMENT '链接地址',
        `index` int(4) DEFAULT NULL COMMENT '排序',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        PRIMARY KEY (`id`),
        KEY `package_index` (`package_id`)
        ) ENGINE=MyISAM DEFAULT CHARSET=utf8
        
------------

##9. 套餐客户咨询表
------------

        CREATE TABLE `package_qa` (
        `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `package_id` int(8) DEFAULT NULL COMMENT '套餐编号',
        `package_type` int(2) DEFAULT NULL COMMENT '套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐 5:自由行套餐',
        `question` varchar(500) DEFAULT NULL COMMENT '咨询内容',
        `answer` varchar(500) DEFAULT NULL COMMENT '答复内容',
        `is_guest` int(2) DEFAULT NULL COMMENT '1:游客提问  2:客服提问',
        `is_answer` int(2) DEFAULT NULL COMMENT '是否回复 1回复 0没回复',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `ask_time` int(10) DEFAULT NULL COMMENT '提问时间',
        `asker` varchar(50) DEFAULT NULL COMMENT '咨询人',
        `answer_time` int(10) DEFAULT NULL COMMENT '答复时间',
        `answer_person` varchar(50) DEFAULT NULL COMMENT '答复人',
        PRIMARY KEY (`id`),
        KEY `package_index` (`package_id`)
        ) ENGINE=MyISAM DEFAULT CHARSET=utf8
        
-------------

##10. 前台菜单表
-------------

        CREATE TABLE `front_menu` (
        `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `module_id` int(2) DEFAULT NULL COMMENT '所属模块编号',
        `module_name` varchar(50) DEFAULT NULL COMMENT '所属模块名称如婚礼套餐',
        `country` varchar(50) DEFAULT NULL COMMENT '归属国家',
        `menu_name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
        `menu_url` varchar(500) DEFAULT NULL COMMENT '菜单链接',
        `parent_id` int(4) DEFAULT NULL COMMENT '父菜单编号',
        `has_child` int(2) DEFAULT NULL COMMENT '是否有子菜单 1有  0无',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        PRIMARY KEY (`id`)
        ) ENGINE=MyISAM DEFAULT CHARSET=utf8
        
-------------

##11. 摄影团队表
-------------

        CREATE TABLE `work_team` (
        `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `name` varchar(50) DEFAULT NULL COMMENT '名称',
        `content` varchar(5000) DEFAULT NULL COMMENT '简介',
        `team_person` varchar(2000) DEFAULT NULL COMMENT '团队构建',
        `img` varchar(500) DEFAULT NULL COMMENT 'log',
        `tel` varchar(20) DEFAULT NULL COMMENT '电话',
        `level` varchar(50) DEFAULT NULL COMMENT '等级',
        `price_small` varchar(50) DEFAULT NULL COMMENT '淡季价格',
        `price_big` varchar(50) DEFAULT NULL COMMENT '旺季价格',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        PRIMARY KEY (`id`)
        ) ENGINE=MyISAM DEFAULT CHARSET=utf8
        
------------

##12. 摄影工作人员表
------------

        CREATE TABLE `workman` (
        `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `work_type` int(2) DEFAULT NULL COMMENT '工种类型 1摄影师 2化妆师 3影片师',
        `name` varchar(50) DEFAULT NULL COMMENT '名称',
        `content` varchar(5000) DEFAULT NULL COMMENT '个人简介',
        `img` varchar(500) DEFAULT NULL COMMENT '头像',
        `tel` varchar(20) DEFAULT NULL COMMENT '电话',
        `level` varchar(50) DEFAULT NULL COMMENT '等级',
        `team_id` int(4) DEFAULT NULL COMMENT '所属团队',
        `price_small` varchar(50) DEFAULT NULL COMMENT '淡季价格',
        `price_big` varchar(50) DEFAULT NULL COMMENT '旺季价格',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        `team_name` varchar(500) DEFAULT NULL COMMENT '团队名称',
        PRIMARY KEY (`id`)
        ) ENGINE=MyISAM DEFAULT CHARSET=utf8
        
--------------



    
