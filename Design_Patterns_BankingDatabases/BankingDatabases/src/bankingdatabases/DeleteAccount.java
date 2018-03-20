package bankingdatabases;

import java.util.*;
import java.sql.*;

public class DeleteAccount {

    Scanner in = new Scanner(System.in);
    Boolean stop = true;

    public DeleteAccount(ChaseUser user) {
        try {
            if (verifyUser(user)) {
                Connection myConn = DriverManager.
                        getConnection("jdbc:mysql://localhost:3306/bankingdatabase",
                                "root", "password");

                Statement myStmt = myConn.createStatement();

                int deleteTable = myStmt.executeUpdate("DROP TABLE " + user.getName() + "chasetransactions");

                int deleteUser = myStmt.executeUpdate("Delete FROM chaseusers where name = " + user.getName());

                int deleteAccount = myStmt.executeUpdate("DROP USER '" + user.getName() + "'@'localhost'");
                System.out.println("Account deleted.");
                System.exit(0);
            } else {
                System.out.println("Verification failed. Information incorrect.");
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DeleteAccount(CitiUser user) {
        try {
            if (verifyUser(user)) {
                Connection myConn = DriverManager.
                        getConnection("jdbc:mysql://localhost:3306/bankingdatabase",
                                "root", "password");

                Statement myStmt = myConn.createStatement();

                int deleteTable = myStmt.executeUpdate("DROP TABLE " + user.getName() + "cititransactions");

                int deleteUser = myStmt.executeUpdate("Delete FROM citiusers where name = " + user.getName());

                int deleteAccount = myStmt.executeUpdate("DROP USER '" + user.getName() + "'@'localhost'");
                System.out.println("Account deleted. Please exit.");
                System.exit(0);
            } else {
                System.out.println("Verification failed. Information incorrect.");
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyUser(ChaseUser user) {
        boolean answer = false;
        try {
            Connection myConn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/bankingdatabase",
                            "root", "password");

            Statement myStmt = myConn.createStatement();

            ResultSet dobCheck = myStmt.executeQuery("SELECT " + user.getName() + " FROM bankingdatabase.chaseusers");

            System.out.println("Enter your Date of Birth in dd/mm/yyyy format to delete your account:");

            String temp = in.nextLine();
            if (temp.contentEquals(dobCheck.getString("dob"))) {
                answer = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

    public boolean verifyUser(CitiUser user) {
        boolean answer = false;
        try {
            //ChaseUser newuser = new ChaseUser();
            Connection myConn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/bankingdatabase",
                            "root", "password");

            Statement myStmt = myConn.createStatement();

            ResultSet dobCheck = myStmt.executeQuery("SELECT " + user.getName() + " FROM bankingdatabase.citiusers");

            System.out.println("Enter your Date of Birth in dd/mm/yyyy format to delete your account:");

            String temp = in.nextLine();
            if (temp.contentEquals(dobCheck.getString("dob"))) {
                answer = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }
}
