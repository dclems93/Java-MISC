import java.util.Comparator;
import java.util.Stack;

/**
 * TODO: Complete the implementation of this class.
 * 
 * A HuffmanTree represents a variable-length code such that the shorter the
 * bit pattern associated with a character, the more frequently that character
 * appears in the text to be encoded.
 */

public class HuffmanTree {
  
  class Node {
    protected char key;
    protected int priority;
    protected Node left, right;
    
    public Node(int priority, char key) {
      this(priority, key, null, null);
    }
    
    public Node(int priority, Node left, Node right) {
      this(priority, '\0', left, right);
    }
    
    public Node(int priority, char key, Node left, Node right) {
      this.key = key;
      this.priority = priority;
      this.left = left;
      this.right = right;
    }
    
    public boolean isLeaf() {
      return left == null && right == null;
    }
  }
  
  protected Node root;
  
  /**
   * TODO
   * 
   * Creates a HuffmanTree from the given frequencies of letters in the
   * alphabet using the algorithm described in lecture.
   */
  public HuffmanTree(FrequencyTable charFreqs) {
    Comparator<Node> comparator = (x, y) -> {
      /**
       *  TODO: x and y are Nodes
       *  x comes before y if x's priority is less than y's priority
       */
      return x.priority - y.priority;
    };  
    PriorityQueue<Node> forest = new Heap<Node>(comparator);
    
    while(forest.size() > 1){
    	Node l = forest.delete();
    	Node r = forest.delete();
    	forest.insert(new Node(l.priority + r.priority, l, r));
    }
    root = forest.peek();

    /**
     * TODO: Complete the implementation of Huffman's Algorithm.
     * Start by populating forest with leaves.
     */
    root = forest.peek();
  }
  
  /**
   * TODO
   * 
   * Returns the character associated with the prefix of bits.
   * 
   * @throws DecodeException if bits does not match a character in the tree.
   */
  public char decodeChar(String bits) {
	  Node p = root;
	  for(int i = 0; i < bits.length(); i++){
		  if(bits.charAt(i) == '0'){
			  p = p.left;
		  }
		  else p = p.right;
	  }
    return p.key;
  }
    
  /**
   * TODO
   * 
   * Returns the bit string associated with the given character. Must
   * search the tree for a leaf containing the character. Every left
   * turn corresponds to a 0 in the code. Every right turn corresponds
   * to a 1. This function is used by CodeBook to populate the map.
   * 
   * @throws EncodeException if the character does not appear in the tree.
   */
  
  public String lookup(char ch) {
	  try{
		  Node r = root;
		  if(r == null)
	          throw new EncodeException(ch);
		  
		  Stack<Node> nodes = new Stack();
		  Stack<String> st = new Stack();
		  st.push("root");

		  while(!nodes.isEmpty()){
			  Node n = nodes.pop(); 
			  System.out.println(n.key);
			  if(n.isLeaf()){
				  if(n.key == ch){
					  return st.toString();
				  }
				  else{
					  n = nodes.pop();
					  st.pop();
				  }
			  }
			  else{
				  if(n.right != null){ 
					  nodes.push(n.right);
					  st.push("0");
				  }
				  if(n.left != null){ 
					  nodes.push(n.left);
					  st.push("1");
				  }
			  }
			  
		  }
	    
	  }
	  catch(Exception e){
		  
	  }
	  return "";
  }



public static void main(String[] args){
	HuffmanTree ht = new HuffmanTree(new FrequencyTable("aaaabbc"));
	ht.lookup('a');
}
}

