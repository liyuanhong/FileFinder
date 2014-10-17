package com.lyh.listener;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
				if(pubParamBean.getSearchWay() == 0){
					startTreeSearch(filelist);
				}else if(pubParamBean.getSearchWay() == 1){
					startCurrentSearch(filelist);
				}				
			}			
		}catch(Exception ex){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(frame, "目录不存在或目录格式有问题！", "信息", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	private void startTreeSearch(File[] filelist){
		if(filelist != null){
			for(int i = 0;i < filelist.length;i++){
				runStatusArea.append(filelist[i].getAbsolutePath() + "\r\n");
				if(filelist[i].isDirectory()){
					String _filepath = filelist[i].getAbsolutePath();
					File _file = new File(_filepath);
					File[] _filelist = _file.listFiles();
					startTreeSearch(_filelist);
				}else{
					searchKeywork(filelist[i].getAbsolutePath());
				}
			}
		}		
	}
	
	private void startCurrentSearch(File[] filelist){
		if(filelist != null){
			for(int i = 0;i < filelist.length;i++){
				runStatusArea.append(filelist[i].getAbsolutePath() + "\r\n");
				if(filelist[i].isDirectory()){
					
				}else{
					searchKeywork(filelist[i].getAbsolutePath());
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
	
	public void allFormatFilter(){
		//不需要进性文件过滤
	}
	
	public void aassignFormatFilter(){
		
	}

	public void manuFormatFilter(){
		
	}
}












