package com.islandback.module;

import com.island.domain.DomainIslandModule;
import com.island.domain.biz.ConfBiz;
import com.jcl.core.module.ModuleRegistry;

public class ModuleEnum {
	/**
	 * 图片存放路径
	 */
	static ConfBiz confBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getConfBiz();
	public static final String IMAGE_SAVE_PATH="/Users/lcjiao/index/";
	
	public static String getImageSavePath(){
		return confBiz.getValue("img_save_path");
	}
	
	public static final String IMAGE_SERV_PREFIX="http://192.168.2.104:8888/";
	public static String getImageServUrl(){
		return confBiz.getValue("img_url_path");
	}

	/**
	 * 首页主推产品
	 */
	public static final Integer FRONT_INDEX_MASTER_RECOMMEND=1;
	
	/**
	 * 首页最受欢迎岛屿
	 */
	public static final Integer FRONT_INDEX_MASTER_WELCOME_ISLAND=2;
	
	/**
	 * 首页咨询内容
	 */
	public static final Integer FRONT_NEW_CONSULT=3;
	
	/**
	 * 首页套餐推荐
	 */
	public static final Integer FRONT_PACKAGE_RECOMMEND=4;
	
	/**
	 * 前台菜单维护
	 */
	public static final Integer NET_MENU=5;
	/**
	 * 婚礼套餐首页主推
	 */
	public static final Integer MARRAY_PACKAGE_INDEX_MASTER_RECOMMEND=6;
	/**
	 * 婚礼套餐首页辅推套餐
	 */
	public static final Integer MARRAY_PACKAGE_INDEX_SECOEND_RECOMMEND=7;
	
	/**
	 * 婚礼套餐首页区域推荐套餐
	 */
	public static final Integer MARRAY_PACKAGE_INDEX_AREA_RECOMMEND=8;
	/**
	 * 婚礼套餐单页区域推荐
	 */
	public static final Integer MARRAY_PACKAGE_DETAIL_RECOMMEND=9;
	
	
	/**
	 * 酒店套餐首页主推
	 */
	public static final Integer HOTEL_PACKAGE_INDEX_MASTER_RECOMMEND=10;
	/**
	 * 酒店套餐首页辅推套餐
	 */
	public static final Integer HOTEL_PACKAGE_INDEX_SECOEND_RECOMMEND=11;
	
	/**
	 * 酒店套餐首页区域推荐套餐
	 */
	public static final Integer HOTEL_PACKAGE_INDEX_AREA_RECOMMEND=12;
	/**
	 * 酒店套餐单页区域推荐
	 */
	public static final Integer HOTEL_PACKAGE_DETAIL_RECOMMEND=13;
	
	/**
	 * 自由行套餐首页主推
	 */
	public static final Integer FREEWALK_PACKAGE_INDEX_MASTER_RECOMMEND=14;
	/**
	 * 自由行套餐首页辅推套餐
	 */
	public static final Integer FREEWALK_PACKAGE_INDEX_SECOEND_RECOMMEND=15;
	
	/**
	 * 自由行套餐首页区域推荐套餐
	 */
	public static final Integer FREEWALK_PACKAGE_INDEX_AREA_RECOMMEND=16;
	/**
	 * 自由行套餐单页区域推荐
	 */
	public static final Integer FREEWALK_PACKAGE_DETAIL_RECOMMEND=17;
	
	/**
	 * 首页咨询标题
	 */
	public static final Integer FRONT_NEW_CONSULT_TITLE=18;
	
	/**
	 * 友情链接
	 */
	public static final Integer FRIEND_LINK=19;
	

	/**
	 * 全站推荐一
	 */
	public static final Integer GLOBAL_RECOMMEND_ONE=20;
	
	/**
	 * 全站推荐二
	 */
	public static final Integer GLOBAL_RECOMMEND_TWO=21;
	
	/**
	 * 全站推荐三
	 */
	public static final Integer GLOBAL_RECOMMEND_THREE=22;
	
	/**
	 * 全站推荐四
	 */
	public static final Integer GLOBAL_RECOMMEND_FOUR=23;
	
	
	
	/**
	 * 婚纱摄影套餐图片推荐
	 */
	public static final Integer WEDDING_PHOTO_FACE_RECOMMEND=103;
	
	/**
	 * 婚纱摄影套餐首页图片推荐(最上面的大图片)
	 */
	public static final Integer WEDDING_PHOTO_FACE_TOP_RECOMMEND=101;
	
	/**
	 * 婚纱摄影套餐左边图片推荐(上边小三块)
	 */
	public static final Integer WEDDING_PHOTO_FACE_LEFT_RECOMMEND=102;

	/**
	 * 婚纱摄影套餐左边图片推荐(下边小三块)
	 */
	public static final Integer WEDDING_PHOTO_FACE_LEFT2_RECOMMEND=104;

	/**
	 * 套餐类型 1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐  5:自由行套餐'
	 */
	public static final Integer PACKAGE_TYPE_MARRY = 1;
	
	public static final Integer PACKAGE_TYPE_WEDDINGPHOTO = 2;
	
	public static final Integer PACKAGE_TYPE_WEDDINGPHOTO_WORKER = 3;
	
	public static final Integer PACKAGE_TYPE_WINESHOP = 4;
	
	public static final Integer PACKAGE_TYPE_FREE_WALKER = 5;
	
	/**
	 * 案例类型：1、摄影案例; 2、视频案例
	 */
	public static final Integer EXAM_TYPE_WEDDINGPHOTO = 1;
	
	public static final Integer EXAM_TYPE_VEDIO = 2;
	
}
