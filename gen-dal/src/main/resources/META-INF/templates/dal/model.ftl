package ${package}.model;

import com.jcl.core.dal.AbsModel;

public class ${name} extends AbsModel{

	public String get(){
		return "${tab.dbNameStr}.${tab.name}";
	}

<#list cols as col>
	<#if col.isPK="no">		
	<#if col.type.javaType="Integer">
	/**
	 * ${col.desc}
	 */
  	private ${col.type.javaType} ${col.fieldName}<#if col.default??>=Integer.parseInt("${col.default}")</#if>;
  	<#elseif col.type.sqlType="Long">
  	/**
	 * ${col.desc}
	 */
  	private ${col.type.javaType} ${col.fieldName}<#if col.default?exists>=Long.parseLong("${col.default}")</#if>;		
  	<#elseif col.type.sqlType="Float">
  	/**
	 * ${col.desc}
	 */
  	private ${col.type.javaType} ${col.fieldName}<#if col.default?exists>=Float.parseFloat("${col.default}")</#if>;  	
  	<#elseif col.type.sqlType="Double">
  	/**
	 * ${col.desc}
	 */
  	private ${col.type.javaType} ${col.fieldName}<#if col.default?exists>=Double.parseDouble("${col.default}")</#if>;  	
  	<#elseif col.type.sqlType="String">
  	/**
	 * ${col.desc}
	 */
  	private ${col.type.javaType} ${col.fieldName}<#if col.default?exists>="${col.default}"</#if>;
  	<#else>
  	/**
	 * ${col.desc}
	 */
  	private ${col.type.javaType} ${col.fieldName};
  	</#if>  	
  	/**
	 * 设置${col.desc}
	 */
  	public void set${col.methodName}(${col.type.javaType} ${col.fieldName}){
  		this.${col.fieldName}=${col.fieldName};
  	}
  	/**
	 * 获取${col.desc}
	 */
  	public ${col.type.javaType} get${col.methodName}(){
  		return this.${col.fieldName};
  	}
  	<#elseif tab.pkFieldNum==1 && col.isPK="yes" &&  col.type.javaType="String">  	  
	@Deprecated
	@Override
	public Integer getId() {
		throw new RuntimeException("replace by getIds()!");
	}
	@Deprecated
	@Override
	public void setId(Integer id) {
		throw new RuntimeException("replace by setIds(String ids)!");
	}
	
  	protected String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	</#if>	  	
</#list>
	/**
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		<#list cols as col>
	  	<#if col.isPK="no">
	  	<#if col.isAllowNull="no">
	  	if(get${col.methodName}()==null){
	  		throw new RuntimeException("${col.fieldName} cannot be null!");
	  	}
	  	</#if>  	
	  	</#if>
		</#list>
		return true;
	}
}
