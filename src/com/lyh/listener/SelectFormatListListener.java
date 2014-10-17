package com.lyh.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;

import com.lyh.bean.PubParamBean;

public class SelectFormatListListener extends MouseAdapter{
	private JList formatList;
	private JList selectFormatList;
	private PubParamBean pubParamBean;
	
	public SelectFormatListListener(JList formatList,JList selectFormatList,PubParamBean pubParamBean) {
		this.formatList = formatList;
		this.selectFormatList = selectFormatList;
		this.pubParamBean = pubParamBean;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			if(e.getClickCount() == 2){
				int index = selectFormatList.getSelectedIndex();
				String format = selectFormatList.getSelectedValue().toString();
				pubParamBean.getSelectedFormatList().remove(index);
				formatList.setListData(pubParamBean.getAllFormatList());
				pubParamBean.getAllFormatList().add(format);
				selectFormatList.setListData(pubParamBean.getSelectedFormatList());
			}
		}
	}
}
