
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
		
		for(int n = 100; n <= 100000; n *= 10) {
			int ssn = 0;

			Employee[] employees = new Employee[n]; 
	      	
	      	for (int i = 0;i<n;i++) {
	      		SalariedEmployee entry = new SalariedEmployee("","",ssn,1,1,1,1,1,1,1,1,1,true,0);
	      		employees[i] = entry;
	      		ssn ++;
	      	}
			
	      	for (int j = 0;j<n/2;j++) {
	      		// make random index
	      		double dValue = Math.random();
	            int index = (int)(dValue * n);
	            // swap
	    		Employee k = employees[j];
	            employees[j] = employees[index];
	    		employees[index] = k;
	      	}
	      	
	      	Employee[] tempEmployees = employees;
	      	
			// get running time of insertion sort
			long startTimeOfInsertion = System.currentTimeMillis();
			
			insertionSort(employees,0,n-1);
			
			long endTimeOfInsertion = System.currentTimeMillis();
			
			long TimeOfInsertion = endTimeOfInsertion - startTimeOfInsertion;
			
			//----------------------------------------------------------------------------
			
			// get running time of quick sort
			long startTimeOfQuick = System.currentTimeMillis();
			
			quickSort(tempEmployees,0,n-1);
			
			long endTimeOfQuick = System.currentTimeMillis();
			
			long TimeOfQuick = endTimeOfQuick - startTimeOfQuick;
			
			System.out.println("----------------------------------------");
			System.out.println("Insertion Sort ("+ n +") : " + TimeOfInsertion/1000.0f + "ÃÊ");
			System.out.println("Quick Sort     ("+ n +") : " + TimeOfQuick/1000.0f + "ÃÊ");
		}
		System.out.println("----------------------------------------");
	}

}
