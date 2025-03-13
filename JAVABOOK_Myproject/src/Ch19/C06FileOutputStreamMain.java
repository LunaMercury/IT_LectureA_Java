package Ch19;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class C06FileOutputStreamMain {

	public static void main(String[] args) throws IOException {
		OutputStream out = new FileOutputStream("C:\\IOTEST\\test4.txt");
//		out.write('가'); //영문자와 다르게 한글은 데이터 크기가 다르다.그러므로 전체적으로 깨지게 된다.
		out.write("가나다".getBytes(StandardCharsets.UTF_8));
		out.write('a');
		out.write('b');
		out.write('c');
		out.flush();
		out.close();
	}
}