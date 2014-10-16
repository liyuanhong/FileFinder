package com.lyh.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.lyh.bean.PubParamBean;

public class SelectDirLisenter extends MouseAdapter{
	private JFrame frame;
	private JTextField dirField;
	private PubParamBean pubParamBean;
	private String searchRootDir = "";
	
	public SelectDirLisenter(JFrame frame,JTextField dirField,PubParamBean pubParamBean) {
		this.frame = frame;
		this.dirField = dirField;
		this.pubParamBean = pubParamBean;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("."));
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.showOpenDialog(frame);
		searchRootDir = fileChooser.getSelectedFile().toString();
		dirField.setText(searchRootDir);
		pubParamBean.setSearchRootDir(searchRootDir);
	}
}
