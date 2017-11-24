import java.io.Reader;
import java.util.Scanner;
import java.io.File;

	/*PSEUDO CODE:
		1) Check if the file path exists, otherwise ask again
		2) Convert file into String array or other elemtn
			?3) Split String by punctuation marks & spaces
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
		EntryAnalyzer.validatePath();
	}

	//Step 1
	boolean validatePath() { //Checks if the file name is valid and then converts it into an element (string or array?)
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the file name:+\n");
			
		while (true) {
			File fileName = new File("~/Documents/Programs/EntryAnalyzer"+scanner.next());//This current path is just for testing
			if (fileName.exists() && !fileName.isDirectory()) {  //if the file doesn't exist, print error and make user enter new file
				continue;
			} else {
				System.out.println("ERROR: File does not exist.  Please enter a new filename.");
				break;
			}
		}
		
		return true;
	}
}
