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
import javax.swing.JTextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorPostLogin {
	public int Reportno=1;
	public String Username;
	public String id;
	
	public JFrame frmDoctorPostlogin;
	private JTextField ReportNumber;
	private JTextField Date;
	private JTextField Id;
	private JTextField Name;
	private JTextField Written_by;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceipRegPage window = new ReceipRegPage();
					window.frmDoctorPostlogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public DoctorPostLogin(String Username,String id) {
		this.Username=Username;
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmDoctorPostlogin = new JFrame();
		frmDoctorPostlogin.setTitle("Generate Bills");
		frmDoctorPostlogin.setResizable(false);
		frmDoctorPostlogin.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 14));
		frmDoctorPostlogin.setBounds(100, 100, 720, 526);
		frmDoctorPostlogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDoctorPostlogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(146, 0, 568, 497);
		frmDoctorPostlogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		
			
		JLabel lblRegisterationForm = new JLabel("Generation of Reports");
		lblRegisterationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterationForm.setFont(new Font("Verdana", Font.BOLD, 14));
		lblRegisterationForm.setBounds(119, 11, 302, 28);
		panel.add(lblRegisterationForm);
		
		JLabel lblReportNo = new JLabel("Report No");
		lblReportNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReportNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportNo.setBounds(26, 69, 57, 14);
		panel.add(lblReportNo);
		
		
		
		
		ReportNumber = new JTextField();
		ReportNumber.setHorizontalAlignment(SwingConstants.CENTER);
		ReportNumber.setEditable(false);
		ReportNumber.setBounds(105, 67, 130, 20);
		panel.add(ReportNumber);
		ReportNumber.setColumns(10);
		 
		try
		{
		Scanner scanner = new Scanner(new File("src/Reports/Report.txt"));
		Reportno=scanner.nextInt();
		scanner.close();
		}
		catch(Exception fnf)
		{
		}
		ReportNumber.setText(""+Reportno);
		Reportno++;
		
		
		
		
		
		JLabel lblDate = new JLabel("Date ");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBounds(283, 70, 90, 14);
		panel.add(lblDate);
		
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Date dateobj = new Date();
		
		Date = new JTextField();
		Date.setHorizontalAlignment(SwingConstants.CENTER);
		Date.setEditable(false);
		Date.setColumns(10);
		Date.setBounds(365, 67, 138, 20);
		Date.setText((df.format(dateobj)));
		panel.add(Date);
		
		JLabel lblPatientId = new JLabel("PatientId*");
		lblPatientId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPatientId.setBounds(10, 121, 90, 14);
		panel.add(lblPatientId);
		
		Id = new JTextField();
		Id.setHorizontalAlignment(SwingConstants.CENTER);
		Id.setColumns(10);
		Id.setBounds(105, 119, 130, 20);
		panel.add(Id);
		
		JLabel lblPatientname = new JLabel("PatientName*");
		lblPatientname.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPatientname.setBounds(272, 121, 83, 14);
		panel.add(lblPatientname);
		
		Name = new JTextField();
		Name.setFocusCycleRoot(true);
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setColumns(10);
		Name.setBounds(365, 121, 138, 20);
		panel.add(Name);
		
		JLabel lblTestDetailsifAny = new JLabel("DiagonsisDetails");
		lblTestDetailsifAny.setHorizontalAlignment(SwingConstants.CENTER);
		lblTestDetailsifAny.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTestDetailsifAny.setBounds(26, 185, 108, 14);
		panel.add(lblTestDetailsifAny);
		
		JTextArea Test = new JTextArea();
		Test.setBorder(new LineBorder(new Color(0, 0, 0)));
		Test.setFont(new Font("Verdana", Font.PLAIN, 12));
		Test.setBounds(167, 161, 336, 80);
		panel.add(Test);
		
		JTextArea Medical = new JTextArea();
		Medical.setBorder(new LineBorder(new Color(0, 0, 0)));
		Medical.setFont(new Font("Verdana", Font.PLAIN, 12));
		Medical.setBounds(167, 272, 336, 80);
		panel.add(Medical);
		
		JLabel lblMedicalDetailsifAny = new JLabel("MedicalDetails");
		lblMedicalDetailsifAny.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicalDetailsifAny.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMedicalDetailsifAny.setBounds(10, 306, 135, 14);
		panel.add(lblMedicalDetailsifAny);
		
		JLabel lblReportWrittenBy = new JLabel("ReportWrittenBy");
		lblReportWrittenBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportWrittenBy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReportWrittenBy.setBounds(127, 400, 130, 14);
		panel.add(lblReportWrittenBy);
		
		Written_by = new JTextField();
		Written_by.setEditable(false);
		Written_by.setHorizontalAlignment(SwingConstants.CENTER);
		Written_by.setColumns(10);
		Written_by.setText(Username);
		Written_by.setBounds(291, 398, 130, 20);
		
		panel.add(Written_by);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int flag=0;
				if((!Id.getText().equals(""))&&(!Name.getText().equals("")))
					flag=1;
				else
				{
					JOptionPane.showMessageDialog(null, "Please fill all the star fields","Error Message", JOptionPane.INFORMATION_MESSAGE);
				}
				int flag2=1;
				
				String regex = "\\d+";
				if(!Id.getText().matches(regex))
				{
					flag2=0;
					JOptionPane.showMessageDialog(null, "PatientId is not valid","Error Message", JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(flag==1&&flag2==1)
				{	
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(lblReportNo.getText(),ReportNumber.getText());
				map.put(lblDate.getText(),Date.getText());
				map.put(lblPatientId.getText(),Id.getText());
				map.put(lblPatientname.getText(),Name.getText());
				map.put(lblMedicalDetailsifAny.getText(),Medical.getText());
				map.put(lblTestDetailsifAny.getText(),Test.getText());
				map.put(lblReportWrittenBy.getText(),Written_by.getText());
				
				
				String filename="src/Reports/Reportno_"+(Reportno-1)+".txt";
				Properties properties = new Properties();
				properties.putAll(map);
				try
				{
				properties.store(new FileOutputStream(filename,true), null);
				}
				catch(Exception ex)
				{
				}
				
				try
				{
				FileWriter fw=new FileWriter(filename,true);
				fw.write("===============================================================\n");
				fw.close();
				}
				catch(Exception ex)
				{
					
				}
				
				
				
				
				
				
				
				
				try
				{
				 FileWriter fw=new FileWriter("src/Reports/Report.txt");
				PrintWriter pw=new PrintWriter(fw);
				pw.print(Reportno);
				pw.close();
				}
				catch(Exception fnf)
				{
				}
				
				JOptionPane.showMessageDialog(null, "Report created Successfully in Reports folder","Success Message", JOptionPane.PLAIN_MESSAGE);
				
				frmDoctorPostlogin.dispose();
				DoctorPostLogin window=new DoctorPostLogin(Username,id);
				window.frmDoctorPostlogin.setVisible(true);
			}
			
			}
		});
		btnPrint.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnPrint.setBounds(105, 450, 89, 23);
		panel.add(btnPrint);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Medical.setText("");
				Test.setText("");
				Name.setText("");
				Id.setText("");
			}
		});
		btnReset.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnReset.setBounds(332, 450, 89, 23);
		panel.add(btnReset);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 146, 497);
		frmDoctorPostlogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(49, 44, 57, 14);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("UpdateDetails");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDoctorPostlogin.dispose();
				DoctorUpdate window=new DoctorUpdate(Username, id);
				window.frmDoctorUpdate.setVisible(true);
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(10, 251, 126, 23);
		panel_1.add(btnNewButton);
		
		JButton btnGenerateBills = new JButton("Generate Reports");
		btnGenerateBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerateBills.setFocusPainted(false);
		btnGenerateBills.setBackground(Color.RED);
		btnGenerateBills.setBounds(10, 124, 126, 23);
		panel_1.add(btnGenerateBills);
		
		JButton btnChangepassword = new JButton("ChangePassword");
		btnChangepassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDoctorPostlogin.dispose();
				DoctorChangePass window =new DoctorChangePass(Username, id);
				window.frmDoctorChangePass.setVisible(true);
			}
		});
		btnChangepassword.setBackground(Color.RED);
		btnChangepassword.setBounds(10, 187, 126, 23);
		panel_1.add(btnChangepassword);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				frmDoctorPostlogin.dispose();
				MainPage window =new MainPage();
				window.frmMainPage.setVisible(true);
			}
		});
		btnLogout.setFocusPainted(false);
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(10, 315, 126, 23);
		panel_1.add(btnLogout);
	}
}
