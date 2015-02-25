/**
 * @Author @Date Sep 12, 2014
 * @Purpose
 * @Version
 */
package user;

import java.sql.ResultSet;
import java.sql.SQLException;

import ui.DBConnection;

/**
 * @author usr
 *
 */
public class Receptionist extends User {

    /**
     *
     */
    public Receptionist() {
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
    public Receptionist(int userID, String userName, String password,
            String firstName, String lastName, String title, String phoneNum,
            String email, String address, String doB) {
        super(userID, userName, password, firstName, lastName, title, phoneNum,
                email, address, doB);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see user.User#borrowBook()
     */
    @Override
    public void borrowBook(String bookID) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see user.User#returnBook()
     */
    @Override
    public void returnBook(String bookID) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see user.User#searchBook()
     */
    @Override
    public void searchBook(String title) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see user.User#logOff()
     */
    @Override
    public void logOff() {
        // TODO Auto-generated method stub

    }

    public void viewCustomer() {

    }

    public void checkCustomerRecord(int CusID) {

    }

    public void addACustomer() {

    }

    public void deleteACustomer(int CusID) {

    }

    public void updateCustomerInfo() {

    }

    public void updateBookStatus() {

    }

    public void takeFine(int CusID) {

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

                newUser = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3),
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
