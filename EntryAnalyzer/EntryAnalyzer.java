package EntryAnalyzer;

import java.io.FileNotFoundException;
import java.util.Scanner;//Step 1
import java.io.File;//Step 1 & 2
import java.util.List;//Step 2
import java.util.ArrayList;//Step 2
import EntryAnalyzer.table;//Step 4

	/*PSEUDO CODE:
		1) Check if the file path exists, otherwise ask again
		2) Convert file into String array or other elements
		3) Split String by punctuation marks & spaces
		4) Count each time a word is used
			?5) remove common grammatical words such as 'the' and 'a', for example
			?6) Save data & output it as a .csv
		7) Print results
	*/

public class EntryAnalyzer {
	public static void main(String [] args) throws FileNotFoundException {
		EntryAnalyzer entryAnalyzer = new EntryAnalyzer();
		entryAnalyzer.start();
	}

	void start() throws FileNotFoundException {
		File prompt = validatePath();	
		String[] promptArray = loadFile(prompt);
		table[] results = hitCount(promptArray);
	
		//debug
		System.out.println(promptArray[0]);	
		System.out.println("If you've reached this line this program has run succesfully");
	}

	//Step 1
	File validatePath() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the file name:\n");
		
		while (true) {
			File fileName = new File(scanner.nextLine());

			if (fileName.exists() && !fileName.isDirectory()) {
				return fileName;
				} else {
				System.out.println("ERROR: File does not exist.  Please enter a new filename.");
			}
		}
	}

	//Step 2
	String[] loadFile(File file) throws FileNotFoundException {
		List<String> list = new ArrayList<String>();
		Scanner sc = new Scanner(file);
		String[] punctuation = {",", ".", ":", ";", "(", ")", "\"", "\'", "!", "?"};//NOTE remember to add more marks later
		
		while (sc.hasNextLine()) {
			list.add(sc.nextLine());
		}

		//Step 3
		String[] splitEntry = list.toArray(new String[0])[0].replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");//I can't believe this line worked

		return splitEntry;
	}

	//Step 4
	table[] hitCount(String[] array) {
		int i = 0;
		ArrayList<String> diffNum = new ArrayList<>();

		for (int j = 0; j <array.length; j++) {
			if(!diffNum.contains(array[j])) {
				diffNum.add(array[j]);
			}
		}
		
		i = diffNum.size();
		System.out.println(i);//debug

		table[] hitCounter = new table[i];

		return hitCounter;
	}
	
}
