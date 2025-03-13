// 파일 내용을 수정 및 추가
// 기본 덮어쓰기

package Ch19;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class C01WriteMain {

	public static void main(String[] args) throws IOException {
		Writer fout = new FileWriter("C:\\IOTEST\\test1.txt", true); //true : 내용추가, false : 덮어쓰기(디폴트)
		fout.write("test5\n");
		fout.write("test6\n");
		fout.write("test7\n");
		fout.write("test8\n");
		
		fout.flush(); // 출력할 것이 끝나면 적용
		fout.close(); //sc.close()와 비슷
	}
}