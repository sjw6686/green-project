package com.green.restaurant.owner.vo;

public class OwnerMenuFileJoinVo {
	//fields
	//menu
	private int menu_idx;
	private String menu_name;
	private String menu_price;
	private int restaurant_idx;
	private int menuTable;	//menu table의 table_type
	//file
	private int file_idx;
	private int table_type;
	private int file_name;
	private int file_ext;
	private String sfile_name;
	private int table_idx;
	
	//constructor
	public OwnerMenuFileJoinVo() {}

	public OwnerMenuFileJoinVo(int menu_idx, String menu_name, String menu_price, int restaurant_idx, int menuTable,
			int file_idx, int table_type, int file_name, int file_ext, String sfile_name, int table_idx) {
		super();
		this.menu_idx = menu_idx;
		this.menu_name = menu_name;
		this.menu_price = menu_price;
		this.restaurant_idx = restaurant_idx;
		this.menuTable = menuTable;
		this.file_idx = file_idx;
		this.table_type = table_type;
		this.file_name = file_name;
		this.file_ext = file_ext;
		this.sfile_name = sfile_name;
		this.table_idx = table_idx;
	}

	//getter/setter
	public int getMenu_idx() {
		return menu_idx;
	}

	public void setMenu_idx(int menu_idx) {
		this.menu_idx = menu_idx;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(String menu_price) {
		this.menu_price = menu_price;
	}

	public int getRestaurant_idx() {
		return restaurant_idx;
	}

	public void setRestaurant_idx(int restaurant_idx) {
		this.restaurant_idx = restaurant_idx;
	}

	public int getMenuTable() {
		return menuTable;
	}

	public void setMenuTable(int menuTable) {
		this.menuTable = menuTable;
	}

	public int getFile_idx() {
		return file_idx;
	}

	public void setFile_idx(int file_idx) {
		this.file_idx = file_idx;
	}

	public int getTable_type() {
		return table_type;
	}

	public void setTable_type(int table_type) {
		this.table_type = table_type;
	}

	public int getFile_name() {
		return file_name;
	}

	public void setFile_name(int file_name) {
		this.file_name = file_name;
	}

	public int getFile_ext() {
		return file_ext;
	}

	public void setFile_ext(int file_ext) {
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
		return "OwnerMenuFileJoinVo [menu_idx=" + menu_idx + ", menu_name=" + menu_name + ", menu_price=" + menu_price
				+ ", restaurant_idx=" + restaurant_idx + ", menuTable=" + menuTable + ", file_idx=" + file_idx
				+ ", table_type=" + table_type + ", file_name=" + file_name + ", file_ext=" + file_ext + ", sfile_name="
				+ sfile_name + ", table_idx=" + table_idx + "]";
	}
	
}
