package plagdect;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class PlagiarismDetectorTest {

	//first test provided
	@Test
	public void basicTest100() throws IOException {
		PlagiarismDetector pd = new PlagiarismDetector();
		ArrayList<String> file1 = new ArrayList<String>();
		ArrayList<String> file2 = new ArrayList<String>();
		HashMap<String, Integer> synMap = new HashMap<String, Integer>();
		synMap.put("run", 0);
		synMap.put("sprint", 0);
		synMap.put("jog", 0);
		file1.add("gofora");
		file1.add("fora0");
		file2.add("gofora");
		file2.add("fora0");
		pd.setFile1(file1);
		pd.setFile2(file2);
		pd.setMap(synMap);
		assertTrue(pd.plagPerc().equals("100%"));
	}
	
	//second test provided
	@Test
	public void basicTest50() throws IOException {
		PlagiarismDetector pd = new PlagiarismDetector();
		ArrayList<String> file1 = new ArrayList<String>();
		ArrayList<String> file2 = new ArrayList<String>();
		HashMap<String, Integer> synMap = new HashMap<String, Integer>();
		synMap.put("run", 0);
		synMap.put("sprint", 0);
		synMap.put("jog", 0);
		file1.add("gofora");
		file1.add("fora0");
		file2.add("wentfora");
		file2.add("fora0");
		pd.setFile1(file1);
		pd.setFile2(file2);
		pd.setMap(synMap);
		assertTrue(pd.plagPerc().equals("50%"));
	}

}
