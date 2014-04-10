package ${package}.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import ${package}.dal.mapper.${name}Mapper;
import ${package}.model.${name};

public class ${name}IbatisDAOImpl extends AbsiBatisDAOImpl<${name}> {
	static {
	<#list dbs as db>
		SqlmapUtils.addMapper(${name}Mapper.class,DataSourceDefinition.${db});
	</#list>
    }
    @Override
	public Class<${name}> getModelCls() {
		
		return ${name}.class;
	}
	@Override
	public Class<${name}Mapper> getMapperCls() {
		
		return ${name}Mapper.class;
	}
	
	@Override
	public DataSourceDefinition getDefWriteDB() {		
		return DataSourceDefinition.${tab.dbName};
	}
	
	<#if tab.queryDB??>
	@Override
	public DataSourceDefinition getDefQueryDB() {
		return DataSourceDefinition.${tab.queryDB};
	}
	</#if>	
	<#if tab.insertDB??>
	@Override
	public DataSourceDefinition getDefInsertDB() {
		
		return DataSourceDefinition.${tab.insertDB};
	}	
	</#if>
	<#if tab.deleteDB??>
	@Override
	public DataSourceDefinition getDefDeleteDB() {
		
		return getDefWriteDB();
	}	
	</#if>
	<#if tab.updateDB??>
	@Override
	public DataSourceDefinition getDefUpdateDB() {
		
		return getDefWriteDB();
	}	
	</#if>	
	<#if tab.pkFieldNum != 1>
	@Override
	public ${name} queryById(Integer id){
		<#if tab.pkFieldNum==0>
		throw new RuntimeException("该表没有主键定义，该方法不能适用，请重新实现！");
		<#else>
		throw new RuntimeException("复合主键，该方法不能适用，请重新实现！");
		</#if>		
	}
	</#if>
}
