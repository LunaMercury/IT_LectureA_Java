// /book 엔드포인트로 들어오는 도서 관련 요청을 처리. 도서 등록, 검색, 수정, 삭제 등의 도서 관련 기능을 수행

package Ch38.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch38.Domain.DTO.BookDTO;
import Ch38.Domain.Service.BookServiceImpl;

public class BookController implements SubController {

	private BookServiceImpl bookService;

	public BookController() {
		try {
			bookService = BookServiceImpl.getInstance();
		} catch (Exception e) {
			exceptionHandler(e);
		}
	}

	Map<String, Object> response;

	// CRUD
	@Override
	public Map<String, Object> execute(Map<String, Object> params) {
		System.out.println("[SC] BookController execute Invoke..");
		response = new HashMap();
		Integer serviceNo = (Integer) params.get("serviceNo");
		if (serviceNo == null) {
			response.put("status", false);
			response.put("message", "유효하지 않은 서비스 요청");
			return response;
		}
		try {
			switch (serviceNo) {
			case 1: { // C - 도서등록(Role-사서, 관리자)
				System.out.println("[SC] 도서 등록 요청 확인");
				// 01 파라미터 받기
				String BookCode = ((String) params.get("BookCode") != null) ? (String) params.get("BookCode") : null;
				String BookName = ((String) params.get("BookName") != null) ? (String) params.get("BookName") : null;
				String Publisher = ((String) params.get("Publisher") != null) ? (String) params.get("Publisher") : null;
				String Isbn = ((String) params.get("Isbn") != null) ? (String) params.get("Isbn") : null;

				BookDTO bookDto = new BookDTO(BookCode, BookName, Publisher, Isbn);

				// 02 유효성 검증(Validation)
				boolean isOk = isValid(bookDto);
				System.out.println("[No-1 도서 등록] : 유효성 검증 확인 : " + isOk);
				if (!isOk) {
					response.put("status", false);
					response.put("message", "유효성 체크 오류발생!");
					return response;
				}

				// 03 관련서비스 실행
				boolean isSuccess = bookService.bookRegistration(bookDto);

				// 04 뷰로 이동(또는 내용전달)
				response.put("status", isSuccess);
				response.put("message", "도서등록 성공");
				break;
			}
			case 2: { // R - 도서 검색 (Role - 회원, 사서, 관리자)
				System.out.println("[SC] 도서 조회 요청 확인");
				break;
			}
			case 3: { // U - 도서 수정 (Role - 사서, 관리자)
				System.out.println("[SC] 도서 수정 요청 확인");
				break;
			}
			case 4: { // D - 도서 삭제 (Role - 사서, 관리자)
				System.out.println("[SC] 도서 삭제 요청 확인");
				break;
			}
			default: {
				System.out.println("[SC] 잘못된 서비스번호 요청 확인");
				response.put("status", false);
				response.put("message", "잘못된 서비스 번호 요청");
			}

			}

		} catch (Exception e) {
			exceptionHandler(e);
		}
		return response;
	}

	// 유효성 검사 함수
	private boolean isValid(BookDTO bookDto) {
		if (bookDto.getBookCode() == null || bookDto.getBookCode().length() != 8) {
			response.put("error", "bookCode의 길이는 8자만 가능.");
			System.out.println("[INVALID] bookCode의 길이는 8자만 가능");
			return false;
		}
		if (bookDto.getBookName().length() >= 255) {
			System.out.println("bookname의 길이는 최소 255자 이하이어야 합니다.");
			response.put("error", "bookname의 길이는 최소 255자 이하이어야 합니다.");
			return false;
		}
		return true;

		// null 체크 / 데이터(자료)수준에서의 의미있는 데이터가 포함되어 있는지 여부
		// username은 첫 문자가 숫자인지 여부 / 길이 등등
		// password 복잡도 체크는 Business Layer 체크(Policy에 의한 처리)

	}

	// 예외 처리 함수
	public Map<String, Object> exceptionHandler(Exception e) {
		if (response == null) {
			response = new HashMap();
		}
		response.put("status", false);
		response.put("message", e.getMessage());
		response.put("exception", e);
		return response;
	}

}
