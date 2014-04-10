package com.jcl.gen.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.jcl.core.logging.LogUtil;
import com.jcl.core.module.ModuleRegistry;
import com.jcl.gen.config.TemplateFactoryBean;
import com.jcl.gen.config.TemplateModule;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class BuildCode extends AbsGen {
	private String className;
	private String urlMethod;
	private String isAuth;
	private String url;
	private String methodName;
	private String methodDes;
	private String inputParName;
	private String inputParType;
	private String inputParIsTrue;     //是否必须
	private String inputParDes;
	private String outObjName;
	private String outParName;
	private String outParType;
	private String outParIsTrue;
	private String outParDes;
	
	private String errorMessages = "";
	
	public void excute(){
		List<String> content = this.readExcelFile();
		
		try {
			this.process();
		} catch (IOException e) {
			e.printStackTrace();
			LogUtil.error(e);
		} catch (TemplateException e) {
			e.printStackTrace();
			LogUtil.error(e);
		}
		
	}
	
	public List<String> readExcelFile(){
		List<String> list = new ArrayList<String>();
		String codefile = null;
		String apifile = null;
		String dir = System.getProperty("user.dir");
		String filePath = dir + "/src/main/resources/META-INF/templates/xls/code.xls";
		String defaultClassName = "FileGenerate";
		String defaultUrlMethod = "post";
		String defaultIsAuth = "y";
		String defaultUrl = "http://api.anjuke.com/common/buildcode";
		String defaultMethodName = "doFile";
		String defaultMethodDes = "no describe";
		String defaultInputParName = "";
		String defaultInputParType = "String";
		String defaultInputParIsTrue = "y";
		String defaultInputParDes = "no describe";
		String defaultOutObjName = "Test";
		String defaultOutParName = "";
		String defaultOutParType = "String";
		String defaultOutParIsTrue = "y";
		String defaultOutParDes = "no describe";
		//辨位标示符
		String flag = "0";
		
		try {
			List<List<Object>> rows = BuildCode.readExcel(filePath);
			for (List<Object> row : rows) {
				String cell1 = row.get(0).toString();
				if(cell1.equals("接口类名")){
					if(row.get(1) == null || row.get(1).equals("") || row.get(1).equals("null")){
						errorMessages = "apikey is required";
					}
					className = row.get(1) == null ? defaultClassName : row.get(1)
							.toString();
				}else if(cell1.equals("请求method")){
					if(row.get(1) == null || row.get(1).equals("") || row.get(1).equals("null")){
						//errorMessages += errorMessages.equals("") ? "urlMethod is required" : ",urlMethod is required";
						errorMessages = "apikey is required";
					}
					urlMethod = row.get(1) == null ? defaultUrlMethod : row.get(1).toString();
				}else if(cell1.equals("是否Auth")){
					if(row.get(1) == null || row.get(1).equals("") || row.get(1).equals("null")){
						errorMessages = "apikey is required";
					}
					isAuth = row.get(1) == null ? defaultIsAuth : row.get(1).toString();
				}else if(cell1.equals("url路径")){
					if(row.get(1) == null || row.get(1).equals("") || row.get(1).equals("null")){
						errorMessages = "apikey is required";
					}
					url = row.get(1) == null ? defaultUrl : row.get(1).toString();
				}else if(cell1.equals("方法名")){
					if(row.get(1) == null || row.get(1).equals("") || row.get(1).equals("null")){
						errorMessages = "apikey is required";
					}
					methodName = row.get(1) == null ? defaultMethodName : row.get(1).toString();
				}else if(cell1.equals("方法描述")){
					if(row.get(1) == null || row.get(1).equals("") || row.get(1).equals("null")){
						errorMessages = "apikey is required";
					}
					methodDes = row.get(1) == null ? defaultMethodDes : row.get(1).toString();
				}else if(cell1.equals("输入参数名称")){
					flag = "1";
				}else if(flag.equals("1") && !cell1.equals("输出参数定义") && !cell1.equals("输出对象名称")){
					if(inputParName != null && !inputParName.equals("")){
						String temp = row.get(0) == null ? defaultInputParName : row.get(0).toString();
						inputParName = inputParName + "," + temp;
					}else{
						inputParName = row.get(0) == null ? defaultInputParName : row.get(0).toString();
					}
					if(inputParType != null && !inputParType.equals("")){
						String temp = row.get(1) == null ? defaultInputParType : row.get(1).toString();
						inputParType = inputParType + "," + temp;
					}else{
						inputParType = row.get(1) == null ? defaultInputParType : row.get(1).toString();
					}
					if(inputParIsTrue != null && !inputParIsTrue.equals("")){
						String temp = row.get(2) == null ? defaultInputParIsTrue : row.get(2).toString();
						inputParIsTrue = inputParIsTrue + "," + temp;
					}else{
						inputParIsTrue = row.get(2) == null ? defaultInputParType : row.get(2).toString();
					}
					if(inputParDes != null && !inputParDes.equals("")){
						String temp = row.get(3) == null ? defaultInputParDes : row.get(3).toString();
						inputParDes = inputParDes + "," + temp;
					}else{
						inputParDes = row.get(3) == null ? defaultInputParDes : row.get(3).toString();
					}
					if(row.get(0) == null || row.get(0).equals("") || row.get(0).equals("null")
							|| row.get(1) == null || row.get(1).equals("") || row.get(1).equals("null")
							|| row.get(2) == null || row.get(2).equals("") || row.get(2).equals("null")
							|| row.get(3) == null || row.get(3).equals("") || row.get(3).equals("null")){
						errorMessages = "apikey is required";
					}
				}else if(cell1.equals("输出对象名称")){
					flag = "2";
				}else if(flag.equals("2")){
					if(row.get(0) == null || row.get(0).equals("") || row.get(0).equals("null")){
						errorMessages = "apikey is required";
					}
					outObjName = row.get(0) == null ? defaultOutObjName : row.get(0).toString();
					flag = "3";
				}else if(flag.equals("3") && cell1 != null && !cell1.equals("输出对象属性名称") && !cell1.equals("")){
					if(outParName != null && !outParName.equals("")){
						String temp = row.get(0) == null ? defaultOutParName : row.get(0).toString();
						outParName = outParName + "," + temp;
					}else{
						outParName = row.get(0) == null ? defaultOutParName : row.get(0).toString();
					}
					if(outParType != null && !outParType.equals("")){
						String temp = row.get(1) == null ? defaultOutParType : row.get(1).toString();
						outParType = outParType + "," + temp;
					}else{
						outParType = row.get(1) == null ? defaultOutParType : row.get(1).toString();
					}
					if(outParIsTrue != null && !outParIsTrue.equals("")){
						String temp = row.get(2) == null ? defaultOutParIsTrue : row.get(2).toString();
						outParIsTrue = outParIsTrue + "," + temp;
					}else{
						outParIsTrue = row.get(2) == null ? defaultOutParIsTrue : row.get(2).toString();
					}
					if(outParDes != null && !outParDes.equals("")){
						String temp = row.get(3) == null ? defaultOutParDes : row.get(3).toString();
						outParDes = outParDes + "," + temp;
					}else{
						outParDes = row.get(3) == null ? defaultOutParDes : row.get(3).toString();
					}
					if(row.get(0) == null || row.get(0).equals("") || row.get(0).equals("null")
							|| row.get(1) == null || row.get(1).equals("") || row.get(1).equals("null")
							|| row.get(2) == null || row.get(2).equals("") || row.get(2).equals("null")
							|| row.get(3) == null || row.get(3).equals("") || row.get(3).equals("null")){
						errorMessages = "apikey is required";
					}
				}
			}
			list.add(codefile);
			list.add(apifile);
		} catch (Exception e) {
			LogUtil.error(e);
		}
		
		return list;
		
	}
	
	/**
	 * 读取Excel文件
	 *
	 * @param filePath
	 *            excel文件路径
	 * @throws IOException
	 */
	public static List<List<Object>> readExcel(String filePath)
			throws Exception {

		FileInputStream fis = new FileInputStream(filePath); // 根据excel文件路径创建文件流
		POIFSFileSystem fs = new POIFSFileSystem(fis); // 利用poi读取excel文件流
		HSSFWorkbook wb = new HSSFWorkbook(fs); // 读取excel工作簿
		HSSFSheet sheet = wb.getSheetAt(0); // 读取excel的sheet，0表示读取第一个、1表示第二个.....
		// 获取sheet中总共有多少行数据sheet.getPhysicalNumberOfRows()
		List<List<Object>> rows = new ArrayList<List<Object>>();
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			HSSFRow row = sheet.getRow(i); // 取出sheet中的某一行数据
			List<Object> columns = new ArrayList<Object>();
			if (row != null) {
				// 获取该行中总共有多少列数据row.getLastCellNum()
				for (int j = 0; j < row.getLastCellNum(); j++) {
					HSSFCell cell = row.getCell((short) j); // 获取该行中的一个单元格对象
					// 判断单元格数据类型，这个地方值得注意：当取某一行中的数据的时候，需要判断数据类型，否则会报错
					// java.lang.NumberFormatException: You cannot get a string
					// value from a numeric cell等等错误
					if(cell==null){
						columns.add("");
					}else if (cell.getCellType() == 0) {
						columns.add(Math.round(cell.getNumericCellValue())); // 一般的数据类型在excel中读出来都为float型
					}else {
						columns.add(cell.getStringCellValue());
					}
				}
			}
			rows.add(columns);
		}
		return rows;
	}
	
	/**
	 * freemarker 处理
	 * @throws IOException
	 * @throws TemplateException
	 */
	@SuppressWarnings("unchecked")
	private void process() throws IOException, TemplateException{
		Map root = new HashMap();
		String service_ = config.getString("package.service.name");
		
		String package_ = config.getString("package.name");
		String java = config.getString("target.java");
		String resource = config.getString("target.resources");
		root.put("package", package_);
		package_ = package_.replaceAll("\\.", "/");
		
		root.put("className", className);
		root.put("urlMethod", urlMethod);
		root.put("isAuth", isAuth);
		root.put("url", url);
		root.put("methodName", methodName);
		root.put("methodDes", methodDes);
		
		List<Inpars> inparslist = new ArrayList<Inpars>();
		if(!inputParName.equals("")){
			String[] inpars = inputParName.split(",");
			String[] inistrus = inputParIsTrue.split(",");
			String[] intypes = inputParType.split(",");
			String[] indes = inputParDes.split(",");
			for(int i=0;i<inpars.length;i++){
				Inpars inpar = new Inpars();
				inpar.setName(inpars[i]);
				inpar.setType(intypes[i]);
				inpar.setAllowNull(inistrus[i]);
				inpar.setDesc(indes[i]);
				inparslist.add(inpar);
			}
		}
		root.put("inparslist", inparslist);
		
		root.put("outObjName", firstToUpper(outObjName));
		
		List<Outpars> outparslist = new ArrayList<Outpars>();
		if(!outParName.equals("")){
			String[] outpars = outParName.split(",");
			String[] outistrus = outParIsTrue.split(",");
			String[] outtypes = outParType.split(",");
			String[] outdes = outParDes.split(",");
			for(int i=0;i<outpars.length;i++){
				Outpars outpar = new Outpars();
				outpar.setName(outpars[i]);
				outpar.setType(outtypes[i]);
				outpar.setAllowNull(outistrus[i]);
				outpar.setDesc(outdes[i]);
				outparslist.add(outpar);
			}
		}
		root.put("outparslist", outparslist);
		if(!errorMessages.equals("")){
			root.put("errorMessages", errorMessages);
		}
		
		className = this.firstToUpper(className);
		//create("result.ftl", root, java + package_ + "/result/" + firstToUpper(outObjName) + "Type.java");
		//create("resource.ftl", root, java + package_ + "/resource/" + className + "Resource.java");
		//create("api.html.ftl", root, resource + package_ + "/" + className + ".html");
		create("servicetest.jsp.ftl", root, resource + package_ + "/" + methodName + ".jsp");
		
	}
	
	//首字母大写
	private String firstToUpper(String fileName){
		return fileName.substring(0, 1).toUpperCase() + fileName.substring(1);
	}
	
	public static void main(String[] args) {
		BuildCode bc = new BuildCode();
		bc.excute();
		
	}

}
