package bankingdatabases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Statement;
import java.util.*;

public class CitiAccountCreate extends CreateAccount {

    String address;
    String bank = "citi";
    int pin;

    public boolean checkUser(String name) {
        boolean newuser = false;
        try {

            Connection myConn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/bankingdatabase",
                            "root", "jacob1923");

            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM bankingdatabase.citiusers");

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

    public String statementBuild(String[] ls) {
        String temp = "values( ";
        for (int i = 0; i < ls.length; i++) {
            if (i == ls.length - 1) {
                temp += "'" + ls[i] + "'" + " )";
            } else {
                temp += "'" + ls[i] + "' , ";
            }
        }
        return temp;
    }

    public CitiUser createUser() {
        CitiUser user = new CitiUser();
        try {
            Scanner in = new Scanner(System.in);
            

            System.out.println("Enter Name:");
            user.name = in.nextLine();

            if (!checkUser(user.name)) {

                System.out.println("New Password:");
                user.password = in.nextLine();
                
                while(user.pin == 0){
                    System.out.println("Enter a five digit pin. This will be used to delete your account:");
                    int temp = in.nextInt();
                    if(Integer.toString(temp).length() == 5){
                        user.pin = temp;
                    }
                }
                

                while (user.gender == null) {
                    System.out.println("Gender?  Enter M for Male or F for Female.");
                    String temp = in.nextLine();
                    if (temp.equals("M") || temp.equals("m")) {
                        user.gender = "M";
                        break;
                    }
                    if (temp.equals("F") || temp.equals("f")) {
                        user.gender = "F";
                        break;
                    } else {
                        System.out.println("Invalid input.");
                    }
                }
                
                System.out.println("Enter address:");
                user.address = in.nextLine();
                
                System.out.println("Enter Social Security Number:");
                user.ssn = in.nextInt();

                while (this.dob.equals("00/00/1000")) {
                    System.out.println("Enter Date of Birth in MM/DD/YYYY format:");
                    String temp = in.nextLine();

                    if (temp.length() == 10) {
                        if ((Integer.parseInt(temp.substring(0, 2)) < 12)
                                && (Integer.parseInt(temp.substring(6, 10)) < 2015)) {
                            user.dob = temp;
                            break;
                        } else {
                            System.out.println("Invalid input.");
                        }
                    } else {
                        System.out.println("Invalid input.");
                    }

                }

                System.out.println("Enter Phone Number:");
                user.phone = in.nextLine();

                System.out.println("Enter your first deposit. The minimum is $250.");
                user.firstbalance = in.nextInt();
                if(user.firstbalance < 250){
                    System.out.println("Insufficient first balance.");
                    System.exit(0);
                }

                String[] userinfo = new String[]{user.name, user.password,
                    user.pin + "" , user.gender, user.ssn + "", user.dob,
                    user.phone + "", user.address};

                Connection myConn = DriverManager.
                        getConnection("jdbc:mysql://localhost:3306/bankingdatabase",
                                "root", "password");
                System.out.println(statementBuild(userinfo));

                Statement myStmt = myConn.createStatement();
                int myRs = myStmt.executeUpdate(("INSERT INTO bankingdatabase.citiusers "
                        + "(name, password, pin, gender, ssn, dob, phone, address)"
                        + statementBuild(userinfo)));

                int newTable = myStmt.executeUpdate("CREATE TABLE " + user.name
                        + "cititransactions (timestamp timestamp not null, deposit int, withdraw int, balance int)");
                
                int firstDep = myStmt.executeUpdate("INSERT INTO bankingdatabase." + user.name 
                        + "cititransactions (timestamp , deposit , balance) VALUES( current_timestamp , " 
                        + user.firstbalance + " , " + user.firstbalance + " )");

                int newUser = myStmt.executeUpdate("CREATE USER '" + user.name
                        + "'@'localhost' IDENTIFIED BY '" + user.password + "'");

                int setPermission = myStmt.executeUpdate("GRANT INSERT,SELECT ON bankingdatabase."
                        + user.name + "cititransactions TO '" + user.name + "'@'localhost' ");

                int flush = myStmt.executeUpdate("FLUSH PRIVILEGES");

                System.out.println("For future transactions, use your name and password to login.");

            } else {
                System.out.println("User Account already exists.");
                System.exit(0);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
