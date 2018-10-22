package plagdect;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class NTupleList {
	public static ArrayList<String> generate(String file, int N, HashMap<String, Integer> synMap) throws IOException {
		ArrayList<String> nTuple = new ArrayList<String>();
			//read in all content from file and split it by word and stem
			String content = new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
			String[] splitContent = content.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			//creates tuple of length N, replacing all synonym words for their numeric key for quick equality comparison
			for (int i = 0; i <= splitContent.length - N; i++) {
				StringBuilder tuple = new StringBuilder();
				for (int j = 0; j < N; j++) {
					String current = splitContent[i + j];
					if (synMap.containsKey(current)) {
						int key = synMap.get(current);
						tuple.append(key);
					}
					else {
						tuple.append(current);
					}
				}
				nTuple.add(tuple.toString());
			}
		return nTuple;
	}
}
