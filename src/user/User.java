/**
 * 
 */
package user;

/**
 * @author usr
 *
 */
public abstract class User {

	private int userID;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String title;
	private String phoneNum;
	private String email;
	private String address;
	private String doB;
	
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




	public int getUserID() {
		return userID;
	}






	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getPhoneNum() {
		return phoneNum;
	}




	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getDoB() {
		return doB;
	}




	public void setDoB(String doB) {
		this.doB = doB;
	}




	public User(int userID, String userName, String password, String firstName,
			String lastName, String title, String phoneNum, String email,
			String address, String doB) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
		this.doB = doB;
	}
	
	public abstract void borrowBook(String bookID);
	public abstract void returnBook(String bookID);
	public abstract void searchBook(String title);
	public abstract User logIn(String username, String password);
	public abstract void logOff();
}