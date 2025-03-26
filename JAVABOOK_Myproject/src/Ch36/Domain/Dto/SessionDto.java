package Ch36.Domain.Dto;

public class SessionDto {
	private int sessionId;
	private String username;
	private String role;
	//toString
	//getter and setter
	//생성자(디폴트,모든인자)
	@Override
	public String toString() {
		return "SessionDto [sessionId=" + sessionId + ", username=" + username + ", role=" + role + "]";
	}
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public SessionDto(int sessionId, String username, String role) {
		super();
		this.sessionId = sessionId;
		this.username = username;
		this.role = role;
	}
	public SessionDto() {}
	
	
}
