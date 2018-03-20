public class AccessProxy implements GetFileAccess{
  public void addUser(String userName, String ssn, String bankNumber){
    
    FileAccess realFileAccess = new FileAccess();
    realFileAccess.addUser(userName, ssn, bankNumber);
    
  }
}