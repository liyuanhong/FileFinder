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
		JOptionPane.showMessageDialog(frame, "�˹��߿��԰�������ĳ��Ŀ���ҵ�����ĳ���ַ������ļ���\r\n" +
				"�汾��1.0.0\r\n���ڣ�2014-10-21", "˵��", JOptionPane.INFORMATION_MESSAGE);		
	}

}
