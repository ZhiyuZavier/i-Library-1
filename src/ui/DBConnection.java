package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import user.Customer;
import user.User;

public class DBConnection {

    private static final String DBNAME = "jdbc:sqlite:noName.s3db";
    public Connection conn;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public DBConnection() {
        super();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void openConn() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.conn = DriverManager.getConnection(this.DBNAME);
            System.out.println("Database connected");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Connection failed");
        }

    }

    public void closeConn() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();            
        }
    }

    public void readData() {
        try {
            java.sql.Statement sta = this.conn.createStatement();
            ResultSet rs = sta.executeQuery("select * from User");
            while (rs.next()) {
                System.out
                        .printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-25s%-15s%-15s\n",
                                rs.getString("userID"),
                                rs.getString("userName"),
                                rs.getString("password"),
                                rs.getString("firstName"),
                                rs.getString("lastName"),
                                rs.getString("title"),
                                rs.getString("phoneNumber"),
                                rs.getString("userType"),
                                rs.getString("email"), rs.getString("address"),
                                rs.getString("DOB"));
                if (rs.getString("userType").equalsIgnoreCase("cus")) {
                    this.customers
                            .add(new Customer(Integer.parseInt(rs
                                                    .getString("userID")), rs
                                            .getString("userName"), rs
                                            .getString("password"), rs
                                            .getString("firstName"), rs
                                            .getString("lastName"), rs
                                            .getString("title"), rs
                                            .getString("phoneNumber"), rs
                                            .getString("email"), rs
                                            .getString("address"), rs.getString("DOB")));
                }
            }
            rs.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addBook(double price, String bookStatus, long sn,
            int publishYear, String title, String publisher,
            String decription, String categories, String author, String shopName) {
        // get row number of table for book
        try {
            Statement sta = this.conn.createStatement();
            ResultSet rs = sta.executeQuery("select * from Book");
            // need to take last bookID
            int lastID = 0;
            while (rs.next()) {
                lastID = Integer.parseInt(rs.getString("bookID"));
            }

            rs.close();
            PreparedStatement statement = this.conn
                    .prepareStatement("INSERT INTO Book (bookID, price, bookStatus, sn, publishYear,title, publisher, description, categories,author, shopName)"
                            + "VALUES(?,?,?,?,?,?,?,?,?,?,?)");

            statement.setInt(1, lastID + 1);
            statement.setDouble(2, price);
            statement.setString(3, bookStatus);
            statement.setLong(4, sn);
            statement.setInt(5, publishYear);
            statement.setString(6, title);
            statement.setString(7, publisher);
            statement.setString(8, decription);
            statement.setString(9, categories);
            statement.setString(10, author);
            statement.setString(11, shopName);
            
            
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void addNewUser() {

    }

    public void deleteBook(int IDNum){
    	try {
            Statement sta = this.conn.createStatement();
            ResultSet rs = sta.executeQuery("select * from Book");
            rs.close();
            PreparedStatement statement = this.conn
                    .prepareStatement("DELETE FROM Book WHERE bookID =" + IDNum);
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    
    
    public void addNewUser(String userName, String password, String firstName,
			String lastName, String title, String phoneNum, String userType,
			String email, String address, String doB) {
            // get row number of table for book
            try {
                Statement sta = this.conn.createStatement();
                ResultSet rs = sta.executeQuery("select * from User");
                int lastID = 0;
                while (rs.next()) {
                    lastID = Integer.parseInt(rs.getString("userID"));
                }

                rs.close();
                System.out.print(userName);
                PreparedStatement statement = this.conn
                        .prepareStatement("INSERT INTO User "
                                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)");

                statement.setInt(1, lastID + 1);
                statement.setString(2, userName);
                statement.setString(3, password);
                statement.setString(4, firstName);
                statement.setString(5, lastName);
                statement.setString(6, title);
                statement.setString(7, phoneNum);
                statement.setString(8, userType);
                statement.setString(9, email);
                statement.setString(10, address);
                statement.setString(11, doB);

                statement.executeUpdate();
            } catch (SQLException e) {

            }
        }
    
    public void deleTEUser(int IDNum){
    	 try {
             Statement sta = this.conn.createStatement();
             ResultSet rs = sta.executeQuery("select * from User");
             rs.close();
             PreparedStatement statement = this.conn
                     .prepareStatement("DELETE FROM User WHERE userID =" + IDNum);
             statement.executeUpdate();
         } catch (SQLException e) {

         }
        }
    	 
    
    public User login(String username, String password) {

        User newUser = null;
        try {

            java.sql.Statement sta = this.conn.createStatement();
            ResultSet rs = sta.executeQuery("select userType from User Where "
                    + "userName ='" + username + "' and password = '" + password + "'");
            while (rs.next()) {
               
              newUser = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
                       rs.getString(8),rs.getString(9),rs.getString(10));
            }

            System.out.println(rs.getString(username));

            rs.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return newUser;

    }
    
    public void updateUser(String title, String phone, String password, String email, String address, int userID){
    	try {
			Statement sta = this.conn.createStatement();
			String sql = "update User set title = '" + title + "' ,PhoneNumber = '"
					+ phone + "' ,Password = '" + password
					+ "' ,Email = '" + email + "', Address = '" + address+"' where UserID = "+ userID+";";
			System.out.println(sql);
			sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
//    	String sql = "update User set title = '" + value1 + "' ,PhoneNumber = '"
//				+ value2 + "' ,Password = '" + value3
//				+ "' ,Email = '" + value4 + "', Address = '" + value5+"' where UserID = '"
//				+ bookid;
//		pst = db.conn.prepareStatement(sql);
//		pst.executeUpdate();
    }
    
    
}


