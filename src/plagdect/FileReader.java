package plagdect;

import java.io.IOException;

public class FileReader {
	public static void main(String[] args) throws IOException {
		//prints out brief usage instructions if 0 arguments 
		if (args.length == 0) {
			System.out.println("Use this NTuple plagiarism checker by putting in the following"
					+ " arguments in order: args[0] = filename of synonym list;"
					+ " args[1] = filename of first file; "
					+ "args[2] = filename of second file; "
					+ "(optional) args[3] = size of N for NTuple generation");
		}
		//throws exception if # arguments provided not 3 or 4
		if (args.length != 3 && args.length != 4) {
			throw new IllegalArgumentException("Wrong number of arguments");
		}
		//tuple size set to 3 by default, else if optional argument put in, sets tuple size to that number
		int N = 3;
		if (args.length == 4) {
			try {
				N = Integer.parseInt(args[3]);
			}
			catch(NumberFormatException e) {
				System.out.println("Wrong format for argument N");
				e.printStackTrace();
				System.exit(1);
			}
		}
		//creates new plagiarismdetector object from filenames from command line
		String syn = args[0];
		String file1 = args[1];
		String file2 = args[2];
		
		PlagiarismDetector plagDect = new PlagiarismDetector(syn, file1, file2, N);
		System.out.println(plagDect.plagPerc());
	}
}
