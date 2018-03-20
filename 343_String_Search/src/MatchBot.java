import java.util.ArrayList;
import java.util.List;

/**
 * TODO #2
 */

public class MatchBot extends TwitterBot {
  /**
   * Constructs a MatchBot to operate on the last numTweets of the given user.
   */
  public MatchBot(String user, int numTweets) {
    super(user, numTweets);
  }
  
  /**
   * TODO
   * 
   * Employs the KMP string matching algorithm to add all tweets containing 
   * the given pattern to the provided list. Returns the total number of 
   * character comparisons performed.
   */
  public int searchTweetsKMP(String pattern, List<String> ans) {
	  int comps=0;
	  for(String t : this.tweets){
		  Result res = StringMatch.matchKMP(pattern, t);
		  comps+= res.comps;
		  if (res.pos != -1) {
		        ans.add(t);
		  }
	  }
    return comps;
  }
  
  /**
   * TODO
   * 
   * Employs the naive string matching algorithm to find all tweets containing 
   * the given pattern to the provided list. Returns the total number of 
   * character comparisons performed.
   */
  public int searchTweetsNaive(String pattern, List<String> ans) {
	  int comps=0;
	  for(String t : this.tweets){
		  Result res = StringMatch.matchNaive(pattern, t);
		  comps+= res.comps;
		  if (res.pos != -1) {
		        ans.add(t);
		        
		  }
	  }
    return comps;
  }
  
  public int searchTweetsBoyerMoore(String pattern, List<String> ans) {
	  int comps=0;
	  for(String t : this.tweets){
		  Result res = StringMatch.matchBoyerMoore(pattern, t);
		  comps+= res.comps;
		  if (res.pos != -1) {
		        ans.add(t);
		  }
	  }
    return comps;
  }
  
  public static void main(String... args) {
    String handle = "realDonaldTrump", pattern = "big";
    MatchBot bot = new MatchBot(handle, 4000);
   
    // Search all tweets for the pattern.  
    
    
    // ================== Commented this out to run own tests below ================
//    List<String> ansNaive = new ArrayList<>();
//    int compsNaive = bot.searchTweetsNaive(pattern, ansNaive); 
//    List<String> ansKMP = new ArrayList<>();
//    int compsKMP = bot.searchTweetsKMP(pattern, ansKMP); 
//    
//    List<String> ansBoyer = new ArrayList<>();
//    int compsBoyer = bot.searchTweetsBoyerMoore(pattern, ansBoyer);
//     
    String[] wordshesays = {
    	"big",
    	"korea",
    	"mexico",
    	"huge",
    	"america",
    	"media",
    	"fail",
    	"great",
    	"make",
    	"china",
    	"U.S.A",
    	"NATO",
    	"currency",
    	"manipulator",
    	"Russia"
    	   	
    };
    
    long KMPtime = 0;
    long NaiveTime = 0;
    long BoyerTime = 0;
    
    for(String word: wordshesays){
    	long begin = System.nanoTime();
    	List<String> ansKMP = new ArrayList<>();
        int compsKMP = bot.searchTweetsKMP(word, ansKMP);
        KMPtime += System.nanoTime() - begin;
        
        begin = System.nanoTime();
    	List<String> ansNaive = new ArrayList<>();
        int compsNaive = bot.searchTweetsNaive(word, ansNaive);
        NaiveTime += System.nanoTime() - begin;
        
        begin = System.nanoTime();
    	List<String> ansBoyer = new ArrayList<>();
        int compsBoyer = bot.searchTweetsNaive(word, ansBoyer);
        BoyerTime += System.nanoTime() - begin;
        
    	
    }
    
    
    System.out.println("The total time it took to calculate 15 words: \n");
    System.out.println("Naive Total: " + NaiveTime);
    System.out.println("Naive Average: " + NaiveTime / 15 + "\n\n");
    
    System.out.println("KMP Total: " + KMPtime);
    System.out.println("KMP Average: " + KMPtime / 15 + "\n\n");
    
    
    System.out.println("Boyer Moore Total: " + BoyerTime);
    System.out.println("Boyer Moore Average: " + BoyerTime / 15 + "\n\n");
    
    
    
    
//    System.out.println("naive comps = " + compsNaive + ", KMP comps = " + compsKMP + ", Boyer Moore comps = " + compsBoyer );
//    
//    for (int i = 0; i < ansBoyer.size(); i++) {
//        String tweet = ansBoyer.get(i);
//        assert tweet.equals(ansNaive.get(i));
//        System.out.println(i++ + ". " + tweet);
//        System.out.println(pattern + " appears at index " + 
//            tweet.toLowerCase().indexOf(pattern.toLowerCase()));
//      }
    
    // Do something similar for the Boyer-Moore matching algorithm.
  
  }
}
