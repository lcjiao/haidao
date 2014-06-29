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
	 * 公司办事处
	 */
	public static final Integer COMPANY_ADDRESS=24;
	

	/**
	 * 同事
	 */
	public static final Integer COMPANY_FRIEND=25;
	
	/**
	 * 合作伙伴
	 */
	public static final Integer COMPANY_MATE=26;
	
	
	
	/**
	 * 婚纱摄影套餐首页图片推荐(最上面的大图片)
	 */
	public static final Integer WEDDING_PHOTO_FACE_TOP_RECOMMEND = 101;
	
	/**
	 * 婚纱摄影套餐图片推荐
	 */
	public static final Integer WEDDING_PHOTO_FACE_RECOMMEND = 102;
	
	/**
	 * 婚纱摄影套餐图 最新套餐推荐
	 */
	public static final Integer WEDDING_PHOTO_FACE_NEW_RECOMMEND = 103;

	/**
	 * 婚纱摄影套餐单面推荐(套餐注意事项)就是一个富文本
	 */
	public static final Integer WEDDING_PHOTO_SINGLE_PAGE_RECOMMEND = 104;
	/**
	 * 婚纱摄影区域推荐module_id
	 */
	public static final Integer WEDDING_PHOTO_AREA_RECOMMEND = 105;
	
	/**
	 * 摄影团队推荐
	 */
	public static final Integer PHOTO_TEAM_RECOMMEND = 106;
	
	/**
	 * 客片案例首页图片推荐 (最上面大图) 
	 */
	public static final Integer CUSTOMER_CASE_TOP_RECOMMEND = 107;
	
	/**
	 * 客片案例视频推荐
	 */
	public static final Integer CUSTOMER_CASE_FACE_VIDEO_RECOMMEND = 108;
	
	/**
	 * 客片案例(视频下面的图片)推荐
	 */
	public static final Integer CUSTOMER_CASE_FACE_IMAGE_RECOMMEND = 109;
	
	
	/**
	 * 套餐类型 1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐  5:自由行套餐  6：团队 '
	 */
	public static final Integer PACKAGE_TYPE_MARRY = 1;
	
	public static final Integer PACKAGE_TYPE_WEDDINGPHOTO = 2;
	
	public static final Integer PACKAGE_TYPE_WEDDINGPHOTO_WORKER = 3;
	
	public static final Integer PACKAGE_TYPE_WINESHOP = 4;
	
	public static final Integer PACKAGE_TYPE_FREE_WALKER = 5;
	
	/**
	 * 案例类型：130、摄影案例; 131、视频案例
	 */
	public static final Integer CUSTOMER_CASE_WEDDINGPHOTO = 130;
	
	public static final Integer CUSTOMER_CASE_VEDIO = 131;
	
	public static final Integer CUSTOMER_CASE_PACKAGE = 7;
	
	
}
