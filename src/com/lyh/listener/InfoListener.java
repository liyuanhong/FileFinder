package com.lyh.listener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InfoListener implements ActionListener{
	private JFrame frame;
	public InfoListener(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(frame, "此工具可以帮助你在某个目中找到包含某个字符串的文件。\r\n" +
				"版本：1.0.0\r\n日期：2014-10-21", "说明", JOptionPane.INFORMATION_MESSAGE);		
	}

}
