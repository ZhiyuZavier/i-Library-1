package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Admin_addReceptionist extends javax.swing.JFrame{

	DBConnection db = new DBConnection();
	ResultSet rs = null;
	PreparedStatement pst = null;

	public void windowclosing (WindowEvent arg0){
		frmAddAReceptionist.dispose();
	}
	
	JFrame frmAddAReceptionist;
	private JTextField textField;
	private JTextField UserNameField;
	private JTextField passwordfield;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField TitleField;
	private JTextField phoneNumberField;
	private JTextField emailField;
	private JTextField addressField;
	private JTextField DOBField;
	private JTable tableReceptionistInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_addReceptionist window = new Admin_addReceptionist();
					window.frmAddAReceptionist.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_addReceptionist() {
		initialize();
		Update_table();
	}

	private void Update_table() {
		// TODO Auto-generated method stub
		try {
			db.openConn();
			String sql = "select * from User where userType = 'Receptionist'";
			pst = db.conn.prepareStatement(sql);
			rs = pst.executeQuery();
			tableReceptionistInfo.setModel(DbUtils.resultSetToTableModel(rs));
			db.closeConn();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
	}

	 private boolean isEmail(String text) {

	        String EMAIL_PATTERN = "^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z0-9]{2,3}$";
	        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	        Matcher regexMatcher = pattern.matcher(text);
	        if (!regexMatcher.matches()) {
	            return false;
	        } else {
	            return true;
	        }
	    }
	
	 private boolean isDOB(String text) {

	        String DOB_PATTERN = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
	        Pattern pattern = Pattern.compile(DOB_PATTERN);
	        Matcher regexMatcher = pattern.matcher(text);
	        if (!regexMatcher.matches()) {
	            return false;
	        } else {
	            return true;
	        }
	    }
	 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddAReceptionist = new JFrame();
		frmAddAReceptionist.setTitle("Add a receptionist");
		frmAddAReceptionist.setBounds(100, 100, 1207, 661);
		frmAddAReceptionist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddAReceptionist.getContentPane().setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(77, 101, 127, 14);
		frmAddAReceptionist.getContentPane().add(lblUserId);
		
		textField = new JTextField();
		textField.setBounds(179, 98, 137, 24);
		textField.setText("Auto generated field");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		frmAddAReceptionist.getContentPane().add(textField);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(77, 135, 127, 14);
		frmAddAReceptionist.getContentPane().add(lblUserName);
		
		UserNameField = new JTextField();
		UserNameField.setBounds(179, 132, 137, 24);
		UserNameField.setColumns(10);
		frmAddAReceptionist.getContentPane().add(UserNameField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(77, 174, 127, 14);
		frmAddAReceptionist.getContentPane().add(lblPassword);
		
		passwordfield = new JTextField();
		passwordfield.setBounds(179, 171, 137, 24);
		passwordfield.setColumns(10);
		frmAddAReceptionist.getContentPane().add(passwordfield);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(77, 212, 127, 14);
		frmAddAReceptionist.getContentPane().add(lblFirstName);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(179, 209, 137, 24);
		firstNameField.setColumns(10);
		frmAddAReceptionist.getContentPane().add(firstNameField);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(77, 256, 127, 14);
		frmAddAReceptionist.getContentPane().add(lblLastName);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(179, 253, 137, 24);
		lastNameField.setColumns(10);
		frmAddAReceptionist.getContentPane().add(lastNameField);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(77, 297, 127, 14);
		frmAddAReceptionist.getContentPane().add(lblTitle);
		
		TitleField = new JTextField();
		TitleField.setBounds(179, 294, 137, 24);
		TitleField.setColumns(10);
		frmAddAReceptionist.getContentPane().add(TitleField);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(77, 337, 127, 14);
		frmAddAReceptionist.getContentPane().add(lblPhoneNumber);
		
		phoneNumberField = new JTextField();
		phoneNumberField.setBounds(179, 334, 137, 24);
		phoneNumberField.setColumns(10);
		frmAddAReceptionist.getContentPane().add(phoneNumberField);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(77, 375, 127, 14);
		frmAddAReceptionist.getContentPane().add(lblEmail);
		
		emailField = new JTextField();
		emailField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {

				// TODO Auto-generated method stub
				try {
					while (Integer.parseInt(phoneNumberField.getText()) < 0300000
							|| Integer.parseInt(phoneNumberField.getText()) > 999999999) {
						phoneNumberField.requestFocus();
						JOptionPane.showMessageDialog(null,
								"Please enter a correct phone number including an area code (eg 092728888)");
						break;

					}
				} catch (NumberFormatException e1) {
					phoneNumberField.requestFocus();
					JOptionPane.showMessageDialog(null,
							"Please enter a correct phone number including an area code (eg 092728888)");
				}
			}
		});
		emailField.setBounds(179, 372, 137, 24);
		emailField.setColumns(10);
		frmAddAReceptionist.getContentPane().add(emailField);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(77, 413, 127, 14);
		frmAddAReceptionist.getContentPane().add(lblAddress);
		
		addressField = new JTextField();
		addressField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
		
					while (!isEmail(emailField.getText())) {
						
						emailField.requestFocus();
						JOptionPane.showMessageDialog(null,
								"Please input a non-empty valid email");
						break;

					}
				
			}
		});
		addressField.setBounds(179, 410, 137, 24);
		addressField.setColumns(10);
		frmAddAReceptionist.getContentPane().add(addressField);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(77, 454, 127, 14);
		frmAddAReceptionist.getContentPane().add(lblDateOfBirth);
		
		DOBField = new JTextField();
		DOBField.setBounds(179, 451, 137, 24);
		DOBField.setColumns(10);
		frmAddAReceptionist.getContentPane().add(DOBField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(337, 98, 844, 369);
		frmAddAReceptionist.getContentPane().add(scrollPane);
		
		tableReceptionistInfo = new JTable();
		tableReceptionistInfo.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tableReceptionistInfo);
		
		JLabel lblExistingReceptionistLogins = new JLabel("Existing Receptionist's Logins");
		lblExistingReceptionistLogins.setHorizontalAlignment(SwingConstants.CENTER);
		lblExistingReceptionistLogins.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExistingReceptionistLogins.setBounds(618, 59, 265, 31);
		frmAddAReceptionist.getContentPane().add(lblExistingReceptionistLogins);
		
		JButton btnNewButton = new JButton("Add Receptionist");
		btnNewButton.setBounds(179, 499, 137, 31);
		frmAddAReceptionist.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			
    			if(! isDOB(DOBField.getText())){
    				DOBField.requestFocus();
					JOptionPane.showMessageDialog(null,
							"Please input a date of birth in this format dd/MM/YYYY");
					
    			}
    			else{
    			DBConnection dd = new DBConnection();
    			dd.openConn();
    			
    			try {
    				dd.addNewUser(UserNameField.getText(), passwordfield.getText(), firstNameField.getText(), lastNameField.getText(), TitleField.getText(), phoneNumberField.getText(), "Receptionist", emailField.getText(), addressField.getText(), DOBField.getText());
    			} catch (Exception e) {
    				
    				JOptionPane.showMessageDialog(null, "Please input valid inforamtion in all fields");
    			}
    				
    			
    			JOptionPane.showMessageDialog(null, "New receptionist has been added" );
    			dd.closeConn();
    			Update_table();
    			UserNameField.setText("");
    			passwordfield.setText("");
    			firstNameField.setText("");
    			lastNameField.setText("");
    			TitleField.setText("");
    			phoneNumberField.setText("");
    			emailField.setText("");
    			addressField.setText("");
    			DOBField.setText("");
    			}
    		}
    	});	
    		
		
		JLabel lblEnterNewReceptionist = new JLabel("Enter new receptionist details");
		lblEnterNewReceptionist.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterNewReceptionist.setBounds(151, 59, 197, 24);
		frmAddAReceptionist.getContentPane().add(lblEnterNewReceptionist);
		
		JButton btnBackToMain = new JButton("Back to Main menu");
		btnBackToMain.setBounds(34, 22, 150, 23);
		frmAddAReceptionist.getContentPane().add(btnBackToMain);
		
btnBackToMain.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				windowclosing(null);
				
				AdiminGUI window2 = new AdiminGUI();
				window2.setVisible(true);
				
				

			}
		});
	}
}
