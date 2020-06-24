
public class SortArray {

	// Sort first middle last
	public static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
		if(a[first].compareTo(a[mid]) == 1 && a[first].compareTo(a[last]) == 1) {
			T temp;
			temp = a[last];
			a[last] = a[first];
			a[first] = temp;
		}else if(a[mid].compareTo(a[first]) == 1 && a[mid].compareTo(a[last]) == 1) {
			T temp;
			temp = a[last];
			a[last] = a[mid];
			a[mid] = temp;
		}
		if(a[first].compareTo(a[mid])==1) {
			T temp;
			temp = a[mid];
			a[mid] = a[first];
			a[first] = temp;
		}
	}
	
	// Partition
	public static <T extends Comparable<? super T>> int partition(T[] a, int first, int last) {
		int mid = (first + last)/2;
		sortFirstMiddleLast(a,first,mid,last);
		
		T temp = a[last-1];
		a[last-1] = a[mid];
		a[mid] = temp;
		
		int pivotIndex = last-1;
		T pivotValue = a[pivotIndex];
		
		int indexFromLeft = first +1;
		int indexFromRight = last -2;
		boolean done = false;
		
		while(!done){
			while(a[indexFromLeft].compareTo(pivotValue) == -1) {
				indexFromLeft++;
			}
			while(a[indexFromRight].compareTo(pivotValue) == 1) {
				indexFromRight--;
			}
			if(indexFromLeft < indexFromRight) {
				T t = a[indexFromLeft];
				a[indexFromLeft] = a[indexFromRight];
				a[indexFromRight] = t;
				indexFromLeft++;
				indexFromRight--;
			}else {
				done = true;
			}
		}
		
		T k = a[indexFromLeft];
		a[indexFromLeft] = a[pivotIndex];
		a[pivotIndex] = k;
		pivotIndex = indexFromLeft;
		return pivotIndex;
	}
	
	// Quick Sort
	public static <T extends Comparable<? super T>> void quickSort(T[] a, int first, int last) {
		if(last - first +1 <= 4) {
			insertionSort(a,first,last);
		}else {
			int pivotIndex = partition(a,first,last);
			quickSort(a,first,pivotIndex-1);
			quickSort(a,pivotIndex+1,last);
		}
	}
	
	// Insertion Sort
	public static <T extends Comparable<? super T>> void insertionSort(T[] a, int first, int last) {
		for(int unsorted = first+1 ; unsorted <= last; unsorted++) {
			T nextToInsert = a[unsorted];
			insertInOrder(nextToInsert,a,first,unsorted-1);
		}
	}
	
	// InsertInOrder
	public static <T extends Comparable<? super T>> void insertInOrder(T anEntry, T[] a,int begin,int end) {
		int index = end;
		while((index>=begin)&&(anEntry.compareTo(a[index])== -1)) {
			a[index+1] = a[index];
			index--;
		}
		a[index+1] = anEntry;
	}
	
	// Main
public static void main(String[] args) {
		
		for(int n = 10000; n <= 100000; n *= 10) {
			int ssn = 0;

			Employee[] employees = new Employee[n];
			Employee[] tempEmployees = new Employee[n];
	      	
	      	for (int i = 0;i<n;i++) {
	      		SalariedEmployee entry = new SalariedEmployee("","",ssn,1,1,1,1,1,1,1,1,1,true,0);
	      		employees[i] = entry;
	      		tempEmployees[i] = entry;
	      		ssn ++;
			  }

	      	
			// sort sorted 
			long startTimeOfSortedInsertion = System.currentTimeMillis();
			
			insertionSort(employees,0,n-1);
			
			long endTimeOfSortedInsertion = System.currentTimeMillis();
			
			// sort sorted
			long startTimeOfSortedQuick = System.currentTimeMillis();
						
			quickSort(tempEmployees,0,n-1);
						
			long endTimeOfSortedQuick = System.currentTimeMillis();
			
			long TimeOfSortedQuick = endTimeOfSortedQuick - startTimeOfSortedQuick;
			
			long TimeOfSortedInsertion = endTimeOfSortedInsertion - startTimeOfSortedInsertion;
			
			
			
			
			//----------------------------------------------------------------------------
			
			
			Employee[] unsortedEmployees = employees;
			Employee[] tempUnsortedEmployees = tempEmployees;
			 
			
			// swap
	      	for (int j = 0;j<n/2;j++) {
	      		// make random index
	      		double dValue = Math.random();
	            int index = (int)(dValue * n);
	            
	    		Employee k = unsortedEmployees[j];
	            unsortedEmployees[j] = unsortedEmployees[index];
	    		unsortedEmployees[index] = k;
	    		
	    		Employee q = tempUnsortedEmployees[j];
	            tempUnsortedEmployees[j] = tempUnsortedEmployees[index];
	    		tempUnsortedEmployees[index] = q;
	      	}

			// sort unsorted
			long startTimeOfUnsortedQuick = System.currentTimeMillis();
			
			quickSort(tempUnsortedEmployees,0,n-1);
			
			long endTimeOfUnsortedQuick = System.currentTimeMillis();
			
			// sort unsorted 
			long startTimeOfUnsortedInsertion = System.currentTimeMillis();
						
			insertionSort(unsortedEmployees,0,n-1);
						
			long endTimeOfUnsortedInsertion = System.currentTimeMillis();
			
			
			long TimeOfUnsortedInsertion = endTimeOfUnsortedInsertion - startTimeOfUnsortedInsertion;
			
			long TimeOfUnsortedQuick = endTimeOfUnsortedQuick - startTimeOfUnsortedQuick;


			System.out.println("----------------------------------------");
			System.out.println("Insertion Sort (Sorted) ("+ n +") : " + TimeOfSortedInsertion/1000.0f + "段");
			System.out.println("Insertion Sort (Unsorted) ("+ n +") : " + TimeOfUnsortedInsertion/1000.0f + "段");
			System.out.println("Quick Sort (Sorted)     ("+ n +") : " + TimeOfSortedQuick/1000.0f + "段");
			System.out.println("Quick Sort (Unsorted)     ("+ n +") : " + TimeOfUnsortedQuick/1000.0f + "段");
		}
		System.out.println("----------------------------------------");
	}

}
