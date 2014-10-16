package com.lyh.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.lyh.bean.PubParamBean;

public class StartSearchListener extends MouseAdapter{
	private JFrame frame;
	private JTextField dirField;
	private JTextField keywordsField;
	private PubParamBean pubParamBean;
	private String keyword = "";
	private String searchRootDir = "";
	private JTextArea manuDefineArea;
	private JList selectFormatList;
	private JTextArea runStatusArea;
	private JTextArea resultArea;
	
	
	public StartSearchListener(JFrame frame,JTextField dirField,JTextField keywordsField,PubParamBean pubParamBean,JTextArea manuDefineArea,JList selectFormatList,JTextArea runStatusArea,JTextArea resultArea) {
		this.frame = frame;
		this.dirField = dirField;
		this.keywordsField = keywordsField;
		this.pubParamBean = pubParamBean;
		this.manuDefineArea = manuDefineArea;
		this.selectFormatList = this.selectFormatList;
		this.runStatusArea = runStatusArea;
		this.resultArea = resultArea;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		resultArea.setText("");
		runStatusArea.setText("");
		keyword = keywordsField.getText();
		pubParamBean.setKeywordsField(keyword);
		searchRootDir = pubParamBean.getSearchRootDir();
		try{
			File file = new File(searchRootDir);
			File[] filelist = file.listFiles();
			if(filelist != null){
				startSearch(filelist);
			}			
		}catch(Exception ex){
			System.out.println("no such path");
		}
		
	}
	
	private void startSearch(File[] filelist){
		if(filelist != null){
			for(int i = 0;i < filelist.length;i++){
				runStatusArea.append(filelist[i].getAbsolutePath() + "\r\n");
				if(filelist[i].isDirectory()){
					String _filepath = filelist[i].getAbsolutePath();
					File _file = new File(_filepath);
					File[] _filelist = _file.listFiles();
					startSearch(_filelist);
				}else{
//					searchKeywork(filelist[i].getAbsolutePath());
				}
			}
		}		
	}
	
	private void searchKeywork(String filePath){
		try {
			FileReader reader = new FileReader(filePath);
			BufferedReader bfreader = new BufferedReader(reader);
			String temp = "";
			while((temp = bfreader.readLine()) != null){
				if(temp.contains(keyword)){
					resultArea.append(filePath + "\r\n");
					return;
				}
			}
			bfreader.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}












