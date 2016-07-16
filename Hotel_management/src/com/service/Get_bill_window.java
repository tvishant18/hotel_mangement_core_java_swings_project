package com.service;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.util.Map;
import java.util.Vector;
import javax.swing.JTextField;
import com.BO.Bill_info;
import com.dao.Bill_Amount_DAO;
import com.dao.Generate_bill_DAO;
import com.dao.Get_Bill_DAO;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Get_bill_window {

	private JFrame frmGenerateBillWindow;
    public static Get_bill_window window;
    private static JTextField table_no_text;
    private static JTextField discount_text;
    private static JTable table;
    private static JTextField price_after_discount_text;
    private static JTextField ser_text;
    private static JTextField total_price_text;
    private static JTextField stamount_text;
	/**
	 * Launch the application.
	 */
	
			public void invoke_get_bill() {
				try {
					window = new Get_bill_window();
					window.frmGenerateBillWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
			@SuppressWarnings("rawtypes")
			public void invoke_getbill_table(){
				int table_no=(Integer)Generate_bill_window.table_no_combo.getSelectedItem();
			    int discount=(Integer)Generate_bill_window.discount_combo.getSelectedItem();
			    float service_tax=Bill_info.Service_TAX;
			    
			    table_no_text.setText(""+table_no);
			    ser_text.setText(""+service_tax);
			    discount_text.setText(""+discount);
			    
			    Bill_info info=new Bill_info();
			    info.setTable_no(table_no);
			    info.setDiscount(discount);
			    info.setService_tax(service_tax);
			    
			    
			    Get_Bill_DAO gbd=new Get_Bill_DAO();
			    Map<String,Vector> map1=gbd.authenticate_jtable(info);
				Vector header_info=null;
				Vector set_data1=null;
				if(map1 !=null){
					header_info=(Vector)map1.get("header_set1");
					set_data1=(Vector)map1.get("dataset1");
					if(header_info.size()>0 && set_data1.size() >0){
					table.setModel(new javax.swing.table.DefaultTableModel(set_data1,header_info));
				
					}
				}
				Bill_Amount_DAO bad=new Bill_Amount_DAO();			
				if(bad.authenticate_cost(info)){
					total_price_text.setText(""+Bill_Amount_DAO.TOTAL_AMOUNT);
					price_after_discount_text.setText(""+Bill_Amount_DAO.Amount_AFTER_DISCOUNT);	
					stamount_text.setText(""+Bill_Amount_DAO.EXTRA);
				}
			}
			/**
	 * Create the application.
	 */
	public Get_bill_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGenerateBillWindow = new JFrame();
		frmGenerateBillWindow.setTitle("Generate Bill Window");
		frmGenerateBillWindow.setBounds(100, 100, 655, 559);
		frmGenerateBillWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGenerateBillWindow.getContentPane().setBackground(new Color(238, 232, 170));
		frmGenerateBillWindow.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 57, 573, 309);
		frmGenerateBillWindow.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblTableNo = new JLabel("Table No :");
		lblTableNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTableNo.setBounds(32, 11, 116, 25);
		frmGenerateBillWindow.getContentPane().add(lblTableNo);
		
		table_no_text = new JTextField();
		table_no_text.setColumns(10);
		table_no_text.setBounds(133, 14, 121, 20);
		frmGenerateBillWindow.getContentPane().add(table_no_text);
		
		JLabel lblDiscount = new JLabel("Discount (%):");
		lblDiscount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiscount.setBounds(369, 11, 116, 25);
		frmGenerateBillWindow.getContentPane().add(lblDiscount);
		
		discount_text = new JTextField();
		discount_text.setColumns(10);
		discount_text.setBounds(470, 14, 135, 20);
		frmGenerateBillWindow.getContentPane().add(discount_text);
		
		JLabel lblPriceAfterDiscount = new JLabel("Price After Discount");
		lblPriceAfterDiscount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPriceAfterDiscount.setBounds(330, 377, 135, 25);
		frmGenerateBillWindow.getContentPane().add(lblPriceAfterDiscount);
		
		price_after_discount_text = new JTextField();
		price_after_discount_text.setColumns(10);
		price_after_discount_text.setBounds(470, 380, 135, 20);
		frmGenerateBillWindow.getContentPane().add(price_after_discount_text);
		
		JLabel lblServTax = new JLabel("S. TAX(%)");
		lblServTax.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblServTax.setBounds(31, 380, 78, 25);
		frmGenerateBillWindow.getContentPane().add(lblServTax);
		
		ser_text = new JTextField();
		ser_text.setColumns(10);
		ser_text.setBounds(133, 383, 135, 20);
		frmGenerateBillWindow.getContentPane().add(ser_text);
		
		JLabel lblTotalPrice = new JLabel("Total Price(VAT+ST)");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalPrice.setBounds(330, 426, 135, 25);
		frmGenerateBillWindow.getContentPane().add(lblTotalPrice);
		
		total_price_text = new JTextField();
		total_price_text.setColumns(10);
		total_price_text.setBounds(470, 429, 135, 20);
		frmGenerateBillWindow.getContentPane().add(total_price_text);
		
		JButton generate_bill_button = new JButton("Generate Bill");
		generate_bill_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int bill_no=Integer.parseInt(Generate_bill_window.bill_no_text.getText());
				int table_no=(Integer)Generate_bill_window.table_no_combo.getSelectedItem();
			    String department=Generate_bill_window.department_text.getText();
			    String guest_name=Generate_bill_window.guest_name_text.getText();
			    int pax=Integer.parseInt(Generate_bill_window.pax_text.getText());
			    int steward_id=Integer.parseInt(Generate_bill_window.steward_id_text.getText());
			    String steward_name=Generate_bill_window.steward_name_text.getText();
			    String date=Generate_bill_window.date_text.getText();
			    String time=Generate_bill_window.time_text.getText();
			    int discount=(Integer)Generate_bill_window.discount_combo.getSelectedItem();
			    float service_tax=Bill_info.Service_TAX;
			    float amount_after_discount=Float.parseFloat(price_after_discount_text.getText());
			    float total_price=Float.parseFloat(total_price_text.getText());
			    Bill_info info=new Bill_info();
			    info.setBill_no(bill_no);
			    info.setTable_no(table_no);
			    info.setDepartment(department);
			    info.setGuest_name(guest_name);
			    info.setPax(pax);
			    info.setSteward_id(steward_id);
			    info.setSteward_name(steward_name);
			    info.setDate(date);
			    info.setTime(time);
			    info.setDiscount(discount);
			    info.setService_tax(service_tax);
			    info.setPrice_After_discount(amount_after_discount);
			    info.setTotal_price(total_price);
			    Generate_bill_DAO gbd=new Generate_bill_DAO();
			    if(gbd.authenticate_new_bill(info)){
			    	if(gbd.authenticate_new_table(info)){
			    		if(gbd.authenticate_kot(info)){
			    			JOptionPane.showMessageDialog(generate_bill_button, "Bill is generated with Bill no= "+info.getBill_no());
			    			window.frmGenerateBillWindow.setVisible(false);
			    		}
			    	}
			    }
			}
		});
		generate_bill_button.setFont(new Font("Tahoma", Font.BOLD, 16));
		generate_bill_button.setForeground(Color.RED);
		generate_bill_button.setBounds(255, 484, 150, 23);
		frmGenerateBillWindow.getContentPane().add(generate_bill_button);
		
		stamount_text = new JTextField();
		stamount_text.setColumns(10);
		stamount_text.setBounds(133, 427, 135, 20);
		frmGenerateBillWindow.getContentPane().add(stamount_text);
		
		JLabel lblStvatrs = new JLabel("S.T+VAT(Rs)");
		lblStvatrs.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStvatrs.setBounds(31, 424, 78, 25);
		frmGenerateBillWindow.getContentPane().add(lblStvatrs);
	}
}
