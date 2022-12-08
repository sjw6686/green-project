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
			if(file.exists()) {
				i += 1;
				fileName = String.format("&s_%d", orgFileName, i);
			}
			else {
				isCheck = false;
			}
		}
		returnFileName = fileName + fileExt;
		
		return returnFileName;
	}
}
