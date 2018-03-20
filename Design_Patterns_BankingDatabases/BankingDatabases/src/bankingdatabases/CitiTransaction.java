package bankingdatabases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;
import java.util.Scanner;

public class CitiTransaction {

    Scanner in = new Scanner(System.in);

    public String citiDeposit(CitiUser user, int deposit) {
        String ending = "";
        int balance = 0;
        int newbalance;
        try {
            System.out.println("SELECT * FROM bankingdatabase." + user.name
                    + "cititransactions ORDER BY timestamp DESC LIMIT 1");

            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingdatabase", "root", "password");

            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM bankingdatabase." + user.name
                    + "cititransactions ORDER BY timestamp DESC LIMIT 1");
            while (myRs.next()) {
                balance = myRs.getInt("balance");
            }

            newbalance = balance + deposit;
            
            System.out.println();

            int depositSet = myStmt.executeUpdate("INSERT INTO bankingdatabase."
                    + user.name + "cititransactions (timestamp , deposit , balance) "
                    + "VALUES( current_timestamp , " + deposit + " , "
                    + newbalance + " ) ");
            
            ending = "Your new balance is " + newbalance;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ending;
    }

    public String citiWithdraw(CitiUser user, int withdraw) {
        String ending = "";
        int balance = 0;
        int newbalance;
        try {

            Connection myConn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/bankingdatabase",
                            user.name, user.password);

            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM bankingdatabase." + user.name
                    + "cititransactions ORDER BY timestamp DESC LIMIT 1");

            while (myRs.next()) {
                balance = myRs.getInt("balance");
            }
            if (balance - withdraw < 100) {
                System.out.println("This action would make your balance below $100. Action denied.");
                System.exit(0);
            }
            newbalance = balance - withdraw;

            int withdrawSet = myStmt.executeUpdate("INSERT INTO bankingdatabase."
                    + user.name + "cititransactions (timestamp , withdraw , balance)"
                    + "VALUES( current_timestamp , " + withdraw + " , "
                    + newbalance + " ) ");

            ending = "Your new balance is " + newbalance;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ending;
    }
}
