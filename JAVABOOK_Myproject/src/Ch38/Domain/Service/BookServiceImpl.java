package Ch38.Domain.Service;

import Ch38.Domain.DAO.BookDAOImpl;
import Ch38.Domain.DAO.BookDao;
import Ch38.Domain.DAO.ConnectionPool.ConnectionPool;
import Ch38.Domain.DTO.BookDTO;

public class BookServiceImpl {

	private BookDao bookDao;
	private ConnectionPool connectionPool;

	// 싱글톤 패턴
	private static BookServiceImpl instance;

	private BookServiceImpl() throws Exception {
		bookDao = BookDAOImpl.getInstance();
		connectionPool = ConnectionPool.getInstance();
		System.out.println("[SERVICE] BookServiceImpl init...");
	}

	public static BookServiceImpl getInstance() throws Exception {
		if (instance == null) {
			instance = new BookServiceImpl();
		}
		return instance;
	}

	// 도서 등록 + 비즈니스 유효성 검사
	// 비즈니스 유효성 검사는 회사의 정책 등이다.(파일 5개 제한, 사진 크기 제한 등)
	public boolean bookRegistration(BookDTO bookDto) throws Exception {
		boolean isRegistrated = false;
		try {
			isRegistrated = bookDao.insert(bookDto) > 0;
		} catch (Exception e) {
			connectionPool.rollbackTransaction();
		}

		return isRegistrated;
	}
}
