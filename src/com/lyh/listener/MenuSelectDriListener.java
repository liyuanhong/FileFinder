package com.lyh.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.lyh.bean.PubParamBean;

public class MenuSelectDriListener implements ActionListener{
	private JFrame frame;
	private JTextField dirField;
	private PubParamBean pubParamBean;
	private String searchRootDir = "";
	public MenuSelectDriListener(JFrame frame,JTextField dirField,PubParamBean pubParamBean) {
		this.frame = frame;
		this.dirField = dirField;
		this.pubParamBean = pubParamBean;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("."));
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.showOpenDialog(frame);
		searchRootDir = fileChooser.getSelectedFile().toString();
		dirField.setText(searchRootDir);
		pubParamBean.setSearchRootDir(searchRootDir);		
	}

}
