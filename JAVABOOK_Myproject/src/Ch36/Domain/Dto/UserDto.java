package Ch36.Domain.Dto;

public class UserDto {
	
	private String username;
	private String password;
	private String role;
	private boolean islocked;
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
	public boolean isIslocked() {
		return islocked;
	}
	public void setIslocked(boolean islocked) {
		this.islocked = islocked;
	}
	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + ", role=" + role + ", islocked=" + islocked
				+ "]";
	}
	public UserDto(String username, String password, String role, boolean islocked) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.islocked = islocked;
	}
	public UserDto() {}
	//생성자(디폴트생성자 , 모든인자 생성자)
	//toString
	//getter and setter
	
	
}
