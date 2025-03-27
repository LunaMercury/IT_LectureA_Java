// /user 엔드포인트로 들어오는 사용자 관련 요청을 처리. 회원 가입, 정보 수정, 로그인, 로그아웃 등의 사용자 관련 기능을 수행
// 간단한 제약 조건 등은 여기서 설정. 세부적인 것은 UserServiceImpl 에서 실행

package Ch38.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch38.Domain.DTO.UserDTO;
import Ch38.Domain.Service.UserServiceImpl;

public class UserController implements SubController {
	// UserService
	private UserServiceImpl userService;
	Map<String, Object> response;

	public UserController() {
		try {
			userService = UserServiceImpl.getInstance();
		} catch (Exception e) {
			exceptionHandler(e);
		}

	}

	// C(1)R(2)U(3)D(4) + 로그인(5), 로그아웃(6)
	@Override
	public Map<String, Object> execute(Map<String, Object> params) {
		System.out.println("[SC] UserController execute Invoke..");
		// 00
		response = new HashMap();
		Integer serviceNo = (Integer) params.get("serviceNo");
		if (serviceNo == null) {
			response.put("status", false);
			response.put("message", "유효하지 않은 서비스 요청");
			return response;
		}

		try {
			switch (serviceNo) {
			case 1: { // C - 회원가입
				System.out.println("[SC] 회원가입 요청 확인");
				// 01 파라미터 받기
				String userid = ((String) params.get("userid") != null) ? (String) params.get("userid") : null;
				String username = ((String) params.get("username") != null) ? (String) params.get("username") : null;
				String password = ((String) params.get("password") != null) ? (String) params.get("password") : null;
				String role = "ROLE_USER"; // 기본값
				UserDTO userDto = new UserDTO(userid, username, password, role); // 유효성 검증 및 기타 실행을 위한 저장.

				// 02 유효성 검증(Validation)
				boolean isOk = isValid(userDto);
				System.out.println("[No-1 회원가입] : 유효성 검증 확인 : " + isOk);
				if (!isOk) {
					response.put("status", false);
					response.put("message", "유효성 체크 오류발생!");
					return response;
				}
				// 03 관련서비스 실행
				Boolean isSuccess = userService.userJoin(userDto);

				// 04 뷰로 이동(또는 내용전달)
				response.put("status", isSuccess);
				response.put("message", "회원가입 성공");
				break;
			}
			case 2: { // R - 개인 회원 정보 수정
				System.out.println("[SC] 개인 회원 정보 수정");
				// 01 파라미터 받기
				// 02 유효성 검증(Validation)
				// 03 관련서비스 실행
				// 04 뷰로 이동(또는 내용전달)
				break;
			}
			case 3: { // U - 개인 회원 정보 수정
				System.out.println("[SC] 개인 회원 정보 수정");
				// 01 파라미터 받기
				// 02 유효성 검증(Validation)
				// 03 관련서비스 실행
				// 04 뷰로 이동(또는 내용전달)
				break;
			}
			case 4: { // D - 탈퇴
				System.out.println("[SC] 탈퇴 요청 확인");
				// 01 파라미터 받기
				// 02 유효성 검증(Validation)
				// 03 관련서비스 실행
				// 04 뷰로 이동(또는 내용전달)
				break;
			}
			case 5: { // P - 로그인
				System.out.println("[SC] 로그인 요청 확인");
				// 01 파라미터 받기
				// 02 유효성 검증(Validation)
				// 03 관련서비스 실행
				// 04 뷰로 이동(또는 내용전달)
				break;
			}
			case 6: { // P - 로그아웃
				System.out.println("[SC] 로그아웃 요청 확인");
				// 01 파라미터 받기
				// 02 유효성 검증(Validation)
				// 03 관련서비스 실행
				// 04 뷰로 이동(또는 내용전달)
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

		// 01 파라미터 받기
		// 02 유효성 검증(Validation)
		// 03 관련서비스 실행
		// 04 뷰로 이동(또는 내용전달)
		return response;
	}

	// 유효성 검사 함수
	// UserServiceImpl에서 해야하지만, 간단하므로 여기서 해도 괜찮다.
	private boolean isValid(UserDTO userDto) {
		if (userDto.getUserid() == null || userDto.getUserid().length() <= 4) {
			response.put("error", "userid의 길이는 최소 5자 이상이어야 합니다.");
			System.out.println("[INVALID] userid의 길이는 최소 5자 이상이어야 합니다.");
			return false;
		}
		if (userDto.getUserid().matches("^[0-9].*")) {
			System.out.println("userid의 길이는 최소 5자 이상이어야 합니다.");
			response.put("error", "userid의 첫문자로 숫자가 될 수 없습니다.");
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
