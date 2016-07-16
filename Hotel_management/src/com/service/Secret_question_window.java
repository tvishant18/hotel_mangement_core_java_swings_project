package com.service;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.BO.Master_info;
import com.DAO2.Change_password_DAO;
import com.DAO2.Secret_Question_DAO;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Secret_question_window {

	private JFrame frmSecretQuestionWindow;
	private static JTextField username1_text;
	private static JTextField secret_question_text;
	private JTextField secret_answer_text;
	public static Secret_question_window window;
	public static String Username1;
	/**
	 * Launch the application.
	 */
			public void invoke_forgot_password() {
				try {
					window = new Secret_question_window();
					window.frmSecretQuestionWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
public void invoke_secret_question(){
username1_text.setText(Master_login.username1);
String username2=	username1_text.getText();
Master_info info=new Master_info();
info.setUsername(username2);
Secret_Question_DAO sqd=new Secret_Question_DAO();
if(sqd.authenticate_secret_question(info)){
	secret_question_text.setText(Secret_Question_DAO.Question);
}
}
	/**
	 * Create the application.
	 */
	public Secret_question_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSecretQuestionWindow = new JFrame();
		frmSecretQuestionWindow.setTitle("Secret Question Window");
		frmSecretQuestionWindow.setBounds(100, 100, 476, 364);
		frmSecretQuestionWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSecretQuestionWindow.getContentPane().setLayout(null);
		frmSecretQuestionWindow.getContentPane().setBackground(new Color(253, 245, 230));
		
		JLabel lblNewLabel = new JLabel("Username  :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(60, 142, 133, 23);
		frmSecretQuestionWindow.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\git\\hotel_mangement_core_java_swings_project\\Hotel_management\\src\\PICS\\16.jpg"));
		label.setBounds(66, 0, 330, 121);
		frmSecretQuestionWindow.getContentPane().add(label);
		
		JLabel lblYourSecretQuestion = new JLabel("Your Secret Question :");
		lblYourSecretQuestion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblYourSecretQuestion.setBounds(60, 181, 133, 23);
		frmSecretQuestionWindow.getContentPane().add(lblYourSecretQuestion);
		
		JLabel lblSecretAnswer = new JLabel("Secret Answer :");
		lblSecretAnswer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSecretAnswer.setBounds(60, 225, 133, 23);
		frmSecretQuestionWindow.getContentPane().add(lblSecretAnswer);
		
		username1_text = new JTextField();
		username1_text.setBounds(199, 143, 197, 20);
		frmSecretQuestionWindow.getContentPane().add(username1_text);
		username1_text.setColumns(10);
		//username1_text.setText(Master_login.username);
		
		secret_question_text = new JTextField();
		secret_question_text.setColumns(10);
		secret_question_text.setBounds(201, 182, 195, 20);
		frmSecretQuestionWindow.getContentPane().add(secret_question_text);
		
		secret_answer_text = new JTextField();
		secret_answer_text.setColumns(10);
		secret_answer_text.setBounds(201, 226, 195, 20);
		frmSecretQuestionWindow.getContentPane().add(secret_answer_text);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    Username1=username1_text.getText();
			String Secret_question=secret_question_text.getText();
			String Secret_answer=secret_answer_text.getText();
			Master_info info=new Master_info();
			info.setUsername(Username1);
			info.setSecret_question(Secret_question);
			info.setSecret_answer(Secret_answer);
			Change_password_DAO cpd=new Change_password_DAO();
			if(cpd.authenticate_change_password(info)){
				Update_Password_window window1=new Update_Password_window();
				window1.invoke_update_password_window();
				window.frmSecretQuestionWindow.setVisible(false);
			}
			else{
				JOptionPane.showMessageDialog(btnNewButton, "Please Enter valid credentials");
				secret_answer_text.setText("");
			}
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(159, 272, 125, 23);
		frmSecretQuestionWindow.getContentPane().add(btnNewButton);
	}
}
