//full name: Dylan Clements
//user name: dyclemen
//collaborator(s): Xander Montgomery
import java.util.Arrays;

class Homework5 {
 
  public static void main(String[] args) {
   
    int[] a = {1, 4, 9, 16 , 9, 7, 4, 9, 11};
    int[] b = {1, 4, 9, 16 , 7, 7, 4, 9, 11};

               
    //P6.6
    System.out.println( "P66(): " + P66(a) ); // should print: P68(): -2 
    
    //P6.7
    System.out.println( "P67(): " + prettyPrint( P67(a) ) );   //should print: P67(): [11, 9, 4, 7, 9, 16, 9, 4, 1] 
    
    //P6.9
    System.out.println( "equals(): " + equals(a, b)  ); // should print: P69(): false 
    
    //P6.10
    System.out.println( "sameSet(): " +  sameSet(a, b)  ); // should print:  P610(): true 
    
  }
  
  //this method can be used to see a nice visual representation of an array of ints
  public static String prettyPrint(int[] array) {
    if (array == null) {
     return "null"; 
    }
    String answer = "[";
    for (int i=0; i< array.length; i++) {
     answer += array[i] + ", ";
    }
    answer = answer.substring(0, answer.length() -2);
    answer += "]";
   return answer; 
  }
  
  
  //***************************
  //*****  Problem P6.6  ******
  //***************************
  
  //Problem P6.6
  public static int P66(int[] array) {
    int answer=0;
    for(int i=0; i < array.length;  i++){
      if(i%2!=0){
        answer-= array[i];
      }
      else answer+= array[i];
    }
    return answer;
  }
  
  //***************************
  //*****  Problem P6.7  ******
  //***************************
  
  //Problem P6.7
  public static int[] P67(int[] array) {
    int[] array2 = new int[array.length];
    for(int i = 0 , b = (array.length - 1); i <array.length ; i++ ,  b--){
     array2[i] = array[b];

    }
    return array2;
  }
  
  //***************************
  //*****  Problem P6.9  ******
  //***************************
  
  //Problem P6.9
  public static boolean equals(int[] a, int[] b) {
    boolean answer=true;
    if(a.length!=b.length){
      answer= false; 
      }
    else for(int i=0; i<a.length; i++){
        if(a[i]!=b[i]){
          answer= false;
        }
      
    } 
    return answer;
  }
  
  //***************************
  //*****  Problem P6.10  *****
  //***************************
  
  //Problem P6.10
  public static boolean sameSet(int[] a, int[] b) {
    boolean answer=true;
    Arrays.sort(a);
    Arrays.sort(b);
    
    a = removeDuplicates(a);
    b = removeDuplicates(b);
    if(a.length!=b.length){
      answer=false;
      System.out.println("1");
    }
     else for(int i=0;  i < a.length; i++){
       if(a[i] == b[i]){
         answer=true;
       }
       else {
         answer = false; 
         break;
         
       }
     }
    return answer;
     
  }
  
     public static int[] removeDuplicates(int []s){
        int result[] = new int[s.length], j=0;
        for (int i : s) {
            if(!isExists(result, i))
                result[j++] = i;
        }
        return result;
    }
    private static boolean isExists(int[] array, int value){
        for (int i : array) {
            if(i==value)
                return true;
        }
        return false;
    }
  }
