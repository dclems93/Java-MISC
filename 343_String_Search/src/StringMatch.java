/**
 * TODO #1
 */

public class StringMatch {

  /**
   * TODO
   * 
   * Returns the result of running the naive algorithm to match pattern in text.
   */
  public static Result matchNaive(String pattern, String text) { 
	  int m = pattern.length(), n = text.length();
	  int ans = 0, i = 0, comps = 0;
	  Result res;
	  while(ans <= n - m){
		  comps++;
		  if(pattern.charAt(i) == text.charAt(i + ans)){
			  i++;			  
			  if(i == m){
				  break;
			  }			  
		  }
		  else{
			  ans++;
			  i = 0;
		  }
	  }
	  if(ans + m - 1 <= n - 1){
		  res = new Result(ans, comps);
	  }
	  else {
		  res = new Result(-1, comps);
	  }
    return res;
  }
  
  /**
   * TODO
   * 
   * Populates flink with the failure links for the KMP machine associated with the
   * given pattern, and returns the cost in terms of the number of character comparisons.
   */
  public static int buildKMP(String pattern, int[] flink) {
	  int j = 1, cost = 0, i=2;
      flink[0] = -1;
      flink[1] = 0;

      while(i < pattern.length() + 1){
          cost++;
          if(pattern.charAt(i - 1) == pattern.charAt(j - 1)){
              flink[i] = j;
              j++;
              i++;
          }else{
              if(j != 1){
                  j = flink[j];
                  if(j == 0){
                      j++;
                  }
              }else{
                  flink[i] = 0;
                  i++;
              }
          }
      }
    return cost;
  }
  
  /**
   * TODO
   * 
   * Returns the result of running the KMP machine specified by flink (built for the
   * given pattern) on the text.
   */
  public static Result runKMP(String pattern, String text, int[] flink) {

	  int i = 0, j = 0, comps= 0;
	  while(i < text.length() && j < pattern.length()){
		  comps++;
		  if(text.charAt(i) == pattern.charAt(j)){
			  i++;
			  j++;
		  }
		  else{
			  if(j!=0){
				  j = flink[j];
			  }
			  else{
				  i++;
			  }
		  }
	  }
	  if(j == pattern.length()){
		  return new Result(i - pattern.length(), comps);
	  }
	  
	  
    return new Result(-1, comps); 

  }
  
  /**
   * Returns the result of running the KMP algorithm to match pattern in text. The number
   * of comparisons includes the cost of building the machine from the pattern.
   */
  public static Result matchKMP(String pattern, String text) {
    int m = pattern.length();
    int[] flink = new int[m + 1];
    int comps = buildKMP(pattern, flink);
    Result ans = runKMP(pattern, text, flink);
    return new Result(ans.pos, comps + ans.comps);
  }
  
  /**
   * TODO
   * 
   * Populates delta1 with the shift values associated with each character in the
   * alphabet. Assume delta1 is large enough to hold any ASCII value.
   */
  public static void buildDelta1(String pattern, int[] delta1) {
	  int patlen = pattern.length();
	  for(int j = 0; j < delta1.length; j++){
		  delta1[j] = patlen;
	  }
	  for(int i = 0; i < patlen - 1; i++){
		  delta1[pattern.charAt(i)] = patlen - 1 - i;
	  }
	    		
  }

  /**
   * TODO
   * 
   * Returns the result of running the simplified Boyer-Moore algorithm using the
   * delta1 table from the pre-processing phase.
   */
  public static Result runBoyerMoore(String pattern, String text, int[] delta1) {
	   
	  int sk = 0, i, comps = 0, z = 0;
	  int patlen = pattern.length();
	  
	  while(text.length() - sk >= patlen){
		  i = patlen - 1;
		  while(text.charAt(sk + i) == pattern.charAt(i)){
			  comps++;
			  if(i == 0)
				  return new Result(sk, comps);
			  else{
				  i--;
			  }
		  }
		  comps++;
		  if (text.charAt(sk + patlen - 1) > delta1.length) {
			  z = patlen;
		  }
		  else {
		        z = text.charAt(sk + patlen - 1);
		   }
		  sk += delta1[z];
	  }
    return new Result(-1, comps);
  }
  
  /**
   * Returns the result of running the simplified Boyer-Moore algorithm to match 
   * pattern in text. 
   */
  public static Result matchBoyerMoore(String pattern, String text) {
    int[] delta1 = new int[Constants.SIGMA_SIZE];
    buildDelta1(pattern, delta1);
    return runBoyerMoore(pattern, text, delta1);
  }
  
  public static void main(String[] args){
	  String pattern = "AAAB";
//	  String text = "ABAAAAACDCBAANBAABAA";
//	  
//	  Result res = matchKMP(pattern, text);
//	  System.out.println("runKMP = " + res.pos+","+ res.comps);
	  
	  String t = "AAAB";
	  int[] flnk = new int[t.length() + 1];
//	  
	  int comps = buildKMP(t, flnk);
	  String str = "";
	  for(int i = 0; i < flnk.length; i++)
		  str += flnk[i];
	  System.out.println(comps + ": " + str);
  }
  

}
