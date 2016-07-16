package com.service;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import com.BO.Bill_info;
import com.dao3.Today_sale_DAO;

public class Today_sale_application_window {

	private JFrame frame;
	public static Today_sale_application_window window ;
	private static  JTextField res_text;
	private static JTextField bar_text;
	private JLabel lblDate;
	private static JTextField date_text;
	/**
	 * Launch the application.
	 */
	
			public void invoke_today_sale() {
				try {
					window = new Today_sale_application_window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
			public void invoke_sale(){
				Bill_info info2=new Bill_info();
				 Date date=new Date();
					SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
					String date1=sdf.format(date);
					date_text.setText(date1);
					
					info2.setDate(date1);
					Today_sale_DAO tsd=new Today_sale_DAO();
				 if(tsd.authenticate_jtable_R(info2)){
					 res_text.setText(""+Today_sale_DAO.Total_RES_SALE);
				 }
			
			 if(tsd.authenticate_jtable_B(info2)){
				 bar_text.setText(""+Today_sale_DAO.Total_BAR_SALE);
			 }
			}
	/**
	 * Create the application.
	 */
	public Today_sale_application_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 464, 409);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(238, 232, 170));
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Pictures\\16.jpg"));
		label.setBounds(59, 0, 330, 153);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Restaurant Sale :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(73, 237, 142, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBarSale = new JLabel("Bar Sale :");
		lblBarSale.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBarSale.setForeground(Color.BLACK);
		lblBarSale.setBounds(73, 295, 142, 24);
		frame.getContentPane().add(lblBarSale);
		
		res_text = new JTextField();
		res_text.setBounds(209, 240, 180, 20);
		frame.getContentPane().add(res_text);
		res_text.setColumns(10);
		
		bar_text = new JTextField();
		bar_text.setColumns(10);
		bar_text.setBounds(209, 299, 180, 20);
		frame.getContentPane().add(bar_text);
		
		lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDate.setBounds(73, 184, 142, 24);
		frame.getContentPane().add(lblDate);
		
		date_text = new JTextField();
		date_text.setColumns(10);
		date_text.setBounds(209, 187, 180, 20);
		frame.getContentPane().add(date_text);
		
		
	
	}
}
