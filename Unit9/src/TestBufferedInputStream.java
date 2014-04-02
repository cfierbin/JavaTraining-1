

import java.io.*;

import com.practicaljava.lesson16.Config;

public class TestBufferedInputStream {

	public static void main(String[] args) throws IOException {

		try (FileInputStream myFile = new FileInputStream(Config.APPLICATION_PATH+"abc.dat");
				BufferedInputStream buff = new BufferedInputStream(myFile);) {

			boolean eof = false;
			while (!eof) {
				int byteValue = buff.read();
				System.out.print(byteValue + " ");
				if (byteValue == -1)
					eof = true;
			}
		} catch (IOException e) {

			System.out.println(e);
		}

	}
}
