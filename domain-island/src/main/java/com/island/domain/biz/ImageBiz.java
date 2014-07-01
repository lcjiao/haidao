package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.ImageIbatisDAOImpl;
import com.island.domain.model.Image;

public class ImageBiz {
	private ImageIbatisDAOImpl imageDao;

	public void addImage( Image  obj){
		this.imageDao.insert(obj);
	}
	
	public void updImageByMap(Map<String,Object> params){
		this.imageDao.updateByMap(params);
	}
	
	public Image queryImgById(Integer id){
		return this.imageDao.queryById(id);
	}
	
	public List<Image> queryImgByMap(Map<String,Object> params){
		return this.imageDao.queryByMap(params);
	}
	
	public Integer countImgByMap(Map<String,Object> params){
		return this.imageDao.countByMap(params);
	}

	public ImageIbatisDAOImpl getImageDao() {
		return imageDao;
	}

	public void setImageDao(ImageIbatisDAOImpl imageDao) {
		this.imageDao = imageDao;
	}
	
	
}
