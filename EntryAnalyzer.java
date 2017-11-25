import java.io.Reader;//I forgot
import java.util.Scanner;//Step 1
import java.io.File;//Step 1 & 2
import org.apache.commons.io.FileUtils;//Step 2


	//This code requires the use of Apache Libraries.

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
		File test = validatePath();	
		loadFile(test);//Maybe make validatePath() a File function, which is loaded into loadFile (to convert it to a string)

		//debug
		System.out.println(test);
		System.out.println("If you've reached this line this program has run succesfully");
	}

	//Step 1
	File validatePath() { //Checks if the file name is valid and then converts it into an element (string or array?)
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the file name:\n");
			
		while (true) {
			File fileName = new File("/Users/Lex/Documents/Programs/EntryAnalyzer/"+scanner.next());//This current path is just for testing
			System.out.println(fileName);//debug
			if (fileName.exists() && !fileName.isDirectory()) {
				//break;
				return fileName;
			} else {
				System.out.println("ERROR: File does not exist.  Please enter a new filename.");
				continue;
			}
		}
		
		//return fileName;
	}

	//Step 2
	String loadFile(File foo) {
		String entry = FileUtils.readFileToString(foo);
		

		return entry;
	}
}
