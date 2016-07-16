package com.service;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.BO.Staff_info;
import com.BO.Table_info;
import com.DAO2.Steward_combo_action_DAO;
import com.DAO2.Update_Combo_table_action_DAO;
import com.DAO2.Update_generate_kot_Table_DAO;
import com.dao3.Auto_generate_KOT_no_DAO;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Generate_bill_window {

	private static JFrame frmGetBill;
	public static Generate_bill_window window;
	public static JTextField bill_no_text;
	public static JTextField steward_id_text;
	public static JTextField steward_name_text;
	public static JTextField department_text;
	public static JTextField guest_name_text;
	public static JTextField pax_text;
	public static JTextField date_text;
	public static JTextField time_text;
	public static JComboBox<Integer> table_no_combo;
	public static JComboBox<Integer> discount_combo;
	/**
	 * Launch the application.
	 */
	
			public void invoke_generate_bill() {
				try {
				//	Generate_bill_window window = new Generate_bill_window();
					Generate_bill_window.frmGetBill.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
			public void invoke_bill_no(){
				
				
		        Auto_generate_KOT_no_DAO agnd=new Auto_generate_KOT_no_DAO();
			if(agnd.authenticate_bill_no()){
				if((Auto_generate_KOT_no_DAO.BILL_NO)==0){
					bill_no_text.setText(""+1);	
					
				}
				else{
					bill_no_text.setText(""+Auto_generate_KOT_no_DAO.BILL_NO);
				}
			}
			}
	/**
	 * Create the application.
	 */
	public Generate_bill_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGetBill = new JFrame();
		frmGetBill.setTitle("Get Bill");
		frmGetBill.setBounds(100, 100, 418, 593);
		frmGetBill.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGetBill.getContentPane().setLayout(null);
		frmGetBill.getContentPane().setBackground(new Color(238, 232, 170));
		
		JLabel lblBillNo = new JLabel("Bill No :");
		lblBillNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBillNo.setBounds(65, 11, 116, 25);
		frmGetBill.getContentPane().add(lblBillNo);
		
		bill_no_text = new JTextField();
		bill_no_text.setColumns(10);
		bill_no_text.setBounds(162, 13, 192, 20);
		frmGetBill.getContentPane().add(bill_no_text);
		
		JLabel label_1 = new JLabel("Steward ID :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(65, 299, 116, 25);
		frmGetBill.getContentPane().add(label_1);
		
		steward_id_text = new JTextField();
		steward_id_text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				Integer Steward_id=Integer.parseInt(steward_id_text.getText()); 
	    		Staff_info info=new Staff_info();
	  		   info.setSteward_id(Steward_id);
	  		   Steward_combo_action_DAO scad=new Steward_combo_action_DAO();
	  			if(scad.authenticate_steward_id_combo(info)){
	  				try {
	  					steward_name_text.setText(Steward_combo_action_DAO.result.getString(2));
	  				} catch (SQLException e) {
	  					
	  					e.printStackTrace();
	  				}
	  			}
			}
		});
		steward_id_text.setColumns(10);
		steward_id_text.setBounds(162, 301, 192, 20);
		frmGetBill.getContentPane().add(steward_id_text);
		
		JLabel label_2 = new JLabel("Steward Name :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(65, 345, 116, 25);
		frmGetBill.getContentPane().add(label_2);
		
		steward_name_text = new JTextField();
		steward_name_text.setColumns(10);
		steward_name_text.setBounds(162, 347, 192, 20);
		frmGetBill.getContentPane().add(steward_name_text);
		
		JLabel label_3 = new JLabel("Department :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(65, 251, 116, 25);
		frmGetBill.getContentPane().add(label_3);
		
		department_text = new JTextField();
		department_text.setColumns(10);
		department_text.setBounds(162, 253, 192, 20);
		frmGetBill.getContentPane().add(department_text);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(65, 398, 116, 25);
		frmGetBill.getContentPane().add(lblDate);
		
		JLabel label_5 = new JLabel("Pax :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(65, 199, 116, 25);
		frmGetBill.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Guest Name :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(65, 153, 116, 25);
		frmGetBill.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Table No :");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(65, 62, 116, 25);
		frmGetBill.getContentPane().add(label_7);
		
		table_no_combo = new JComboBox<Integer>();
		table_no_combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int table_no=(Integer)table_no_combo.getSelectedItem();
				Table_info info=new Table_info();
				info.setTable_no(table_no);
				Update_Combo_table_action_DAO uctd=new Update_Combo_table_action_DAO();
				if(uctd.authenticate_table_no(info)){
					try {
						guest_name_text.setText(Update_Combo_table_action_DAO.result.getString(2));
					    pax_text.setText(""+Update_Combo_table_action_DAO.result.getInt(3));
					    department_text.setText(Update_Combo_table_action_DAO.result.getString(6));
					    steward_id_text.setText(""+Update_Combo_table_action_DAO.result.getInt(7));
					    steward_name_text.setText(Update_Combo_table_action_DAO.result.getString(8));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		table_no_combo.setBounds(162, 65, 192, 20);
		frmGetBill.getContentPane().add(table_no_combo);
		Update_generate_kot_Table_DAO ugktd=new Update_generate_kot_Table_DAO();
		if(ugktd.authenticate_table_no()){
			Integer a[]=new Integer[Update_generate_kot_Table_DAO.mylist.size()];
			  a=Update_generate_kot_Table_DAO.mylist.toArray(a);
			  table_no_combo.setModel(new javax.swing.DefaultComboBoxModel<Integer>(a));	
		}
		
		guest_name_text = new JTextField();
		guest_name_text.setColumns(10);
		guest_name_text.setBounds(162, 158, 192, 20);
		frmGetBill.getContentPane().add(guest_name_text);
		
		pax_text = new JTextField();
		pax_text.setColumns(10);
		pax_text.setBounds(162, 202, 192, 20);
		frmGetBill.getContentPane().add(pax_text);
		
		JLabel lblDiscount = new JLabel("Discount :");
		lblDiscount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiscount.setBounds(65, 113, 116, 25);
		frmGetBill.getContentPane().add(lblDiscount);
		
		JLabel lblTime = new JLabel("Time :");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTime.setBounds(65, 445, 116, 25);
		frmGetBill.getContentPane().add(lblTime);
		
		date_text = new JTextField();
		date_text.setColumns(10);
		date_text.setBounds(162, 401, 192, 20);
		frmGetBill.getContentPane().add(date_text);
		
		time_text = new JTextField();
		time_text.setColumns(10);
		time_text.setBounds(162, 450, 192, 20);
		frmGetBill.getContentPane().add(time_text);
		
		discount_combo = new JComboBox<Integer>();
		discount_combo.setBounds(162, 116, 192, 20);
		frmGetBill.getContentPane().add(discount_combo);
	    Integer d[]={0,5,10,15,20,25,30,35,40};
	    discount_combo.setModel(new javax.swing.DefaultComboBoxModel<Integer>(d));
	    
		JButton get_bill_button = new JButton("Get Bill");
		get_bill_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Get_bill_window window1=new Get_bill_window();
				window1.invoke_get_bill();
				window1.invoke_getbill_table();
				Generate_bill_window.frmGetBill.setVisible(false);
			}
		});
		get_bill_button.setFont(new Font("Tahoma", Font.BOLD, 17));
		get_bill_button.setForeground(Color.RED);
		get_bill_button.setBounds(119, 499, 160, 23);
		frmGetBill.getContentPane().add(get_bill_button);

		 Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			date_text.setText(sdf.format(date));
	
			SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm:ss");
			time_text.setText(sdf1.format(date));
	}
}
