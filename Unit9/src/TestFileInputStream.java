

import java.io.*;

import com.practicaljava.lesson16.Config;

public class TestFileInputStream {
	
	public static void main(String[] args) {

		try (FileInputStream myFile = new FileInputStream(Config.APPLICATION_PATH+"abc.dat");) {

			boolean eof = false;
			while (!eof) {
				int byteValue = myFile.read();
				System.out.print(byteValue + " ");
				if (byteValue == -1)
					eof = true;
			}
		} catch (IOException e) {
			System.out.println("Could not read file: " + e.toString());
		}
	}
}
