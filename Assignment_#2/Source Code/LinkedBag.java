/**
  	A class of bags whose entries are stored in a chain of linked nodes.
 	The bag is never full.
  	@author 20171620 MoonSeongchan
 */
public final class LinkedBag<T> implements BagInterface<T>{
	
	private Node firstNode;		// Reference to first node
	private int numberOfEntries;
	
	/** Creates an empty bag whose firstNode is null. */
	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	}	// end default constructor
	
	/** Adds a new entry to this bag.
	 * @param newEntry The object to be added as a new entry.
	 * @return True.	 */
	public boolean add(T newEntry) {
		// Add to beginning of chain:
		Node newNode = new Node(newEntry);
		newNode.setNextNode(firstNode);
		firstNode = newNode;	// New node is at beginning of chain
		numberOfEntries++;
		return true;
	}	// end add
	
	/** Retrieves all entries that are in this bag.
	 * @return A newly allocated array of all the entries in the bag.
	 */
	public T[] toArray() {
		//The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];	// Unchecked cast
		
		int index = 0;
		Node currentNode = firstNode;
		while ((index<numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.getNextNode();
		}	// end while
		
		return result;
	}	// end toArray
	
	/** Counts the number of times a given entry appears in this bag.
	 * @param anEntry The entry to be counted.
	 * @return The number of times anEntry appears in the bag.
	 */
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int loopCounter = 0;
		Node currentNode = firstNode;
		
		while((loopCounter<numberOfEntries)&&(currentNode != null)) {
			if (anEntry.equals(currentNode.data)) {
				frequency++;
			loopCounter++;
			currentNode = currentNode.getNextNode();
		
			}
		}
		return frequency;
	}
	
	/** Check if there is anEntry in this bag.
	 * @param anEntry The entry to be searched.
	 * @return boolean value the result of search.
	 */
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data)) {
				found = true;
			}else {
				currentNode = currentNode.getNextNode();
			}
		}
		return found;
	}
	
	/** Remove one unspecified entry from this bag, if possible
	 * @return Either the removed object, if the removal was successful, or null.
	 */
	public T remove() {
		T result = null;
		if (firstNode != null) {
			result = firstNode.getData();
			firstNode = firstNode.next;
			numberOfEntries--;
		}
		return result;
	}
	
	/** Locates a given entry within this bag.
	 * 	Returns a reference to the node containing the entry, if located, or null otherwise.
	 */
	private Node getReferenceTo(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data)) {
				found = true;
			}else {
				currentNode = currentNode.getNextNode();
			}
		}
		return currentNode;
	}
	
	/** Removes one occurrence of a given entry from this bag, if possible.
	 * 	@param anEntry The entry to be removed.
	 * 	@return True if the removal was successful, or false otherwise.
	 */
	public boolean remove(T anEntry) {
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);
		
		if(nodeN != null) {
			nodeN.data = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
			result = true;
		}
		return result;
	}
	
	/** Returns True if the	bag is empty, or false if not. */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	
	/** Returns current size of bag */
	public int getCurrentSize() {
		return numberOfEntries;
	}

	/** Removes all entries from this bag. */
	public void clear() {
		while(!isEmpty()) {
			remove();
		}
	}
	
	private class Node{
		private T data;		// Entry in bag
		private Node next;	// Link to next Node
		
		private Node(T dataPortion) {
			this(dataPortion,null);
		}	// end default constructor
		
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}	// end constructor
		
		private T getData() {
			return data;
		}
		
		private void setData(T newData) {
			data = newData;
		}
		
		private Node getNextNode() {
			return next;
		}
		
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}	// end Node
}
