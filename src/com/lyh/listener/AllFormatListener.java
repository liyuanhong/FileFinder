package com.lyh.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;

import com.lyh.bean.PubParamBean;

public class AllFormatListener extends MouseAdapter{
	private JList formatList;
	private JList selectFormatList;
	private PubParamBean pubParamBean;
	
	public AllFormatListener(JList formatList,JList selectFormatList,PubParamBean pubParamBean) {
		this.formatList = formatList;
		this.selectFormatList = selectFormatList;
		this.pubParamBean = pubParamBean;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			if(e.getClickCount() == 2){
				int index = formatList.getSelectedIndex();
				String format = formatList.getSelectedValue().toString();
				pubParamBean.getAllFormatList().remove(index);
				formatList.setListData(pubParamBean.getAllFormatList());
				pubParamBean.getSelectedFormatList().add(format);
				selectFormatList.setListData(pubParamBean.getSelectedFormatList());
			}
		}
	}
}
