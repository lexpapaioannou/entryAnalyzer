package EntryAnalyzer;

import java.io.FileNotFoundException;//Step 1
import java.io.IOException;//Step 6
import java.io.File;//Step 1 & 2
import java.io.PrintWriter;//Step 6
import java.util.List;//Step 2
import java.util.Scanner;//Step 1
import java.util.ArrayList;//Step 2
//import java.util.Collections;//Step 5
import java.util.Arrays;//Step 5
import java.lang.Character;//Step 7
import EntryAnalyzer.table;//Step 4

	/*Known bugs:
		*Entries with multiple paragraphs are ignored with exception to the first paragraph
			This is probably a bug in Step 2, within the while loop
	*/

	/*PSEUDO CODE:
		1) Check if the file path exists, otherwise ask again
		2) Convert file into String array or other elements
		3) Split String by punctuation marks & spaces
		4) Count each time a word is used
		5) remove common grammatical words such as 'the' and 'a', for example
		6) Save data & output it as a .csv
		7) Print results
	*/

public class EntryAnalyzer {
	public static void main(String [] args) throws FileNotFoundException, IOException{
		(new EntryAnalyzer()).start();
	}

	void start() throws FileNotFoundException, IOException{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the file name:");
		while(true) {
			File name = new File(scan.nextLine());
			if(!validatePath(name)) {
				System.out.println("ERROR: File not found.  Please try again.");
				continue;
			}
			table[] results = hitCount(loadFile(name));
			output(results, name.toString());		

			//Step 7
			System.out.println("Do you want to print your results?  (y/n)");
			char p = scan.next().charAt(0);
			p = Character.toLowerCase(p);
			if (p == 'y') {
				for (int i = 0; i < results.length; i++){
					System.out.println(results[i].getLabel());	
					System.out.println(results[i].getHits());
					System.out.println("\n");
				}
			} else if (p != 'n') {
				System.out.println("Please try again.");
				continue;
			}
			System.exit(0);
		}
	}

	//Step 1
	boolean validatePath(File fileName) {
		if (fileName.exists() && !fileName.isDirectory()) {
			return true;
		}
		return false;
	}

	//Step 2
	String[] loadFile(File file) throws FileNotFoundException {
		List<String> list = new ArrayList<String>();
		Scanner sc = new Scanner(file);
		
		if (sc.hasNextLine()) {
			list.add(sc.nextLine());
		} else if (!sc.hasNextLine()) {
			System.out.println("MISS");
		}
		
		//Step 3
		String[] splitEntry = list.toArray(new String[0])[0].replaceAll("-" ," ").replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");//I can't believe this line worked

		return splitEntry;
	}

	//Step 4
	table[] hitCount(String[] array) {
		int i = 0;
		ArrayList<String> diffNum = new ArrayList<>();
		ArrayList<Integer> hits = new ArrayList<>();
		String[] commonWords = {"", "is", "this", "a", "the", "or", "as", "of", "to", "and", "for"};

		for (int j = 0; j <array.length; j++) {
			if(!diffNum.contains(array[j])) {
				diffNum.add(array[j]);
				hits.add(1);
			} else {
				for (int f = 0; f<diffNum.size(); f++) {
					if (diffNum.get(f).equals(array[j])) {
						int k = hits.get(f);
						hits.set(f, k + 1);
					}
				}
			}
		}
		
		i = diffNum.size();
		table[] hitCounter = new table[i];

		for (int k = 0; k <hitCounter.length; k++) {
			hitCounter[k] = new table();
		}
		
		for (int k = 0; k <i; k++) {
			hitCounter[k].setLabel(diffNum.get(k));
			hitCounter[k].setHits(hits.get(k));
		}

		//Step 5
		for (int k = 0; k <hitCounter.length; k++) {
			for (int j = 0; j <commonWords.length; j++) {
				if (hitCounter[k].getLabel().equals(commonWords[j])) {
					//Collections.rotate(hitCounter[k], -1);
					hitCounter[k].removeEntry(hitCounter[k].getLabel());
				}
			}
		}

		return hitCounter;
	}

	//Step 6
	public void output(table[] data, String fileName) throws IOException {
		fileName = fileName.replace(".txt","");
		PrintWriter writer = new PrintWriter(new File(fileName+"WordCount.csv"));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i <data.length; i++) {
			sb.append(data[i].getLabel()+","+data[i].getHits()+",\n");
		}

		writer.write(sb.toString());
		writer.close();
	}
	
}
