package com.service;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class Panel_right_DAO implements Runnable {
	public void run() {
		try {
			for(int i=1;i<=10;i++){
				Home_window2.lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Desktop\\PICS\\"+i+".jpg"));
			
			Thread.sleep(4000);}
			run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
	}
}
public class Home_window2 {

	private JFrame frmHome;
    private static JPanel panel;
    public static JLabel lblNewLabel;
    private static Home_window2 window ;
    /**
	 * Launch the application.
	 */
	
			public void invoke_home2() {
				try {
					 window = new Home_window2();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the application.
	 */
	public Home_window2() {
		initialize();
	    Thread t1=new Thread(new Panel_right_DAO());	
	    t1.setName("thread 1");
	    t1.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setTitle("Home");
		frmHome.setBounds(100, 100, 1233, 772);
		frmHome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmHome.getContentPane().setBackground(new Color(220, 220, 220));
		frmHome.getContentPane().setLayout(null);
		frmHome.getContentPane().setBackground(new Color(210, 105, 30));
		 frmHome.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    panel = new JPanel();
		panel.setBounds(0, 0, 1090, 560);
		frmHome.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(210, 105, 30));
		
		 lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Desktop\\PICS\\1.jpg"));
		lblNewLabel.setBounds(25, 64, 1137, 577);
		panel.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 10));
		menuBar.setBounds(0, 0, 1024, 24);
		panel.add(menuBar);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("KOT");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				KOT_generate_window window1=new KOT_generate_window();
				window1.invoke_kot_window();
				window1.get_kot_no();
				window1.invoke_kot_no();
				
				//window.frame.setVisible(false);
			}
		});
		
		JMenu mnNewMenu = new JMenu("Add table");
		menuBar.add(mnNewMenu);
		mnNewMenu.setForeground(Color.RED);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JMenuItem menuItem_2 = new JMenuItem("Restaurant");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_table_window window1=new Add_table_window();
				window1.invoke_add_table();
			}
		});
		
		menuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_2.setForeground(Color.RED);
		menuItem_2.setFont(new Font("Dialog", Font.BOLD, 13));
		mnNewMenu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Bar");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_table_Bar_window window1=new Add_table_Bar_window();
				window1.invoke_bar_add_table();
			}
		});
		
		menuItem_3.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_3.setForeground(Color.RED);
		menuItem_3.setFont(new Font("Dialog", Font.BOLD, 13));
		mnNewMenu.add(menuItem_3);
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem_1.setForeground(Color.RED);
		
	
		mntmNewMenuItem_1.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmBill = new JMenuItem("Bill");
		mntmBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Generate_bill_window window1=new Generate_bill_window();
				window1.invoke_generate_bill();
				window1.invoke_bill_no();
			}
		});
		mntmBill.setForeground(Color.RED);
		mntmBill.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar.add(mntmBill);
		
		JMenu mnBillHistory = new JMenu("Bill History");
		mnBillHistory.setHorizontalAlignment(SwingConstants.RIGHT);
		mnBillHistory.setForeground(Color.RED);
		mnBillHistory.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnBillHistory);
		
		JMenuItem mntmTodaysBill = new JMenuItem("Today's Bill");
		mntmTodaysBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Today_bill_history_window window1=new Today_bill_history_window();
				window1.invoke_today_history();
			//	window.frmHome.setVisible(false);
				
			}
		});
		mntmTodaysBill.setHorizontalAlignment(SwingConstants.LEFT);
		mntmTodaysBill.setForeground(Color.RED);
		mntmTodaysBill.setFont(new Font("Dialog", Font.BOLD, 13));
		mnBillHistory.add(mntmTodaysBill);
		
		JMenuItem mntmOthers = new JMenuItem("Others");
		mntmOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Other_bill_history_window window1=new Other_bill_history_window();
				window1.invoke_other_bill_history();
			//	window.frmHome.setVisible(false);
			}
		});
		mntmOthers.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOthers.setForeground(Color.RED);
		mntmOthers.setFont(new Font("Dialog", Font.BOLD, 13));
		mnBillHistory.add(mntmOthers);
		
		JMenuItem mntmInfo = new JMenuItem("Info");
		mntmInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Info_window window1=new Info_window();
				window1.invoke_info();
				window1.invoke_jTAble();
			}
		});
		mntmInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmInfo.setForeground(Color.RED);
		mntmInfo.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar.add(mntmInfo);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Master Login");
		mntmNewMenuItem_3.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Master_login window1 = new Master_login();
				window1.invoke_master_login();
				window.frmHome.setVisible(false);
			}
		});
		mntmNewMenuItem_3.setForeground(Color.RED);
		mntmNewMenuItem_3.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar.add(mntmNewMenuItem_3);
		
		JMenu mnSale = new JMenu("SALE");
		mnSale.setHorizontalAlignment(SwingConstants.RIGHT);
		mnSale.setForeground(Color.RED);
		mnSale.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnSale);
		
		JMenuItem mntmTodaysSale = new JMenuItem("Today's Sale");
		mntmTodaysSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Today_sale_application_window window1=new Today_sale_application_window();
				window1.invoke_today_sale();
				window1.invoke_sale();
			}
		});
		mntmTodaysSale.setHorizontalAlignment(SwingConstants.LEFT);
		mntmTodaysSale.setForeground(Color.RED);
		mntmTodaysSale.setFont(new Font("Dialog", Font.BOLD, 13));
		mnSale.add(mntmTodaysSale);
		
		JMenuItem menuItem_5 = new JMenuItem("Others");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Other_sale_window window1=new Other_sale_window();
				window1.invoke_other_sale();
			}
		});
		menuItem_5.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_5.setForeground(Color.RED);
		menuItem_5.setFont(new Font("Dialog", Font.BOLD, 13));
		mnSale.add(menuItem_5);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
			System.exit(0);
			}
		});
		mntmExit.setForeground(Color.RED);
		mntmExit.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar.add(mntmExit);
	}

}
