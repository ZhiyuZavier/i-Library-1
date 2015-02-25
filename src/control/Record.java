/**
 * @Author
 * @Date Sep 12, 2014
 * @Purpose
 * @Version
 */
package control;

/**
 * @author usr
 *
 */
public class Record {
	private int uID;
	private int bookID;
	private int recordID;
	private String borrowDate;
	private String expiryDate;
	private String returnDate;
	
	public Record(int uID, int bookID, int recordID, String borrowDate,
			String expiryDate, String returnDate) {
		super();
		this.uID = uID;
		this.bookID = bookID;
		this.recordID = recordID;
		this.borrowDate = borrowDate;
		this.expiryDate = expiryDate;
		this.returnDate = returnDate;
	}
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public int getRecordID() {
		return recordID;
	}
	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}
	public String getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	public void updateBookStatus(){
		
	}
	


}
