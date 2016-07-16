package com.main;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.service.Home_window2;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Welcome {

	private JFrame frmWelcome;
	public static Welcome window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Welcome();
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome ");
		frmWelcome.getContentPane().setForeground(Color.WHITE);
		frmWelcome.setBounds(100, 100, 1272, 735);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		 frmWelcome.getContentPane().setBackground(new Color(210, 105, 30));
		 frmWelcome.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 1236, 685);
		frmWelcome.getContentPane().add(panel);
		panel.setLayout(null);
        panel.setBackground(new Color(210, 105, 30));		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home_window2 window1=new Home_window2();
				window1.invoke_home2();
				window.frmWelcome.setVisible(false);
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Desktop\\PICS\\14.jpg"));
		lblNewLabel.setBounds(0, 0, 442, 275);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("New label");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home_window2 window1=new Home_window2();
				window1.invoke_home2();
				window.frmWelcome.setVisible(false);
			
			}
		});
		label_1.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Desktop\\PICS\\3.jpg"));
		label_1.setBounds(438, 0, 808, 275);
		panel.add(label_1);
		
		JLabel label = new JLabel("New label");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home_window2 window1=new Home_window2();
				window1.invoke_home2();
				window.frmWelcome.setVisible(false);
			
			
			}
		});
		label.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Desktop\\PICS\\2.jpg"));
		label.setBounds(721, 278, 515, 407);
		panel.add(label);
		
		JLabel label_2 = new JLabel("New label");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home_window2 window1=new Home_window2();
				window1.invoke_home2();
				window.frmWelcome.setVisible(false);
			
			}
		});
		label_2.setIcon(new ImageIcon("C:\\Users\\vishant thakur\\Desktop\\PICS\\8.jpg"));
		label_2.setBounds(0, 278, 725, 411);
		panel.add(label_2);
	}
}
