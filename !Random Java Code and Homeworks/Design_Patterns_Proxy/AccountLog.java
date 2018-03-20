import java.util.*;

class AccountLog{
  public static void main(String[] args){
    
    Scanner s = new Scanner(System.in);
    
    
    GetFileAccess realFileAccess = new FileAccess();
    
    GetFileAccess proxyFileAccess = new AccessProxy();
    
    System.out.println("What is your Username?");
    String username = s.nextLine();
    
    System.out.println("What is your SSN?");
    String ssn = s.nextLine();
    
    System.out.println("What is your Bank Number?");
    String banknumber = s.nextLine();
    
    proxyFileAccess.addUser(username, ssn, banknumber);
    
    
    //realFileAccess.readUser(username);
    // this line does not work because the proxy blocks this method from being implimented, thus 
    // securing the data.
    
  }
  
  
}