package ui;

import java.awt.EventQueue;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ImageIcon;



import javax.swing.JTextField;

import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

public class Admin_purchaseReport extends javax.swing.JFrame {

	public void windowclosing (WindowEvent arg0){
		frmPurchasedBooksReport.dispose();
	}
	
	JFrame frmPurchasedBooksReport;
	private JTable TablePurchasereport;
	DBConnection db = new DBConnection();
	ResultSet rs = null;
	PreparedStatement pst = null;
	private JTextField textField;
	private JButton btnReport;
	String date;
	
	JDateChooser dateChooser = new JDateChooser();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_purchaseReport window = new Admin_purchaseReport();
					window.frmPurchasedBooksReport.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	/**
	 * Create the application.
	 */
	public Admin_purchaseReport() {
		initialize();
                this.setLocationRelativeTo(null);
	}


	private void Update_table(String date1, String date2) {
		try {
			db.openConn();
			String sql = "select * from Book where purchasedDate between + '"+date1+"' and '"+date2+"'";
			pst = db.conn.prepareStatement(sql);
			rs = pst.executeQuery();
			TablePurchasereport.setModel(DbUtils.resultSetToTableModel(rs));
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
		frmPurchasedBooksReport = new JFrame();
		frmPurchasedBooksReport.setTitle("Purchased books report");
		frmPurchasedBooksReport.setBounds(100, 100, 1150, 599);
		frmPurchasedBooksReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPurchasedBooksReport.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 76, 1044, 362);
		frmPurchasedBooksReport.getContentPane().add(scrollPane);
		
		TablePurchasereport = new JTable();
		TablePurchasereport.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		
		
		
		scrollPane.setViewportView(TablePurchasereport);
		
		JLabel lblPurchasedBooksReport = new JLabel("Purchased books Report");
		lblPurchasedBooksReport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPurchasedBooksReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurchasedBooksReport.setBounds(453, 21, 193, 33);
		frmPurchasedBooksReport.getContentPane().add(lblPurchasedBooksReport);
		
		final JDateChooser jDateChooser1 = new JDateChooser();
		jDateChooser1.setDateFormatString("yyyy-MM-dd");
		jDateChooser1.setBounds(77, 483, 110, 20);
		frmPurchasedBooksReport.getContentPane().add(jDateChooser1);
		
		btnReport = new JButton("Generate report");
		btnReport.setBounds(360, 480, 193, 23);
		frmPurchasedBooksReport.getContentPane().add(btnReport);
		
		final JDateChooser jDateChooser2 = new JDateChooser();
		jDateChooser2.setDateFormatString("yyyy-MM-dd");
		jDateChooser2.setBounds(226, 483, 110, 20);
		frmPurchasedBooksReport.getContentPane().add(jDateChooser2);
		
		JButton btnBackToMain = new JButton("Back to Main menu");
		btnBackToMain.setBounds(37, 21, 150, 23);
		frmPurchasedBooksReport.getContentPane().add(btnBackToMain);
		
btnBackToMain.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				windowclosing(null);
				
//				AdiminGUI window2 = new AdiminGUI();
//				window2.setVisible(true);
				
				

			}
		});
		
		btnReport.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			
    			try {
    	    		String date1 = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
    	    		String date2 = ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();
    	    		Update_table(date1, date2);
    			} catch (Exception e) {
    				// TODO: handle exception
    				JOptionPane.showMessageDialog(null, "Saved");
    			
    			//date = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
    			
    			}}});
	}
}
