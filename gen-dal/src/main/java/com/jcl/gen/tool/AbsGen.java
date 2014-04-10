package com.jcl.gen.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

import org.apache.commons.configuration.Configuration;

import com.jcl.core.module.ModuleRegistry;
import com.jcl.gen.config.TemplateFactoryBean;
import com.jcl.gen.config.TemplateModule;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class AbsGen {
	
	protected TemplateFactoryBean factory = ModuleRegistry.getInstance()
			.getModule(TemplateModule.class).getTemplateFactoryBean();

	protected Configuration config = ModuleRegistry.getInstance()
			.getModule(TemplateModule.class).getConfig();

	protected String format(String name) {
		name = name.trim();
		int idx = -1;
		while ((idx = name.indexOf("_")) != -1) {
			String pre = name.substring(0, idx);
			String tmpSuf = name.substring(idx + 1).trim();
			String suf_ = "";
			if (tmpSuf.length() > 0) {
				String suf = tmpSuf.substring(0, 1).toUpperCase();
				if (tmpSuf.length() > 1) {
					suf_ = suf + tmpSuf.substring(1);
				} else {
					suf_ = suf;
				}
			}
			name = pre + suf_;
		}
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	public void create(String template, Map params, String file)
			throws IOException, TemplateException {
		Template t = factory.getTemplate(template);
		int index = file.lastIndexOf("/");
		String dir = file.substring(0, index);
		File file_ = new File(dir);
		file_.mkdirs();
		file_ = new File(file);
		// file_.createNewFile();
		t.process(
				params,
				new OutputStreamWriter(new FileOutputStream(file_
						.getAbsolutePath())));
		System.out.println(file_.getAbsolutePath());
	}

}
