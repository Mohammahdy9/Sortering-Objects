
/** The Driver class includes a main() method which calls the sorting methods and determines
 * how much time it takes to sort
 * 
 * @author 	Sue Fitzgerald and Mohamed Mahdy
 * 			10/13/20
 *
 */

public class Driver {
	public static void main (String[] args)	{
		
		// This line tests to see if asserts are turned on
		// Comment out this line after you see that asserts are turned on
        // assert false;
		Library data[] = null;
		
		try	{
			data = ReadFromFile.readFile ("Libraries Data.txt");
		} catch (Exception e)	{
			System.out.println("Something went wrong while reading the file\n"+e);
		}
		
		// Decide how many items to sort
		int numToSort = 16000;  
		long begin = System.currentTimeMillis(); 	// start time	
		
					//Testing Methods//
		///////////////////////////////////////////
		
		MySorter.quickSort (data, 0, numToSort-1);
		MySorter.mergeSort(data, 0, numToSort);
		MySorter.insertionSort(data, numToSort);
		
		long end = System.currentTimeMillis(); 		// end time
		// Display elapsed time
		System.out.println("Size: " + numToSort + "\tTime in ms: " + (end-begin));	

		// Make sure the list is correctly sorted
		// You must enable asserts for this test to work.  
		// See D2L - Content | Programming Assignments | Program 2 | Using Asserts to Test Your Program
		// The file is attached to the assignment
		for (int i=0; i < numToSort-1; i++)	{			
			//System.out.println(data[i]);
			assert (data[i].compareTo(data[i+1]) <= 0);
		}
		
	}
}
