package util;

import java.util.ArrayList;
import java.util.Iterator;

import book.Book;
import book.BookInte;
import book.Magazine;

public class BookManager implements BookInte {
	private ArrayList<Book> blist = new ArrayList<Book>();
	private static BookManager instance;
	
	public static BookManager getInstance() {
		if (instance == null) {
			instance = new BookManager();
		}
		return instance;
	}

	@Override
	public void addBook(Book newBook) {
		boolean s = true;
		for(Book b : blist) {
			if (b.getIsbn().equals(newBook.getIsbn())) {
				System.out.println(newBook.getTitle()+"의 국제표준도서번호(ISBN)가 중복입니다.");
				s=false;
				break;
			}
		}
		if(s) {
			blist.add(newBook);
			System.out.println("도서 명: "+newBook.getTitle()+"이/가 추가되었습니다.");
		}
		
	}

	@Override
	public ArrayList<Book> getAllBook() {
		return blist;
	}

	@Override
	public Book searchISBN(String isbn) {
		Book cache = new Book();
		for(Book b : blist)
			if(b.getIsbn().equals(isbn)) cache = b;
		return cache;
	}
	
	@Override
	public ArrayList<Book> searchName(String name){
		ArrayList<Book> cache = new ArrayList<Book>();
		for(Book b : blist)
			if(b.getName().equals(name)) cache.add(b);
		return cache;
		
	}

	@Override
	public ArrayList<Book> searchTitle(String title) {
		ArrayList<Book> cache = new ArrayList<Book>();
		for(Book b : blist)
			if(b.getTitle().contains(title)) cache.add(b);
		return cache;
	}

	@Override
	public ArrayList<Book> onlyBook() {
		ArrayList<Book> cache = new ArrayList<Book>();
		for(Book b : blist) {
			if (b instanceof Magazine)continue;
			else cache.add(b);
			
		}
		return cache;
	}

	@Override
	public ArrayList<Book> onlyMagazine() {
		ArrayList<Book> cache = new ArrayList<Book>();
		for(Book b : blist){
			if(b instanceof Magazine) cache.add(b);
			else continue;
		}
		return cache;
	}

	@Override
	public ArrayList<Book> MagYear(int year) {
		ArrayList<Book> cache = new ArrayList<Book>();
		for(Book b: blist) {
			if(b instanceof Magazine) {
				if (((Magazine)b).getYear() == year) {
					cache.add(b);
				}
			}
		}
		return cache;
	}

	@Override
	public ArrayList<Book> searchPub(String pub) {
		ArrayList<Book> cache = new ArrayList<Book>();
		for(Book b : blist)
			if(b.getPublisher().equals(pub)) cache.add(b);
		return cache;
	}
	
	public void deleteBook(String isbn) {
		Iterator<Book> iterator = blist.iterator();
		while(iterator.hasNext()) {
			Book bk = iterator.next();
			if (bk.getIsbn().equals(isbn)) {
				iterator.remove();
				System.out.println(bk.getTitle()+"이/가 제거되었습니다.");
			}
		}
	}

	@Override
	public int getTotal() {
		int total = 0;
		for(Book b : blist)
			total += b.getPrice();
		return total;
	}

	@Override
	public int getAvg() {
		return getTotal()/blist.size();
	}
}
