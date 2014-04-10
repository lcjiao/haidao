package com.jcl.gen.tool;

public class Inpars {

	private String name;
	private String type;
	private String allowNull = "n";
	private String desc;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getAllowNull() {
		return allowNull;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setAllowNull(String allowNull) {
		this.allowNull = allowNull;
	}
}
