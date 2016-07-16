package com.service;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.BO.KOT_info;
import com.BO.Staff_info;
import com.BO.Table_info;
import com.DAO2.Steward_combo_action_DAO;
import com.DAO2.Update_Combo_table_action_DAO;
import com.DAO2.Update_generate_kot_Table_DAO;
import com.dao3.Auto_generate_KOT_no_DAO;
import com.dao3.Insertion_KOT_no_DAO;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KOT_generate_window {

	public static JFrame frmKotGenerateWindow;
	public static JTextField kot_no_text;
	public static JTextField Steward_id_text;
	public static JTextField steward_name_text;
	public static JTextField guest_name_text;
	public static JTextField pax_text;
	public static JTextField department_text;
	public static JTextField date_text;
	public static KOT_generate_window window ;
	public static JComboBox<Integer> comboBox ;
	public static JTable table;
	/**
	 * Launch the application.
	 */
	
			public void invoke_kot_window() {
				try {
					 window = new KOT_generate_window();
					KOT_generate_window.frmKotGenerateWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	public void get_kot_no(){
		Insertion_KOT_no_DAO ikd=new Insertion_KOT_no_DAO();
		ikd.authenticate_auto_kot();
			
		
	}
	
	public void invoke_kot_no(){
		
		
        Auto_generate_KOT_no_DAO agnd=new Auto_generate_KOT_no_DAO();
	if(agnd.authenticate_table_no()){
		if((Auto_generate_KOT_no_DAO.KOT_NO)==0){
			kot_no_text.setText(""+1);	
			
		}
		else{
			kot_no_text.setText(""+Auto_generate_KOT_no_DAO.KOT_NO);
		}
		
	}
	
	
	
	}
	

	/**
	 * Create the application.
	 */
	public KOT_generate_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKotGenerateWindow = new JFrame();
		frmKotGenerateWindow.setTitle("KOT Generate Window");
		frmKotGenerateWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmKotGenerateWindow.setBounds(100, 100, 774, 609);
		frmKotGenerateWindow.getContentPane().setLayout(null);
		frmKotGenerateWindow.getContentPane().setBackground(new Color(238, 232, 170));
			
		JLabel lblNewLabel = new JLabel("KOT No :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(52, 25, 116, 25);
		frmKotGenerateWindow.getContentPane().add(lblNewLabel);
		
		JLabel lblStewardId = new JLabel("Steward ID :");
		lblStewardId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStewardId.setBounds(52, 76, 116, 25);
		frmKotGenerateWindow.getContentPane().add(lblStewardId);
		
		JLabel lblStewardName = new JLabel("Steward Name :");
		lblStewardName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStewardName.setBounds(52, 122, 116, 25);
		frmKotGenerateWindow.getContentPane().add(lblStewardName);
		
		JLabel lblTableNo = new JLabel("Table No :");
		lblTableNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTableNo.setBounds(417, 25, 116, 25);
		frmKotGenerateWindow.getContentPane().add(lblTableNo);
		
		JLabel lblGuestName = new JLabel("Guest Name :");
		lblGuestName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGuestName.setBounds(417, 76, 116, 25);
		frmKotGenerateWindow.getContentPane().add(lblGuestName);
		
		JLabel lblPax = new JLabel("Pax :");
		lblPax.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPax.setBounds(417, 122, 116, 25);
		frmKotGenerateWindow.getContentPane().add(lblPax);
		
		kot_no_text = new JTextField();
		kot_no_text.setBounds(149, 27, 168, 20);
		frmKotGenerateWindow.getContentPane().add(kot_no_text);
		kot_no_text.setColumns(10);
		
		Steward_id_text = new JTextField();
		Steward_id_text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				Integer Steward_id=Integer.parseInt(Steward_id_text.getText()); 
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
		Steward_id_text.setColumns(10);
		Steward_id_text.setBounds(149, 78, 168, 20);
		frmKotGenerateWindow.getContentPane().add(Steward_id_text);
		
		steward_name_text = new JTextField();
		steward_name_text.setColumns(10);
		steward_name_text.setBounds(149, 124, 168, 20);
		frmKotGenerateWindow.getContentPane().add(steward_name_text);
		
		guest_name_text = new JTextField();
		guest_name_text.setColumns(10);
		guest_name_text.setBounds(527, 78, 168, 20);
		frmKotGenerateWindow.getContentPane().add(guest_name_text);
		
		pax_text = new JTextField();
		pax_text.setColumns(10);
		pax_text.setBounds(527, 124, 168, 20);
		frmKotGenerateWindow.getContentPane().add(pax_text);
		
		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartment.setBounds(52, 175, 116, 25);
		frmKotGenerateWindow.getContentPane().add(lblDepartment);
		
		JLabel lblDateTime = new JLabel("Date & Time");
		lblDateTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateTime.setBounds(417, 175, 116, 25);
		frmKotGenerateWindow.getContentPane().add(lblDateTime);
		
		department_text = new JTextField();
		department_text.setColumns(10);
		department_text.setBounds(149, 177, 168, 20);
		frmKotGenerateWindow.getContentPane().add(department_text);
		
		date_text = new JTextField();
		date_text.setColumns(10);
		date_text.setBounds(527, 177, 168, 20);
		frmKotGenerateWindow.getContentPane().add(date_text);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 241, 643, 285);
		frmKotGenerateWindow.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"S NO.", "ITEM CODE", "ITEM NAME", "PRICE(QTY=1)", "QTY", "TOTAL"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(41);
		table.getColumnModel().getColumn(2).setPreferredWidth(165);
		table.getColumnModel().getColumn(3).setPreferredWidth(109);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JButton generate_kot_button = new JButton("Generate KOT");
		generate_kot_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(generate_kot_button, "KOT is generated with KOT no "+kot_no_text.getText());
			KOT_generate_window.frmKotGenerateWindow.setVisible(false);
			}
		});
		generate_kot_button.setForeground(Color.RED);
		generate_kot_button.setFont(new Font("Tahoma", Font.BOLD, 13));
		generate_kot_button.setBounds(435, 537, 152, 23);
		frmKotGenerateWindow.getContentPane().add(generate_kot_button);
		
		JButton add_item_button1 = new JButton("ADD ITEM");
		add_item_button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_item_KOT window1=new Add_item_KOT();
				window1.invoke_add_item_kot();
				window1.get_sno();
				int Kot_no3=Integer.parseInt(kot_no_text.getText());
				int sr_no3=Integer.parseInt(Add_item_KOT.sr_text.getText());
				KOT_info info5=new KOT_info();
				info5.setKOT_no(Kot_no3);
				info5.setSr_no(sr_no3);
				Insertion_KOT_no_DAO ikd=new Insertion_KOT_no_DAO();
				ikd.authenticate_kot(info5);
				
			}
		});
		add_item_button1.setForeground(Color.RED);
		add_item_button1.setFont(new Font("Tahoma", Font.BOLD, 13));
		add_item_button1.setBounds(165, 537, 152, 23);
		frmKotGenerateWindow.getContentPane().add(add_item_button1);
		
		comboBox = new JComboBox<Integer>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int table_no=(Integer)comboBox.getSelectedItem();
			Table_info info=new Table_info();
			info.setTable_no(table_no);
			Update_Combo_table_action_DAO uctd=new Update_Combo_table_action_DAO();
			if(uctd.authenticate_table_no(info)){
				try {
					guest_name_text.setText(Update_Combo_table_action_DAO.result.getString(2));
				    pax_text.setText(""+Update_Combo_table_action_DAO.result.getInt(3));
				    department_text.setText(Update_Combo_table_action_DAO.result.getString(6));
				    Steward_id_text.setText(""+Update_Combo_table_action_DAO.result.getInt(7));
				    steward_name_text.setText(Update_Combo_table_action_DAO.result.getString(8));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			}
		});
		comboBox.setBounds(527, 28, 168, 20);
		frmKotGenerateWindow.getContentPane().add(comboBox);
		Update_generate_kot_Table_DAO ugktd=new Update_generate_kot_Table_DAO();
		if(ugktd.authenticate_table_no()){
			Integer a[]=new Integer[Update_generate_kot_Table_DAO.mylist.size()];
			  a=Update_generate_kot_Table_DAO.mylist.toArray(a);
	         comboBox.setModel(new javax.swing.DefaultComboBoxModel<Integer>(a));	
		}
		 Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("E  dd/MM/yyyy  HH:mm:ss" );
			date_text.setText(sdf.format(date));
	
		/*	  Auto_generate_KOT_no_DAO agnd=new Auto_generate_KOT_no_DAO();
				if(agnd.authenticate_table_no()){
					if((Auto_generate_KOT_no_DAO.KOT_NO)==0){
						kot_no_text.setText(""+1);	
						
					}
					else{
						kot_no_text.setText(""+Auto_generate_KOT_no_DAO.KOT_NO);
					}
				}*/
	}
}
