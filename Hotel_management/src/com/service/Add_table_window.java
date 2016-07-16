package com.service;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import com.BO.Staff_info;
import com.BO.Table_info;
import com.DAO2.Steward_combo_action_DAO;
import com.DAO2.Update_Steward_id_DAO;
import com.DAO2.Update_table_no_DAO;
import com.dao.Add_table_DAO;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Add_table_window {

	private JFrame frmRestaurantTableWindow;
	private JTextField guest_name_text;
	private JTextField pax_text;
	private JTextField date_text;
	private JComboBox<Integer> table_no_combo;
	private JTextField steward_name_text;
	private JComboBox<Integer> comboBox;
	public static Add_table_window window ;
	/**
	 * Launch the application.
	 */
	
			public void invoke_add_table() {
				try {
				    window = new Add_table_window();
					window.frmRestaurantTableWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the application.
	 */
	public Add_table_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRestaurantTableWindow = new JFrame();
		frmRestaurantTableWindow.setTitle("Restaurant Table Window");
		frmRestaurantTableWindow.setBounds(100, 100, 450, 540);
		frmRestaurantTableWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRestaurantTableWindow.getContentPane().setLayout(null);
		frmRestaurantTableWindow.getContentPane().setBackground(new Color(238, 232, 170));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Desktop\\PICS\\16.jpg"));
		label.setBounds(53, 0, 330, 121);
		frmRestaurantTableWindow.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Table No :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(77, 163, 117, 21);
		frmRestaurantTableWindow.getContentPane().add(lblNewLabel);
		
		JLabel lblGuestName = new JLabel("Guest Name :");
		lblGuestName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGuestName.setBounds(77, 215, 117, 21);
		frmRestaurantTableWindow.getContentPane().add(lblGuestName);
		
		JLabel lblPax = new JLabel("Pax :");
		lblPax.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPax.setBounds(77, 267, 117, 21);
		frmRestaurantTableWindow.getContentPane().add(lblPax);
		
		JLabel lblDatetime = new JLabel("Date&Time :");
		lblDatetime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatetime.setBounds(77, 314, 117, 21);
		frmRestaurantTableWindow.getContentPane().add(lblDatetime);
		
		guest_name_text = new JTextField();
		guest_name_text.setBounds(183, 215, 182, 20);
		frmRestaurantTableWindow.getContentPane().add(guest_name_text);
		guest_name_text.setColumns(10);
		
		pax_text = new JTextField();
		pax_text.setColumns(10);
		pax_text.setBounds(183, 267, 182, 20);
		frmRestaurantTableWindow.getContentPane().add(pax_text);
		
		date_text = new JTextField();
		date_text.setColumns(10);
		date_text.setBounds(183, 314, 182, 20);
		frmRestaurantTableWindow.getContentPane().add(date_text);
		
		table_no_combo = new JComboBox<Integer>();
		table_no_combo.setBounds(183, 163, 182, 20);
		frmRestaurantTableWindow.getContentPane().add(table_no_combo);
		Update_table_no_DAO utnd=new Update_table_no_DAO();
		if(utnd.authenticate_table_no()){
		Integer b[]=new Integer[Update_table_no_DAO.mylist.size()];
		b=Update_table_no_DAO.mylist.toArray(b);
		//	Integer d[]=Update_table_no_DAO.mylist.toArray(new Integer[mylist.size()]);
			table_no_combo.setModel(new javax.swing.DefaultComboBoxModel<Integer>(b));
		}
		
		
		JButton btnNewButton = new JButton("ADD TABLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int Table_no=(Integer)table_no_combo.getSelectedItem();
			String Guest_name=guest_name_text.getText();
			int Pax=Integer.parseInt(pax_text.getText());
			String Date=date_text.getText();
			int Steward_id=(Integer)comboBox.getSelectedItem();
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
				JOptionPane.showMessageDialog(btnNewButton, "Table is Added sucessfully");
				guest_name_text.setText("");
				pax_text.setText("");
				date_text.setText("");
				steward_name_text.setText("");
				window.frmRestaurantTableWindow.setVisible(false);
			}
			}else{
				JOptionPane.showMessageDialog(btnNewButton, "Please fill all the fields");
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(145, 454, 132, 23);
		frmRestaurantTableWindow.getContentPane().add(btnNewButton);
		
		JLabel lblStewardId = new JLabel("Steward ID :");
		lblStewardId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStewardId.setBounds(77, 357, 117, 21);
		frmRestaurantTableWindow.getContentPane().add(lblStewardId);
		
		JLabel lblStewardName = new JLabel("Steward Name :");
		lblStewardName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStewardName.setBounds(77, 404, 117, 21);
		frmRestaurantTableWindow.getContentPane().add(lblStewardName);
		
		steward_name_text = new JTextField();
		steward_name_text.setColumns(10);
		steward_name_text.setBounds(183, 404, 182, 20);
		frmRestaurantTableWindow.getContentPane().add(steward_name_text);
		
		comboBox = new JComboBox<Integer>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		   Integer Steward_id=(Integer)comboBox.getSelectedItem();
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
      
		comboBox.setBounds(183, 358, 182, 20);
		frmRestaurantTableWindow.getContentPane().add(comboBox);
		Update_Steward_id_DAO usid=new Update_Steward_id_DAO();
		if(usid.authenticate_steward_id()){
			Integer c[]=new Integer[Update_Steward_id_DAO.mylist1.size()];
			c=Update_Steward_id_DAO.mylist1.toArray(c);
			comboBox.setModel(new javax.swing.DefaultComboBoxModel<Integer>(c));
		}
		  Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("E  dd/MM/yyyy  HH:mm:ss" );
			date_text.setText(sdf.format(date));
	        
	}
}
