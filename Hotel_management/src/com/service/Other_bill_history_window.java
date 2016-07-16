package com.service;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import com.BO.Bill_info;
import com.dao3.Bill_History_DAO;
import javax.swing.JTable;

public class Other_bill_history_window {

	private JFrame frmBillHistoryWindow;
	public static Other_bill_history_window window ;
	private JComboBox<Integer> day_combo;
	private JComboBox<String> month_combo;
	private JComboBox<Integer> year_combo;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
			public void invoke_other_bill_history() {
				try {
					window = new Other_bill_history_window();
					window.frmBillHistoryWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	/**
	 * Create the application.
	 */
	public Other_bill_history_window() {
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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Pictures\\16.jpg"));
		label.setBounds(507, 11, 330, 153);
		frmBillHistoryWindow.getContentPane().add(label);
		
		JLabel label23 = new JLabel("Date :");
		label23.setFont(new Font("Tahoma", Font.BOLD, 13));
		label23.setBounds(535, 194, 62, 20);
		frmBillHistoryWindow.getContentPane().add(label23);
		
		day_combo = new JComboBox<Integer>();
		day_combo.setBounds(612, 195, 49, 20);
		frmBillHistoryWindow.getContentPane().add(day_combo);
		ArrayList<Integer> mylist=new ArrayList<Integer>();
		for(Integer i=1;i<=31;i++){
			mylist.add(i);
		}
		Integer d[]=mylist.toArray(new Integer[mylist.size()]);
        day_combo.setModel(new javax.swing.DefaultComboBoxModel<Integer>(d));
	
		
		month_combo = new JComboBox<String>();
		month_combo.setBounds(671, 195, 49, 20);
		frmBillHistoryWindow.getContentPane().add(month_combo);
		String e[]={"01","02","03","04","05","06","07","08","09","10","11","12"};
		month_combo.setModel(new javax.swing.DefaultComboBoxModel<String>(e));
        
		
		year_combo = new JComboBox<Integer>();
		year_combo.setBounds(736, 195, 72, 20);
		frmBillHistoryWindow.getContentPane().add(year_combo);
		ArrayList<Integer> mylist2=new ArrayList<Integer>();
		for(Integer i=2016;i<=2025;i++){
			mylist2.add(i);
		}
		Integer f[]=mylist2.toArray(new Integer[mylist2.size()]);
		year_combo.setModel(new javax.swing.DefaultComboBoxModel<Integer>(f));
	
		
		JButton btnNewButton = new JButton("Get History");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  Bill_info info1=new Bill_info();
				    String date2=(Integer)day_combo.getSelectedItem()+"/"+(String)month_combo.getSelectedItem()+"/"+(Integer)year_combo.getSelectedItem();
				    info1.setDate(date2);
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
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(647, 244, 115, 23);
		frmBillHistoryWindow.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 283, 1224, 411);
		frmBillHistoryWindow.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
	
	    
	}
}
