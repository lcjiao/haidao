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
    `area_name` varchar(50) DEFAULT NULL COMMENT '归属区域名称',
    `name` varchar(50) DEFAULT NULL COMMENT '岛屿名称',
    `island_desc` text DEFAULT NULL COMMENT '岛屿描述',
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
    `recommend_time` varchar(50) DEFAULT NULL COMMENT '推荐时间',
    `recommend_desc` varchar(500) DEFAULT NULL COMMENT '备注',
    `img_url` varchar(500) DEFAULT NULL COMMENT '图片地址',
    `link_url` varchar(500) DEFAULT NULL COMMENT '链接地址',
    `price` varchar(50) DEFAULT NULL COMMENT '价格',
    `tel` varchar(50) DEFAULT NULL COMMENT '联系电话',
    `area_id` int(4) DEFAULT NULL COMMENT '区域编号',
    `area_name` varchar(50) DEFAULT NULL COMMENT '区域名称',
    `island_id` int(4) DEFAULT NULL COMMENT '岛屿编号',
    `island_name` varchar(50) DEFAULT NULL COMMENT '岛屿名称',
    `recommend_index` int(4) DEFAULT NULL COMMENT '排序',
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
    PRIMARY KEY (`id`)
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

    CREATE TABLE `island_package` (
    `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `package_type` int(2) DEFAULT NULL COMMENT '套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐  5:自由行套餐',
    `title` varchar(200) DEFAULT NULL COMMENT '套餐标题',
    `content` varchar(10000) DEFAULT NULL COMMENT '套餐内容',
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

##13. 客户案例表
-------------

        CREATE TABLE `guest_example` (
        `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `exam_type` int(2) DEFAULT NULL COMMENT '案例类型1:摄影案例 2:视频案例',
        `package_id` int(8) DEFAULT NULL COMMENT '套餐编号',
        `package_name` varchar(500) DEFAULT NULL COMMENT '套餐名称',
        `package_content` varchar(1000) DEFAULT NULL COMMENT '套餐项目',
        `wed_person` varchar(50) DEFAULT NULL COMMENT '新人姓名',
        `wed_time` varchar(50) DEFAULT NULL COMMENT '时间',
        `wed_lensman` varchar(50) DEFAULT NULL COMMENT '摄影师',
        `wed_dresser` varchar(50) DEFAULT NULL COMMENT '化妆师',
        `default_img` varchar(500) DEFAULT NULL COMMENT '缩略图',
        `view_url` varchar(500) DEFAULT NULL COMMENT '视频地址',
        `exam_imgs` varchar(500) COMMENT '图片id集合 多个以逗号间隔',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        PRIMARY KEY (`id`),
        KEY `package_index` (`package_id`)
        ) ENGINE=MyISAM DEFAULT CHARSET=utf8
        
------------

##14.疑难解答表
------------

        CREATE TABLE `global_qa` (
        `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `question_type` varchar(50) DEFAULT NULL COMMENT '问题种类',
        `title` varchar(500) DEFAULT NULL COMMENT '问题标题',
        `answer` varchar(10000) DEFAULT NULL COMMENT '回答',
        `index` int(4) DEFAULT NULL COMMENT '展示次序',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        PRIMARY KEY (`id`)
        ) ENGINE=MyISAM DEFAULT CHARSET=utf8
        
-------------

##15.用户访问记录表
-------------

        CREATE TABLE `guest_visit_log` (
        `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `package_id` int(8) DEFAULT NULL COMMENT '套餐编号',
        `package_name` varchar(500) DEFAULT NULL COMMENT '套餐名称',
        `package_img` varchar(500) DEFAULT NULL COMMENT '套餐图片',
        `package_url` varchar(500) DEFAULT NULL COMMENT '套餐链接',
        `package_title` varchar(500) DEFAULT NULL COMMENT '套餐标题',
        `ip` varchar(50) DEFAULT NULL COMMENT 'ip地址',
        `visit_time` int(10) DEFAULT NULL COMMENT '访问时间',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `session_id` varchar(200) DEFAULT NULL COMMENT 'session_id',
        PRIMARY KEY (`id`),
        KEY `ip_index` (`ip`)
        ) ENGINE=MyISAM DEFAULT CHARSET=utf8
        
-------------

##16.订单表
-------------

        CREATE TABLE `island_order` (
        `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `country` varchar(20) DEFAULT NULL COMMENT '国家',
        `wed_area` varchar(20) DEFAULT NULL COMMENT '婚礼区域',
        `wed_from` int(20) DEFAULT NULL COMMENT '出发地',
        `budget` int(8) DEFAULT NULL COMMENT '婚礼预算单位元',
        `wed_person_num` int(4) DEFAULT NULL COMMENT '婚礼人数',
        `wed_name` varchar(20) DEFAULT NULL COMMENT '新人姓名',
        `tel` varchar(20) DEFAULT NULL COMMENT '手机号码',
        `qq` varchar(20) DEFAULT NULL COMMENT 'qq号码',
        `mail` varchar(20) DEFAULT NULL COMMENT '邮箱地址',
        `ip` varchar(50) DEFAULT NULL COMMENT 'ip地址',
        `ask_msg` text COMMENT '咨询内容',
        `is_send` int(2) DEFAULT NULL COMMENT '1已经发送邮件  0没有发送邮件',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        PRIMARY KEY (`id`)
        ) ENGINE=MyISAM DEFAULT CHARSET=utf8
        
--------------
        

##17. 购物车表
-------------

        CREATE TABLE `shopping_car` (
        `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `package_ids` varchar(500) DEFAULT NULL COMMENT '套餐编号 多个编号以逗号间隔',
        `ip` varchar(50) DEFAULT NULL COMMENT 'ip',
        `session_id` varchar(200) DEFAULT NULL COMMENT 'seesion_id',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        PRIMARY KEY (`id`)
        ) ENGINE=MyISAM DEFAULT CHARSET=utf8
        
--------------

##18. 联系方式表
--------------

        CREATE TABLE `contact` (
        `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `tel` varchar(100) DEFAULT NULL COMMENT '联系电话 多个以逗号间隔',
        `phone` varchar(100) DEFAULT NULL COMMENT '座机 多个以逗号间隔',
        `person` varchar(100) DEFAULT NULL COMMENT '联系人 多个以逗号间隔',
        `address` varchar(200) DEFAULT NULL COMMENT '联系地址 多个以逗号间隔',
        `qq` varchar(100) DEFAULT NULL COMMENT 'qq号码 多个以逗号间隔',
        `mail` varchar(200) DEFAULT NULL COMMENT '邮箱地址 多个以逗号间隔',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        PRIMARY KEY (`id`)
        ) ENGINE=MyISAM DEFAULT CHARSET=utf8
        
---------------

##19. 后台用户表
--------------

        CREATE TABLE `user` (
        `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `user_name` varchar(50) NOT NULL COMMENT '用户名称',
        `user_pass` varchar(200) NOT NULL COMMENT '用户密码',
        `user_role_id` int(5) NOT NULL COMMENT '用户角色编号',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        `valid` int(2) NOT NULL DEFAULT '1' COMMENT '是否有效',
        `role_name` varchar(50) DEFAULT '' COMMENT '角色名称',
        PRIMARY KEY (`id`)
        ) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8
        
---------------

##20. 后台角色表
--------------

        CREATE TABLE `role` (
        `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `role_name` varchar(200) NOT NULL COMMENT '角色名称',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        `valid` int(2) NOT NULL DEFAULT '1' COMMENT '是否有效',
        PRIMARY KEY (`id`)
        ) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8
        
--------------

##21. 后台角色权限表
-------------

        CREATE TABLE `role_right` (
        `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `role_id` int(5) NOT NULL COMMENT '角色编号',
        `menu_ids` varchar(200) DEFAULT NULL COMMENT '拥有的权限菜单编号集合以逗号间隔如 3,6,8',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        `valid` int(2) NOT NULL DEFAULT '1' COMMENT '是否有效',
        PRIMARY KEY (`id`)
        ) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8
        
--------------

##22. 后台菜单表
--------------
        
        CREATE TABLE `menu` (
        `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
        `menu_url` varchar(256) DEFAULT NULL COMMENT '菜单链接',
        `menu_parent` int(5) NOT NULL COMMENT '父菜单编号',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `valid` int(2) NOT NULL DEFAULT '1' COMMENT '是否有效',
        PRIMARY KEY (`id`)
        ) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8

---------------


##23. 套餐图片映射表

---------------
        
        
        CREATE TABLE `package_image_relation` (
        `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `package_type` int(4) DEFAULT NULL COMMENT '套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐 5:自由行套餐',
        `package_id` int(10) DEFAULT NULL COMMENT '套餐编号',
        `img_id` int(10) DEFAULT NULL COMMENT '图片编号',
        `img_type` int(4) DEFAULT NULL COMMENT '图片类型',
        `img_des` varchar(500) DEFAULT NULL COMMENT '图片描述',
        `img_index` int(4) DEFAULT NULL COMMENT '图片展示次序',
        `valid` int(2) DEFAULT NULL COMMENT '是否有效 1有效  0无效',
        `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
        `create_person` varchar(50) DEFAULT NULL COMMENT '创建人',
        `upd_time` int(10) DEFAULT NULL COMMENT '更新时间',
        `upd_person` varchar(50) DEFAULT NULL COMMENT '更新人',
        PRIMARY KEY (`id`),
        KEY `img_id` (`img_id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8
        
-------------------
        
        
        
        
        
        
