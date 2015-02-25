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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Receptionist_addCustomer extends javax.swing.JFrame{

	DBConnection db = new DBConnection();
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	public void windowclosing (WindowEvent arg0){
		frmAddACustomer.dispose();
	}
	
	JFrame frmAddACustomer;
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
					Receptionist_addCustomer window = new Receptionist_addCustomer();
					window.frmAddACustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Receptionist_addCustomer() {
		initialize();                
                Update_table();
	}

	private void Update_table() {
		// TODO Auto-generated method stub
		try {
			db.openConn();
			String sql = "select * from User where userType = 'cus'";
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
		frmAddACustomer = new JFrame();
		frmAddACustomer.setTitle("Add a customer");
		frmAddACustomer.setBounds(100, 100, 1207, 661);
		frmAddACustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddACustomer.getContentPane().setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(77, 101, 127, 14);
		frmAddACustomer.getContentPane().add(lblUserId);
		
		textField = new JTextField();
		textField.setBounds(179, 98, 137, 23);
		textField.setText("Auto generated field");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		frmAddACustomer.getContentPane().add(textField);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(77, 135, 127, 14);
		frmAddACustomer.getContentPane().add(lblUserName);
		
		UserNameField = new JTextField();
		UserNameField.setBounds(179, 132, 137, 20);
		UserNameField.setColumns(10);
		frmAddACustomer.getContentPane().add(UserNameField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(77, 174, 127, 14);
		frmAddACustomer.getContentPane().add(lblPassword);
		
		passwordfield = new JTextField();
		passwordfield.setBounds(179, 171, 137, 20);
		passwordfield.setColumns(10);
		frmAddACustomer.getContentPane().add(passwordfield);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(77, 212, 127, 14);
		frmAddACustomer.getContentPane().add(lblFirstName);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(179, 209, 137, 20);
		firstNameField.setColumns(10);
		frmAddACustomer.getContentPane().add(firstNameField);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(77, 256, 127, 14);
		frmAddACustomer.getContentPane().add(lblLastName);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(179, 253, 137, 20);
		lastNameField.setColumns(10);
		frmAddACustomer.getContentPane().add(lastNameField);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(77, 297, 127, 14);
		frmAddACustomer.getContentPane().add(lblTitle);
		
		TitleField = new JTextField();
		TitleField.setBounds(179, 294, 137, 20);
		TitleField.setColumns(10);
		frmAddACustomer.getContentPane().add(TitleField);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(77, 337, 127, 14);
		frmAddACustomer.getContentPane().add(lblPhoneNumber);
		
		phoneNumberField = new JTextField();
		phoneNumberField.setBounds(179, 334, 137, 20);
		phoneNumberField.setColumns(10);
		frmAddACustomer.getContentPane().add(phoneNumberField);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(77, 375, 127, 14);
		frmAddACustomer.getContentPane().add(lblEmail);
		
		emailField = new JTextField();
		emailField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
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
		emailField.setBounds(179, 372, 137, 20);
		emailField.setColumns(10);
		frmAddACustomer.getContentPane().add(emailField);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(77, 413, 127, 14);
		frmAddACustomer.getContentPane().add(lblAddress);
		
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
		addressField.setBounds(179, 410, 137, 20);
		addressField.setColumns(10);
		frmAddACustomer.getContentPane().add(addressField);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(77, 454, 127, 14);
		frmAddACustomer.getContentPane().add(lblDateOfBirth);
		
		DOBField = new JTextField();
		DOBField.setBounds(179, 451, 137, 20);
		DOBField.setColumns(10);
		frmAddACustomer.getContentPane().add(DOBField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(337, 98, 844, 432);
		frmAddACustomer.getContentPane().add(scrollPane);
		
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
		
		JLabel lblExistingReceptionistLogins = new JLabel("Existing Customer's Logins");
		lblExistingReceptionistLogins.setHorizontalAlignment(SwingConstants.CENTER);
		lblExistingReceptionistLogins.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExistingReceptionistLogins.setBounds(618, 59, 265, 31);
		frmAddACustomer.getContentPane().add(lblExistingReceptionistLogins);
		
		JButton btnNewButton = new JButton("Add Customer");
		btnNewButton.setBounds(179, 499, 137, 31);
		frmAddACustomer.getContentPane().add(btnNewButton);
		
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
    				dd.addNewUser(UserNameField.getText(), passwordfield.getText(), firstNameField.getText(), lastNameField.getText(), TitleField.getText(), phoneNumberField.getText(), "cus", emailField.getText(), addressField.getText(), DOBField.getText());
    			} catch (Exception e) {
    				
    				JOptionPane.showMessageDialog(null, "Please input valid inforamtion in all fields");
    			}
    				
    			
    			JOptionPane.showMessageDialog(null, "New customer has been added" );
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
    		
		
		JLabel lblEnterNewReceptionist = new JLabel("Enter new customer's details");
		lblEnterNewReceptionist.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterNewReceptionist.setBounds(129, 59, 231, 24);
		frmAddACustomer.getContentPane().add(lblEnterNewReceptionist);
		
		JButton btnBackToMain = new JButton("Back to Main menu");
		btnBackToMain.setBounds(33, 28, 150, 23);
		frmAddACustomer.getContentPane().add(btnBackToMain);
		
btnBackToMain.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				windowclosing(null);
				
				ReceptionistGUI window2 = new ReceptionistGUI();
				window2.setVisible(true);
				
				

			}
		});
	}
}
