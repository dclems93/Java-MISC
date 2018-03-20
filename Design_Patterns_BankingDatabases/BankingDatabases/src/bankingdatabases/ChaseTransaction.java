package bankingdatabases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;
import java.util.Scanner;

public class ChaseTransaction {

    Scanner in = new Scanner(System.in);

    public String chaseDeposit(ChaseUser user, int deposit) {
        String ending = "";
        int balance = 0;
        int newbalance;
        try {
            System.out.println("SELECT * FROM bankingdatabase." + user.name
                    + "chasetransactions ORDER BY timestamp DESC LIMIT 1");

            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingdatabase","root","password");

            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM bankingdatabase." + user.name
                    + "chasetransactions ORDER BY timestamp DESC LIMIT 1");
            while(myRs.next()){
                balance = myRs.getInt("balance");
            }
            
            
            System.out.println(balance);
            newbalance = balance + deposit;
            System.out.println(newbalance);

            int depositSet = myStmt.executeUpdate("INSERT INTO bankingdatabase."
                    + user.name + "chasetransactions (timestamp , deposit , balance) "
                    + "VALUES( current_timestamp , " + deposit + " , "
                    + newbalance + " ) ");
            ending += "Your new balance is " + newbalance;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ending;
    }

    public String chaseWithdraw(ChaseUser user, int withdraw) {
        String ending = "";
        int balance = 0;
        int newbalance;
        try {

            Connection myConn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/bankingdatabase",
                            user.name, user.password);

            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM bankingdatabase." + user.name
                    + "chasetransactions ORDER BY timestamp DESC LIMIT 1");

            while(myRs.next()){
                balance = myRs.getInt("balance");
            }
            if(balance - withdraw < 0){
                System.out.println("This action would overdraft your account. Action cannot be performed.");
                System.exit(0);
            }
            newbalance = balance - withdraw;

            if (newbalance < 200) {
                String newdob = "";
                System.out.println("This transaction will put your balance below $200.");
                System.out.println("Please enter your date of birth in MM/DD/YYYY format to confirm.");
                String dob = in.nextLine();

                Connection newConn = DriverManager.
                        getConnection("jdbc:mysql://localhost:3306/bankingdatabase",
                                "root", "password");

                Statement newStmt = newConn.createStatement();
                ResultSet newRs = newStmt.executeQuery("SELECT * FROM bankingdatabase.chaseusers "
                        + "WHERE name = '" + user.name + "' ");
                
                while(newRs.next()){
                    newdob = newRs.getString("dob");
                }

                if (dob.length() == 10) {
                    if ((Integer.parseInt(dob.substring(0, 2)) < 12)
                            && (Integer.parseInt(dob.substring(6, 10)) < 2015)) {
                        if (newdob.equals(dob)) {
                            int withdrawSet = myStmt.executeUpdate("INSERT INTO bankingdatabase."
                                    + user.name + "chasetransactions (timestamp , withdraw , balance)"
                                    + " VALUES( current_timestamp , " + withdraw + " , "
                                    + newbalance + " ) ");

                        } else {
                            System.out.println("Incorrect Date of Birth. Please try again.");
                            System.exit(0);
                        }

                    } else {
                        System.out.println("Invalid input. Please try again.");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Invalid input. Please try again.");
                    System.exit(0);
                }

            } else {
                int withdrawSet = myStmt.executeUpdate("INSERT INTO bankingdatabase."
                        + user.name + "chasetransactions (timestamp , withdraw , balance)"
                        + "VALUES( current_timestamp , " + withdraw + " , "
                        + newbalance + " ) ");
            }

            ending += "Your new balance is " + newbalance;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ending;
    }
}
