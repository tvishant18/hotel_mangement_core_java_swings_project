package com.service;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import com.BO.Bill_info;
import com.DAO2.Update_generate_kot_Table_DAO;
import com.dao.Get_Bill_DAO;
import com.dao.Info_DAO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Info_window {

	private JFrame frmInfoWindow;
	private JComboBox<Integer> table_no_combo;
	private static JTextField price_text;
	private static JTable table;
	private static JTable table_1;
	/**
	 * Launch the application.
	 */
			public void invoke_info() {
				try {
					Info_window window = new Info_window();
					window.frmInfoWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
			@SuppressWarnings("rawtypes")
			public void invoke_jTAble(){
				Info_DAO id=new Info_DAO();
				   
				    Map<String,Vector> map1=id.authenticate_jtable();
					Vector header_info=null;
					Vector set_data1=null;
					if(map1 !=null){
						price_text.setText(""+Get_Bill_DAO.TOTAL);
						header_info=(Vector)map1.get("header_set1");
						set_data1=(Vector)map1.get("dataset1");
						if(header_info.size()>0 && set_data1.size() >0){
						table_1.setModel(new javax.swing.table.DefaultTableModel(set_data1,header_info));
					
						}
					}	
			}
	/**
	 * Create the application.
	 */
	public Info_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInfoWindow = new JFrame();
		frmInfoWindow.setTitle("Info Window");
		frmInfoWindow.setBounds(100, 100, 758, 457);
		frmInfoWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInfoWindow.getContentPane().setBackground(new Color(238, 232, 170));
		frmInfoWindow.getContentPane().setLayout(null);
		frmInfoWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(139, 47, 1071, 632);
		frmInfoWindow.getContentPane().add(tabbedPane);
		tabbedPane.setBackground(new Color(238, 232, 170));
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Table Info", null, panel_1, null);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(238, 232, 170));

		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Pictures\\16.jpg"));
		label_1.setBounds(391, 11, 330, 153);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Table No :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(408, 192, 116, 25);
		panel_1.add(label_2);
		
		table_no_combo = new JComboBox<Integer>();
		table_no_combo.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent arg0) {
				int table_no=(Integer)table_no_combo.getSelectedItem();
				Bill_info info=new Bill_info();
				info.setTable_no(table_no);
				   Get_Bill_DAO gbd=new Get_Bill_DAO();
				   
				    Map<String,Vector> map1=gbd.authenticate_jtable(info);
					Vector header_info=null;
					Vector set_data1=null;
					if(map1 !=null){
						price_text.setText(""+Get_Bill_DAO.TOTAL);
						header_info=(Vector)map1.get("header_set1");
						set_data1=(Vector)map1.get("dataset1");
						if(header_info.size()>0 && set_data1.size() >0){
						table.setModel(new javax.swing.table.DefaultTableModel(set_data1,header_info));
					
						}
					}	
			}
		});
		table_no_combo.setBounds(505, 195, 192, 20);
		panel_1.add(table_no_combo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(187, 266, 760, 287);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAmount.setBounds(616, 568, 116, 25);
		panel_1.add(lblAmount);
		
		price_text = new JTextField();
		price_text.setBounds(725, 571, 175, 20);
		panel_1.add(price_text);
		price_text.setColumns(10);
		Update_generate_kot_Table_DAO ugktd=new Update_generate_kot_Table_DAO();
		if(ugktd.authenticate_table_no()){
			Integer a[]=new Integer[Update_generate_kot_Table_DAO.mylist.size()];
			  a=Update_generate_kot_Table_DAO.mylist.toArray(a);
			  table_no_combo.setModel(new javax.swing.DefaultComboBoxModel<Integer>(a));	
		}
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("KOT Info", null, panel, null);
		panel.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Pictures\\16.jpg"));
		label.setBounds(378, 11, 330, 153);
		panel.add(label);
		panel.setBackground(new Color(238, 232, 170));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(142, 218, 760, 375);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

	}
}
