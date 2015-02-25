package ui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.InputMismatchException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;

import java.awt.Font;

public class Admin_purchaseBook extends javax.swing.JFrame {

	/**
	 * 
	 */

	DBConnection db = new DBConnection();
	ResultSet rs = null;
	PreparedStatement pst = null;

	public void windowclosing (WindowEvent arg0){
		frmPurchaseABook.dispose();
	}
	

	JFrame frmPurchaseABook;
	private JTable table_BookInfo;
	private JLabel label;
	private JTextField BookPriceTextField;
	private JLabel label_1;
	private JTextField SerialNumberTextField;
	private JLabel label_2;
	private JTextField YearPublishedTextField;
	private JLabel label_3;
	private JTextField BookTitleTextField;
	private JLabel label_4;
	private JTextField PublisherTextField;
	private JLabel label_5;
	private JTextField DescriptionTextField;
	private JLabel label_6;
	private JTextField CategoryTextField;
	private JLabel label_7;
	private JTextField AuthorTextField;
	private JLabel label_8;
	private JTextField ShopNameTextField;
	private JTextField txtAutoGeneratedField;
	private JScrollPane scrollPane_1;
	private JButton btnBackToMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Admin_purchaseBook window = new Admin_purchaseBook();
					window.frmPurchaseABook.setVisible(true);                                        
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_purchaseBook() {
		initialize();
                this.setLocationRelativeTo(null);
		Update_table();
	}

	private void Update_table() {
		try {
			db.openConn();
			String sql = "select * from Book";
			pst = db.conn.prepareStatement(sql);
			rs = pst.executeQuery();
			table_BookInfo.setModel(DbUtils.resultSetToTableModel(rs));
			db.closeConn();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPurchaseABook = new JFrame();
		frmPurchaseABook.setTitle("Purchase a Book");
		frmPurchaseABook.setBounds(100, 100, 1451, 648);
		frmPurchaseABook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPurchaseABook.getContentPane().setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(343, 104, 1082, 411);
		frmPurchaseABook.getContentPane().add(scrollPane_1);

		table_BookInfo = new JTable();
		table_BookInfo.setFont(new Font("Tahoma", Font.BOLD, 9));
		table_BookInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_BookInfo.setSurrendersFocusOnKeystroke(true);
		scrollPane_1.setViewportView(table_BookInfo);
		table_BookInfo.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_BookInfo.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_BookInfo.getColumnModel().getColumn(0).setMinWidth(5);
		table_BookInfo.getColumnModel().getColumn(0).setMaxWidth(30);
		table_BookInfo.getColumnModel().getColumn(1).setMinWidth(5);
		table_BookInfo.getColumnModel().getColumn(2).setMinWidth(5);
		table_BookInfo.getColumnModel().getColumn(3).setMinWidth(5);
		table_BookInfo.getColumnModel().getColumn(4).setMinWidth(5);
		table_BookInfo.getColumnModel().getColumn(5).setMinWidth(5);
		table_BookInfo.getColumnModel().getColumn(6).setMinWidth(5);
		table_BookInfo.getColumnModel().getColumn(7).setMinWidth(5);
		table_BookInfo.getColumnModel().getColumn(8).setMinWidth(5);
		table_BookInfo.getColumnModel().getColumn(9).setMinWidth(5);
		table_BookInfo.getColumnModel().getColumn(10).setMinWidth(5);
		table_BookInfo.getColumnModel().getColumn(11).setMinWidth(5);

		label = new JLabel("Book Price");
		label.setBounds(57, 145, 127, 14);
		frmPurchaseABook.getContentPane().add(label);

		BookPriceTextField = new JTextField();
		BookPriceTextField.setBounds(182, 142, 137, 24);
		BookPriceTextField.setColumns(10);
		frmPurchaseABook.getContentPane().add(BookPriceTextField);
		BookPriceTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

		});

		label_1 = new JLabel("Serial Number");
		label_1.setBounds(57, 184, 127, 14);
		frmPurchaseABook.getContentPane().add(label_1);

		SerialNumberTextField = new JTextField();
		SerialNumberTextField.setBounds(182, 181, 137, 24);
		SerialNumberTextField.setColumns(10);
		frmPurchaseABook.getContentPane().add(SerialNumberTextField);

		SerialNumberTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				try {
					while (Double.parseDouble(BookPriceTextField.getText()) < 1
							|| Double.parseDouble(BookPriceTextField.getText()) > 1000) {
						BookPriceTextField.requestFocus();
						JOptionPane.showMessageDialog(null,
								"Please enter a correct price ($1-$1000)");
						break;

					}
				} catch (NumberFormatException e1) {
					BookPriceTextField.requestFocus();
					JOptionPane.showMessageDialog(null,
							"Please enter a correct price ($1-$1000)");
				}
			}

		});

		label_2 = new JLabel("Year published");
		label_2.setBounds(57, 222, 127, 14);
		frmPurchaseABook.getContentPane().add(label_2);

		YearPublishedTextField = new JTextField();
		YearPublishedTextField.setBounds(182, 220, 137, 24);
		YearPublishedTextField.setColumns(10);
		frmPurchaseABook.getContentPane().add(YearPublishedTextField);

		YearPublishedTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				try {
					while (Long.parseLong(SerialNumberTextField.getText()) < 1) {
						SerialNumberTextField.requestFocus();
						JOptionPane.showMessageDialog(null,
								"Please enter a correct serial number");

						break;

					}
				} catch (NumberFormatException e1) {
					SerialNumberTextField.requestFocus();
					JOptionPane.showMessageDialog(null,
							"Please enter a correct serial number");
				}
			}

		});

		label_3 = new JLabel("Book Title");
		label_3.setBounds(57, 266, 127, 14);
		frmPurchaseABook.getContentPane().add(label_3);

		BookTitleTextField = new JTextField();
		BookTitleTextField.setBounds(182, 260, 137, 24);
		BookTitleTextField.setColumns(10);
		frmPurchaseABook.getContentPane().add(BookTitleTextField);

		BookTitleTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				try {
					while (Integer.parseInt(YearPublishedTextField.getText()) < 1800
							|| Integer.parseInt(YearPublishedTextField
									.getText()) > 2015) {
						YearPublishedTextField.requestFocus();
						JOptionPane.showMessageDialog(null,
								"Please enter a correct published year");

						break;

					}
				} catch (NumberFormatException e1) {
					YearPublishedTextField.requestFocus();
					JOptionPane.showMessageDialog(null,
							"Please enter a correct published year");
				}
			}

		});

		label_4 = new JLabel("Publisher");
		label_4.setBounds(57, 307, 127, 14);
		frmPurchaseABook.getContentPane().add(label_4);

		PublisherTextField = new JTextField();
		PublisherTextField.setBounds(182, 302, 137, 24);
		PublisherTextField.setColumns(10);
		frmPurchaseABook.getContentPane().add(PublisherTextField);

		label_5 = new JLabel("Description");
		label_5.setBounds(57, 347, 127, 14);
		frmPurchaseABook.getContentPane().add(label_5);

		DescriptionTextField = new JTextField();
		DescriptionTextField.setBounds(182, 342, 137, 24);
		DescriptionTextField.setColumns(10);
		frmPurchaseABook.getContentPane().add(DescriptionTextField);

		label_6 = new JLabel("Category");
		label_6.setBounds(57, 385, 127, 14);
		frmPurchaseABook.getContentPane().add(label_6);

		CategoryTextField = new JTextField();
		CategoryTextField.setBounds(182, 381, 137, 24);
		CategoryTextField.setColumns(10);
		frmPurchaseABook.getContentPane().add(CategoryTextField);

		label_7 = new JLabel("Author");
		label_7.setBounds(57, 423, 127, 14);
		frmPurchaseABook.getContentPane().add(label_7);

		AuthorTextField = new JTextField();
		AuthorTextField.setBounds(182, 420, 137, 24);
		AuthorTextField.setColumns(10);
		frmPurchaseABook.getContentPane().add(AuthorTextField);

		label_8 = new JLabel("Shop Name");
		label_8.setBounds(57, 464, 127, 14);
		frmPurchaseABook.getContentPane().add(label_8);

		ShopNameTextField = new JTextField();
		ShopNameTextField.setBounds(182, 461, 137, 24);
		ShopNameTextField.setColumns(10);
		frmPurchaseABook.getContentPane().add(ShopNameTextField);

		JButton AddBookButton = new JButton("Add Book");
		AddBookButton.setBounds(182, 519, 137, 33);
		frmPurchaseABook.getContentPane().add(AddBookButton);

		AddBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				db.openConn();
				try {
					db.addBook(
							Double.parseDouble(BookPriceTextField.getText()),
							"Available",
							Long.parseLong(SerialNumberTextField.getText()),
							Integer.parseInt(YearPublishedTextField.getText()),
							BookTitleTextField.getText(),
							PublisherTextField.getText(),
							DescriptionTextField.getText(),
							CategoryTextField.getText(),
							AuthorTextField.getText(),
							ShopNameTextField.getText());
				} catch (Exception e) {

					JOptionPane.showMessageDialog(null,
							"Please input valid inforamtion in all fields");
				}

				JOptionPane.showMessageDialog(
						null,
						"Below book has been added "
								+ " Price $"
								+ BookPriceTextField.getText()
								+ "  Serial Number  "
								+ Integer.parseInt(SerialNumberTextField
										.getText()));
				db.closeConn();
				Update_table();
				BookPriceTextField.setText("");
				SerialNumberTextField.setText("");
				YearPublishedTextField.setText("");
				BookTitleTextField.setText("");
				PublisherTextField.setText("");
				DescriptionTextField.setText("");
				CategoryTextField.setText("");
				AuthorTextField.setText("");
				ShopNameTextField.setText("");

			}
		});

		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(57, 111, 127, 14);
		frmPurchaseABook.getContentPane().add(lblBookId);

		txtAutoGeneratedField = new JTextField();
		txtAutoGeneratedField.setBounds(182, 104, 137, 24);
		txtAutoGeneratedField.setHorizontalAlignment(SwingConstants.CENTER);
		txtAutoGeneratedField.setEditable(false);
		txtAutoGeneratedField.setEnabled(false);
		txtAutoGeneratedField.setText("Auto generated field");
		txtAutoGeneratedField.setColumns(10);
		frmPurchaseABook.getContentPane().add(txtAutoGeneratedField);

		JLabel lblEnterNewBook = new JLabel("Enter new book details");
		lblEnterNewBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterNewBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterNewBook.setBounds(164, 56, 169, 33);
		frmPurchaseABook.getContentPane().add(lblEnterNewBook);

		btnBackToMain = new JButton("Back to Main menu");
		btnBackToMain.setBounds(34, 22, 150, 23);
		frmPurchaseABook.getContentPane().add(btnBackToMain);
		
		JLabel lblExistingBooks = new JLabel("Existing books");
		lblExistingBooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExistingBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblExistingBooks.setBounds(784, 56, 185, 25);
		frmPurchaseABook.getContentPane().add(lblExistingBooks);

		btnBackToMain.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				windowclosing(null);
				
				AdiminGUI window2 = new AdiminGUI();
				window2.setVisible(true);
				
				

			}
		});

	}
}
