
package bankingdatabases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChaseUser extends User {

    String otherbank;
    String email;

    public boolean checkName(String name) {
        boolean newuser = false;
        try {

            Connection myConn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/bankingdatabase",
                            "root", "jacob1923");

            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM bankingdatabase.chaseusers");

            while (myRs.next()) {
                if (name.contentEquals(myRs.getString("name"))) {
                    newuser = true;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newuser;
    }

    public boolean checkPassword(String name, String password) {
        boolean newuser = false;
        try {

            Connection myConn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/bankingdatabase",
                            "root", "password");

            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM bankingdatabase.chaseusers where name = '" + name + "'");

            while (myRs.next()) {
                if (password.contentEquals(myRs.getString("password"))) {
                    newuser = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newuser;
    }

}
