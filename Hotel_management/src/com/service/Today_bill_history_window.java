package com.service;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.BO.Bill_info;
import com.dao3.Bill_History_DAO;

public class Today_bill_history_window {

	private JFrame frmBillHistoryWindow;
	public static Today_bill_history_window window;
	private static JTable table;
	/**
	 * Launch the application.
	 */
	
		public void invoke_today_history(){
				try {
					window = new Today_bill_history_window();
					window.frmBillHistoryWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the application.
	 */
	public Today_bill_history_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frmBillHistoryWindow = new JFrame();
		frmBillHistoryWindow.setTitle("Bill History Window");
		frmBillHistoryWindow.setBounds(100, 100, 450, 300);
		frmBillHistoryWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBillHistoryWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmBillHistoryWindow.getContentPane().setLayout(null);
		frmBillHistoryWindow.getContentPane().setBackground(new Color(238, 232, 170));
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Pictures\\16.jpg"));
		label.setBounds(540, 11, 330, 153);
		frmBillHistoryWindow.getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 199, 1224, 495);
		frmBillHistoryWindow.getContentPane().add(scrollPane);
		
		 Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			String date1=sdf.format(date);
			Bill_info info1=new Bill_info();
			info1.setDate(date1);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Bill_History_DAO bhd=new Bill_History_DAO();
		Map<String,Vector> map1=bhd.authenticate_jtable(info1);
		Vector header_info=null;
		Vector set_data1=null;
		if(map1 !=null){
			header_info=(Vector)map1.get("header_set1");
			set_data1=(Vector)map1.get("dataset1");
			if(header_info.size()>0 && set_data1.size() >0){
			
				table.setModel(new javax.swing.table.DefaultTableModel(set_data1,header_info));
		
			}
		}
	}
}
