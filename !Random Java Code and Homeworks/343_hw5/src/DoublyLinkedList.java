import java.util.Comparator;
import java.util.Iterator;

/**
 * [hw5] Problem 1: 
 * 
 * TODO: Add a sort() method, based on the Quicksort Algorithm, to the
 * DoublyLinkedList implementation.
 */

public class DoublyLinkedList<T> implements List<T> {

  /**
   * Node is a pair containing a data field and a pointers to
   * the previous and next nodes in the list.
   */
  class Node {
    T data;
    Node next, prev;

    Node(T data) {
      this(data, null, null);
    }

    Node(T data, Node prev, Node next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }
  }

  protected Node head;  // always points to the headnode for this list
  protected int n;      // the number of nodes in this list, initially 0

  /**
   * Creates the empty list. 
   */
  public DoublyLinkedList() {
    head = new Node(null);
    head.next = head.prev = head;
  }
  
  /**
   * TODO
   * 
   * Rearranges the elements of this list so they are in order according
   * to the supplied Comparator by using the Quicksort Algorithm. Your
   * implementation must run in O(n log n) time on the average.
   */
  
  public void sort(Comparator<T> comp) {
    quicksortHelper(comp, head.next, head.prev);

  }
  
  /**
   * TODO
   * 
   * Sorts the elements in the list between low and high, inclusive, in the
   * order specified by comp.
   */
  private void quicksortHelper(Comparator<T> comp, Node low, Node high) {
	  if(comp.compare(low.data, high.data) < 0){
		  Node n = partition(comp, low, high);
		  quicksortHelper(comp, low, n);
		  quicksortHelper(comp, n, high);
	  }
  }
  
  /**
   * TODO: Be sure to follow the Partition Algorithm described in lecture.
   * (See the notes from lec8a for details.)
   * 
   * Partitions the elements in the list about the pivot (which is the
   * data in the low node), and then returns the node containing the
   * pivot. Note that you should move the data around rather than
   * trying to adjust the links in the nodes.
   */
  private Node partition(Comparator<T> comp, Node low, Node high) {
    T pivot = low.data;
    Node free = low;
    outer:
    	while(true){
    		while(comp.compare(high.data,pivot) >= 0){
    			high = high.prev;
    			if(high.next == low) break outer;
    		}
    		free.data = high.data;
    		free = high;
    		if(high.next == low && high.next != null)
				break;
    		
    		while(comp.compare(low.data,pivot) <= 0){
    			low = low.next;
    			if(low.prev == high)
    				break outer;
    		}
    		free.data = low.data;
    		free = low;
    		if(low.prev == high && low.prev != null)
    			break;
    	}
    free.data = pivot;

    return free;
  }

  /**
   * Inserts the value x at the end of this list. 
   */
  public void add(T x) {  
    n++;
    Node last = head.prev;
    Node curr = new Node(x, last, head);
    last.next = curr;
    head.prev = curr;
  }
  
  /**
   * Inserts the value x at the front of this list.
   */
  public void addFront(T x) {
    n++;
    Node curr = new Node(x, head, head.next);
    head.next.prev = curr;
    head.next = curr;
  }

  /**
   * Removes the element at index i from this list.
   * @return the data in the removed node.
   * @throw IndexOutOfBoundsException iff i is out of range 
   * for this list.
   */
  public T remove(int i) {
    if (i < 0 || i >= size())
      throw new IndexOutOfBoundsException();
    Node p = head.next;
    while (i-- > 0)
      p = p.next;
    remove(p);
    return p.data;
  }
  
  /**
   * Removes the node pointed to by p. This helper is called by the list's
   * remove() and by the iterator's remove().
   */
  private void remove(Node p) {
    n--;
    p.prev.next = p.next;
    p.next.prev = p.prev;
  }

  /**
   * Returns the i-th element from this list, where i is a zero-based index.
   * @throw IndexOutOfBoundsException iff i is out of range for this list.
   */
  public T get(int i) {
    if (i < 0 || i >= size())
      throw new IndexOutOfBoundsException();
    Node p = head.next;
    while (i > 0) {
      p = p.next;
      i--;
    }
    return p.data;
  }

  /**
   * Returns true iff the value x appears somewhere in this list.
   */
  public boolean contains(T x) {
    Node p = head.next;
    while (p != head)
      if (p.data.equals(x))  
        return true;
      else
        p = p.next;
    return false;
  }

  /**
   * Returns the number of elements in this list.
   */
  public int size() {
    return n;
  }

  /**
   * Returns an iterator for this list.
   */
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      Node p = head.next;

      public boolean hasNext() {
        return p != head;
      }

      public T next() {
        T ans = p.data;
        p = p.next;
        return ans;
      }
      
      public void remove() {
        DoublyLinkedList.this.remove(p.prev);
      }
    };
  }

  /**
   * Returns a string representing this list (resembling a Racket list).
   */
  public String toString() {
    if (isEmpty())
      return "()";    
    Iterator<T> it = iterator();
    StringBuilder ans = new StringBuilder("(").append(it.next());
    while (it.hasNext())
      ans.append(" ").append(it.next());
    return ans.append(")").toString();
  }

  /**
   * TODO: Write a comprehensive battery of test cases.
   */
  public static void main(String... args) {
    DoublyLinkedList<Integer> xs = new DoublyLinkedList<>();
    int[] a = new int[] { 4, 3, 0, 6, 5, 7, 2, 8, 1 };
    for (int x : a)
      xs.add(x);
    System.out.println(xs.toString());
    // Sort xs in the natural order:
    xs.sort((x, y) -> x.compareTo(y));
    System.out.println(xs.toString());
    for (int i = 0; i < xs.size(); i++)
      assert i == xs.get(i);
    // Sort xs in the reverse of the natural order:
    //xs.sort((x, y) -> y.compareTo(x));
    System.out.println(xs.toString());
    //for (int i = 0; i < xs.size(); i++)
      //assert xs.size() - 1 - i == xs.get(i);
    System.out.println("All tests passed...");
  }
}

/**
 * If you want to call yourself a List, then implement this interface:
 */
interface List<T> extends Iterable<T> {
  void add(T x);  // simple add
  T remove(int i);
  T get(int i);
  boolean contains(T x);
  int size();
  default boolean isEmpty() {
    return size() == 0;
  }
}
