package com.lyh.bean;

import java.util.Vector;

import javax.swing.JList;

public class PubParamBean {
	//�����ĸ�Ŀ¼
	private String searchRootDir;
	//�������ַ���
	private String keywordsField;
	//���ҷ�ʽ����(0��ʾ�ݹ���ң�1��ʾ�ǵݹ����)
	private int searchWay = 0;
	//���˷�ʽ�ı���(0��ʾ�����ļ���1��ʾѡ����ˣ�2��ʾ�Զ������)
	private int filterWay = 0;
	//���п���ѡ��ĸ�ʽ
	private Vector<String> allFormatList = new Vector<String>();
	//ѡ��Ҫ���˵��ĸ�ʽ
	private Vector<String> selectedFormatList = new Vector<String>();
	//�Զ���Ҫ���˵ĸ�ʽ
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
