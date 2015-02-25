/**
 * 
 */
package products;

/**
 * @author usr
 *
 */
public class Book {

	private int bookID;
	private double price;
	private String bookStatus;
	private int sn;
	private String publishYear;
	private String title;
	private String publisher;
	private String description;
	private String categories;
	private String author;
	private String shopName;

	public Book(int bookID, double price, String bookStatus, int sn,
			String publishYear, String title, String publisher, String decription,
			String categories, String shopName, String author) {
		super();
		this.bookID = bookID;
		this.price = price;
		this.bookStatus = bookStatus;
		this.sn = sn;
		this.publishYear = publishYear;
		this.title = title;
		this.publisher = publisher;
		this.description = decription;
		this.categories = categories;
		this.author = author;
		this.shopName = shopName;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public String getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDecription() {
		return description;
	}

	public void setDecription(String decription) {
		this.description = decription;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * 
	 * @param bookID
	 * @param price
	 * @param sn
	 * @param publishYear
	 * @param title
	 * @param publisher
	 * @param decription
	 * @param categories
	 * @param author
	 * @param shopName
	 */
	public void addAbook(int bookID, double price, int sn, String publishYear,
			String title, String publisher, String decription,
			String categories, String shopName,String author) {
		this.bookID = bookID;
		this.price = price;
		this.bookStatus = "Available";
		this.sn = sn;
		this.publishYear = publishYear;
		this.title = title;
		this.publisher = publisher;
		this.description = decription;
		this.categories = categories;
		this.author = author;
		this.shopName = shopName;
	}
	
	/**
	 * showBookInfo() shows the book information
	 * to user
	 */
	public void showBookInfo(){
		System.out.println(this.title);
		System.out.printf("%-30s-20s-30s-20s\n", "Title"
				, this.title, "SN", this.sn);
		System.out.printf("%-30s-20s-30s-20s\n", "Author"
				, this.author, "Publisher", this.publisher);
		System.out.printf("%-30s-20d-30s-20s\n", "Publish year"
				, this.publishYear, "Status", this.bookStatus);
	}
}
