package com.lyh.bean;

import java.util.Vector;

import javax.swing.JList;

public class PubParamBean {
	//搜索的根目录
	private String searchRootDir;
	//搜索的字符串
	private String keywordsField;
	//查找方式变量(0表示递归查找，1表示非递归查找)
	private int searchWay = 0;
	//过滤方式的变量(0表示所有文件，1表示选择过滤，2表示自定义过滤)
	private int filterWay = 0;
	//所有可以选择的格式
	private Vector<String> allFormatList = new Vector<String>();
	//选择要过滤掉的格式
	private Vector<String> selectedFormatList = new Vector<String>();
	//自定义要过滤的格式
	private Vector<String> manuFormatList = new Vector<String>();

	public int getFilterWay() {
		return filterWay;
	}

	public Vector<String> getManuFormatList() {
		return manuFormatList;
	}

	public void setManuFormatList(Vector<String> manuFormatList) {
		this.manuFormatList = manuFormatList;
	}

	public void setFilterWay(int filterWay) {
		this.filterWay = filterWay;
	}

	public int getSearchWay() {
		return searchWay;
	}

	public Vector<String> getAllFormatList() {
		return allFormatList;
	}

	public void setAllFormatList(Vector<String> allFormatList) {
		this.allFormatList = allFormatList;
	}

	public Vector<String> getSelectedFormatList() {
		return selectedFormatList;
	}

	public void setSelectedFormatList(Vector<String> getSelectedFormatList) {
		this.selectedFormatList = getSelectedFormatList;
	}

	public void setSearchWay(int searchWay) {
		this.searchWay = searchWay;
	}

	public String getKeywordsField() {
		return keywordsField;
	}

	public void setKeywordsField(String keywordsField) {
		this.keywordsField = keywordsField;
	}

	public String getSearchRootDir() {
		return searchRootDir;
	}

	public void setSearchRootDir(String searchRootDir) {
		this.searchRootDir = searchRootDir;
	}
	
}
