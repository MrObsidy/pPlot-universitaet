package alexander.pplot;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteHelper {
	public static void writeArrayToFile(ArrayList<String> strings, String fileName){
		List<String> lines = strings;
		
		Path path = Paths.get(fileName);
		
		try {
			Files.write(path, lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
