/* 
 * Original quickSort() code found at https://www.baeldung.com/java-quicksort
 * Original merge(), mergeSort(), partition(), and insertionSort() code found in week 8 code folder authored by Sue Fitzgerald
 * 
 */
public class MySorter {
	
	/**
	 * Quicksort recursively organizes data into partitions, reducing the entropy of the data with
	 * each round
	 * 
	 * @param arr	array of integer data to be sorted
	 * @param begin	index of beginning of this partition
	 * @param end	index of the end of this partition
	 */
	public static void quickSort(Library[] data, int begin, int end) {
	    
		// Stop when beginning index >= ending index
		if (begin < end) {
			
			// Reorganize the data into 2 parts - <= pivot and > pivot
	        int partitionIndex = partition(data, begin, end);
	 
	        // Recursively sort each partition
	        quickSort(data, begin, partitionIndex-1);
	        quickSort(data, partitionIndex+1, end);
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
	private static int partition(Library data[], int begin, int end) {
		
		// Pivot arbitrarily chosen as last element in the array
	    Library pivot = data[end];
	    int i = (begin-1);		// partition < pivot
	 
	    for (int j = begin; j < end; j++) {
	        if (data[j].compareTo(pivot)<=0) {		// if element < pivot
	            i++;					// increase size of < partition
	 
	            Library swapTemp = data[i];	// swap from > partition to < partition
	            data[i] = data[j];
	            data[j] = swapTemp;
	        }
	    }
	 
	    // Move pivot to end of < partition
	    Library swapTemp = data[i+1];
	    data[i+1] = data[end];
	    data[end] = swapTemp;
	 
	    // Return index of pivot
	    return i+1;
	}
	
	public static void merge(Library[] data, int first, int n1, int n2){	
		Library[] temp = new Library[n1+n2];
		int p1 = 0, p2 = 0, p = 0;
		
		while ((p1 < n1) && (p2<n2)){
			if (data[first+p1].compareTo(data[first+n1+p2])<0) {
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
	
	public static void mergeSort(Library[]data, int first, int n){
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
	
		public static void insertionSort(Library[] data, int n){

			for ( int i = 1; i < n; i++){
				Library element = data[i];
				int j = i;

				// shift elements to the right as long as they are
				// greater than element
				for (j = i; j > 0 && data[j-1].compareTo(element)>0 ; j--)
					data[j] = data[j-1];

				// insert the data element
				data[j] = element;
			}
	}

	public static void main(String[] args) {
		
		Library n = new Library("MN", "North Branch", "Blaine", "55448", "Anoka", 100, 7, 5);
		Library s = new Library("TX", "South Branch", "Dallas", "54541","South", 200, 7, 5);
		Library w = new Library("NC", "West Branch", "Raleigh", "70654", "West", 300, 8, 5);
		Library e = new Library("FL", "East Branch", "Miami", "90431", "East", 400, 8, 7);
		
		Library libMerge[] = {n,s,w,e};	
		Library libQuick[] = {n,s,w,e};
		Library libInsertion[] = {n,s,w,e};
		int size = libMerge.length;
	
		//			     Testing mergeSort()              //
		///////////////////////////////////////////////////
		
		System.out.println("\nBefore: mergeSort()");
		for (int i=0; i < size; i++)
			System.out.println(libMerge[i]);
		
		MySorter.mergeSort(libMerge, 0, size);
		
		System.out.println("After: mergeSort()");
		for (int i=0; i < size; i++)
			System.out.println(libMerge[i]);
		
		for (int i=0; i < size-1; i++)
			assert(libMerge[i].compareTo(libMerge[i+1])<=0);
		
		// 				Testing quickSort()               //
		///////////////////////////////////////////////////
		
		System.out.println("\nBefore: quickSort()");
		for (int i=0; i < size; i++)
			System.out.println(libQuick[i]);
		
		MySorter.quickSort(libQuick, 0, size-1);
		
		System.out.println("After: quickSort()");
		for (int i=0; i < size; i++)
			System.out.println(libQuick[i]);
		
		for (int i=0; i < size-1; i++)
			assert(libQuick[i].compareTo(libQuick[i+1])<=0);
		
		//			 Testing insertionSort()              //
		///////////////////////////////////////////////////

		System.out.println("\nBefore: insertionSort()");
		for (int i=0; i < size; i++)
			System.out.println(libInsertion[i]);

		MySorter.insertionSort(libInsertion,size);

		System.out.println("After: insertionSort()");
		for (int i=0; i < size; i++)
			System.out.println(libInsertion[i]);

		for (int i=0; i < size-1; i++)
			assert(libInsertion[i].compareTo(libInsertion[i+1])<=0);
		
	}

}
