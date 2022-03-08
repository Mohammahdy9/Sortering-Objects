/* 
 * Original quickSort() code found at https://www.baeldung.com/java-quicksort
 * Original merge(), mergeSort(), partition(), and insertionSort() code found in week 8 code folder authored by Sue Fitzgerald
 * 
 */

public class Sorter {
	
	/**
	 * Quicksort recursively organizes data into partitions, reducing the entropy of the data with
	 * each round
	 * 
	 * @param arr	array of integer data to be sorted
	 * @param begin	index of beginning of this partition
	 * @param end	index of the end of this partition
	 */
	public static void quickSort(int arr[], int begin, int end) {
	    
		// Stop when beginning index >= ending index
		if (begin < end) {
			
			// Reorganize the data into 2 parts - <= pivot and > pivot
	        int partitionIndex = partition(arr, begin, end);
	 
	        // Recursively sort each partition
	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
	
	/** 
	 * partition() reorganizes the data into two partitions - one < the pivot and one > the pivot
	 * 
	 * @param arr	Array of data to be sorted
	 * @param begin	Index of beginning of partition
	 * @param end	Index of end of partition
	 * @return		Returns index of new pivot point
	 */
	private static int partition(int arr[], int begin, int end) {
		
		// Pivot arbitrarily chosen as last element in the array
	    int pivot = arr[end];
	    int i = (begin-1);		// partition < pivot
	 
	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {		// if element < pivot
	            i++;					// increase size of < partition
	 
	            int swapTemp = arr[i];	// swap from > partition to < partition
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }
	 
	    // Move pivot to end of < partition
	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;
	 
	    // Return index of pivot
	    return i+1;
	}
	public static void merge(int[] data, int first, int n1, int n2){	
		int[] temp = new int[n1+n2];
		int p1 = 0, p2 = 0, p = 0;
		
		while ((p1 < n1) && (p2<n2)){
			if (data[first+p1] < data[first+n1+p2]) {
				temp[p] = data[first+p1]; p++; p1++;
			}else{
				temp[p] = data[first+n1+p2]; p++; p2++;
			}
		}
		
		//copy the remaining elements from the first half 
		while (p1 < n1){
			temp[p] = data[first+p1]; p++; p1++;
		}	
		
		// copy back from temp array to the original array
		for (int i=0; i < p; i ++)
			data[first+i] = temp[i];
	}
	
	public static void mergeSort(int[]data, int first, int n){
		int n1; //size of the first half of the array
		int n2; //size of the second half of the array
		if (n > 1){
			n1 = n/2;
			n2 = n - n1;
			//sort data[first]...data[first+n1]
			mergeSort(data,first,n1); 
			//sort data[first+n1+1] to the end
			mergeSort(data,first+n1,n2); 
			//merge the two sorted halves
			merge(data,first,n1,n2);
		}
	}
	
	public static void insertionSort(int[] data, int N){

		for ( int i = 1; i < N; i++){
			int element = data[i];
			int j = i;

			// shift elements to the right as long as they are
			// greater than element
			for (j = i; j > 0 && data[j-1] > element ; j--)
				data[j] = data[j-1];

			// insert the data element
			data[j] = element;
		}
	}
	
	
	/** This main() method tests quickSort() with a short list of numbers
	 * 
	 * @param args
	 */
	public static void main (String args[])	{
		
		int mergeData[] = {10, 100, 52, 90, 40, 32, 1, 8, 200, 16, 83};
		int quickData[] = {10, 100, 52, 90, 40, 32, 1, 8, 200, 16, 83};
		int insertionData[] = {10, 100, 52, 90, 40, 32, 1, 8, 200, 16, 83};
		
		int size = mergeData.length;
		
		//	     		Testing mergeSort()               //
		///////////////////////////////////////////////////
		
		System.out.println("\nBefore: mergeSort()");
		for (int i=0; i < size; i++)
			System.out.println(mergeData[i]);
		
		Sorter.mergeSort(mergeData, 0, size);
		
		System.out.println("After: mergeSort()");
		for (int i=0; i < size; i++)
			System.out.println(mergeData[i]);
		
		for (int i=0; i < size-1; i++)
			assert(mergeData[i] < mergeData[i+1]);
		
		// 				Testing quickSort()               //
		///////////////////////////////////////////////////
		
		System.out.println("\nBefore: quickSort()");
		for (int i=0; i < size; i++)
			System.out.println(quickData[i]);
		
		Sorter.quickSort(quickData, 0, size-1);

		System.out.println("After: quickSort()");
		for (int i=0; i < size; i++)
			System.out.println(quickData[i]);
		
		for (int i=0; i < size-1; i++)
			assert(quickData[i] < quickData[i+1]);
		
		// 				Testing insertionSort()           //
		///////////////////////////////////////////////////
		
		System.out.println("\nBefore: insertionSort()");
		for (int i=0; i < size; i++)
			System.out.println(insertionData[i]);
		
		Sorter.insertionSort(insertionData,size);

		System.out.println("After: insertionSort()");
		for (int i=0; i < size; i++)
			System.out.println(insertionData[i]);
		
		for (int i=0; i < size-1; i++)
			assert(insertionData[i] < insertionData[i+1]);
		
	}
}
