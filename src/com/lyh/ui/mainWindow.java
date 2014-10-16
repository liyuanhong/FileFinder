package com.lyh.ui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.lyh.bean.PubParamBean;
import com.lyh.listener.SelectDirLisenter;
import com.lyh.listener.StartSearchListener;

public class mainWindow {

	private JFrame frame;
	private JTextField dirField;
	private JTextField keywordsField;
	private PubParamBean pubParamBean;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//���캯��
	public mainWindow() {
		pubParamBean = new PubParamBean();
		initialize();
	}

	//��ʼ������
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 566, 654);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("�ļ�");
		menu.setFont(new Font("����", Font.PLAIN, 12));
		menuBar.add(menu);
		
		JMenuItem chooseDirMenu = new JMenuItem("ѡ��Ŀ¼");
		chooseDirMenu.setFont(new Font("����", Font.PLAIN, 12));
		menu.add(chooseDirMenu);
		
		JMenuItem exitMenu = new JMenuItem("�˳�");
		exitMenu.setFont(new Font("����", Font.PLAIN, 12));
		menu.add(exitMenu);
		
		JMenu recousiveWayMenu = new JMenu("���ҷ�ʽ");
		recousiveWayMenu.setFont(new Font("����", Font.PLAIN, 12));
		menuBar.add(recousiveWayMenu);
		
		JRadioButton radioButton = new JRadioButton("�ݹ����");
		radioButton.setFont(new Font("����", Font.PLAIN, 12));
		radioButton.setSelected(true);
		recousiveWayMenu.add(radioButton);
		
		JRadioButton nonRecousiveWay = new JRadioButton("�ǵݹ����");
		nonRecousiveWay.setFont(new Font("����", Font.PLAIN, 12));
		recousiveWayMenu.add(nonRecousiveWay);
		
		JMenu menu_3 = new JMenu("������");
		menu_3.setFont(new Font("����", Font.PLAIN, 12));
		menuBar.add(menu_3);
		
		JRadioButton allFormatMenu = new JRadioButton("���и�ʽ");
		allFormatMenu.setFont(new Font("����", Font.PLAIN, 12));
		allFormatMenu.setSelected(true);
		menu_3.add(allFormatMenu);
		
		JRadioButton assignFormatMenu = new JRadioButton("ָ����ʽ");
		assignFormatMenu.setFont(new Font("����", Font.PLAIN, 12));
		menu_3.add(assignFormatMenu);
		
		JRadioButton ManuFormatMenu = new JRadioButton("�Զ����ʽ");
		ManuFormatMenu.setFont(new Font("����", Font.PLAIN, 12));
		menu_3.add(ManuFormatMenu);
		
		JMenu menu_1 = new JMenu("˵��");
		menu_1.setFont(new Font("����", Font.PLAIN, 12));
		menuBar.add(menu_1);
		
		JMenuItem detailsMenu = new JMenuItem("˵��");
		detailsMenu.setFont(new Font("����", Font.PLAIN, 12));
		menu_1.add(detailsMenu);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(UIManager.getColor("Button.disabledForeground")));
		panel.setBounds(10, 77, 530, 110);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel.add(scrollPane_4, "name_4355653145808");
		
		JTextArea manuDefineArea = new JTextArea();
		manuDefineArea.setText(".txt   .xml   .html  .java  .cpp  .c   .cmd   .bat    .js   .dtd    .py    .pyw      .property ");
		manuDefineArea.setLineWrap(true);
		manuDefineArea.setFont(new Font("����", Font.PLAIN, 13));
		scrollPane_4.setViewportView(manuDefineArea);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "name_3281517048565");
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "name_2395144553732");
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 186, 108);
		panel_1.add(scrollPane);
		
		JList formatList = new JList();
		formatList.setFont(new Font("����", Font.PLAIN, 12));
		scrollPane.setViewportView(formatList);
		formatList.setModel(new AbstractListModel() {
			String[] values = new String[] {".txt", ".c", ".java", ".php", ".js", ".cmd", ".bat", ".cpp", ".py", ".pyw", ".sh", ".html", ".xml", ".dtd"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(342, 0, 186, 108);
		panel_1.add(scrollPane_1);
		
		JList selectFormatList = new JList();
		selectFormatList.setFont(new Font("����", Font.PLAIN, 12));
		scrollPane_1.setViewportView(selectFormatList);
		
		JLabel label = new JLabel("����Ŀ¼��");
		label.setFont(new Font("����", Font.PLAIN, 12));
		label.setBounds(10, 10, 70, 15);
		frame.getContentPane().add(label);
		
		dirField = new JTextField();
		dirField.setFont(new Font("����", Font.PLAIN, 12));
		dirField.setBounds(77, 7, 356, 21);
		frame.getContentPane().add(dirField);
		dirField.setColumns(10);
		
		JButton findButton = new JButton("����");
		findButton.setFont(new Font("����", Font.PLAIN, 12));
		findButton.setBounds(457, 35, 83, 23);
		frame.getContentPane().add(findButton);
		
		JButton selectDirButton = new JButton("ѡ��Ŀ¼");
		selectDirButton.setFont(new Font("����", Font.PLAIN, 12));
		selectDirButton.setBounds(457, 6, 83, 23);
		frame.getContentPane().add(selectDirButton);
		
		JLabel label_1 = new JLabel("ִ��״̬��");
		label_1.setFont(new Font("����", Font.PLAIN, 12));
		label_1.setBounds(10, 358, 70, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("��ѯ�����");
		label_2.setFont(new Font("����", Font.PLAIN, 12));
		label_2.setBounds(10, 197, 70, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("�����ַ���");
		label_3.setFont(new Font("����", Font.PLAIN, 12));
		label_3.setBounds(10, 35, 70, 15);
		frame.getContentPane().add(label_3);
		
		keywordsField = new JTextField();
		keywordsField.setFont(new Font("����", Font.PLAIN, 12));
		keywordsField.setColumns(10);
		keywordsField.setBounds(77, 35, 356, 21);
		frame.getContentPane().add(keywordsField);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 383, 530, 210);
		frame.getContentPane().add(scrollPane_2);
		
		JTextArea runStatusArea = new JTextArea();
		scrollPane_2.setViewportView(runStatusArea);
		runStatusArea.setFont(new Font("����", Font.PLAIN, 13));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 217, 530, 131);
		frame.getContentPane().add(scrollPane_3);
		
		JTextArea resultArea = new JTextArea();
		scrollPane_3.setViewportView(resultArea);
		resultArea.setFont(new Font("����", Font.PLAIN, 13));
		
		
		//��Ӽ�������
		findButton.addMouseListener(new StartSearchListener(frame, dirField, keywordsField, pubParamBean, manuDefineArea, selectFormatList, runStatusArea, resultArea));
		selectDirButton.addMouseListener(new SelectDirLisenter(frame, dirField,pubParamBean));
	}
}
