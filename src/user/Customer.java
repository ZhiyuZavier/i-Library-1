/**
 * @Author @Date Sep 12, 2014
 * @Purpose
 * @Version
 */
package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import products.Book;
import ui.Borrow_Return_GUI;

import ui.DBConnection;

/**
 * @author usr
 *
 */
public class Customer extends User {

    private double fine;
    // private Borrow_Return_GUI borrow_return_gui = new Borrow_Return_GUI();
    // private ArrayList<Book> books = new ArrayList<Book>();

    /**
     *
     */
    public Customer() {
        // TODO Auto-generated constructor stub         
    }

    /**
     * @param userID
     * @param userName
     * @param password
     * @param firstName
     * @param lastName
     * @param title
     * @param phoneNum
     * @param email
     * @param address
     * @param doB
     */
    public Customer(int userID, String userName, String password,
            String firstName, String lastName, String title, String phoneNum,
            String email, String address, String doB) {
        super(userID, userName, password, firstName, lastName, title, phoneNum,
                email, address, doB);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see user.User#borrowBook()
     */
    @Override
    public void borrowBook(String bookID) {
        // TODO Auto-generated method stub
        DBConnection db = new DBConnection();
        db.openConn();
        try {
            java.sql.Statement sta = db.conn.createStatement();
            String sql = "UPDATE Book SET bookStatus = 'borrowed out' WHERE bookID =" + bookID;
            sta.executeUpdate(sql);
            //db.conn.commit();
            //sta.close

        } catch (Exception e) {
            e.printStackTrace();
        }
        db.closeConn();
    }

    /* (non-Javadoc)
     * @see user.User#returnBook()
     */
    @Override
    public void returnBook(String bookID) {
        // TODO Auto-generated method stub
        DBConnection db = new DBConnection();
        db.openConn();
        try {
            java.sql.Statement sta = db.conn.createStatement();
            String sql = "UPDATE Book SET bookStatus = 'available' WHERE bookID =" + bookID;
            sta.executeUpdate(sql);
            //db.conn.commit();
            //sta.close

        } catch (Exception e) {
            e.printStackTrace();
        }
        db.closeConn();

    }

    /* (non-Javadoc)
     * @see user.User#searchBook()
     */
    @Override
    public void searchBook(String title) {
        // TODO Auto-generated method stub        
        DBConnection db = new DBConnection();
        db.openConn();
        try {
            java.sql.Statement sta = db.conn.createStatement();
            ResultSet rs = sta.executeQuery("select * from Book");
            while (rs.next()) {
                if (rs.getString("title").toLowerCase().equalsIgnoreCase(title)) {
                    Borrow_Return_GUI borrow_return_gui = new Borrow_Return_GUI();
                    borrow_return_gui.setVisible(true);
                    ArrayList<Book> books = new ArrayList<Book>();
                    books.add(new Book(rs.getInt("bookID"), rs.getDouble("price"),
                            rs.getString("bookStatus"), rs.getInt("sn"),
                            rs.getString("publishYear"), rs.getString("title"),
                            rs.getString("publisher"), rs.getString("description"),
                            rs.getString("categories"), rs.getString("shopName"),
                            rs.getString("author")));
                    Book newBook = new Book();
                    System.out.println(Integer.toString(newBook.getBookID()));
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Sorry! There is no such book in our library",
                            "Search Results",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.closeConn();
    }

    /* (non-Javadoc)
     * @see user.User#logOff()
     */
    @Override
    public void logOff() {
        // TODO Auto-generated method stub

    }

    public void payFine() {
        this.fine = 0.0;

    }

    public void reeequestABook() {

    }

    @Override
    public int getUserID() {
        // TODO Auto-generated method stub
        return super.getUserID();
    }

    @Override
    public String getUserName() {
        // TODO Auto-generated method stub
        return super.getUserName();
    }

    @Override
    public void setUserName(String userName) {
        // TODO Auto-generated method stub
        super.setUserName(userName);
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        // TODO Auto-generated method stub
        super.setPassword(password);
    }

    @Override
    public String getFirstName() {
        // TODO Auto-generated method stub
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        // TODO Auto-generated method stub
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        // TODO Auto-generated method stub
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        // TODO Auto-generated method stub
        super.setLastName(lastName);
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return super.getTitle();
    }

    @Override
    public void setTitle(String title) {
        // TODO Auto-generated method stub
        super.setTitle(title);
    }

    @Override
    public String getPhoneNum() {
        // TODO Auto-generated method stub
        return super.getPhoneNum();
    }

    @Override
    public void setPhoneNum(String phoneNum) {
        // TODO Auto-generated method stub
        super.setPhoneNum(phoneNum);
    }

    @Override
    public String getEmail() {
        // TODO Auto-generated method stub
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        // TODO Auto-generated method stub
        super.setEmail(email);
    }

    @Override
    public String getAddress() {
        // TODO Auto-generated method stub
        return super.getAddress();
    }

    @Override
    public void setAddress(String address) {
        // TODO Auto-generated method stub
        super.setAddress(address);
    }

    @Override
    public String getDoB() {
        // TODO Auto-generated method stub
        return super.getDoB();
    }

    @Override
    public void setDoB(String doB) {
        // TODO Auto-generated method stub
        super.setDoB(doB);
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public double getFine() {
        return this.fine;
    }

    public User logIn(String username, String password) {
        // TODO Auto-generated method stub
        User newUser = null;
        DBConnection db = new DBConnection();
        db.openConn();
        try {

            java.sql.Statement sta = db.conn.createStatement();
            ResultSet rs = sta.executeQuery("select userType from User Where "
                    + "userName ='" + username + "' and password = '" + password + "'");
            while (rs.next()) {

                newUser = new Receptionist(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10));
            }

            rs.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        db.closeConn();
        return newUser;

    }
}
