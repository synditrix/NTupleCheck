package plagdect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PlagiarismDetector {
	
	private HashMap<String, Integer> synMap; 
	private ArrayList<String> file1tup;
	private ArrayList<String> file2tup;

	public PlagiarismDetector(String syn, String file1, String file2, int N) throws IOException {
		synMap = SynonymMap.generate(syn);
		file1tup = NTupleList.generate(file1, N, synMap);
		file2tup = NTupleList.generate(file2, N, synMap);
	}
	
	//empty constructor for testing purposes
	public PlagiarismDetector() {
		
	}
	
	//calculates percentage of plagiarism
	public String plagPerc() {
		double count = 0; 
		for (int i = 0; i < file1tup.size(); i++) {
			for (int j = 0; j < file2tup.size(); j++) {
				if (file1tup.get(i).equals(file2tup.get(j))) {
					count++;
					break;
				}
			}
		}
		double percent = (count / file2tup.size()) * 100;
		return Math.round(percent) + "%";
	}
	
	//setters for testing purposes
	public void setMap(HashMap<String, Integer> map) {
		synMap = map;
	}

	public void setFile1(ArrayList<String> file1) {
		file1tup = file1;
	}
	
	public void setFile2(ArrayList<String> file2) {
		file2tup = file2;
	}
	
}
