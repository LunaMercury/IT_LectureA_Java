// 파일 복사

package Ch19;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class C03FileCopyMain {

	private static String FileDir = "C:\\IOTEST\\"; // 파일위치가 아닌 폴더위치

	public static void main(String[] args) throws IOException{
		for (String arg : args) {
			System.out.println(arg);
		}
		Reader fin = new FileReader(FileDir + args[0]); // 원본파일
		Writer fout = new FileWriter(FileDir + args[1]); // 대상파일
		
		while (true) {
			int data = fin.read();
			if (data ==-1) {
				break;
			}
			fout.write((char)data);
			fout.flush();
		}
		fout.close();
		fin.close();
	}
}