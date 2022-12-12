package com.green.restaurant.pds.service.impl;

import java.io.File;

public class CheckFileName {
	public String getFileName(
				String filePath,
				String orgFileName,
				String fileExt
			) {
		boolean isCheck = true;
		String returnFileName = null;
		String fullFilePath = null;
		File file = null;
		String fileName = orgFileName;
		
		int i = 0;
		while(isCheck) {
			fullFilePath = filePath + fileName + fileExt;
			file = new File(fullFilePath);
			System.out.println("getFileName.while>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>file: " + file.exists());
			System.out.println("getFileName.while>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>orgFileName: " + orgFileName);
			if(file.exists()) {
				System.out.println("getFileName.while.if>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>fileName: " + orgFileName);
				i += 1;
				fileName = String.format("%s_%d", orgFileName, i);	//error 발생
				System.out.println("getFileName.if>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>fileName: " + fileName);
			}
			else {
				System.out.println("getFileName.else>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>file: " + file.exists());
				isCheck = false;
			}
		}
		returnFileName = fileName + fileExt;
		
		return returnFileName;
	}
}
