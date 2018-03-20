import java.util.HashMap;

/**
 * TODO: Complete the implementation of this class.
 */

public class FrequencyTable extends HashMap<Character, Integer> {
  /**
   * Constructs an empty table.
   */
  public FrequencyTable() {
    super();
  }
    
  /**
   * TODO: Make use of get() and put().
   * 
   * Constructs a table of character counts from the given text string.
   */
  public FrequencyTable(String text) {
	  for(int i = 0; i < text.length(); i++){
		  char c = text.charAt(i);
		  put(c,get(c) + 1);
	  }
  }

  
  /**
   * TODO
   * 
   * Returns the count associated with the given character. In the case that
   * there is no association of ch in the map, return 0.
   */
  @Override
  public Integer get(Object ch) {
	  int c = 0;
	  if(this.containsKey(ch))
		  c = super.get(ch);
    return c;
  }
}
