package com.service;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.BO.Staff_info;
import com.BO.Table_info;
import com.DAO2.Steward_combo_action_DAO;
import com.DAO2.Update_bar_steward_id_combo_DAO;
import com.dao.Add_table_DAO;
import com.dao.Update_bar_table_no_combo_DAO;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Add_table_Bar_window {

	private JFrame frmBarTableWindow;
	private JTextField guest_name_text;
	private JTextField pax_text;
	private JTextField date_text;
	private JTextField steward_name_text;
	private JComboBox<Integer> steward_id_combo;
	private JComboBox<Integer> table_no_combo;
	public static Add_table_Bar_window window ;
	/**
	 * Launch the application.
	 */
	
			public void invoke_bar_add_table() {
				try {
					window = new Add_table_Bar_window();
					window.frmBarTableWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the application.
	 */
	public Add_table_Bar_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBarTableWindow = new JFrame();
		frmBarTableWindow.setTitle("Bar Table Window");
		frmBarTableWindow.setBounds(100, 100, 450, 541);
		frmBarTableWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBarTableWindow.getContentPane().setBackground(new Color(238, 232, 170));
		frmBarTableWindow.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Desktop\\PICS\\16.jpg"));
		label.setBounds(42, 0, 330, 121);
		frmBarTableWindow.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Table No :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(66, 163, 117, 21);
		frmBarTableWindow.getContentPane().add(label_1);
		
		table_no_combo = new JComboBox<Integer>();
		table_no_combo.setBounds(172, 163, 182, 20);
		frmBarTableWindow.getContentPane().add(table_no_combo);
		Update_bar_table_no_combo_DAO ubtcd=new Update_bar_table_no_combo_DAO();
		if(ubtcd.authenticate_table_no()){
			Integer b[]=new Integer[Update_bar_table_no_combo_DAO.mylist.size()];
			b=Update_bar_table_no_combo_DAO.mylist.toArray(b);
			//	Integer d[]=Update_table_no_DAO.mylist.toArray(new Integer[mylist.size()]);
				table_no_combo.setModel(new javax.swing.DefaultComboBoxModel<Integer>(b));
		}
		JLabel label_2 = new JLabel("Guest Name :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(66, 215, 117, 21);
		frmBarTableWindow.getContentPane().add(label_2);
		
		guest_name_text = new JTextField();
		guest_name_text.setColumns(10);
		guest_name_text.setBounds(172, 215, 182, 20);
		frmBarTableWindow.getContentPane().add(guest_name_text);
		
		JLabel label_3 = new JLabel("Pax :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(66, 267, 117, 21);
		frmBarTableWindow.getContentPane().add(label_3);
		
		pax_text = new JTextField();
		pax_text.setColumns(10);
		pax_text.setBounds(172, 267, 182, 20);
		frmBarTableWindow.getContentPane().add(pax_text);
		
		JLabel label_4 = new JLabel("Date&Time :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(66, 314, 117, 21);
		frmBarTableWindow.getContentPane().add(label_4);
		
		date_text = new JTextField();
		date_text.setText("Sun  10/07/2016  11:57:35");
		date_text.setColumns(10);
		date_text.setBounds(172, 314, 182, 20);
		frmBarTableWindow.getContentPane().add(date_text);
		
		JLabel label_5 = new JLabel("Steward ID :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(66, 357, 117, 21);
		frmBarTableWindow.getContentPane().add(label_5);
		
	    steward_id_combo = new JComboBox<Integer>();
	    steward_id_combo.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		Integer Steward_id=(Integer)steward_id_combo.getSelectedItem(); 
	    		Staff_info info=new Staff_info();
	  		   info.setSteward_id(Steward_id);
	  		   Steward_combo_action_DAO scad=new Steward_combo_action_DAO();
	  			if(scad.authenticate_steward_id_combo(info)){
	  				try {
	  					steward_name_text.setText(Steward_combo_action_DAO.result.getString(2));
	  				} catch (SQLException e) {
	  					// TODO Auto-generated catch block
	  					e.printStackTrace();
	  				}
	  			}
	    	}
	    });
		steward_id_combo.setBounds(172, 358, 182, 20);
		frmBarTableWindow.getContentPane().add(steward_id_combo);
		Update_bar_steward_id_combo_DAO usid=new Update_bar_steward_id_combo_DAO();
		if(usid.authenticate_steward_id()){
			Integer c[]=new Integer[Update_bar_steward_id_combo_DAO.mylist1.size()];
			c=Update_bar_steward_id_combo_DAO.mylist1.toArray(c);
			steward_id_combo.setModel(new javax.swing.DefaultComboBoxModel<Integer>(c));
		}
		JLabel label_6 = new JLabel("Steward Name :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(66, 404, 117, 21);
		frmBarTableWindow.getContentPane().add(label_6);
		
		steward_name_text = new JTextField();
		steward_name_text.setColumns(10);
		steward_name_text.setBounds(172, 404, 182, 20);
		frmBarTableWindow.getContentPane().add(steward_name_text);
		
		JButton add_table_button = new JButton("ADD TABLE");
		add_table_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int Table_no=(Integer)table_no_combo.getSelectedItem();
				String Guest_name=guest_name_text.getText();
				int Pax=Integer.parseInt(pax_text.getText());
				String Date=date_text.getText();
				int Steward_id=(Integer)steward_id_combo.getSelectedItem();
				String Steward_name=steward_name_text.getText();
				Table_info info=new Table_info();
				info.setTable_no(Table_no);
				info.setGuest_name(Guest_name);
				info.setPax(Pax);
				info.setDate(Date);
				info.setSteward_id(Steward_id);
				info.setSteward_name(Steward_name);
				Add_table_DAO atrd=new Add_table_DAO();
				if(!(guest_name_text.getText().isEmpty())&& !(steward_name_text.getText().isEmpty())){
				if(atrd.authenticate_new_table(info)){
					JOptionPane.showMessageDialog(add_table_button, "Table is Added sucessfully");
					guest_name_text.setText("");
					pax_text.setText("");
					date_text.setText("");
					steward_name_text.setText("");
				   window.frmBarTableWindow.setVisible(false);
				}
				
				}else{
					JOptionPane.showMessageDialog(add_table_button, "Please fill all the details");
				}
			}
		});
		add_table_button.setForeground(Color.RED);
		add_table_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		add_table_button.setBounds(134, 454, 132, 23);
		frmBarTableWindow.getContentPane().add(add_table_button);
		
		 Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("E  dd/MM/yyyy  HH:mm:ss" );
			date_text.setText(sdf.format(date));
	}
}
