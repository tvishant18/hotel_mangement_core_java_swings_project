package com.service;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.BO.KOT_info;
import com.DAO2.Update_combo_DAO;
import com.DAO2.Update_combo_add_item_name_DAO;
import com.dao.Insertion_KOT_DAO;
import com.dao3.Autogenerate_SNO_DAO;
import com.dao3.Update_JTable_DAO;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Add_item_KOT {

	private JFrame frame;
	private JTextField item_code_text;
	private JTextField quantity_text;
	private JTextField price_text;
	private JTextField total_price_text;
    public static Add_item_KOT window ;
    private JTextField department_text;
    public static JTextField sr_text;
	private JComboBox<String> item_name_combo;
    public static float VAT;
    public static float TOTAL_COST;
	/**
	 * Launch the application.
	 */

			public void invoke_add_item_kot() {
				try {
					window = new Add_item_KOT();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public void get_sno(){
		int Kot_no3=Integer.parseInt(KOT_generate_window.kot_no_text.getText());
		KOT_info info4=new KOT_info();
		info4.setKOT_no(Kot_no3);
		Autogenerate_SNO_DAO asd=new Autogenerate_SNO_DAO();
		if(asd.authenticate_table_no(info4)){
			
			if((Autogenerate_SNO_DAO.SR_NO)==0){
				sr_text.setText(""+1);	
				
			}
			else{
				sr_text.setText(""+Autogenerate_SNO_DAO.SR_NO);
			}
		}
	}
	
	public Add_item_KOT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 562);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(238, 232, 170));
		
		JLabel lblNewLabel = new JLabel("Item Code :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(71, 201, 108, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblItemName = new JLabel("Item Name :");
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblItemName.setBounds(71, 249, 108, 21);
		frame.getContentPane().add(lblItemName);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(71, 342, 108, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPrice = new JLabel("Price :(QTY=1) ");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrice.setBounds(71, 391, 108, 21);
		frame.getContentPane().add(lblPrice);
		
		item_code_text = new JTextField();
		item_code_text.setBounds(189, 202, 193, 20);
		frame.getContentPane().add(item_code_text);
		item_code_text.setColumns(10);
		
		quantity_text = new JTextField();
		quantity_text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			float a=Float.parseFloat(price_text.getText())*Float.parseFloat(quantity_text.getText());
			total_price_text.setText(""+a);
			}
		});
		quantity_text.setColumns(10);
		quantity_text.setBounds(189, 341, 193, 20);
		frame.getContentPane().add(quantity_text);
		
		price_text = new JTextField();
		price_text.setColumns(10);
		price_text.setBounds(189, 392, 193, 20);
		frame.getContentPane().add(price_text);
		
		JButton add_item_button = new JButton("ADD ITEM");
		add_item_button.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent arg0) {
			int sr_no=Integer.parseInt(sr_text.getText());	
			int kot_no1=Integer.parseInt(KOT_generate_window.kot_no_text.getText());
			int steward_id1=Integer.parseInt(KOT_generate_window.Steward_id_text.getText());
			String steward_name1=KOT_generate_window.steward_name_text.getText();
			int table_no1=(Integer)KOT_generate_window.comboBox.getSelectedItem();
			String date1=KOT_generate_window.date_text.getText();
			String department1=KOT_generate_window.department_text.getText();
			String item_code1=item_code_text.getText();
			String item_name1=(String)item_name_combo.getSelectedItem();
			//String Department1=department_text.getText();
			float quantity1=Float.parseFloat(quantity_text.getText());
			float price1=Float.parseFloat(price_text.getText());
			float vat1=VAT;
			float total_cost=TOTAL_COST;
			float total_price1=Float.parseFloat(total_price_text.getText());
			KOT_info info1=new KOT_info();
			info1.setKOT_no(kot_no1);
			info1.setSteward_id(steward_id1);
			info1.setDate(date1);
			info1.setDepartment(department1);
			info1.setItem_code(item_code1);
			info1.setItem_name(item_name1);
			info1.setPrice(price1);
			info1.setQuantity(quantity1);
			info1.setSteward_name(steward_name1);
			info1.setTable_no(table_no1);
			info1.setTotal_price(total_price1);
			info1.setTotal_cost(total_cost);
			info1.setVat(vat1);
			info1.setSr_no(sr_no);
			Insertion_KOT_DAO ikd=new Insertion_KOT_DAO();
			if(ikd.authenticate_kot(info1)){
			    if(ikd.authenticate_kot_record(info1)){
				 Update_JTable_DAO ujd=new Update_JTable_DAO();
				   Map<String,Vector> map1=ujd.authenticate_jtable(info1);
					Vector header_info=null;
					Vector set_data1=null;
					if(map1 !=null){
						header_info=(Vector)map1.get("header_set1");
						set_data1=(Vector)map1.get("dataset1");
						if(header_info.size()>0 && set_data1.size() >0){
						System.out.println(set_data1);
						System.out.println(header_info);
						KOT_generate_window.table.setModel(new javax.swing.table.DefaultTableModel(set_data1,header_info));
					
						}
					}
                			   
			//	window1.invoke_Jtable();
				window.frame.setVisible(false);
				KOT_generate_window.frmKotGenerateWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
			}
			}
		});
		add_item_button.setFont(new Font("Tahoma", Font.BOLD, 13));
		add_item_button.setForeground(Color.RED);
		add_item_button.setBounds(157, 489, 132, 23);
		frame.getContentPane().add(add_item_button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\git\\hotel_mangement_core_java_swings_project\\Hotel_management\\src\\PICS\\16.jpg"));
		label.setBounds(60, 3, 330, 121);
		frame.getContentPane().add(label);
		
		total_price_text = new JTextField();
		total_price_text.setColumns(10);
		total_price_text.setBounds(189, 438, 193, 20);
		frame.getContentPane().add(total_price_text);
		
		JLabel lblTotalPrice = new JLabel("Total Price :");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalPrice.setBounds(71, 437, 108, 21);
		frame.getContentPane().add(lblTotalPrice);
		
		department_text = new JTextField();
		department_text.setColumns(10);
		department_text.setBounds(189, 292, 193, 20);
		frame.getContentPane().add(department_text);
		
		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDepartment.setBounds(71, 291, 108, 21);
		frame.getContentPane().add(lblDepartment);
		
		item_name_combo = new JComboBox<String>();
		item_name_combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		//	String item_code=item_code_text.getText();
			String item_name=(String)item_name_combo.getSelectedItem();
		//	String department=department_text.getText();
		//	float Quantity=Float.parseFloat(quantity_text.getText());
		//	float price=Float.parseFloat(price_text.getText());
		//	float total_price=Float.parseFloat(total_price_text.getText());
			KOT_info info=new KOT_info();
		//	info.setItem_code(item_code);
			info.setItem_name(item_name);
		//	info.setDepartment(department);
		//	info.setPrice(price);
		//	info.setTotal_price(total_price);
		//	info.setQuantity(Quantity);
			Update_combo_add_item_name_DAO ucind=new Update_combo_add_item_name_DAO();
			if(ucind.authenticate_item(info)){
				try {
					item_code_text.setText(Update_combo_add_item_name_DAO.result.getString(1));
					department_text.setText(Update_combo_add_item_name_DAO.result.getString(3));
					price_text.setText(""+Update_combo_add_item_name_DAO.result.getFloat(4));
				    VAT=Update_combo_add_item_name_DAO.result.getFloat(5);
				    TOTAL_COST=Update_combo_add_item_name_DAO.result.getFloat(6);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			}
		});
		item_name_combo.setBounds(189, 250, 193, 20);
		frame.getContentPane().add(item_name_combo);
		Update_combo_DAO ucd =new Update_combo_DAO();
		if(ucd.authenticate_item()){
		String b[]=new String[Update_combo_DAO.mylist1.size()];
		  b=Update_combo_DAO.mylist1.toArray(b);
		  item_name_combo.setModel(new javax.swing.DefaultComboBoxModel<String>(b));
		}
		JLabel lblSrNo = new JLabel("Sr No :");
		lblSrNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSrNo.setBounds(71, 155, 108, 21);
		frame.getContentPane().add(lblSrNo);
		
		sr_text = new JTextField();
		sr_text.setColumns(10);
		sr_text.setBounds(189, 155, 193, 20);
		frame.getContentPane().add(sr_text);
	}

	}
