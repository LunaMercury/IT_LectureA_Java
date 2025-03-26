package Ch36.Domain.Dto;

import java.io.Serializable;

public class BookDto  implements Serializable{
	
	private int bookCode;
	private String bookName;
	private String publisher;
	private String isbn;
	@Override
	public String toString() {
		return "BookDto [bookCode=" + bookCode + ", bookName=" + bookName + ", publisher=" + publisher + ", isbn="
				+ isbn + "]";
	}
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public BookDto(int bookCode, String bookName, String publisher, String isbn) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.publisher = publisher;
		this.isbn = isbn;
	}
	public BookDto() {}
	//toString
	//getter and Setter
	//디폴트생성자 / 모든인자 생성자 추가하기
	

}
