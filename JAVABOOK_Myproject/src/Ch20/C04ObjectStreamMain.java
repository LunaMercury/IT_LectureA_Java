// 소켓 통신 시 object 단위로 다른 컴퓨터로 전달하기 위한 방식 중 하나.
// 데이터를 프로그램 종료 후에도 유지할 수 있도록 하는 목적도 있음.
// 출력은 ~~~.db로 나옴.

package Ch20;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

class Board implements Serializable { //object를 전달할 때 Serializable 상속을 받아야 한다.
	// 이클립스 버전 정보 ↓　
	private static final long serialVersionUID = 1L;

	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date date;

	public Board(int bno, String title, String content, String writer, Date date) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", date="
				+ date + "]";
	}

	// All Args Constructor
	// Getter and Setter
	// toString

}

public class C04ObjectStreamMain {

	public static void main(String[] args) throws Exception {

		// 직렬화
//		FileOutputStream out = new FileOutputStream("c:\\IOTEST\\board.db");
//		ObjectOutputStream oout = new ObjectOutputStream(out);
//		oout.writeObject(new Board(1, "제목1", "하2", "홍길동", new Date()));;
//		oout.writeObject(new Board(2, "제목2", "하3", "남길동", new Date()));;
//		oout.flush();
//		oout.close();
//		out.close();

		// 역직렬화
		FileInputStream in = new FileInputStream("c:\\IOTEST\\board.db");
		ObjectInputStream oin = new ObjectInputStream(in);

 		Object obj =  oin.readObject();
		Board down = (Board)obj;
		System.out.println(down);		
 		Object obj2 =  oin.readObject();
		Board down2 = (Board)obj2;
		System.out.println(down2);
		//더이상 읽을것이 없으면 java.io.EOFException 발생 
 		Object obj3 =  oin.readObject();
		Board down3 = (Board)obj3;
		System.out.println(down3);
		}
}