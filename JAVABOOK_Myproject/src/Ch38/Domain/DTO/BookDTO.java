package Ch38.Domain.DTO;

public class BookDTO {
	private String BookCode;
	private String BookName;
	private String Publisher;
	private String Isbn;

	public BookDTO() {}
	public BookDTO(String bookCode, String bookName, String publisher, String isbn) {
		super();
		this.BookCode = bookCode;
		this.BookName = bookName;
		this.Publisher = publisher;
		this.Isbn = isbn;
	}

	public String getBookCode() {
		return BookCode;
	}
	public void setBookCode(String bookCode) {
		this.BookCode = bookCode;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		this.BookName = bookName;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	}
	public String getIsbn() {
		return Isbn;
	}
	public void setIsbn(String Isbn) {
		this.Isbn = Isbn;
	}
	@Override
	public String toString() {
		return "BookDTO [BookCode=" + BookCode + ", BookName=" + BookName + ", Publisher=" + Publisher + ", Isbn="
				+ Isbn + "]";
	}

}
