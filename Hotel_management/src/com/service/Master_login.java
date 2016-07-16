package com.service;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import com.BO.Master_info;
import com.dao.Sign_in_DAO;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Master_login {

	private JFrame frmLoginWindow;
	private static JTextField username_text;
	private JPasswordField password_text;
    public static Master_login window ;
	public static String username1;
    /**
	 * Launch the application.
	 */
	public void invoke_master_login() {
				try {
					window = new Master_login();
					window.frmLoginWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	/**
	 * Create the application.
	 */
	public Master_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginWindow = new JFrame();
		frmLoginWindow.setTitle("Login Window");
		frmLoginWindow.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		frmLoginWindow.setBounds(100, 100, 478, 354);
		frmLoginWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLoginWindow.getContentPane().setLayout(null);
		frmLoginWindow.getContentPane().setBackground(new Color(253, 245, 230));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Desktop\\PICS\\16.jpg"));
		lblNewLabel.setBounds(77, 11, 330, 122);
		frmLoginWindow.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Username :");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(96, 144, 84, 21);
		frmLoginWindow.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Password  :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(96, 183, 84, 21);
		frmLoginWindow.getContentPane().add(label_1);
		
		username_text = new JTextField();
		username_text.setColumns(10);
		username_text.setBounds(185, 144, 184, 20);
		frmLoginWindow.getContentPane().add(username_text);
		
		password_text = new JPasswordField();
		password_text.setBounds(185, 183, 184, 20);
		frmLoginWindow.getContentPane().add(password_text);
		
		JButton sign_in_button = new JButton("Sign In");
		sign_in_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=username_text.getText();
				String password=new String(password_text.getPassword());
			   Master_info info=new Master_info();
			   info.setUsername(username);
			   info.setPassword(password);
			   Sign_in_DAO sid=new Sign_in_DAO();
			try {
				if(sid.authenticate_master(info)){
					Master_window window1=new Master_window();
					window1.invoke_master_window();
				   window.frmLoginWindow.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(sign_in_button, "Please enter a valid password");
					password_text.setText("");
				}
			} catch (SQLException e) {
		        e.printStackTrace();
			}
			}
		});
		sign_in_button.setForeground(Color.BLUE);
		sign_in_button.setFont(new Font("Tahoma", Font.BOLD, 12));
		sign_in_button.setBounds(275, 229, 101, 33);
		frmLoginWindow.getContentPane().add(sign_in_button);
		
		JButton forgot_button = new JButton("Forgot Password ?");
		forgot_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username1=username_text.getText();
				Secret_question_window window1=new Secret_question_window();
				window1.invoke_forgot_password();
				window1.invoke_secret_question();
				window.frmLoginWindow.setVisible(false);
			}
		});
		forgot_button.setForeground(Color.RED);
		forgot_button.setFont(new Font("Tahoma", Font.BOLD, 10));
		forgot_button.setBounds(118, 230, 129, 32);
		frmLoginWindow.getContentPane().add(forgot_button);
	}
}
