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

public class DoctorChangePass {
	public String Username;
	public String id;
	
	public JFrame frmDoctorChangePass;
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
					window.frmDoctorChangePass.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public DoctorChangePass(String Username,String id) {
		this.Username=Username;
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmDoctorChangePass = new JFrame();
		frmDoctorChangePass.setTitle("Change Password");
		frmDoctorChangePass.setResizable(false);
		frmDoctorChangePass.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 14));
		frmDoctorChangePass.setBounds(100, 100, 720, 526);
		frmDoctorChangePass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDoctorChangePass.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(146, 0, 568, 497);
		frmDoctorChangePass.getContentPane().add(panel);
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
					  System.out.println(pass1);
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
								frmDoctorChangePass.dispose();
								DoctorPostLogin window=new DoctorPostLogin(Username, id);
								window.frmDoctorPostlogin.setVisible(true);
							  
						  }
						  else
							  JOptionPane.showMessageDialog(null, "New Passwords are not matching or Password cannot be empty","Error Message", JOptionPane.INFORMATION_MESSAGE);
						  
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
		frmDoctorChangePass.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(49, 44, 57, 14);
		panel_1.add(lblNewLabel);
		
		JButton button = new JButton("Generate Reports");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDoctorChangePass.dispose();
				DoctorPostLogin window =new DoctorPostLogin(Username, id);
				window.frmDoctorPostlogin.setVisible(true);
			}
		});
		button.setFocusPainted(false);
		button.setBackground(Color.RED);
		button.setBounds(10, 110, 126, 23);
		panel_1.add(button);
		
		JButton button_1 = new JButton("ChangePassword");
		button_1.setBackground(Color.RED);
		button_1.setBounds(10, 173, 126, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("UpdateDetails");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDoctorChangePass.dispose();
				DoctorUpdate window =new DoctorUpdate(Username,id);
				window.frmDoctorUpdate.setVisible(true);
			}
		});
		button_2.setFocusPainted(false);
		button_2.setBackground(Color.RED);
		button_2.setBounds(10, 237, 126, 23);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("Logout");
		button_3.setFocusPainted(false);
		button_3.setBackground(Color.RED);
		button_3.setBounds(10, 301, 126, 23);
		panel_1.add(button_3);
	}
}
