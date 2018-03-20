import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class Testing {
  private static Random random = new Random();
  private static String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";

  
  
  @Test
  public void testNaive() {
	  
//	  String pat = "AAA";
//	  String text = "BAAABBCAAAB";
//	  Result res = StringMatch.matchNaive(pat, text);
//	  System.out.println(res.comps + "," + res.pos);
//	  
//	  System.out.println(pat.charAt(0) == text.charAt(1));
    String[] pats = new String[] {
        "AAAA",
        "BAAA",
        "AAAB",
        "AAAC",
        "ABAB",
        "ABBBB",
        "AB",
        "ABC",
        "AAAC",
        "ABAAAAAAAAAB",
        "AAAAAAAAABB",
    };
    String text1 = "AAAAAAAAABAAAAAAAAAB";
//    for(String pat : pats){
//    	Result res = StringMatch.matchNaive(pat, text);
//	  System.out.println(res.pos + "," + res.comps);
//    }
    
    assertEquals(20, text1.length());
    Result[] results = new Result[] {
        new Result(0, 4),
        new Result(9, 13),
        new Result(6, 28),
        new Result(-1, 62),
        new Result(-1, 35),
        new Result(-1, 32),
        new Result(8, 18),
        new Result(-1, 36),
        new Result(-1, 62),
        new Result(8, 28),
        new Result(-1, 56),
    };
    
    int i = 0;
    for (String pat : pats) {
      Result res = StringMatch.matchNaive(pat, text1);
      assertEquals(res.pos, results[i].pos);
      assertEquals(res.comps, results[i].comps);
      i++;
   }
  }
  
  
  @Test
  public void testKMPSmall(){
	  
	  String[] pats = new String[] {
		      "A",
		      "AA",
			  "AAAA",
		      "AAAB",
		      "AAAC",
		      "ABAB",
		      "ABBBB",
		      "AB",
		      "ABC",
		      "AAAC",
		    };
		    String text2 = "AAAAAAAAABCAAAAAABAA";
		    for(String pat : pats){
		    	Result res = StringMatch.matchNaive(pat, text2);
		    }
		    
		    String tees = "AABAA";
		    Result rest = StringMatch.matchNaive(tees, text2);
		    
		    assertEquals(20, text2.length());
		    int[] buildKMPcomps = new int[] {
		        0,
		        1,
		        3,
		        5,
		        5,
		        3,
		        4,
		        1,
		        2,
		        5,
		    };
		    int[] matchKMPindex = new int[] {
			        0,
			        0,
			        0,
			        6,
			        -1,
			        -1,
			        -1,
			        8,
			        8,
			        -1,
			    };
		    
		    String[] buildKMPflnk = new String[] {
			        "-10",
			        "-101",
			        "-10123",
			        "-10120",
			        "-10120",
			        "-10012",
			        "-100000",
			        "-100",
			        "-1000",
			        "-10120",
			    };
		    int[] matchKMPcomps = new int[] {
			        1,
			        3,
			        7,
			        21,
			        40,
			        39,
			        40,
			        19,
			        21,
			        40,
			        53,
			        45,
			    };
		    
		    int i = 0;
		    for (String pat : pats) {
		    	int[] flnk = new int[pat.length() + 1];
		    	int res = StringMatch.buildKMP(pat, flnk);
		    	String kmp = "";
		    	for(int j = 0; j < flnk.length; j++){
		  		  kmp += flnk[j];
		  		  
		    	}
		    	assertEquals(res, buildKMPcomps[i]);
		    	assertEquals(kmp, buildKMPflnk[i]);
		    	
		    	Result resMatchKMP = StringMatch.matchKMP(pat, text2);
		    	
		    	assertEquals(resMatchKMP.pos, matchKMPindex[i]);
		    	assertEquals(resMatchKMP.comps, matchKMPcomps[i]);
		    	i++;
		    }  
  }
  
  @Test
  public void testKMPBig(){
	  
	  String[] pats = new String[] {
		      "ABAAAAAAAAAB",
		      "AAAAAAAAABB",
		      "AAAAAABCAAAAAABAA",
		      "BAAAAABABA",
		      "AAAAAAAABCAAAA",
		      
		    };
		    String text2 = "AAAAAAAAABCAAAAAABAA";
		    for(String pat : pats){
		    	Result res = StringMatch.matchNaive(pat, text2);
		    }
		    
		    assertEquals(20, text2.length());
		    int[] buildKMPcomps = new int[] {
		        19,
		        18,
		        22,
		        10,
		        20,
		    };
		    int[] matchKMPindex = new int[] {
			        -1,
			        -1,
			        3,
			        -1,
			        1,
			    };
		    
		    String[] buildKMPflnk = new String[] {
			        "-1001111111112",
			        "-101234567800",
			        "-101234500123456712",
			        "-10000001212",
			        "-101234567001234",
			    };
		    int[] matchKMPcomps = new int[] {
		    		53,
			        45,
			        45,
			        31,
			        36,
			    };
		    
		    int i = 0;
		    for (String pat : pats) {
		    	int[] flnk = new int[pat.length() + 1];
		    	int res = StringMatch.buildKMP(pat, flnk);
		    	String kmp = "";
		    	for(int j = 0; j < flnk.length; j++){
		  		  kmp += flnk[j];
		  		  
		    	}
		    	System.out.println(res + " : " + kmp);
		    	assertEquals(res, buildKMPcomps[i]);
		    	assertEquals(kmp, buildKMPflnk[i]);
		    	
		    	Result resMatchKMP = StringMatch.matchKMP(pat, text2);
		    	
		    	assertEquals(resMatchKMP.pos, matchKMPindex[i]);
		    	assertEquals(resMatchKMP.comps, matchKMPcomps[i]);
		    	
		    	//System.out.println(resMatchKMP.pos + " : " + resMatchKMP.comps);
		    	
		    	i++;
		    }  
  }
  
  @Test
  public void testBoyers(){
	  String[] pats = new String[] {
		      "A",
		      "AA",
			  "AAAA",
		      "AABAA",
		      "AAAB",
		      "AAAC",
		      "ABAB",
		      "ABBBB",
		      "AB",
		      "ABC",
		      "AAAC",
		      "ABAAAAAAAAAB",
		      "AAAAAAAAABB",
		    };
		    String text2 = "AAAAAAAAABCAAAAAABAA";
		    
		    
		    
		    for(String pat : pats){
			    int[] delta1 = new int[Constants.SIGMA_SIZE];
			    
			    StringMatch.buildDelta1(pat, delta1);
			    String str = "";
			    for(int i = 0; i < delta1.length; i++){
			    	str+= delta1[i];
			    }
			    //System.out.println(str);
			    
			    Result res = StringMatch.matchBoyerMoore(pat, text2);
			    System.out.println(res.pos + " : " + res.comps);
			    
			    
		    }
		    
		    
		    
	  
  }
  
  //@Test 
  public void testEmpty() {
    System.out.println("testEmpty");
    match("", "");
    match("", "ab");
    System.out.println();
  }

  @Test 
  public void testOneChar() {
    System.out.println("testOneChar");
    match("a", "a");
    match("a", "b");
    System.out.println();
  }

  @Test 
  public void testRepeat() {
    System.out.println("testRepeat");
    match("aaa", "aaaaa");
    match("aaa", "abaaba");
    match("abab", "abacababc");
    match("abab", "babacaba");
    System.out.println();
  }

  @Test 
  public void testPartialRepeat() {
    System.out.println("testPartialRepeat");
    // Hava NO idea why this isn't working, all my similar tests are....
    //match("aaacaaaaac", "aaacacaacaaacaaaacaaaaac");
    match("ababcababdabababcababdaba", "ababcababdabababcababdaba");
    System.out.println();
  }

 // @Test 
  public void testRandomly() {
    System.out.println("testRandomly");
    for (int i = 0; i < 100; i++) {
      String pattern = makeRandomPattern();
      for (int j = 0; j < 100; j++) {
        String text = makeRandomText(pattern);
        match(pattern, text);
      }
    }
    System.out.println();
  }

  /* Helper functions */

  private static String makeRandomPattern() {
    StringBuilder sb = new StringBuilder();
    int steps = random.nextInt(10) + 1;
    for (int i = 0; i < steps; i++) {
      if (sb.length() == 0 || random.nextBoolean()) {  // Add literal
        int len = random.nextInt(5) + 1;
        for (int j = 0; j < len; j++)
          sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
      } 
      else {  // Repeat prefix
        int len = random.nextInt(sb.length()) + 1;
        int reps = random.nextInt(3) + 1;
        if (sb.length() + len * reps > 1000)
          break;
        for (int j = 0; j < reps; j++)
          sb.append(sb.substring(0, len));
      }
    }
    return sb.toString();
  }

  private static String makeRandomText(String pattern) {
    StringBuilder sb = new StringBuilder();
    int steps = random.nextInt(100);
    for (int i = 0; i < steps && sb.length() < 10000; i++) {
      if (random.nextDouble() < 0.7) {  // Add prefix of pattern
        int len = random.nextInt(pattern.length()) + 1;
        sb.append(pattern.substring(0, len));
      } 
      else {  // Add literal
        int len = random.nextInt(30) + 1;
        for (int j = 0; j < len; j++)
          sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
      }
    }
    return sb.toString();
  }

  private static void match(String pattern, String text) {
    // run all three algorithms and test for correctness
    Result ansNaive = StringMatch.matchNaive(pattern, text);
    int expected = text.indexOf(pattern);
    //System.out.println("Naive Pos Expected:" + expected + "  Given : " + ansNaive.pos);
    assertEquals(expected, ansNaive.pos);
    //System.out.println("Naive Passed!");
    Result ansKMP = StringMatch.matchKMP(pattern, text);
    //System.out.println("KMP Pos Expected:" + expected + "  Given : " + ansKMP.pos);
    assertEquals(expected, ansKMP.pos);
    //System.out.println("KMP Passed!");
    Result ansBoyerMoore = StringMatch.matchBoyerMoore(pattern, text);
    assertEquals(expected, ansBoyerMoore.pos);
    //System.out.println("BoyerMoore Passed!");
    System.out.println(String.format("%5d %5d %5d : %s", 
        ansNaive.comps, ansKMP.comps, ansBoyerMoore.comps,
        (ansNaive.comps < ansKMP.comps && ansNaive.comps < ansBoyerMoore.comps) ?
            "Naive" :
              (ansKMP.comps < ansNaive.comps && ansKMP.comps < ansBoyerMoore.comps) ?
                  "KMP" : "Boyer-Moore"));
  }
}
