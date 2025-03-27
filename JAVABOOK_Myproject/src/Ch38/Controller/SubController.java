// 하위 컨트롤러들이 구현해야 하는 인터페이스. execute 메서드를 통해 요청을 처리하고 결과를 반환

package Ch38.Controller;

import java.util.Map;

public interface SubController {
	public Map<String, Object> execute(Map<String, Object> params); // Map을 받아 Map을 반환
}
