package plagdect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class SynonymMap {

	public static HashMap<String, Integer> generate(String syn) {
		//unique key for each line of synonyms passed in
		int marker = 0;
		HashMap<String, Integer> synMap = new HashMap<String, Integer>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(syn));
			String line = br.readLine();
			//each line is stemmed and all synonym words on the line are hashed according to unique key
			while (line != null) {
				String[] lineSplit = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
				for (int i = 0; i < lineSplit.length; i++) {
					synMap.put(lineSplit[i], marker);
				}
				marker++;
				line = br.readLine();
			}
		}
		catch (Exception e) {
			System.out.println("Problem reading and processing synonym file");
			e.printStackTrace();
		}
		finally {
			if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Problem closing BufferedReader for synonym file");
				e.printStackTrace();
			}
			}
		}
		return synMap;
	}
}
