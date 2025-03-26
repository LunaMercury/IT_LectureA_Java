package Ch36.Controller;

import java.util.Map;

public class LendController implements SubController{
	// 1 Insert , 2 Update , 3 Delete 4 SelectAll 5 Select 
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("LendController's execute()");
		return null;
	}

}
