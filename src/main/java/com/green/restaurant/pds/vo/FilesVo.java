package com.green.restaurant.pds.vo;

public class FilesVo {
	//fields
	private int file_idx;
	private int file_type;
	private String file_name;
	private String file_ext;
	private String sfile_name;
	private int table_idx;
	
	//constructor
	public FilesVo() {}

	public FilesVo(int file_idx, int file_type, String file_name, String file_ext, String sfile_name, int table_idx) {
		super();
		this.file_idx = file_idx;
		this.file_type = file_type;
		this.file_name = file_name;
		this.file_ext = file_ext;
		this.sfile_name = sfile_name;
		this.table_idx = table_idx;
	}
	
	//getter/setter
	public int getFile_idx() {
		return file_idx;
	}

	public void setFile_idx(int file_idx) {
		this.file_idx = file_idx;
	}

	public int getFile_type() {
		return file_type;
	}

	public void setFile_type(int file_type) {
		this.file_type = file_type;
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

	public int getTable_idx() {
		return table_idx;
	}

	public void setTable_idx(int table_idx) {
		this.table_idx = table_idx;
	}
	
	//toString
	@Override
	public String toString() {
		return "FilesVo [file_idx=" + file_idx + ", file_type=" + file_type + ", file_name=" + file_name + ", file_ext="
				+ file_ext + ", sfile_name=" + sfile_name + ", table_idx=" + table_idx + "]";
	}
	
}
