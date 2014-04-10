package com.jcl.gen.util;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.gen.tool.DB;
import com.jcl.gen.tool.DalGen;

public class DalGenFromDB extends DalGen {
	private String table;
	private String dbName;
	private DataSourceDefinition[] datasource;
	
	public DalGenFromDB(String dbName,String table, DataSourceDefinition[] datasource) {
		this.table = table;
		this.dbName=dbName;
		this.datasource = datasource;
	}

	@Override
	protected DB load() throws Exception {
		return new DB(dbName,table, datasource);
	}

	public static void main(String[] args) throws Exception {
		DalGenFromDB hf = new DalGenFromDB("haidao_db","test_tab",
				new DataSourceDefinition[] { DataSourceDefinition.HAIDAO_DB,DataSourceDefinition.HAIDAO_DB});
		hf.process();
	}

}
