import java.util.Arrays;

/**
 * A class of bags whose entries are stored in a fixed-size array.
 * @author 20171620 MoonSeongchan
 */
public final class ArrayBag<T> implements BagInterface<T> {
	
	private T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;
	private boolean initialized = false;
	private static final int MAX_CAPACITY = 10000;
	
	/** Creates an empty bag whose capacity is 25. */
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	
	/** Creates an empty bag having a given capacity
	 	@param desiredCapacity The integer capacity desired.
	 */
	public ArrayBag(int desiredCapacity) {
		if (desiredCapacity <= MAX_CAPACITY) {
			// The cast is safe because the new array contains null entries.
			@SuppressWarnings("unchecked")
			T[] tempBag = (T[])new Object[desiredCapacity];
			bag = tempBag;
			numberOfEntries = 0;
			initialized = true;
		}else {
			throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum");
			
		}
	}
	
	/** Throws an exception if this object is not initialized. */
	private void checkInitialization() {
		if (!initialized) {
			throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum");
		}
	}
	
	/** Doubles the size of the array bag.
	 * Precondition: checkInitialization has been called.
	 */
	private void doubleCapacity() {
		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag,newLength);
	}
	
	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY) {
			throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum of "+MAX_CAPACITY);
		}
	}
	
	/** Adds a new entry to this bag.
	 	@param newEntry The object to be added as a new entry.
	 	@return True. */
	public boolean add(T newEntry) 
	{
		checkInitialization();
		if (isArrayFull()) {
			doubleCapacity();
		}
		bag[numberOfEntries] = newEntry;
		numberOfEntries++;
		
		return true;	
	}
	
	/** Returns true if the arraybag is full, or false if not. */
	private boolean isArrayFull() {
		return numberOfEntries >= bag.length;
	}
	
	/** Retrieves all entries that are in this bag.
	 * @return A newly allocated array of all the entries in the bag. */
	public T[] toArray() {
		// The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index ++) {
			result[index] = bag[index];
		}
		return result;
	}
	
	/** Returns True if the bag is empty, or false if not. */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	
	/** Returns current size of bag */
	public int getCurrentSize() {
		return numberOfEntries;
	}
	
	/** Counts the number of times a given entry appears in this bag.
	 * @param anEntry The entry to be counted.
	 * @return The number of times anEntry appears in the bag.
	 */
	public int getFrequencyOf(T anEntry) {
		checkInitialization();
		int counter = 0;
		
		for (int index =0;index < numberOfEntries; index ++) {
			if (anEntry.equals(bag[index])) {
				counter ++;
			}
		}
		return counter;
	}
	
	/** Check if there is anEntry in this bag.
	 * @param anEntry The entry to be searched.
	 * @return boolean value the result of search.
	 */
	public boolean contains(T anEntry) {
		checkInitialization();
		return getIndexOf(anEntry) > -1;
	}
	
	/** Removes all entries from this bag. */
	public void clear() {
		while(!isEmpty()) {
			remove();
		}
	}
	
	/** Removes and returns the entry at a given index within the array bag.
	 * @param givenIndex
	 * @return entry to be removed, if no such entry exists, returns null.
	 */
	private T removeEntry(int givenIndex) {
		T result = null;
		if (!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex];
			bag[givenIndex] = bag[numberOfEntries-1];
			bag[numberOfEntries-1] = null;
			numberOfEntries--;
		}
		return result;
	}
	
	/** Locates a given entry within the array bag.
	 * @param anEntry The entry to be removed.
	 * @return the index of the entry, if located, or -1 otherwise. */
	private int getIndexOf(T anEntry) {
		int where = -1;
		boolean found = false;
		int index = 0;
		while(!found && (index < numberOfEntries)) {
			if (anEntry.equals(bag[index])) {
				found = true;
				where = index;
			}
			index++;
		}
		return where;
	}
	
	/** Remove one unspecified entry from this bag, if possible
	 * @return Either the removed entry, if the removal was successful, or null otherwise.
	 */
	public T remove() {
		checkInitialization();
		T result =  removeEntry(numberOfEntries-1);
		return result;
	}
	
	/** Removes one occurrence of a given entry from this bag, if possible.
	 * @param anEntry The entry to be removed.
	 * @return True if the removal was successful, or false if not.
	 */
	public boolean remove(T anEntry) {
		checkInitialization();
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	}
}
