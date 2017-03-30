package HMS;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.*;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class ReceipUpdate {
	private String pass1;
	public String Username;
	public String id;
	public JFrame frmReceipUpdate;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField UserName;
	private JTextField Age;
	private JTextField PhoneNo;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceipUpdate window = new ReceipUpdate();
					window.frmReceipUpdate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ReceipUpdate(String Username,String id) {
		this.Username=Username;
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReceipUpdate = new JFrame();
		frmReceipUpdate.setTitle("Update Details");
		frmReceipUpdate.setResizable(false);
		frmReceipUpdate.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 14));
		frmReceipUpdate.setBounds(100, 100, 720, 526);
		frmReceipUpdate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReceipUpdate.getContentPane().setLayout(null);
		
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
		
		pass1=ldapContent.get("Password:");
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(146, 0, 568, 497);
		frmReceipUpdate.getContentPane().add(panel);
		panel.setLayout(null);
		ButtonGroup bg=new ButtonGroup();
		JTextArea RecepAddress = new JTextArea();
		RecepAddress.setText(ldapContent.get("Address:"));
		
			
		JLabel lblRegisterationForm = new JLabel("Receiptionist Registeration Form");
		lblRegisterationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterationForm.setFont(new Font("Verdana", Font.BOLD, 14));
		lblRegisterationForm.setBounds(119, 11, 302, 28);
		panel.add(lblRegisterationForm);
		
		JLabel lblFirst = new JLabel("FirstName:");
		lblFirst.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirst.setBounds(95, 63, 90, 14);
		panel.add(lblFirst);
		
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
		lblSex.setBounds(95, 236, 90, 14);
		panel.add(lblSex);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		String sex= ldapContent.get(lblSex.getText());
		if(sex.equals("Male"))
			rdbtnMale.setSelected(true);
		rdbtnMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMale.setBounds(226, 233, 90, 23);
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		if(sex.equals("Female"))
			rdbtnFemale.setSelected(true);
		rdbtnFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnFemale.setBounds(331, 233, 90, 23);
		panel.add(rdbtnFemale);
		
		
		
		
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);
		
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(95, 297, 90, 14);
		panel.add(lblAddress);
		
		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhoneNo.setBounds(95, 375, 90, 14);
		panel.add(lblPhoneNo);
		
		
		
		RecepAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		RecepAddress.setBounds(249, 281, 172, 46);
		panel.add(RecepAddress);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int flag1=0;
				
				if((!UserName.getText().equals(""))&&(!RecepAddress.getText().equals(""))&&(!PhoneNo.getText().equals(""))&&(!Age.getText().equals(""))&&(!FirstName.getText().equals(""))&&(!LastName.getText().equals("")))
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
					JOptionPane.showMessageDialog(null, "Not valid Phone Number and Age","Error Message", JOptionPane.INFORMATION_MESSAGE);
					
				}
				if(flag1==1&&flag2==1&&flag3==1)
				{
					
					
					HashMap<String, String> map = new HashMap<String, String>();
					map.put(lblFirst.getText(),FirstName.getText());
					map.put(lblLastname.getText(),LastName.getText());
					map.put(lblUsername.getText(),UserName.getText());
					map.put(lblAddress.getText(),RecepAddress.getText());
					map.put(lblPhoneNo.getText(),PhoneNo.getText());
					map.put(lblAge.getText(),Age.getText());
					
					map.put(lblSex.getText(),sel); 
					  map.put("Password:",pass1);
					
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
					
					frmReceipUpdate.dispose();
					ReceipPostLogin window =new ReceipPostLogin(Username,id);
					window.frmReceiptionistPostlogin.setVisible(true);
				}
			    				
			}
		});
		btnNewButton_2.setBounds(110, 437, 89, 23);
		panel.add(btnNewButton_2);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstName.setText("");
				LastName.setText("");
				UserName.setText("");
				Age.setText("");
				RecepAddress.setText("");
				PhoneNo.setText("");
				bg.clearSelection();
				
				
			}
		});
		btnReset.setBounds(339, 437, 89, 23);
		panel.add(btnReset);
		
		FirstName = new JTextField();
		FirstName.setText(ldapContent.get(lblFirst.getText()));
		FirstName.setHorizontalAlignment(SwingConstants.CENTER);
		FirstName.setBorder(new LineBorder(new Color(0, 0, 0)));
		FirstName.setBounds(249, 61, 172, 20);
		panel.add(FirstName);
		FirstName.setColumns(10);
		
		LastName = new JTextField();
		LastName.setHorizontalAlignment(SwingConstants.CENTER);
		LastName.setText(ldapContent.get(lblLastname.getText()));
		LastName.setBorder(new LineBorder(new Color(0, 0, 0)));
		LastName.setColumns(10);
		LastName.setBounds(249, 98, 172, 20);
		panel.add(LastName);
		
		UserName = new JTextField();
		UserName.setEditable(false);
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		UserName.setBorder(new LineBorder(new Color(0, 0, 0)));
		UserName.setText(ldapContent.get(lblUsername.getText()));
		UserName.setColumns(10);
		UserName.setBounds(249, 139, 172, 20);
		panel.add(UserName);
		
		Age = new JTextField();
		Age.setText(ldapContent.get(lblAge.getText()));
		Age.setHorizontalAlignment(SwingConstants.CENTER);
		Age.setBorder(new LineBorder(new Color(0, 0, 0)));
		Age.setColumns(10);
		Age.setBounds(249, 178, 172, 20);
		panel.add(Age);
		
		
		
		PhoneNo = new JTextField();
		PhoneNo.setText(ldapContent.get(lblPhoneNo.getText()));
		PhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNo.setBorder(new LineBorder(new Color(0, 0, 0)));
		PhoneNo.setColumns(10);
		PhoneNo.setBounds(249, 373, 172, 20);
		panel.add(PhoneNo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 146, 497);
		frmReceipUpdate.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(49, 44, 57, 14);
		panel_1.add(lblNewLabel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				frmReceipUpdate.dispose();
				MainPage window =new MainPage();
				window.frmMainPage.setVisible(true);
			}
		});
		btnLogout.setFocusPainted(false);
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(10, 317, 126, 23);
		panel_1.add(btnLogout);
		
		JButton button_1 = new JButton("UpdateDetails");
		button_1.setFocusPainted(false);
		button_1.setBackground(Color.RED);
		button_1.setBounds(10, 256, 126, 23);
		panel_1.add(button_1);
		
		JButton btnChangepassword = new JButton("ChangePassword");
		btnChangepassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmReceipUpdate.dispose();
				ReceipChangePass window =new ReceipChangePass(Username, id);
				window.frmReceipChangePass.setVisible(true);
			}
		});
		btnChangepassword.setBackground(Color.RED);
		btnChangepassword.setBounds(10, 194, 126, 23);
		panel_1.add(btnChangepassword);
		
		JButton btnGenerateBills = new JButton("Generate Bills");
		btnGenerateBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmReceipUpdate.dispose();
				ReceipPostLogin window=new ReceipPostLogin(Username,id);
				window.frmReceiptionistPostlogin.setVisible(true);
			}
		});
		btnGenerateBills.setFocusPainted(false);
		btnGenerateBills.setBackground(Color.RED);
		btnGenerateBills.setBounds(10, 130, 126, 23);
		panel_1.add(btnGenerateBills);
	}
}
