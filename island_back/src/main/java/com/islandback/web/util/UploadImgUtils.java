package com.islandback.web.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.islandback.module.ModuleEnum;

public class UploadImgUtils {

	private static String imageServPath = ModuleEnum.IMAGE_SAVE_PATH;
	private static String imageServPrefix = ModuleEnum.IMAGE_SERV_PREFIX;
	
	public static String getImgUrl(File image,String imageFileName){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); 
		if(image == null){
			   return "";
		   }
		 	
		   Date date = new Date();
	   	   String namePrefix=format.format(date);
	       String path = imageServPath+namePrefix;
	       File file = new File(path);  
	       if (!file.exists()) {  
	           file.mkdirs();  
	       }  
	       try {  
	              FileUtils.copyFile(image, new File(file, imageFileName));  
	        } catch (IOException e) {  
	              e.printStackTrace();  
	        }  
	       return imageServPrefix+namePrefix+"/"+imageFileName; 
	}
}
