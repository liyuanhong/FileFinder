package com.lyh.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;

import com.lyh.bean.PubParamBean;

public class MenuSearchWayListener extends MouseAdapter{
	private JRadioButton recousiveWay;
	private JRadioButton nonRecousiveWay;
	private PubParamBean pubParamBean;
	
	public MenuSearchWayListener(JRadioButton recousiveWay,JRadioButton nonRecousiveWay
			,PubParamBean pubParamBean) {
		this.recousiveWay = recousiveWay;
		this.nonRecousiveWay = nonRecousiveWay;
		this.pubParamBean = pubParamBean;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			if(e.getSource().equals(recousiveWay)){
				pubParamBean.setSearchWay(0);
			}else if(e.getSource().equals(nonRecousiveWay)){
				pubParamBean.setSearchWay(1);
			}
		}
	}
}
