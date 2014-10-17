package com.lyh.listener;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.lyh.bean.PubParamBean;

public class MenuFilterListener extends MouseAdapter{
	private CardLayout cardlayout;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane panel_3;
	private JRadioButton allFormatMenu;
	private JRadioButton assignFormatMenu;
	private JRadioButton manuFormatMenu;
	private JPanel panel;
	private PubParamBean pubParamBean;
	
	public MenuFilterListener(CardLayout cardlayout,JPanel panel_1,JPanel panel_2,
			JScrollPane panel_3,JRadioButton allFormatMenu,JRadioButton assignFormatMenu,
			JRadioButton manuFormatMenu,JPanel panel,PubParamBean pubParamBean) {
		this.cardlayout = cardlayout;
		this.panel_1 = panel_1;
		this.panel_2 = panel_2;
		this.panel_3 = panel_3;
		this.allFormatMenu = allFormatMenu;
		this.assignFormatMenu = assignFormatMenu;
		this.manuFormatMenu = manuFormatMenu;
		this.panel = panel;
		this.pubParamBean = pubParamBean;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			if(e.getSource().equals(allFormatMenu)){
				cardlayout.show(panel,"panel_1");
				allFormatFilter();
			}else if(e.getSource().equals(assignFormatMenu)){
				cardlayout.show(panel,"panel_2");
				aassignFormatFilter();
			}else if(e.getSource().equals(manuFormatMenu)){
				cardlayout.show(panel,"panel_3");
				manuFormatFilter();
			}
		}
	}
	
	public void allFormatFilter(){
		pubParamBean.setFilterWay(0);
	}
	
	public void aassignFormatFilter(){
		pubParamBean.setFilterWay(2);
	}

	public void manuFormatFilter(){
		pubParamBean.setFilterWay(2);
	}
}
