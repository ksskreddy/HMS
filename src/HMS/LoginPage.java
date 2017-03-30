package HMS;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LoginPage {

	public JFrame frmLoginpage;
	private JTextField UserName;
	private JPasswordField password;
	private JTextField Id;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frmLoginpage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginpage = new JFrame();
		frmLoginpage.setTitle("LoginPage");
		frmLoginpage.setResizable(false);
		frmLoginpage.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 14));
		frmLoginpage.setBounds(100, 100, 720, 526);
		frmLoginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginpage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(UIManager.getColor("InternalFrame.resizeIconHighlight"));
		panel.setBounds(146, 0, 568, 497);
		frmLoginpage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginForm.setFont(new Font("Verdana", Font.BOLD, 14));
		lblLoginForm.setBounds(293, 42, 156, 28);
		panel.add(lblLoginForm);
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Receiptionist", "Doctor"}));
		comboBox.setMaximumRowCount(2);
		comboBox.setBounds(371, 104, 172, 20);
		panel.add(comboBox);
		
		JLabel lblUsername = new JLabel("UserName  :");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(243, 160, 90, 14);
		panel.add(lblUsername);
		
		JButton btnNewButton_2 = new JButton("Login");
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name,id;
				Name=UserName.getText();
				id=Id.getText();
				String filename="src/Res/"+Name+"_"+id+".txt";
				HashMap<String, String> ldapContent = new HashMap<String, String>();
				File f=new File(filename);
				if(!f.exists())
					JOptionPane.showMessageDialog(null,"Wrong UserName/UserId","Error Message", JOptionPane.INFORMATION_MESSAGE);
				else
				{
					
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
					
					char[] pass = password.getPassword();
					  String pass1=new String(pass); 
					  if(pass1.equals(ldapContent.get("Password:")))
					  {
						  
						 
						  if(comboBox.getSelectedItem().equals("Receiptionist"))
						  {
							  if(ldapContent.containsKey("Address:"))
							  {
								  frmLoginpage.dispose();
								  ReceipPostLogin window =new ReceipPostLogin(Name,id);
								  window.frmReceiptionistPostlogin.setVisible(true);
							  }
							  else 
							  {
								  JOptionPane.showMessageDialog(null,"You are not Receiptionist","Error Message", JOptionPane.INFORMATION_MESSAGE);
							  }
						  }
						  else
						  {
							  if(ldapContent.containsKey("Qualifications:"))
							  {
								  frmLoginpage.dispose();
								  DoctorPostLogin window =new DoctorPostLogin(Name,id);
								  window.frmDoctorPostlogin.setVisible(true);
							  }
							  else 
							  {
								  JOptionPane.showMessageDialog(null,"You are not Doctor","Error Message", JOptionPane.INFORMATION_MESSAGE);
							  }
						  }
					  }
					  else
					  {
						 
						  JOptionPane.showMessageDialog(null,"Wrong Password","Error Message", JOptionPane.INFORMATION_MESSAGE);
					  }
						  
							  
						  
					
					
				}
			
			}
			
		});
		btnNewButton_2.setBounds(351, 308, 89, 23);
		panel.add(btnNewButton_2);
		
		UserName = new JTextField();
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		UserName.setBorder(new LineBorder(new Color(0, 0, 0)));
		UserName.setColumns(10);
		UserName.setBounds(371, 158, 172, 20);
		panel.add(UserName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(243, 256, 90, 14);
		panel.add(lblPassword);
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setBorder(new LineBorder(new Color(0, 0, 0)));
		password.setBounds(371, 255, 172, 18);
		panel.add(password);
		
		JLabel lblUserid = new JLabel("UserId  :");
		lblUserid.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUserid.setBounds(243, 210, 90, 14);
		panel.add(lblUserid);
		
		Id = new JTextField();
		Id.setHorizontalAlignment(SwingConstants.CENTER);
		Id.setBorder(new LineBorder(new Color(0, 0, 0)));
		Id.setColumns(10);
		Id.setBounds(371, 208, 172, 20);
		panel.add(Id);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/HMS/LoginIcon.jpg")));
		label.setBounds(10, 83, 204, 189);
		panel.add(label);
		
		JLabel lblAccounttype = new JLabel("AccountType :");
		lblAccounttype.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccounttype.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccounttype.setBounds(243, 106, 90, 14);
		panel.add(lblAccounttype);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 146, 497);
		frmLoginpage.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Verdana", Font.BOLD, 14));
		lblMenu.setBounds(36, 47, 57, 14);
		panel_1.add(lblMenu);
		
		JButton UserRegistration = new JButton("Registeration");
		UserRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginpage.dispose();
				MainPage window = new MainPage();
				window.frmMainPage.setVisible(true);
			}
		});
		UserRegistration.setFocusPainted(false);
		UserRegistration.setBackground(new Color(255, 0, 0));
		UserRegistration.setBounds(10, 126, 126, 23);
		panel_1.add(UserRegistration);
		
		JButton UserLogin = new JButton("Login");
		UserLogin.setBackground(new Color(255, 0, 0));
		UserLogin.setBounds(10, 323, 126, 23);
		panel_1.add(UserLogin);
	}
}

