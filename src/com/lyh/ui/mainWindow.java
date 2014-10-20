package com.lyh.ui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
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
import javax.swing.event.MenuEvent;

import com.lyh.bean.PubParamBean;
import com.lyh.listener.AllFormatListener;
import com.lyh.listener.MenuExitListener;
import com.lyh.listener.MenuFilterListener;
import com.lyh.listener.MenuSearchWayListener;
import com.lyh.listener.SelectDirLisenter;
import com.lyh.listener.SelectFormatListListener;
import com.lyh.listener.StartSearchListener;
import com.lyh.listener.MenuSelectDriListener;

public class mainWindow {

	private JFrame frame;
	private JTextField dirField;
	private JTextField keywordsField;
	private PubParamBean pubParamBean;
	private Vector<String> allFormatList;

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
		allFormatList = new Vector<String>();
		initFormatVector(allFormatList);
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
		
		JRadioButton recousiveWay = new JRadioButton("�ݹ����");
		recousiveWay.setFont(new Font("����", Font.PLAIN, 12));
		recousiveWay.setSelected(true);
		recousiveWayMenu.add(recousiveWay);
		
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
		
		JRadioButton manuFormatMenu = new JRadioButton("�Զ����ʽ");
		manuFormatMenu.setFont(new Font("����", Font.PLAIN, 12));
		menu_3.add(manuFormatMenu);
		
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
		CardLayout cardlayout = new CardLayout(0, 0);
		panel.setLayout(cardlayout);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "panel_1");
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "panel_2");
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 186, 108);
		panel_2.add(scrollPane);
		
		JList formatList = new JList();
		formatList.setFont(new Font("����", Font.PLAIN, 12));
		scrollPane.setViewportView(formatList);
		formatList.setListData(allFormatList);	
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(342, 0, 186, 108);
		panel_2.add(scrollPane_1);
		
		JList selectFormatList = new JList();
		selectFormatList.setFont(new Font("����", Font.PLAIN, 12));
		scrollPane_1.setViewportView(selectFormatList);
		
		JScrollPane panel_3 = new JScrollPane();
		panel.add(panel_3, "panel_3");
		
		JTextArea manuDefineArea = new JTextArea();
		manuDefineArea.setText(".txt   .xml   .html  .java  .cpp  .c  .bat   .js  .dtd  .py  .sh");
		manuDefineArea.setLineWrap(true);
		manuDefineArea.setFont(new Font("����", Font.PLAIN, 13));
		panel_3.setViewportView(manuDefineArea);
		
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
		
		//����һ������ť����
		ButtonGroup rulegroup = new ButtonGroup();
		rulegroup.add(allFormatMenu);
		rulegroup.add(assignFormatMenu);
		rulegroup.add(manuFormatMenu);
		//����һ�����ҷ�ʽ����
		ButtonGroup searchWayGroup = new ButtonGroup();
		searchWayGroup.add(recousiveWay);
		searchWayGroup.add(nonRecousiveWay);
		//��Ӽ�������
		findButton.addMouseListener(new StartSearchListener(frame, dirField, keywordsField, pubParamBean, manuDefineArea, selectFormatList, runStatusArea, resultArea));
		selectDirButton.addMouseListener(new SelectDirLisenter(frame, dirField,pubParamBean));
		chooseDirMenu.addActionListener(new MenuSelectDriListener(frame, dirField, pubParamBean));
		exitMenu.addActionListener(new MenuExitListener());
		allFormatMenu.addMouseListener(new MenuFilterListener(cardlayout, panel_1, panel_2, panel_3, allFormatMenu, assignFormatMenu, manuFormatMenu, panel,pubParamBean));
		assignFormatMenu.addMouseListener(new MenuFilterListener(cardlayout, panel_1, panel_2, panel_3, allFormatMenu, assignFormatMenu, manuFormatMenu, panel,pubParamBean));
		manuFormatMenu.addMouseListener(new MenuFilterListener(cardlayout, panel_1, panel_2, panel_3, allFormatMenu, assignFormatMenu, manuFormatMenu, panel,pubParamBean));
		recousiveWay.addMouseListener(new MenuSearchWayListener(recousiveWay, nonRecousiveWay, pubParamBean));
		nonRecousiveWay.addMouseListener(new MenuSearchWayListener(recousiveWay, nonRecousiveWay, pubParamBean));
		formatList.addMouseListener(new AllFormatListener(formatList, selectFormatList, pubParamBean));
		selectFormatList.addMouseListener(new SelectFormatListListener(formatList, selectFormatList, pubParamBean));
	}
	
	private void initFormatVector(Vector<String> allFormatList){
		String[] values = new String[] {".txt", ".c", ".java",".class",".php", ".js", ".cmd", ".bat", ".cpp", ".py", ".pyw", ".sh", ".html", ".xml", ".dtd"};
		for(int i = 0;i < values.length;i++){
			allFormatList.add(values[i]);
		}
		pubParamBean.setAllFormatList(allFormatList);
	}
}
