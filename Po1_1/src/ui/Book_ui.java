package ui;

import java.util.ArrayList;
import java.util.Scanner;

import book.Book;
import book.Magazine;
import util.BookManager;

public class Book_ui {
	public static void main(String[] args) {
		ArrayList<Book> bs = new ArrayList<Book>();
		bs.add(new Book("9788983922557", "해리포터와 죽음의 성물 1", "조앤 K. 롤링","문학수첩", 8500));
		bs.add(new Book("9788983922564", "해리포터와 죽음의 성물 2", "조앤 K. 롤링","문학수첩", 8500));
		bs.add(new Book("9788983922571", "HarryPotter", "J K. 롤링","스콜라스틱", 8500));
		bs.add(new Book("9788983922588", "HarryPotter", "조앤 K. 롤링","문학수첩", 8500));
		bs.add(new Book("9788932906577", "개미", "베르나르 베르베르", "열린책들", 11520));
		printB(bs);
	}


	public static void printB(ArrayList<Book> bs) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BookManager server = BookManager.getInstance();
		
		for(Book b : bs) {
			server.addBook(b);
		}
		
		boolean menu = true;
		while(menu) {
			System.out.println("==============================");
			System.out.println("	<<도서 관리 페이지>>   ");
			System.out.println("	1. 전체 소장책 조회");
			System.out.println("	2. 소장책 추가하기");
			System.out.println("	3. 도서 검색");
			System.out.println("	4. 서점 소유 도서 가격합계 및 평균");
			System.out.println("	5. 도서 삭제");
			System.out.println("==============================");
			
			int select = sc.nextInt();
			switch (select) {
			case 1:
				System.out.println("전체 도서 총 "+server.getAllBook().size()+"권");
				for (Book b : server.getAllBook()) {
					System.out.println(b);
				}
				break;
			case 2:
				System.out.println("국제표준도서번호(ISBN)을 입력해주세요.");
				String isbn = sc.next();
				System.out.println("도서 명을 입력해주세요. ");
				String title = sc.next();
				System.out.println("저자를 입력해주세요. ");
				String name = sc.next();
				System.out.println("출판사를 입력해주세요. ");
				String pub = sc.next();
				System.out.println("책 가격을 입력해주세요.");
				int price = sc.nextInt();
				System.out.println("만약 책이면 true를 잡지면 false를 입력해주세요.");
				boolean BorM = sc.nextBoolean();
				if(BorM) {
					server.addBook(new Book(isbn, title, name, pub, price));
				}
				else if (!BorM) {
					System.out.println("출간연도를 입력하세요. ");
					int year = sc.nextInt();
					System.out.println("출간월을 입력하세요. ");
					int month = sc.nextInt();
					server.addBook(new Magazine(isbn, title, name, pub, price, year, month));
				}
				break;
			case 3:
				System.out.println("=====================================");
				System.out.println("	<<	도서 검색 방법	>>");
				System.out.println("	1. 국제표준도서번호(ISBN)");
				System.out.println("	2. 도서 명");
				System.out.println("	3. 저자 이름");
				System.out.println("	4. 출판사");
				System.out.println("	5. 도서만");
				System.out.println("	6. 잡지만");
				
				int selectFind = sc.nextInt();
				switch (selectFind) {
				case 1:
					System.out.println("찾으실 도서의 국제표준도서번호(ISBN)을 입력하세요.");
					String sisbn = sc.next();
					System.out.println(server.searchISBN(sisbn));
					break;
				case 2:
					System.out.println("찾으실 도서 명을 입력하세요.");
					String stitle = sc.next();
					System.out.println(server.searchTitle(stitle));
					break;
				case 3:
					System.out.println("찾으실 도서들의 저자 이름을 입력하세요.");
					String sName = sc.next();
					System.out.println(server.searchName(sName));
					break;
				case 4:
					System.out.println("찾으실 도서들의 출판사를 입력하세요.");
					String spub = sc.next();
					System.out.println(server.searchPub(spub));
					break;
				case 5:
					System.out.println("도서들만 출력됩니다.(잡지 제외)");
					System.out.println(server.onlyBook());
					break;
				case 6:
					System.out.println("===============================");
					System.out.println("	<<	잡지	>>");
					System.out.println("	1. 전체 검색");
					System.out.println("	2. 해당하는 연도");
					
					int selectM = sc.nextInt();
					if (selectM == 1) {
						System.out.println("잡지들만 출력됩니다.");
						System.out.println(server.onlyMagazine());
					}else if(selectM == 2) {
						System.out.println("해당하는 연도를 입력하세요.");
						int syear = sc.nextInt();
						System.out.println(server.MagYear(syear));
					}else {
						System.out.println("없음");
						return;
					}
					break;
				default:
					break;
				}
				break;
			case 4:
				System.out.println("도서 가격의 총합: "+server.getTotal());
				System.out.println("도서 가격의 평균: "+server.getAvg());
				break;
			case 5:
				System.out.println("삭제할 도서의 ISBN을 입력해주세요.");
				String dISBN = sc.next();
				server.deleteBook(dISBN);
				break;
			default:
				break;
			}
		}
		
		
	}
}
