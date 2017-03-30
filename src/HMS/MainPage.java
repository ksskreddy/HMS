package HMS;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
public class MainPage {

	public JFrame frmMainPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frmMainPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainPage = new JFrame();
		frmMainPage.setTitle("Main Page");
		frmMainPage.setResizable(false);
		frmMainPage.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 14));
		frmMainPage.setBounds(100, 100, 720, 526);
		frmMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(146, 0, 568, 497);
		frmMainPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnDoctor = new JButton("Doctor");
		btnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frmMainPage.dispose();
			DoctorRegPage window = new DoctorRegPage();
			window.frmRegPage.setVisible(true);
			}
		});
		btnDoctor.setBounds(269, 248, 134, 23);
		panel.add(btnDoctor);
		
		JButton btnReceiptionist = new JButton("Receiptionist");
		btnReceiptionist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frmMainPage.dispose();
			ReceipRegPage window = new ReceipRegPage();
			window.frmRecepPage.setVisible(true);
			}
		});

		btnReceiptionist.setBounds(269, 334, 134, 23);
		panel.add(btnReceiptionist);
		
		JLabel lblRegisterAs = new JLabel("Register As");
		lblRegisterAs.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterAs.setFont(new Font("Verdana", Font.BOLD, 14));
		lblRegisterAs.setBounds(269, 164, 118, 34);
		panel.add(lblRegisterAs);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/HMS/RegistrationIcon.gif")));
		lblNewLabel_1.setBounds(10, 11, 238, 203);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 146, 497);
		frmMainPage.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(49, 44, 57, 14);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Registeration");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(10, 126, 126, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainPage.dispose();
				LoginPage window = new LoginPage();
				window.frmLoginpage.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(10, 323, 126, 23);
		panel_1.add(btnNewButton_1);
	}
}

