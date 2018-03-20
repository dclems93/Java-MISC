//full name: Dylan Clements
//user name: dyclemen
//collaborator(s): none

class Homework4 {
    
    public static void main( String[] args) {
 System.out.println( middle("abc") ); //should output "b"
 System.out.println( middle("abcd") ); //should output "bc"
 System.out.println(repeat("he", 0) ); //should output ""
 System.out.println(repeat("he", 3) ); //should output "hehehe"
 System.out.println(countVowels("abcde") ); //should output 2
 System.out.println(countWords("Mary had a little lamb") ); //should output 5
 System.out.println( reverse("wolf") ); //should output "flow"

}
    // P5.4
    
    public static String middle(String str) {
 
    if (str.length()%2 !=0)
    {return( str.substring(((str.length()) /2),((str.length() /2)+1)));
    }
   else return( (str.substring((((str.length()) /2)-1),((str.length() /2)+1)))); 
    }
    
    
  
    // P5.5
    public static String repeat(String str, int n) {
      String answer= "";
      for(int i=0; i<n; i++){
        answer += str;
      }
 return answer;
    }
  
    // P5.6
    public static int countVowels(String str) {
      int answer=0;
        for(int i=0;i<str.length(); i++){
        if(str.charAt(i)=='a'||
           str.charAt(i)=='e'||
           str.charAt(i)=='i'||
           str.charAt(i)=='o'||
           str.charAt(i)=='u'||
           str.charAt(i)=='A'||
           str.charAt(i)=='E'||
           str.charAt(i)=='I'||
           str.charAt(i)=='O'||
           str.charAt(i)=='U')
        {
          answer=answer+1;
        }}
 return answer;
    }

    // P5.7
    public static int countWords(String str) {
      int answer=0;
      String str2= str + ' ';
      for(int i=0;i<(str.length()+1);i++){
        if(str2.charAt(i)==' '){
          answer+=1;}
      }
      
      return answer;}
    // P5.15
    public static String reverse(String str) {
     String answer="";
     String str2=' '+ str;
      for(int i=(str2.length()-1);i>0;i--){
        answer+=str2.charAt(i);}
 return answer;
    }

}
