package com.lyh.listener;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.lyh.bean.PubParamBean;
import com.lyh.jchardet.FileCharsetDetector;

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
		initManuFormat();
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
	
	//递归查找
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
					if(isFilterFile(filelist[i].getAbsolutePath())){
						searchKeywork(filelist[i].getAbsolutePath());
					}
				}
			}
		}		
	}
	
	//非递归查找
	private void startCurrentSearch(File[] filelist){
		if(filelist != null){
			for(int i = 0;i < filelist.length;i++){
				runStatusArea.append(filelist[i].getAbsolutePath() + "\r\n");
				if(filelist[i].isDirectory()){
					
				}else{
					if(isFilterFile(filelist[i].getAbsolutePath())){
						searchKeywork(filelist[i].getAbsolutePath());
					}
				}
			}
		}
	}
	
	private void searchKeywork(String filePath){
		try {
			String coding = getEncoding(filePath);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), coding);
			BufferedReader bfreader = new BufferedReader(reader);
			String temp = null;
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
	
	
	public boolean isFilterFile(String file){
		if(pubParamBean.getFilterWay() == 1){
			return aassignFormatFilter(file);
		}else if(pubParamBean.getFilterWay() == 2){
			return manuFormatFilter(file);
		}else{
			return allFormatFilter();
		}
	}
	
	public boolean allFormatFilter(){
		return true;
	}
	
	public boolean aassignFormatFilter(String file){
		String _suff = getFileSuffix(file);
		Vector<String> selectedFormatList = pubParamBean.getSelectedFormatList();
		for(int i = 0;i < selectedFormatList.size();i++){
			if(selectedFormatList.get(i).equals(_suff)){
				return true;
			}
		}
		return false;
	}

	public boolean manuFormatFilter(String file){
		String _suff = getFileSuffix(file);
		Vector<String> manuFormatList = pubParamBean.getManuFormatList();
		for(int i = 0;i < manuFormatList.size();i++){
			if(manuFormatList.get(i).equals(_suff)){
				return true;
			}
		}
		return false;
	}
	
	//初始化自定义过滤格式
	public void initManuFormat(){
		pubParamBean.setManuFormatList(new Vector<String>());
		String[] suffix = manuDefineArea.getText().split(" ");
		for(int i  = 0;i < suffix.length;i++){
			pubParamBean.getManuFormatList().add(suffix[i]);
		}
	}
	
	//获取文件的后缀
	public String getFileSuffix(String file){
		String[] temp = file.split("[.]");
		String _suffix = "not a file";
		if(temp.length != 0){
			_suffix =  "." + temp[temp.length - 1];
		}				
		return _suffix;
	}
	
	//获取编码方式参见：http://blog.csdn.net/paul630/article/details/6164390
	public String getEncoding(String file){
		BufferedInputStream bin;
		String coding = "GBK";	
		try {
		coding = FileCharsetDetector.guestFileEncoding(new File(file));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		return coding;
	}
}












