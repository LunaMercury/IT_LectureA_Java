// 빠른 파일 내용 읽기
// 소요시간

package Ch19;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class C04FileCopyMain {

	private static String FileDir = "C:\\IOTEST\\"; // 파일위치가 아닌 폴더위치

	public static void main(String[] args) throws IOException {
		Reader fin = new FileReader(FileDir + "사냥개.png");
		int data = 0;
		StringBuffer buffer = new StringBuffer();

		char[] buf = new char[1024]; // 1024byte 단위로 읽는다
//		fin.read(buf); //1024byte 갯수가 몇 개 있는지 리턴

		long startTime = System.currentTimeMillis(); // 시작시간
		while ((data = fin.read((buf))) != -1) { // .read()는 문자가 없을 때 -1을 반환한다.
//			System.out.print((char)data);
			buffer.append((char) data);
			buffer.append(buf);
		}
		long endTime = System.currentTimeMillis(); // 끝시간
		System.out.println();
		System.out.println("소요시간 : " + (endTime - startTime) + "ms");
//		System.out.println(buffer);
	}
}