package control;

import java.util.ArrayList;

public class Receipt {
	private int receiptID;
	private String issueDate;
	private ArrayList<Record> records;

	public Receipt(int receiptID, String issueDate) {
		super();
		this.receiptID = receiptID;
		this.issueDate  =issueDate;
		this.records = records;
		// TODO Auto-generated constructor stub
	}

	public int getReceiptID() {
		return receiptID;
	}

	public void setReceiptID(int receiptID) {
		this.receiptID = receiptID;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public ArrayList<Record> getRecords() {
		return records;
	}

	public void setRecords(ArrayList<Record> records) {
		this.records = records;
	}

	public void printReceipt(){
	
	}
	
	public void creatReceipt(ArrayList<Record> records){
		
		
	}
}
