import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


// Author Dylan Clements, collaborated with Garrett Greenfield

/**
 * TODO: Complete the implementation of this class.
 * 
 * The keys in the heap must be stored in an array.
 * 
 * There may be duplicate keys in the heap.
 * 
 * The constructor takes an argument that specifies how objects in the 
 * heap are to be compared. This argument is a java.util.Comparator, 
 * which has a compare() method that has the same signature and behavior 
 * as the compareTo() method found in the Comparable interface. 
 * 
 * Here are some examples of a Comparator<String>:
 *    (s, t) -> s.compareTo(t);
 *    (s, t) -> t.length() - s.length();
 *    (s, t) -> t.toLowerCase().compareTo(s.toLowerCase());
 *    (s, t) -> s.length() <= 3 ? -1 : 1;  
 */

public class Heap<E> implements PriorityQueue<E> {
  protected List<E> keys;
  private Comparator<E> comparator;
  
  /**
   * TODO
   * 
   * Creates a heap whose elements are prioritized by the comparator.
   */
  public Heap(Comparator<E> comparator) {
    this.keys = new ArrayList<>();
    this.comparator = comparator;
  }

  /**
   * Returns the comparator on which the keys in this heap are prioritized.
   */
  public Comparator<E> comparator() {
    return comparator;
  }

  /**
   * TODO
   * 
   * Returns the top of this heap. This will be the highest priority key. 
   * @throws NoSuchElementException if the heap is empty.
   */
  public E peek() {
	  if(keys.isEmpty())
		  throw new NoSuchElementException();
	  return keys.get(0);
  }

  /**
   * TODO
   * 
   * Inserts the given key into this heap. Uses siftUp().
   */
  public void insert(E key) {
	  keys.add(key);
	  this.siftUp(this.size() - 1);
  }

  /**
   * TODO
   * 
   * Removes and returns the highest priority key in this heap.
   * @throws NoSuchElementException if the heap is empty.
   */
  public E delete() {
	  if(keys.isEmpty())
		  throw new NoSuchElementException();
	  if(this.size() == 1)
		  return keys.remove(0);
	  E r = keys.remove(0);
	  E last = keys.remove(keys.size() - 1);
	  keys.add(0, last);
	  siftDown(0);
	  return r;
  }

  /**
   * TODO
   * 
   * Restores the heap property by sifting the key at position p down
   * into the heap.
   */
  
  public void siftDown(int p) {
    if(getLeft(p) >= size() && getRight(p) >= size())
    	return;
    int leftChild=getLeft(p), maxChild = 0;
    if(getRight(p) >= size())
    	maxChild = leftChild;
    else{
    	maxChild = Math.max(leftChild, getRight(p));
    }
    if(comparator.compare(keys.get(maxChild),keys.get(p)) < 0){
    	this.swap(maxChild, p);
    	siftDown(p);
    }
  }
  
  /**
   * TODO
   * 
   * Restores the heap property by sifting the key at position q up
   * into the heap. (Used by insert()).
   */
  public void siftUp(int q) {
	  int parent = getParent(q);
	  if(q == 0)
	    	return;
	  if(comparator.compare(keys.get(parent),keys.get(q)) > 0){
	    	this.swap(parent, q);
	    	siftUp(parent);
	    }
  }

  /**
   * TODO
   * 
   * Exchanges the elements in the heap at the given indices in keys.
   */
  public void swap(int i, int j) {
	  Collections.swap(keys, i,j);
  }
  
  /**
   * Returns the number of keys in this heap.
   */
  public int size() {
    return keys.size();
  }

  /**
   * Returns a textual representation of this heap.
   */
  public String toString() {
    return keys.toString();
  }
  
  /**
   * TODO
   * 
   * Returns the index of the left child of p.
   */
  public static int getLeft(int p) {
    return p*2 + 1;
  }

  /**
   * TODO
   * 
   * Returns the index of the right child of p.
   */
  public static int getRight(int p) {
    return p*2 + 2;
  }

  /**
   * TODO
   * 
   * Returns the index of the parent of p.
   */
  public static int getParent(int p) {
    return (p - 1)/ 2;
  }
}
