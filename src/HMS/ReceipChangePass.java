package HMS;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.*;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ReceipChangePass {
	public String Username;
	public String id;
	
	public JFrame frmReceipChangePass;
	private JPasswordField old;
	private JPasswordField new_pass;
	private JPasswordField confirm_new;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceipRegPage window = new ReceipRegPage();
					window.frmReceipChangePass.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ReceipChangePass(String Username,String id) {
		this.Username=Username;
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmReceipChangePass = new JFrame();
		frmReceipChangePass.setTitle("Change Password");
		frmReceipChangePass.setResizable(false);
		frmReceipChangePass.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 14));
		frmReceipChangePass.setBounds(100, 100, 720, 526);
		frmReceipChangePass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReceipChangePass.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(146, 0, 568, 497);
		frmReceipChangePass.getContentPane().add(panel);
		panel.setLayout(null);
		
		
			
		JLabel lblRegisterationForm = new JLabel("Change Password");
		lblRegisterationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterationForm.setFont(new Font("Verdana", Font.BOLD, 14));
		lblRegisterationForm.setBounds(119, 11, 302, 28);
		panel.add(lblRegisterationForm);
		
		
		
		JLabel lblOld = new JLabel("Old Password ");
		lblOld.setHorizontalAlignment(SwingConstants.CENTER);
		lblOld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOld.setBounds(168, 90, 90, 14);
		panel.add(lblOld);
		
		JLabel lblNewPassword = new JLabel("New Password ");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewPassword.setBounds(168, 150, 90, 14);
		panel.add(lblNewPassword);
		
		JLabel lblConfirm = new JLabel("Confirm New Password ");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConfirm.setBounds(123, 205, 135, 14);
		panel.add(lblConfirm);
		
		old = new JPasswordField();
		old.setHorizontalAlignment(SwingConstants.CENTER);
		old.setBounds(288, 88, 169, 20);
		panel.add(old);
		
		new_pass = new JPasswordField();
		new_pass.setHorizontalAlignment(SwingConstants.CENTER);
		new_pass.setBounds(288, 148, 169, 20);
		panel.add(new_pass);
		
		confirm_new = new JPasswordField();
		confirm_new.setHorizontalAlignment(SwingConstants.CENTER);
		confirm_new.setBounds(288, 203, 169, 20);
		panel.add(confirm_new);
		
		JButton btnChangePassword = new JButton("Confirm Changes");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String filename="src/Res/"+Username+"_"+id+".txt";
				HashMap<String, String> ldapContent = new HashMap<String, String>();
				Properties properties = new Properties();
				try
				{
					properties.load(new FileInputStream(filename));
				}
				catch(Exception ioe)
				{
				}
				for (String key : properties.stringPropertyNames()) {
					 ldapContent.put(key, properties.get(key).toString());
				}
					
					char[] pass = old.getPassword();
					  String pass1=new String(pass); 
					  if(pass1.equals(ldapContent.get("Password:")))
					  {
						  char[] new1=new_pass.getPassword();
						  char[] new2=confirm_new.getPassword();
						  String new12=new String(new1);
						  String new21=new String(new2);
						  if(new12.equals(new21)&&(!new12.equals("")))
						  {
							  ldapContent.put("Password:",new12);
							  
								
								properties.putAll(ldapContent);
								try
								{
								properties.store(new FileOutputStream(filename), null);
								}
								catch(Exception ex)
								{
									
								}
								JOptionPane.showMessageDialog(null, "Password Changed Succesfully","Success Message", JOptionPane.DEFAULT_OPTION);
								frmReceipChangePass.dispose();
								ReceipPostLogin window=new ReceipPostLogin(Username, id);
								window.frmReceiptionistPostlogin.setVisible(true);
							  
						  }
						  else
							  JOptionPane.showMessageDialog(null, "New Passwords are not matching or password field cannot be empty","Error Message", JOptionPane.INFORMATION_MESSAGE);
						  
					  }
					  else
					  {
						  JOptionPane.showMessageDialog(null, "Old Password is wrong","Error Message", JOptionPane.INFORMATION_MESSAGE);
					  }
				
				
			}
		});
		btnChangePassword.setBounds(232, 261, 142, 23);
		panel.add(btnChangePassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 146, 497);
		frmReceipChangePass.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(49, 44, 57, 14);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("UpdateDetails");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmReceipChangePass.dispose();
				ReceipUpdate window=new ReceipUpdate(Username,id);
				window.frmReceipUpdate.setVisible(true);
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(10, 255, 126, 23);
		panel_1.add(btnNewButton);
		
		JButton btnGenerateBills = new JButton("Generate Bills");
		btnGenerateBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmReceipChangePass.dispose();
				ReceipPostLogin window=new ReceipPostLogin(Username,id);
				window.frmReceiptionistPostlogin.setVisible(true);
			}
		});
		btnGenerateBills.setFocusPainted(false);
		btnGenerateBills.setBackground(Color.RED);
		btnGenerateBills.setBounds(10, 132, 126, 23);
		panel_1.add(btnGenerateBills);
		
		JButton btnChangepassword = new JButton("ChangePassword");
		btnChangepassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmReceipChangePass.dispose();
				ReceipPostLogin window =new ReceipPostLogin(Username, id);
				window.frmReceiptionistPostlogin.setVisible(true);
			}
		});
		
		btnChangepassword.setBackground(Color.RED);
		btnChangepassword.setBounds(10, 194, 126, 23);
		panel_1.add(btnChangepassword);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				frmReceipChangePass.dispose();
				MainPage window =new MainPage();
				window.frmMainPage.setVisible(true);
			}
		});
		btnLogout.setFocusPainted(false);
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(10, 316, 126, 23);
		panel_1.add(btnLogout);
	}
}
