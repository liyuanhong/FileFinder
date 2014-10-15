package com.lyh.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class mainWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 566, 654);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6587\u4EF6");
		menu.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u9009\u62E9\u76EE\u5F55");
		menuItem.setFont(new Font("宋体", Font.PLAIN, 12));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA");
		menuItem_1.setFont(new Font("宋体", Font.PLAIN, 12));
		menu.add(menuItem_1);
		
		JMenu menu_2 = new JMenu("\u67E5\u627E\u65B9\u5F0F");
		menu_2.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(menu_2);
		
		JRadioButton radioButton = new JRadioButton("\u9012\u5F52\u67E5\u627E");
		radioButton.setFont(new Font("宋体", Font.PLAIN, 12));
		radioButton.setSelected(true);
		menu_2.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u975E\u9012\u5F52\u67E5\u627E");
		radioButton_1.setFont(new Font("宋体", Font.PLAIN, 12));
		menu_2.add(radioButton_1);
		
		JMenu menu_3 = new JMenu("\u8FC7\u6EE4\u5668");
		menu_3.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(menu_3);
		
		JRadioButton radioButton_2 = new JRadioButton("\u6240\u6709\u683C\u5F0F");
		radioButton_2.setFont(new Font("宋体", Font.PLAIN, 12));
		radioButton_2.setSelected(true);
		menu_3.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("\u6307\u5B9A\u683C\u5F0F");
		radioButton_3.setFont(new Font("宋体", Font.PLAIN, 12));
		menu_3.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("\u81EA\u5B9A\u4E49\u683C\u5F0F");
		radioButton_4.setFont(new Font("宋体", Font.PLAIN, 12));
		menu_3.add(radioButton_4);
		
		JMenu menu_1 = new JMenu("\u8BF4\u660E");
		menu_1.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u8BF4\u660E");
		menuItem_2.setFont(new Font("宋体", Font.PLAIN, 12));
		menu_1.add(menuItem_2);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(UIManager.getColor("Button.disabledForeground")));
		panel.setBounds(10, 77, 530, 110);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel.add(scrollPane_4, "name_4355653145808");
		
		JTextArea txtrtxtxmlhtml = new JTextArea();
		txtrtxtxmlhtml.setText(".txt   .xml   .html  .java  .cpp  .c   .cmd   .bat    .js   .dtd    .py    .pyw      .property ");
		txtrtxtxmlhtml.setLineWrap(true);
		txtrtxtxmlhtml.setFont(new Font("宋体", Font.PLAIN, 13));
		scrollPane_4.setViewportView(txtrtxtxmlhtml);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "name_3281517048565");
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "name_2395144553732");
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 186, 108);
		panel_1.add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("宋体", Font.PLAIN, 12));
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
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
		
		JList list_1 = new JList();
		list_1.setFont(new Font("宋体", Font.PLAIN, 12));
		scrollPane_1.setViewportView(list_1);
		
		JLabel label = new JLabel("\u67E5\u627E\u76EE\u5F55\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(10, 10, 70, 15);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 12));
		textField.setBounds(77, 7, 356, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u627E");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(457, 35, 83, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u9009\u62E9\u76EE\u5F55");
		button_1.setFont(new Font("宋体", Font.PLAIN, 12));
		button_1.setBounds(457, 6, 83, 23);
		frame.getContentPane().add(button_1);
		
		JLabel label_1 = new JLabel("\u6267\u884C\u72B6\u6001\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(10, 197, 70, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u67E5\u8BE2\u7ED3\u679C\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		label_2.setBounds(10, 439, 70, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u67E5\u627E\u5B57\u7B26\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 12));
		label_3.setBounds(10, 35, 70, 15);
		frame.getContentPane().add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(77, 35, 356, 21);
		frame.getContentPane().add(textField_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 222, 530, 210);
		frame.getContentPane().add(scrollPane_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.PLAIN, 13));
		scrollPane_2.setViewportView(textArea);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 464, 530, 131);
		frame.getContentPane().add(scrollPane_3);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("宋体", Font.PLAIN, 13));
		scrollPane_3.setViewportView(textArea_1);
	}
}
