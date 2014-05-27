package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.IslandPackageIbatisDAOImpl;
import com.island.domain.dal.IslandPackageTypeIbatisDAOImpl;
import com.island.domain.dal.PackageDetailInfoIbatisDAOImpl;
import com.island.domain.dal.PackageImageRelationIbatisDAOImpl;
import com.island.domain.dal.PackageKepianliuyingIbatisDAOImpl;
import com.island.domain.model.IslandPackage;
import com.island.domain.model.IslandPackageType;
import com.island.domain.model.PackageDetailInfo;
import com.island.domain.model.PackageImageRelation;
import com.island.domain.model.PackageKepianliuying;

public class MarrayPackageBiz {
	private IslandPackageIbatisDAOImpl islandPackageDao;
	private PackageDetailInfoIbatisDAOImpl islandPackageDetailDao;
	private PackageImageRelationIbatisDAOImpl islandPackageImgDao;
	private PackageKepianliuyingIbatisDAOImpl islandPackageKepianDao;
	private IslandPackageTypeIbatisDAOImpl islandPackageTypeDao;

	public IslandPackageIbatisDAOImpl getIslandPackageDao() {
		return islandPackageDao;
	}
	public void setIslandPackageDao(IslandPackageIbatisDAOImpl islandPackageDao) {
		this.islandPackageDao = islandPackageDao;
	}
	public PackageDetailInfoIbatisDAOImpl getIslandPackageDetailDao() {
		return islandPackageDetailDao;
	}
	public void setIslandPackageDetailDao(
			PackageDetailInfoIbatisDAOImpl islandPackageDetailDao) {
		this.islandPackageDetailDao = islandPackageDetailDao;
	}
	public PackageImageRelationIbatisDAOImpl getIslandPackageImgDao() {
		return islandPackageImgDao;
	}
	public void setIslandPackageImgDao(
			PackageImageRelationIbatisDAOImpl islandPackageImgDao) {
		this.islandPackageImgDao = islandPackageImgDao;
	}
	public PackageKepianliuyingIbatisDAOImpl getIslandPackageKepianDao() {
		return islandPackageKepianDao;
	}
	public void setIslandPackageKepianDao(
			PackageKepianliuyingIbatisDAOImpl islandPackageKepianDao) {
		this.islandPackageKepianDao = islandPackageKepianDao;
	}
	public IslandPackageTypeIbatisDAOImpl getIslandPackageTypeDao() {
		return islandPackageTypeDao;
	}
	public void setIslandPackageTypeDao(
			IslandPackageTypeIbatisDAOImpl islandPackageTypeDao) {
		this.islandPackageTypeDao = islandPackageTypeDao;
	}
	
	
	
	
	public List<IslandPackage> queryPackageByMap(Map<String,Object> params){
		return this.islandPackageDao.queryByMap(params);
	}
	public Integer countPackageByMap(Map<String,Object> params){
		return this.islandPackageDao.countByMap(params);
	}
	public void addPackage(IslandPackage model){
		this.islandPackageDao.insert(model);
	}
	public IslandPackage queryPackageById(Integer id){
		return this.islandPackageDao.queryById(id);
	}
	
	public void updPackageByMap(Map<String,Object> params){
		this.islandPackageDao.updateByMap(params);
	}
	public List<PackageDetailInfo> queryPackageDetailByMap(Map<String,Object> params){
		return this.islandPackageDetailDao.queryByMap(params);
	}
	public void updPackageDetailByMap(Map<String,Object> params){
		this.islandPackageDetailDao.updateByMap(params);
	}
	public void addPackageDetail(PackageDetailInfo obj){
		this.islandPackageDetailDao.insert(obj);
	}
	public List<PackageImageRelation> queryPackageImgByMap(Map<String,Object> params){
		return this.islandPackageImgDao.queryByMap(params);
	}
	public Integer countPackageImgByMap(Map<String,Object> params){
		return this.islandPackageImgDao.countByMap(params);
	}
	public void addPackageImg(PackageImageRelation obj){
		this.islandPackageImgDao.insert(obj);
	}
	public void updPackageImgByMap(Map<String,Object> params){
		this.islandPackageImgDao.updateByMap(params);
	}
	public PackageImageRelation queryPackageImgById(Integer id){
		return this.islandPackageImgDao.queryById(id);
	}
	public List<PackageKepianliuying> queryPackageKepianByMap(Map<String,Object> params){
		return this.islandPackageKepianDao.queryByMap(params);
	}
	public Integer countPackageKepianByMap(Map<String,Object> params){
		return this.islandPackageKepianDao.countByMap(params);
	}
	public void updPackageKepianByMap(Map<String,Object> params){
		this.islandPackageKepianDao.updateByMap(params);
	}
	public void addPackageKepianliuying(PackageKepianliuying obj){
		this.islandPackageKepianDao.insert(obj);
	}
	public PackageKepianliuying queryPackageKepianById(Integer id){
		return this.islandPackageKepianDao.queryById(id);
	}
	
	public List<IslandPackageType> queryPackageTypeByMap(Map<String,Object> params){
		return this.islandPackageTypeDao.queryByMap(params);
	}
	
	public Integer countPackageTypeByMap(Map<String,Object> params){
		return this.islandPackageTypeDao.countByMap(params);
	}
	
	public void addPackageType(IslandPackageType obj){
		this.islandPackageTypeDao.insert(obj);
	}
	public IslandPackageType queryPackageTypeById(Integer id){
		return this.islandPackageTypeDao.queryById(id);
	}
	public void updPackageTypeByMap(Map<String,Object> params){
		this.islandPackageTypeDao.updateByMap(params);
	}
}
