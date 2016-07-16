package com.service;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import com.BO.Menu_info;
import com.DAO2.Update_combo_DAO;
import com.DAO2.Update_combo_item_name;
import com.dao.Menu_DAO;
import com.dao.Menu_unique_item_DAO;
import com.dao.Update_menu_DAO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Master_window {
	public static Master_window window;
	private JFrame frmMasterWindow;
	private JTextField item_code_text;
	private JTextField item_name_text;
	private JTextField price_text;
	private JTextField vat_text;
	private JTextField total_price_text;
	private JComboBox<String> comboBox;
	private JComboBox<String> item_code_combo;
	private JComboBox<String> department_combo;
	private JTextField item_name1_text;
	private JTextField price1_text;
	private JTextField vat1_text;
	private static JTextField total_price1_text;
	/**
	 * Launch the application.
	 */

			public void invoke_master_window() {
				try {
					 window = new Master_window();
					window.frmMasterWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public Master_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMasterWindow = new JFrame();
		frmMasterWindow.setTitle("Master Window");
		frmMasterWindow.setBounds(100, 100, 1079, 675);
		frmMasterWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMasterWindow.getContentPane().setLayout(null);
		frmMasterWindow.getContentPane().setBackground(new Color(238, 232, 170));
		frmMasterWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.GRAY);
		tabbedPane.setBounds(162, 29, 876, 596);
		frmMasterWindow.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setForeground(new Color(0, 0, 0));
		panel.setLayout(null);
		panel.setBackground(new Color(238, 232, 170));
		tabbedPane.addTab("Add Item", null, panel, null);
		
		JLabel label = new JLabel("Item Code :");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(192, 157, 136, 24);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Item Name :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(192, 207, 136, 24);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Department :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(192, 261, 136, 24);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Price(in Rs) :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(192, 318, 136, 24);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("VAT :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(192, 376, 136, 24);
		panel.add(label_4);
		
		JButton add_item_button = new JButton("ADD ITEM");
		add_item_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String item_code=item_code_text.getText();
				String item_name=item_name_text.getText();
				String department=(String)comboBox.getSelectedItem();
				float price=Float.parseFloat(price_text.getText());
				float vat=Float.parseFloat(vat_text.getText());
				float total_price=Float.parseFloat(total_price_text.getText());
				Menu_info info=new Menu_info();
				info.setItem_code(item_code);
				info.setItem(item_name);
				info.setDepartment(department);
				info.setPrice(price);
				info.setVAT(vat);
				info.setTotal_price(total_price);
				Menu_DAO md=new Menu_DAO();
				Menu_unique_item_DAO muid=new Menu_unique_item_DAO();
				if(!(item_code_text.getText().isEmpty())&& !(item_name_text.getText().isEmpty())){
				if(muid.authenticate_item(info)){
				if(md.authenticate_menu(info)){
					JOptionPane.showMessageDialog(add_item_button, "Item is added succesfully to Menu");
					item_code_text.setText("");
					item_name_text.setText("");
					price_text.setText("");
					vat_text.setText("");
					total_price_text.setText("");
					}
				}
				else{
					JOptionPane.showMessageDialog(add_item_button, "Item is already in menu");
					item_code_text.setText("");
					item_name_text.setText("");
					price_text.setText("");
					vat_text.setText("");
					total_price_text.setText("");

				}
			}else{
			JOptionPane.showMessageDialog(add_item_button, "Please fill all the fields");
			}
			}
		});
		add_item_button.setForeground(Color.RED);
		add_item_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		add_item_button.setBounds(343, 493, 197, 31);
		panel.add(add_item_button);
		
		item_code_text = new JTextField();
		item_code_text.setColumns(10);
		item_code_text.setBounds(362, 157, 254, 24);
		panel.add(item_code_text);
		
		item_name_text = new JTextField();
		item_name_text.setColumns(10);
		item_name_text.setBounds(362, 204, 254, 24);
		panel.add(item_name_text);
		
		price_text = new JTextField();
		price_text.setColumns(10);
		price_text.setBounds(362, 318, 254, 24);
		panel.add(price_text);
		
		vat_text = new JTextField();
		vat_text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				float b=Float.parseFloat(price_text.getText())+((Float.parseFloat(vat_text.getText())* Float.parseFloat(price_text.getText()))/100);
				total_price_text.setText(""+b);
			}
		});
		vat_text.setColumns(10);
		vat_text.setBounds(361, 376, 254, 24);
		panel.add(vat_text);
		
		total_price_text = new JTextField();
		total_price_text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
					float b=Float.parseFloat(price_text.getText())+((Float.parseFloat(vat_text.getText())* Float.parseFloat(price_text.getText()))/100);
					total_price_text.setText(""+b);
			
			}
		});
		
		total_price_text.setColumns(10);
		total_price_text.setBounds(362, 435, 254, 24);
		panel.add(total_price_text);
		
		JLabel label_5 = new JLabel("Total Price (in Rs):");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(192, 437, 136, 24);
		panel.add(label_5);
		
	    comboBox = new JComboBox<String>();
		comboBox.setBounds(361, 260, 255, 24);
		panel.add(comboBox);
		String c[]={"TANDOOR","KITCHEN","BAR"};
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<String>(c));
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Desktop\\PICS\\16.jpg"));
		label_6.setBounds(260, 11, 330, 121);
		panel.add(label_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(238, 232, 170));
		tabbedPane.addTab("Update Item", null, panel_1, null);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Desktop\\PICS\\16.jpg"));
		label_7.setBounds(244, 27, 330, 121);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("Item Code :");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setBounds(173, 178, 136, 24);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Item Name :");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBounds(173, 228, 136, 24);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("Department :");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_10.setBounds(173, 282, 136, 24);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("Price(in Rs) :");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_11.setBounds(173, 339, 136, 24);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("VAT :");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_12.setBounds(173, 397, 136, 24);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("Total Price (in Rs):");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_13.setBounds(173, 458, 136, 24);
		panel_1.add(label_13);
		
		JButton btnUpdateItem = new JButton("UPDATE  ITEM");
		btnUpdateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String item_code1=(String)item_code_combo.getSelectedItem();
			String item_name1=item_name1_text.getText();
			String department1=(String)department_combo.getSelectedItem();
			float price1=Float.parseFloat(price1_text.getText());
			float vat1=Float.parseFloat(vat1_text.getText());
			float total_price1=Float.parseFloat(total_price1_text.getText());
			Menu_info info2=new Menu_info();
			info2.setItem_code(item_code1);
			info2.setItem(item_name1);
			info2.setDepartment(department1);
			info2.setPrice(price1);
			info2.setVAT(vat1);
			info2.setTotal_price(total_price1);
			Update_menu_DAO umd=new Update_menu_DAO();
			if(!(item_name1_text.getText().isEmpty())){
			if(umd.authenticate_update_item(info2)){
			  JOptionPane.showMessageDialog(btnUpdateItem, "Item is updated successfully");
			  item_name1_text.setText("");
			  price1_text.setText("");
			  vat1_text.setText("");
			  total_price1_text.setText("");
				 }
			}
			else{
				JOptionPane.showMessageDialog(btnUpdateItem, "Please fill all the fields");
			}
			}
		});
		btnUpdateItem.setForeground(Color.RED);
		btnUpdateItem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdateItem.setBounds(302, 507, 197, 31);
		panel_1.add(btnUpdateItem);
		
		item_name1_text = new JTextField();
		item_name1_text.setColumns(10);
		item_name1_text.setBounds(373, 229, 254, 24);
		panel_1.add(item_name1_text);
		
		department_combo = new JComboBox<String>();
		department_combo.setBounds(372, 281, 255, 24);
		panel_1.add(department_combo);
		department_combo.setModel(new javax.swing.DefaultComboBoxModel<String>(c));
		
		price1_text = new JTextField();
		price1_text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				float c=Float.parseFloat(price1_text.getText())+((Float.parseFloat(vat1_text.getText())* Float.parseFloat(price1_text.getText()))/100);
				total_price1_text.setText(""+c);
			}
		});
		price1_text.setColumns(10);
		price1_text.setBounds(373, 339, 254, 24);
		panel_1.add(price1_text);
		
		vat1_text = new JTextField();
		vat1_text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				float c=Float.parseFloat(price1_text.getText())+((Float.parseFloat(vat1_text.getText())* Float.parseFloat(price1_text.getText()))/100);
				total_price1_text.setText(""+c);
			}
		});
		vat1_text.setColumns(10);
		vat1_text.setBounds(372, 397, 254, 24);
		panel_1.add(vat1_text);
		
		total_price1_text = new JTextField();
		
		total_price1_text.setColumns(10);
		total_price1_text.setBounds(373, 456, 254, 24);
		panel_1.add(total_price1_text);
		
		item_code_combo = new JComboBox<String>();
		item_code_combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String combo_Item_code=(String)item_code_combo.getSelectedItem();
			Menu_info info1=new Menu_info();
			info1.setItem_code(combo_Item_code);
			Update_combo_item_name ucin=new Update_combo_item_name();
			if(ucin.authenticate_item(info1)){
				try {
				item_name1_text.setText(Update_combo_item_name.result.getString(2));
				price1_text.setText(""+Update_combo_item_name.result.getFloat(4));
				vat1_text.setText(""+Update_combo_item_name.result.getFloat(5));
				total_price1_text.setText(""+Update_combo_item_name.result.getFloat(6));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			}
		});
		item_code_combo.setBounds(372, 179, 255, 24);
		panel_1.add(item_code_combo);
		Update_combo_DAO ucd =new Update_combo_DAO();
		if(ucd.authenticate_item()){
		String a[]=new String[Update_combo_DAO.mylist.size()];
		  a=Update_combo_DAO.mylist.toArray(a);
		  //String d[]=mylist.toArray(new String[mylist.size()]);
	//	  for(String s : Update_combo_DAO.mylist){
	//		  System.out.println(s);
	//	  }
		
		  item_code_combo.setModel(new javax.swing.DefaultComboBoxModel<String>(a));
		}
		
		
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home_window2 window1 = new Home_window2();
			    window1.invoke_home2();
			    window.frmMasterWindow.setVisible(false);
			}
		});
		btnLogout.setForeground(Color.RED);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogout.setBounds(924, 11, 114, 23);
		frmMasterWindow.getContentPane().add(btnLogout);
	}
}
