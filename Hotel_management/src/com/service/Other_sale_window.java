package com.service;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import com.BO.Bill_info;
import com.dao3.Today_sale_DAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Other_sale_window {

	private JFrame frmSaleWindow;
	private static JTextField date_text;
	private static JTextField res_text;
	private static JTextField bar_text;
	private JComboBox<Integer> day_combo;
	private JComboBox<String> month_combo;
	private JComboBox<Integer> year_combo;
	/**
	 * Launch the application.
	 */
	
			public void invoke_other_sale() {
				try {
					Other_sale_window window = new Other_sale_window();
					window.frmSaleWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	/**
	 * Create the application.
	 */
	public Other_sale_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSaleWindow = new JFrame();
		frmSaleWindow.setTitle("Sale Window");
		frmSaleWindow.setBounds(100, 100, 469, 479);
		frmSaleWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSaleWindow.getContentPane().setLayout(null);
		frmSaleWindow.getContentPane().setBackground(new Color(238, 232, 170));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\git\\hotel_mangement_core_java_swings_project\\Hotel_management\\src\\PICS\\16.jpg"));
		label.setBounds(60, 0, 330, 153);
		frmSaleWindow.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Date :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(80, 177, 62, 20);
		frmSaleWindow.getContentPane().add(label_1);
		
		day_combo = new JComboBox<Integer>();
		day_combo.setBounds(157, 178, 49, 20);
		frmSaleWindow.getContentPane().add(day_combo);
		ArrayList<Integer> mylist=new ArrayList<Integer>();
		for(Integer i=1;i<=31;i++){
			mylist.add(i);
		}
		Integer d[]=mylist.toArray(new Integer[mylist.size()]);
        day_combo.setModel(new javax.swing.DefaultComboBoxModel<Integer>(d));
	
		month_combo = new JComboBox<String>();
		month_combo.setBounds(216, 178, 49, 20);
		frmSaleWindow.getContentPane().add(month_combo);
		String e[]={"01","02","03","04","05","06","07","08","09","10","11","12"};
		month_combo.setModel(new javax.swing.DefaultComboBoxModel<String>(e));
        	
		year_combo = new JComboBox<Integer>();
		year_combo.setBounds(281, 178, 72, 20);
		frmSaleWindow.getContentPane().add(year_combo);
		ArrayList<Integer> mylist2=new ArrayList<Integer>();
		for(Integer i=2016;i<=2025;i++){
			mylist2.add(i);
		}
		Integer f[]=mylist2.toArray(new Integer[mylist2.size()]);
		year_combo.setModel(new javax.swing.DefaultComboBoxModel<Integer>(f));
	
		JButton btnGetSale = new JButton("Get Sale");
		btnGetSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Bill_info info2=new Bill_info();
				    String date2=(Integer)day_combo.getSelectedItem()+"/"+(String)month_combo.getSelectedItem()+"/"+(Integer)year_combo.getSelectedItem();
				    info2.setDate(date2);
				  
					date_text.setText(date2);
					Today_sale_DAO tsd=new Today_sale_DAO();
				 if(tsd.authenticate_jtable_R(info2)){
					 res_text.setText(""+Today_sale_DAO.Total_RES_SALE);
				 }
			
			 if(tsd.authenticate_jtable_B(info2)){
				 bar_text.setText(""+Today_sale_DAO.Total_BAR_SALE);
			 }
			}
		});
		btnGetSale.setForeground(Color.RED);
		btnGetSale.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGetSale.setBounds(192, 227, 115, 23);
		frmSaleWindow.getContentPane().add(btnGetSale);
		
		JLabel label_2 = new JLabel("Date :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(60, 274, 142, 24);
		frmSaleWindow.getContentPane().add(label_2);
		
		date_text = new JTextField();
		date_text.setColumns(10);
		date_text.setBounds(196, 277, 180, 20);
		frmSaleWindow.getContentPane().add(date_text);
		
		JLabel label_3 = new JLabel("Restaurant Sale :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(60, 327, 142, 24);
		frmSaleWindow.getContentPane().add(label_3);
		
		res_text = new JTextField();
		res_text.setColumns(10);
		res_text.setBounds(196, 330, 180, 20);
		frmSaleWindow.getContentPane().add(res_text);
		
		JLabel label_4 = new JLabel("Bar Sale :");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(60, 385, 142, 24);
		frmSaleWindow.getContentPane().add(label_4);
		
		bar_text = new JTextField();
		bar_text.setColumns(10);
		bar_text.setBounds(196, 389, 180, 20);
		frmSaleWindow.getContentPane().add(bar_text);
	}
}
