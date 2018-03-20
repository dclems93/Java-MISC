//full name:
//username:
//collaborator(s):

class Homework3 {

 public static void main(String[] args) {

  // Problems are based upon problem R4.1, R4.2, R4.3...
  // This template sets up the framework, to get credit you must use this template.
  // A single test case is not sufficient to prove that it works for all
  // cases. So we encourage you to make your own test cases
  // You MUST keep the definitions of each problem as specified below 
  // Here are a couple of sample tests to get you started.
  
  System.out.println( "example(10): " + example(10) );            // should OUTPUT: "1 2 3 4 5 6 7 8 9 10"
  
  System.out.println( "p319(2.0, 1.98999): " + p319(2.0, 1.98999) ); // should OUTPUT: False
  System.out.println( "p319(2.0, 1.99999): " + p319(2.0, 1.99999) ); // should OUTPUT: True
  System.out.println( "p325(\"a\"): " + p325("a") ); // should OUTPUT: "Vowel"
  System.out.println( "p325(\"c\"): " + p325("c") ); // should OUTPUT: "Consonant"  
  System.out.println( "p325(\"ab\"): "+ p325("ab")); // should OUTPUT: "Error"    
  System.out.println( "p325(\"0\"): " + p325("0") ); // should OUTPUT: "Error"  
  System.out.println( "p43a(\"abCDe\"): " + p43a("abCDe") ); // should OUTPUT: "CD"    
  System.out.println( "p43b(\"abcde\"): " + p43b("abcde") ); // should OUTPUT: "bd"      
  System.out.println( "p43c(\"abcde\"): " + p43c("abcde") ); // should OUTPUT: "_bcd_"      
  System.out.println( "p43d(\"abcde\"): " + p43d("abcde") ); // should OUTPUT: "2"        
  System.out.println( "p43e(\"abcde\"): " + p43e("abcde") ); // should OUTPUT: "0,4"
  System.out.println( "p45(\"1.1 2.2 3.3\"):\n" + p45("1.1 2.2 3.3") );  //should OUTPUT: 
  //"Average: 2.2
  //Smallest: 1.1
  //Largest: 3.3 
  //Range: 2.2"
  
 }

 //*******************************
 // Example Problem: 
 // Return String with numbers 
 // from 1 to n
 //*******************************
 public static String example(int n) {
  
  // initialize String *answer* to be an empty string
  String answer = "";
  
  // initialize variable *i* to be an int with value 0
  int i = 0;

  // Loop while i is < 10
  while (i < n) {
   
   // increase i by 1
   i++;
   
   // concatenate the value of *i* and a space on to *answer*
   answer += i + " ";
  }
  
  // remove the last space from the end of *answer*
  answer = answer.substring(0, answer.length() - 1);
  
  // return *answer*, which holds the "answer" to the problem
  return answer;
 }
 
 
 // ******************************
 // PROBLEM P 3.19
 // ******************************

 // Problem P 3.19
 public static boolean p319(double x, double y) {
  // START CODE
  return true;
  // STOP CODE
 }
 
 // ******************************
 // PROBLEM P 3.25
 // ******************************

 // Problem P 3.25
 public static String p325(String string) {
  // START CODE
  return "P3.25";
  // STOP CODE
 }

 // ******************************
 // PROBLEM P 4.3
 // ******************************

 // Problem P4.3a
 public static String p43a(String string) {
  // START CODE
  return "P4.3a";
  // STOP CODE
 }

 // Problem P4.3b
 public static String p43b(String string) {
  // START CODE
  return "P4.3b";
  // STOP CODE
 }

 // Problem P4.3c
 public static String p43c(String string) {
  // START CODE
  return "P4.3c";
  // STOP CODE
 }

 // Problem P4.3d
 public static String p43d(String string) {
  // START CODE
  return "P4.3d";
  // STOP CODE
 }

 // Problem P4.3e
 public static String p43e(String string) {
  // START CODE
  return "P4.3e";
  // STOP CODE
 }
 
 // ******************************
 // PROBLEM P 4.5
 // ******************************

 // Problem P4.5
 public static String p45(String string) {
  // START CODE
  String answer = "Average: "+ 5;
  answer += "\n";
  answer += "Smallest: " + 1;
  answer += "\n";
  answer += "Largest: " + 9;
  answer += "\n";
  answer += "Range: " + 8;
  return answer;
  // STOP CODE
 }
 
}