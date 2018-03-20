import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

interface Digraph {
  Iterable<Integer> in(int v);
  Iterable<Integer> out(int v);
  default void addEdge(int u, int v) {
    addEdge(u, v, 1);
  }
  void addEdge(int u, int v, int weight);
  default int weight(int u, int v) {
    throw new UnsupportedOperationException();
  }
  int numVertices();
  int numEdges();
}

/** 
 * ListDigraph is a class that implements a directed graph using
 * a Map of adjacency lists. 
 * 
 * A digraph may have self-loops but no parallel edges. We assume that
 * vertices are labeled by the integers 0, 1, ..., n - 1. The edges are 
 * labeled with a positive weight.
 * 
 * TODO: Give the big-Oh cost for each of the following operations in
 *       terms of n (the number of vertices):
 *          in            O(?)                                                  
 *          out           O(?)                                                  
 *          addEdge       O(?)                                                  
 *          weight        O(?)                                                  
 *          numVertices   O(?)                                                  
 *          numEdges      O(?)                                                  
 *          twoHopsAway   O(?) 
 */

public class ListDigraph implements Digraph {
  
  /**
   * An Edge encapsulates the incident vertex and a weight.
   */
  class Edge {
    int to, weight;
    Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
    
    public String toString() {
      return String.format("(%d,%d)", to, weight);
    }
  }
  
  private Map<Integer, List<Edge>> adj;
  private int n;         // number of vertices
  private int m;         // number of edges

  /** 
   * TODO
   * 
   * Create a directed graph with no edges and n vertices,
   * labeled 0, 1, 2, ..., n - 1. Assume n is non-negative.
   */
  public ListDigraph(int n) {
    assert n >= 0;
    for(int i = 0; i < n; i++){
    	List<Edge> temp = null;
    	adj.put(i, temp);
    }
  }

  /**
   * TODO
   * 
   * Returns the weight of the edge from u to v, if it exists. Otherwise,
   * Integer.MAX_VALUE is returned.
   */
  public int weight(int u, int v) {
	  int ans = Integer.MAX_VALUE;
	  List<Edge> temp = adj.get(u);
	  for(Edge e : temp){
		  if(e.to == v)
			  ans = e.weight;
	  }
    return ans;
  }

  /**
   * TODO
   * 
   * Returns true iff the edge between u and v exists.
   */
  public boolean hasEdge(int u, int v) {
	  Boolean ans = false;
	  List<Edge> temp = adj.get(u);
	  for(Edge e : temp){
		  if(e.to == v)
			  ans = true;
	  }
    return ans;    
  }

  /**
   * Returns the number of vertices in this graph.
   */
  public int numVertices() {
    return n;
  }

  /**
   * Returns the number of edges in this graph.
   */
  public int numEdges() {
    return m;
  }

  /** 
   * TODO
   * 
   * Adds the edge from u to v of the given weight to this graph. If 
   * the edge already exists, then its weight is replaced with the new weight.
   */	
  public void addEdge(int u, int v, int weight) {
    Edge t = new Edge(v,weight);
    
    if(!hasEdge(u, v))
    	adj.get(u).add(t);
    for(Edge e : adj.get(u))
    	if(e.to == v)
    		e.weight = weight;
    
  }

  /** 
   * TODO
   * 
   * Returns those vertices that are incident to an outgoing edge of v.
   */	
  public Set<Integer> out(int v) {
    Set<Integer> neighbors = new HashSet<Integer>();

    return neighbors;
  }

  /** 
   * TODO
   * 
   * Returns those vertices that are incident to an incoming edge of v.
   */
  public Set<Integer> in(int v) {
    Set<Integer> neighbors = new HashSet<Integer>();

    return neighbors;
  }

  /** 
   * TODO
   * 
   * Returns those vertices that are exactly two hops away from v.
   */	
  public Set<Integer> twoHopsAway(int v) {
    Set<Integer> neighbors = new HashSet<>();

    return neighbors;
  }

  /**
   * Returns a textual representation of the adjacency lists.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("Adjacency lists (n = %d, m = %d)", n, m));
    for (int i = 0; i < n; i++) {
      sb.append("\n\t" + i + ": ");
      sb.append(adj.get(i));
    }
    return sb.toString();
  }

}
