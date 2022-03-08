// Java Program to illustrate reading from Text File 
// using Scanner Class 
// https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
// https://stackoverflow.com/questions/225337/how-to-split-a-string-with-any-whitespace-chars-as-delimiters
// http://pages.cs.wisc.edu/~hasti/cs302/examples/Parsing/parseString.html
// https://www.javatpoint.com/java-string-to-int

import java.io.File; 
import java.util.Scanner; 
import java.nio.file.Files;
import java.util.stream.Stream;
import java.nio.file.Paths;

public class ReadFromFile {

	/**
	 * 
	 * @param filename	String	holds path name of file to be read
	 * @return			Library[]	returns an array holding all the data that was read
	 * 					from the file
	 */
	public static Library[] readFile(String filename)	throws Exception {	

		
		int noOfLines = 0;		
		// Retrieve number of lines from file
		// https://www.baeldung.com/java-file-number-of-lines
		try  {
			Stream<String> fileStream = Files.lines(Paths.get(filename));
			noOfLines = (int) fileStream.count();	
			System.out.println("Lines: " + noOfLines);
		
			// Instantiate a data array of exactly the correct size
			Library[] libs = new Library[noOfLines];			
			int curIndex = 0;

			// Open file
			File file = new File(filename); 
			// Pass the path to the file as a parameter 
			Scanner sc = new Scanner(file); 

			// Loop until end of file
			while (sc.hasNextLine()) {
				String line = sc.nextLine();				// Get one line of data
//				System.out.println(line);					// Debugging statement
				
				// Data fields are separated by tabs
				// Split one line into 8 Strings
				String tokens[] = line.split("[\\t]+");		

				// tokens[0] - String	state
				// tokens[1] - String	branch
				// tokens[2] - String	city
				// tokens[3] - String	zip
				// tokens[4] - String	county
				// tokens[5] - String	squareFeet (convert from digits to int)
				// tokens[6] - String	hoursOpen (convert from digits to int)
				// tokens[7] - String	weeksOpen (convert from digits to int)

				// Convert numbers from Strings of digits to ints  
				int squareFeet = Integer.parseInt(tokens[5]);
				int hoursOpen = Integer.parseInt(tokens[6]);
				int weeksOpen = Integer.parseInt(tokens[7]);			

				// Add one Library object to the array of Library objects
				libs[curIndex++] = new Library (tokens[0], tokens[1], tokens[2],
						tokens[3], tokens[4], squareFeet, hoursOpen, weeksOpen);
			}

			// Return the data array
			return libs;

		} catch (Exception e)	{
			throw e;		// Pass exception up to calling method
		}

	}
		
	/** This is a test program to make sure that readFile works properly
	 * 
	 * @param args
	 */
	public static void main (String[] args)	{
		
		Library[] arrayToBeSorted = null;  // Will hold all data read from file, size unknown
		
		try	{
			// Read the file and return an array holding the data
			arrayToBeSorted = ReadFromFile.readFile ("Libraries Data.txt");
		} catch (Exception e)	{
			System.out.println("Something went wrong while reading the file\n"+e);
		}
		
		// Report on the number of records read and print a few data items
		System.out.println ("Length: " + arrayToBeSorted.length);
		for (int i=0; i < 10; i++)
			System.out.println(arrayToBeSorted[i]);
	}
}
