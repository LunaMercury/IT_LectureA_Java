package Ch37_MVC_Add_View_Socket_Thread.Socket.Type;

import java.io.Serializable;
import java.util.Map;

public class Response  implements Serializable{
	private static final long serialVersionUID = 2L;

	private Map<String,Object> header;
	private Map<String,Object> body;
	
	public Response() {}
	public Response(Map<String, Object> header, Map<String, Object> body) {
		super();
		this.header = header;
		this.body = body;
	}
	public Map<String, Object> getHeader() {
		return header;
	}
	public void setHeader(Map<String, Object> header) {
		this.header = header;
	}
	public Map<String, Object> getBody() {
		return body;
	}
	public void setBody(Map<String, Object> body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "Response [header=" + header + ", body=" + body + "]";
	}
	
	
}
