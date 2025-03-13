// 파일 내용 읽기

package Ch19;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class C02ReaderMain {

	public static void main(String[] args) throws IOException {
		Reader fin = new FileReader("C:\\IOTEST\\test1.txt");
		int data = 0;
		String string="";
		StringBuffer buffer = new StringBuffer();
		while ((data = fin.read()) != -1) { // .read()는 끝에 도달했을 때 -1을 반환한다.
//			System.out.print((char) data);
			buffer.append((char) data); // 유니코드를 char로
//			string.toString(data); 이건 안된다.
		}
		System.out.println();
//		System.out.println(data); // 결과값이 -1인거보니까 한 글자씩 받는듯?
		System.out.println(buffer);
	}
}