package com.green.restaurant.pds.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.green.restaurant.pds.vo.FilesVo;

public class PdsFile {
	public static void save(
			HashMap<String, Object> map,
			HttpServletRequest request
			) {
		System.out.println("PdsFile.save>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>in save");
		String filePath = "c:\\upload\\";
		File dir = new File(filePath);
		if(!dir.exists()) {
			dir.mkdir();	//파일지정될 경로 없으면 생성
		}
		System.out.println("PdsFile.save>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>after if");
		CheckFileName checkFile = new CheckFileName();	//중복파일저장을위해 추가
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;	//파일저장 라이브러리. 서비스로부터 넘어온 파일정보를 MultipartHttpServletRequest자료형으로 바꾼후 multipartHttpServletRequest변수로 저장
		
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();	//중복되는 파일이름을 다르게 처리해주기위해 Iterator이용
		System.out.println("PdsFile.save>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>after iterator");
		MultipartFile multipartFile = null;
		
		List<FilesVo> filesList = new ArrayList<>();
		
		String fileName = null;
		String orgFileName = null;
		String fileExt = null;
		String sFileName = null;
		
		while(iterator.hasNext()) {
			System.out.println("PdsFile.save>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>in while");
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			
			if(!multipartFile.isEmpty()) {
				fileName = multipartFile.getOriginalFilename();	//전체파일이름 받음
				orgFileName = fileName.substring(0, fileName.lastIndexOf('.'));	//파일이름 첫글자부터 . 이 나올때까지 저장
				fileExt = fileName.substring(fileName.lastIndexOf('.'));		//파일이름중 .이 있는위치부터 저장
				
				sFileName = checkFile.getFileName(filePath, orgFileName, fileExt);	//checkFileName의 getFileName이용해서 중복체크한다음 실제 db에 저장될 파일이름 구함
				
				FilesVo vo = new FilesVo(0, 0, fileName, fileExt, sFileName, 0);
				filesList.add(vo);
				
				File file = new File(filePath + sFileName);
				
				try {
					multipartFile.transferTo(file);//파일저장
				} catch(IllegalStateException e) {
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}//end of if
		}//end of while		
		map.put("filesList", filesList);
		System.out.println("PdsFile.save>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
	}
}
