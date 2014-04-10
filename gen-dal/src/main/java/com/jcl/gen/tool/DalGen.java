package com.jcl.gen.tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.TemplateException;

public abstract class DalGen extends AbsGen {
	private String dbFile = "";
	
	protected abstract DB load() throws Exception;
	
	public void process() throws Exception {
		
		DB def = load();
		process(def);		
	}
	
	protected void process(DB def) throws IOException, TemplateException{
		
		Map root = new HashMap();

		List<Tab> tabs = def.getTabs();

		int size = tabs == null ? 0 : tabs.size();

		String package_ = config.getString("package.name");

		String java = config.getString("target.java");

		String resource = config.getString("target.resources");

		root.put("package", package_);

		package_ = package_.replaceAll("\\.", "/");

		List<String> modelNames = new ArrayList<String>();

		for (int i = 0; i < size; i++) {

			String name = format(tabs.get(i).getName());
			modelNames.add(name);

			root.put("name", name);
			root.put("tab", tabs.get(i));
			root.put("dbs", tabs.get(i).getDbs());
			root.put("cols", tabs.get(i).getCols());

			create("model.ftl", root, java + package_ + "/model/" + name
					+ ".java");
//			create("idao.ftl", root, java + package_ + "/dao/" + "I" + name
//					+ "DAO.java");
			create("daoimpl.ftl", root, java + package_ + "/dal/"
					+ name + "IbatisDAOImpl.java");
			create("mapper.ftl", root, java + package_
					+ "/dal/mapper/" + name + "Mapper.java");
			create("mapper.xml.ftl", root, resource + package_
					+ "/dal/mapper/" + name + "Mapper.xml");			
		}
		//root.put("modelNames", modelNames);

		create("spring.xml.ftl", root, resource + package_ + "/spring-dao.xml");
	}
}
