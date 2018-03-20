import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * TODO: This is your first major task.
 * 
 * This class implements a generic unbalanced binary search tree (BST).
 */

public class BinarySearchTree<K> implements Tree<K> {
  
  /**
   * A Node is a Location, which means that it can be the return value
   * of a search on the tree.
   */
  
  class Node implements Location<K> { 
    protected K data;
    protected Node left, right;
    protected Node parent;     // the parent of this node
    protected int height;      // the height of the subtree rooted at this node
    protected boolean dirty;   // true iff the key in this node has been removed

    /**
     * Constructs a leaf node with the given key.
     */
    public Node(K key) {
      this(key, null, null);
      this.height = 1;
    }
    
    /**
     * TODO
     * 
     * Constructs a new node with the given values for fields.
     */
    public Node(K data, Node left, Node right) {
    	this.data = data;
    	this.left = left;
    	this.right = right;
    	this.height = 1;
    	this.dirty = false;
    }

    /**
     * Return true iff this node is a leaf in the tree.
     */
    protected boolean isLeaf() {
      return left == null && right == null;
    }
    
    /**
     * TODO
     * 
     * Performs a local update on the height of this node. Assumes that the 
     * heights in the child nodes are correct. This function *must* run in 
     * O(1) time.
     */
    protected void fixHeight() {
    	if(this.equals(null)){
    		this.height = 0;
    	}
    	if(!this.isLeaf()){
    		if(this.left == null){
    			this.height = this.right.height + 1;
    		}
    		else if(this.right == null){
    			this.height = this.left.height + 1;
    		}
    		else{
    			this.height = 1 + Math.max(this.right.height, this.left.height);
    		}
    	}
    	else{
    		this.height = 1;
    	}
    }
    
    /**
     * TODO
     * 
     * Returns the data in this node.
     */
    public K get() {
      return data;
    }
    

    /**
     * TODO
     * 
     * Returns the location of the node containing the inorder predecessor
     * of this node.
     */
    
    public Node getMax(Node p) {
    	while(p.right != null){
    		p = p.right;
    		
    	}
    	return p;
    }
    
    public Node getBefore(){
    	if (this == null)
			return null;
    	if (this.left != null)
			return getMax(this.left);

		Node y = this.parent;
		Node x = this;
		while (y != null && x == y.left){
			x = y;
			y = y.parent;
		}

		return y;
     }

    /**
     * TODO
     * 
     * Returns the location of the node containing the inorder successor
     * of this node.
     */
    
    public Node getMin(Node p) {
		while(p.right != null){
    		p = p.right;
    		
    	}
		return p;
    }
    
    public Node getAfter() {
    	if (this == null)
			return null;
    	if (this.right != null)
			return getMin(this.right);
    	Node x = this;
		Node y = this.parent;
		while (y != null && x == y.right){
			x = y;
			y = y.parent;
		}
		return y;
    }
  }
  
  protected Node root;
  protected int n;
  protected BiPredicate<K, K> lessThan;
  
  /**
   * Constructs an empty BST, where the data is to be organized according to
   * the lessThan relation.
   */
  public BinarySearchTree(BiPredicate<K, K> lessThan) {
    this.lessThan = lessThan;
  }
  
  /**
   * TODO
   * 
   * Looks up the key in this tree and, if found, returns the (possibly dirty)
   * location containing the key.
   */
  public Node search(K key) {
	  return searchHelper(key, root);
  }
  
  public Node searchHelper(K key, Node p){
	  if(p ==  null){
		  return null;
	  }
	  if(p.data == key){
		  return p;
	  }
	  if(lessThan.test(key,p.data)){
		  return searchHelper(key, p.left);
	  }
	  else if(lessThan.test(p.data, key)){
		  p = searchHelper(key, p.right);
	  }
	  
	  return p;
  }

  /**
   * TODO
   * 
   * Returns the height of this tree. Runs in O(1) time!
   */
  public int height() {
	  if(root == null)
		  return 0;
    return root.height;
  }
  
  /**
   * TODO
   * 
   * Clears all the keys from this tree. Runs in O(1) time!
   */
  public void clear() {
	  root = null;
	  n = 0;
  }

  /**
   * Returns the number of keys in this tree.
   */
  public int size() {
    return n;
  }
  
  /**
   * TODO
   * 
   * Inserts the given key into this BST, as a leaf, where the path
   * to the leaf is determined by the predicate provided to the tree
   * at construction time. The parent pointer of the new node and
   * the heights in all node along the path to the root are adjusted
   * accordingly.
   * 
   * Note: we assume that all keys are unique. Thus, if the given
   * key is already present in the tree, nothing happens.
   * 
   * Returns the location where the insert occurred (i.e., the leaf
   * node containing the key).
   */
  public Node insert(K key) {
		root = insertHelper(root, key);
		
		return root;
	}

	private Node insertHelper(Node p, K key){
		if(p == null){
			p = new Node(key);
			n++;
		}
		if (p.data.equals(key))
			if(p.dirty)
				p.dirty = false;
		if (lessThan.test(key, p.data)){
			p.left = insertHelper(p.left, key);
			p.left.parent = p;
		}
		else if (lessThan.test(p.data, key)){
			p.right = insertHelper(p.right, key);
			p.right.parent = p;
		}
		p.fixHeight();
		return p;
	}
  
  /**
   * TODO
   * 
   * Returns true iff the given key is in this BST.
   */
  public boolean contains(K key) {
    Node p = search(key);
    return p != null && !p.dirty;
  }

  /**
   * TODO
   * 
   * Removes the key from this BST. If the key is not in the tree,
   * nothing happens. Implement the removal using lazy deletion.
   */
  public void remove(K key) {
	  Node p = search(key);
	  if(p!= null && !p.dirty){
		  n--;
		  p.dirty = true;
	  }
  }
  
  /**
   * TODO
   * 
   * Clears out all dirty nodes from this BST.
   * 
   * Use the following algorithm:
   * (1) Let ks be the list of keys in this tree. 
   * (2) Clear this tree.
   * (2) For each key in ks, insert it into this tree.
   */
  public void rebuild() {
	  List<K> ks = keys();
	  clear();
	  for(K key : ks)
		  insert(key);
  }
    
  /**
   * TODO
   * 
   * Returns a sorted list of all the keys in this tree.
   */
  public List<K> keys() {
	  List<K> keys = new LinkedList<>();
	  
    return keysHelper(root, keys);
  }
  public List<K> keysHelper(Node p, List<K> ls){
	  if(p == null){
	  }
	  else{
		  if(!p.dirty){
			  ls.add(p.data);
		  }
		  keysHelper(p.left, ls);
		  keysHelper(p.right, ls);
		  
	  }
	  return ls;
  }

  /**
   * TODO
   * 
   * Returns a textual representation of this BST.
   */
  public String toString() {
	  String str = "";
	  str = toStringHelper(str, root);
    return str;
  }
  public String toStringHelper(String str, Node p){
	  str += p.data;
	  System.out.println(str);
	  if(p.left != null)
		  toStringHelper(str , p.left);
		 
	  if(p.right != null)
		  toStringHelper(str , p.right);
			  
	  
	  
	  return str;  
  }
  
  
  
//  public static void main(String[] args){
//	  BinarySearchTree<Integer> bst = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
//
//
//      int[] a = new int[] { 4, 8, 0, 2, 6, 10 };
//      
//
//      for (Integer key : a) {
//        bst.insert(key);
//        System.out.println(bst.search(key).data);
//
//      }
//      System.out.println(bst.toString());
//      System.out.println(bst.root.right.data + "");
//  }
}
