package com.service;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.BO.Master_info;
import com.DAO2.Update_password_DAO;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update_Password_window {

	private JFrame frmUpdatePasswordWindow;
	public static Update_Password_window window ;
	private JTextField username3_text;
	private JPasswordField new_password_text;
	private JPasswordField new_password1_text;
	/**
	 * Launch the application.
	 */
			public void invoke_update_password_window() {
				try {
					window = new Update_Password_window();
					window.frmUpdatePasswordWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public Update_Password_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdatePasswordWindow = new JFrame();
		frmUpdatePasswordWindow.setTitle("Update Password Window");
		frmUpdatePasswordWindow.setBounds(100, 100, 450, 386);
		frmUpdatePasswordWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUpdatePasswordWindow.getContentPane().setLayout(null);
		frmUpdatePasswordWindow.getContentPane().setBackground(new Color(253, 245, 230));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\git\\hotel_mangement_core_java_swings_project\\Hotel_management\\src\\PICS\\16.jpg"));
		label.setBounds(57, 0, 330, 121);
		frmUpdatePasswordWindow.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Username  :");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(70, 149, 133, 23);
		frmUpdatePasswordWindow.getContentPane().add(label_1);
		
		username3_text = new JTextField();
		username3_text.setColumns(10);
		username3_text.setBounds(189, 151, 197, 20);
		frmUpdatePasswordWindow.getContentPane().add(username3_text);
		username3_text.setText(Secret_question_window.Username1);
		
		JLabel lblNewPassword = new JLabel("New Password :");
		lblNewPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewPassword.setBounds(70, 197, 133, 23);
		frmUpdatePasswordWindow.getContentPane().add(lblNewPassword);
		
		JLabel lblRetypePassword = new JLabel("ReType Password :");
		lblRetypePassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRetypePassword.setBounds(70, 241, 133, 23);
		frmUpdatePasswordWindow.getContentPane().add(lblRetypePassword);
		
		new_password_text = new JPasswordField();
		new_password_text.setBounds(189, 199, 197, 20);
		frmUpdatePasswordWindow.getContentPane().add(new_password_text);
		
		new_password1_text = new JPasswordField();
		new_password1_text.setBounds(189, 243, 197, 20);
		frmUpdatePasswordWindow.getContentPane().add(new_password1_text);
		
		JButton change_password_button = new JButton("Change Password");
		change_password_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String Username3=username3_text.getText();
			String New_password=new String(new_password_text.getPassword());
			String Retype_password=new String(new_password1_text.getPassword());
			Master_info info1= new Master_info();
			info1.setUsername(Username3);
			info1.setNew_password(New_password);
			info1.setRetype_password(Retype_password);
			Update_password_DAO upd=new Update_password_DAO();
			if(upd.authenticate_password(info1)){
				JOptionPane.showMessageDialog(change_password_button, "New Password is updated successfully");
				Master_window window1=new Master_window();
				window1.invoke_master_window();
				window.frmUpdatePasswordWindow.setVisible(false);
			}
			else{
				JOptionPane.showMessageDialog(change_password_button, "Both Password fields should be same");
				new_password_text.setText("");
				new_password1_text.setText("");
			}
			}
		});
		change_password_button.setForeground(Color.RED);
		change_password_button.setFont(new Font("Tahoma", Font.BOLD, 13));
		change_password_button.setBounds(150, 295, 162, 23);
		frmUpdatePasswordWindow.getContentPane().add(change_password_button);
	}
}
