package nowapps.nxton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LinkedinMembers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "c://lines.txt";
		List<String> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			//
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
