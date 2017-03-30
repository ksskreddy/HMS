package HMS;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
public class DoctorRegPage {
	public String Username;
	public String id1;
	public JFrame frmRegPage;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField UserName;
	private JTextField Age;
	private JTextField PhoneNo;
	private JPasswordField password;
	private JPasswordField Confirmpassword;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorRegPage window = new DoctorRegPage();
					window.frmRegPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public DoctorRegPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegPage = new JFrame();
		frmRegPage.setTitle("Doctor Registeration Page");
		frmRegPage.setResizable(false);
		frmRegPage.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 14));
		frmRegPage.setBounds(100, 100, 720, 526);
		frmRegPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(146, 0, 568, 497);
		frmRegPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRegisterationForm = new JLabel("Doctor Registeration Form");
		lblRegisterationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterationForm.setFont(new Font("Verdana", Font.BOLD, 14));
		lblRegisterationForm.setBounds(119, 11, 262, 28);
		panel.add(lblRegisterationForm);
		
		JLabel lblNewLabel_1 = new JLabel("FirstName:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(95, 63, 90, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblLastname = new JLabel("LastName:");
		lblLastname.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastname.setBounds(95, 100, 90, 14);
		panel.add(lblLastname);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(95, 141, 90, 14);
		panel.add(lblUsername);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAge.setBounds(95, 180, 90, 14);
		panel.add(lblAge);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSex.setBounds(95, 218, 90, 14);
		panel.add(lblSex);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMale.setBounds(225, 215, 90, 23);
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnFemale.setBounds(339, 215, 90, 23);
		panel.add(rdbtnFemale);
		
		
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);
		
		
		JLabel lblAddress = new JLabel("Qualifications:");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(95, 262, 90, 14);
		panel.add(lblAddress);
		
		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhoneNo.setBounds(95, 305, 90, 14);
		panel.add(lblPhoneNo);
		
		
		
		JTextArea Qualifications = new JTextArea();
		Qualifications.setBorder(new LineBorder(new Color(0, 0, 0)));
		Qualifications.setBounds(249, 245, 172, 46);
		panel.add(Qualifications);
		
		JButton DocRegister = new JButton("Register");
		DocRegister.setBorder(new LineBorder(new Color(0, 0, 0)));
		DocRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int flag=0,flag1=0;
				if(Arrays.equals(password.getPassword(), Confirmpassword.getPassword()))
					flag=1;
				else
				{
					JOptionPane.showMessageDialog(null, "Password Fields are not matching","Error Message", JOptionPane.INFORMATION_MESSAGE);
				}
				
				if((!new String(password.getPassword()).equals(""))&&(!UserName.getText().equals(""))&&(!Qualifications.getText().equals(""))&&(!PhoneNo.getText().equals(""))&&(!Age.getText().equals(""))&&(!FirstName.getText().equals(""))&&(!LastName.getText().equals("")))
				  flag1=1;
				else
				{
					JOptionPane.showMessageDialog(null, "No Field can be Empty","Error Message", JOptionPane.INFORMATION_MESSAGE);
				}
				String sel="";
				int flag2=1;
				if(rdbtnMale.isSelected())
					 sel="Male";
				else if(rdbtnFemale.isSelected())
					sel="Female";
					
				if(sel.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Sex field cannot be empty","Error Message", JOptionPane.INFORMATION_MESSAGE);
					flag2=0;
				}

				int flag3=1;
				String regex = "\\d+";
				if(!PhoneNo.getText().matches(regex)||(PhoneNo.getText().length()!=10)||(!Age.getText().matches(regex)))
				{
					flag3=0;
					JOptionPane.showMessageDialog(null, "Not valid Phone Number or Age","Error Message", JOptionPane.INFORMATION_MESSAGE);
					
				}
				if(flag==1&&flag1==1&&flag2==1&&flag3==1)
				{
					int id=0;
					try
					{
					Scanner scanner = new Scanner(new File("src/Res/ID.txt"));
					id=scanner.nextInt();
					scanner.close();
					}
					catch(Exception fnf)
					{
						JOptionPane.showMessageDialog(null, "Error Generating Id","Error Message", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
					HashMap<String, String> map = new HashMap<String, String>();
					map.put(lblNewLabel_1.getText(),FirstName.getText());
					map.put(lblLastname.getText(),LastName.getText());
					map.put(lblUsername.getText(),UserName.getText());
					map.put(lblAddress.getText(),Qualifications.getText());
					map.put(lblPhoneNo.getText(),PhoneNo.getText());
					map.put(lblAge.getText(),Age.getText());
					
					map.put(lblSex.getText(),sel);
					char[] pass = password.getPassword();
					  String pass1=new String(pass); 
					  map.put("Password:",pass1);
					map.put("Id", new Integer(id).toString());
					id++;
					try
					{
					FileWriter fw=new FileWriter("src/Res/ID.txt");
					PrintWriter pw=new PrintWriter(fw);
					pw.print(id);
					pw.close();
					}
					catch(Exception fnf)
					{
						JOptionPane.showMessageDialog(null, "Error Generating Id","Error Message", JOptionPane.INFORMATION_MESSAGE);
					}
					String msg="Your generated Id is:"+(--id);
					JOptionPane.showMessageDialog(null, msg,"Info Message", JOptionPane.INFORMATION_MESSAGE);
					
					String filename="src/Res/"+UserName.getText()+"_"+(id)+".txt";
					Properties properties = new Properties();
					properties.putAll(map);
					try
					{
					properties.store(new FileOutputStream(filename), null);
					}
					catch(Exception ex)
					{
					}
					
					frmRegPage.dispose();
					DoctorPostLogin window =new DoctorPostLogin(Username,id1);
					window.frmDoctorPostlogin.setVisible(true);
				}
				
				
				
			}
		});
		DocRegister.setBounds(110, 437, 89, 23);
		panel.add(DocRegister);
		
		JButton DocReset = new JButton("Reset");
		DocReset.setBorder(new LineBorder(new Color(0, 0, 0)));
		DocReset.setBorder(new LineBorder(new Color(0, 0, 0)));
		DocReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstName.setText("");
				LastName.setText("");
				UserName.setText("");
				Age.setText("");
				Qualifications.setText("");
				PhoneNo.setText("");
				password.setText("");
				Confirmpassword.setText("");
				bg.clearSelection();
				
				
			}
		});
		DocReset.setBounds(339, 437, 89, 23);
		panel.add(DocReset);
		
		FirstName = new JTextField();
		FirstName.setHorizontalAlignment(SwingConstants.CENTER);
		FirstName.setBorder(new LineBorder(new Color(0, 0, 0)));
		FirstName.setBounds(249, 61, 172, 20);
		panel.add(FirstName);
		FirstName.setColumns(10);
		
		LastName = new JTextField();
		LastName.setHorizontalAlignment(SwingConstants.CENTER);
		LastName.setBorder(new LineBorder(new Color(0, 0, 0)));
		LastName.setColumns(10);
		LastName.setBounds(249, 98, 172, 20);
		panel.add(LastName);
		
		UserName = new JTextField();
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		UserName.setBorder(new LineBorder(new Color(0, 0, 0)));
		UserName.setColumns(10);
		UserName.setBounds(249, 139, 172, 20);
		panel.add(UserName);
		
		Age = new JTextField();
		Age.setHorizontalAlignment(SwingConstants.CENTER);
		Age.setBorder(new LineBorder(new Color(0, 0, 0)));
		Age.setColumns(10);
		Age.setBounds(249, 178, 172, 20);
		panel.add(Age);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(95, 345, 90, 14);
		panel.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConfirmPassword.setBounds(81, 382, 104, 14);
		panel.add(lblConfirmPassword);
		
		
		
		PhoneNo = new JTextField();
		PhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNo.setBorder(new LineBorder(new Color(0, 0, 0)));
		PhoneNo.setColumns(10);
		PhoneNo.setBounds(249, 303, 172, 20);
		panel.add(PhoneNo);
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setBorder(new LineBorder(new Color(0, 0, 0)));
		password.setBounds(249, 341, 172, 18);
		panel.add(password);
		
		Confirmpassword = new JPasswordField();
		Confirmpassword.setHorizontalAlignment(SwingConstants.CENTER);
		Confirmpassword.setBorder(new LineBorder(new Color(0, 0, 0)));
		Confirmpassword.setBounds(249, 380, 172, 18);
		panel.add(Confirmpassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 146, 497);
		frmRegPage.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(49, 44, 57, 14);
		panel_1.add(lblNewLabel);
		
		JButton DocRegisteration = new JButton("Registeration");
		DocRegisteration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegPage.dispose();
				MainPage window = new MainPage();
				window.frmMainPage.setVisible(true);
			}
		});
		DocRegisteration.setFocusPainted(false);
		DocRegisteration.setBackground(new Color(255, 0, 0));
		DocRegisteration.setBounds(10, 126, 126, 23);
		panel_1.add(DocRegisteration);
		
		JButton DocLogin = new JButton("Login");
		DocLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegPage.dispose();
				LoginPage window = new LoginPage();
				window.frmLoginpage.setVisible(true);
			}
		});
		DocLogin.setBackground(new Color(255, 0, 0));
		DocLogin.setBounds(10, 323, 126, 23);
		panel_1.add(DocLogin);
	}
}
