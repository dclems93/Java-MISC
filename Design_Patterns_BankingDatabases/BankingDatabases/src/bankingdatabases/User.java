
package bankingdatabases;

public class User {
    String name;
    String gender = null;
    int ssn;
    String dob = "00/00/1000";
    String phone;
    String bank;
    String password;   
    int firstbalance;
 
    public String getName(){
        return this.name;
    }
}
