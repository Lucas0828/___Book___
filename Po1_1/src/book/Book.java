package book;

public class Book {
	String isbn;
	String title;
	String name;
	String publisher;
	int price;
	public Book() {
		
	}
	
	public Book(String isbn ,String title, String name, String publisher, int price){
		this.isbn = isbn;
		this.title = title;
		this.name = name;
		this.publisher = publisher;
		this.price = price;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "["+isbn+", "+title+", "+name+", "+publisher+", "+price+"]";
	}
}
