import java.io.FileNotFoundException;
import java.util.Scanner;//Step 1
import java.io.File;//Step 1 & 2
import java.util.List;//Step 2
import java.util.ArrayList;//Step 2

	//This code requires the use of Apache Libraries.

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
	public static void main(String [] args) {
		EntryAnalyzer entryAnalyzer = new EntryAnalyzer();
		entryAnalyzer.start();
	}

	void start() {
		//TODO

		File prompt = validatePath();	
		String[] promptArray = loadFile(prompt);
			
		//debug
		System.out.println(prompt);	
		System.out.println("If you've reached this line this program has run succesfully");

	}

	//Step 1
	File validatePath() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the file name:\n");
		
		while (true) {
			File fileName = new File("/Users/Lex/Documents/Programs/EntryAnalyzer/"+scanner.next());//This current path is just for testing

			//System.out.println(fileName);//debug
			if (fileName.exists() && !fileName.isDirectory()) {
				//break;
				return fileName;
				} else {
				System.out.println("ERROR: File does not exist.  Please enter a new filename.");
			}
		}

		//return fileName;
		
	}

	//Step 2
	String[] loadFile(File file) {
		List<String> entry = new ArrayList<String>();
			
		while (file.hasNextLine()) {
			entry.add(file.nextLine());
		}

		//Step 3
		String[] punctuation = {",", ".", ":", ";", "(", ")", "\"", "\'", "!", "?"};//NOTE remember to add more marks later
		for (int j = 0; j <punctuation.length; j++) {
			String a = punctuation[j];
			entry = entry.replace(punctuation[j],"");
		}
		
		String[] strArray = entry.split(" ");

		return strArray;
	}

	//Step 4
	

	
}
