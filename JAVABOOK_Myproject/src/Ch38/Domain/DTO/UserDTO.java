// 데이터 구조 역할

package Ch38.Domain.DTO;

// 저장단위 : Controller <-> Service<->DAO<->DB
public class UserDTO {
	private String userid;
	private String username;
	private String password;
	private String role;
	
	public UserDTO() {}
	public UserDTO(String userid, String username, String password, String role) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", username=" + username + ", password=" + password + ", role=" + role
				+ "]";
	}
	
}
