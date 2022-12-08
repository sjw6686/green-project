package com.green.restaurant.pds.vo;

public class FilesVo {
	//fields
	private int file_num;
	private int file_idx;
	private String file_name;
	private String file_ext;
	private String sfile_name;
	
	//constructor
	public FilesVo() {}
	
	public FilesVo(int file_num, int file_idx, String file_name, String file_ext, String sfile_name) {
		super();
		this.file_num = file_num;
		this.file_idx = file_idx;
		this.file_name = file_name;
		this.file_ext = file_ext;
		this.sfile_name = sfile_name;
	}
	
	//getter/setter
	public int getFile_num() {
		return file_num;
	}
	public void setFile_num(int file_num) {
		this.file_num = file_num;
	}
	public int getFile_idx() {
		return file_idx;
	}
	public void setFile_idx(int file_idx) {
		this.file_idx = file_idx;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_ext() {
		return file_ext;
	}
	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}
	public String getSfile_name() {
		return sfile_name;
	}
	public void setSfile_name(String sfile_name) {
		this.sfile_name = sfile_name;
	}
	
	//toString
	@Override
	public String toString() {
		return "FilesVo [file_num=" + file_num + ", file_idx=" + file_idx + ", file_name=" + file_name + ", file_ext="
				+ file_ext + ", sfile_name=" + sfile_name + "]";
	}
	
}
