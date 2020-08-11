package book;

import java.util.ArrayList;

public interface BookInte {
	
	void addBook(Book newBook);
	ArrayList<Book> getAllBook();
	Book searchISBN(String isbn);
	ArrayList<Book> searchTitle(String title);
	ArrayList<Book> searchName(String name);
	ArrayList<Book> onlyBook();
	ArrayList<Book> onlyMagazine();
	ArrayList<Book> MagYear(int year);
	ArrayList<Book> searchPub(String pub);
	int getTotal();
	int getAvg();
	
	
}
