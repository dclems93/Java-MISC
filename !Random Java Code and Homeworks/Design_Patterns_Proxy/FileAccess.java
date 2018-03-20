import java.io.*;
import static java.lang.System.*;


public class FileAccess implements GetFileAccess{
  public void addUser(String userName, String ssn, String bankNumber){
    try{
      FileWriter fw = new FileWriter(userName + ".txt");
      PrintWriter pw = new PrintWriter(fw);
      
      pw.println("Username: " + userName);
      pw.println("User SSN: " + ssn);
      pw.println("User Account#: " + bankNumber);
      
      pw.close();
      
      
      
    }
    catch(IOException e){
      out.println("ERROR!"); 
    }
    
  }
  
  
  // This is the potentially harmfull method that the proxy protects against
  public void readUser(String filename){
    try{
      FileReader fr = new FileReader(filename + ".txt");
      BufferedReader br = new BufferedReader(fr);
      
      String str;
      while((str = br.readLine()) != null) {
        out.println(str + "\n");
      }
      
      br.close();
    }
    catch(IOException e){
     out.println("File not found"); 
    }
    
  }
  
  
}