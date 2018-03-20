package bankingdatabases;

import java.util.Scanner;

public class BankingDatabases {

    public static void main(String[] args) {
        ChaseUser chaseuser = new ChaseUser();
        CitiUser citiuser = new CitiUser();
        String account = "";
        Scanner in = new Scanner(System.in);
        ChaseTransaction transaction = new ChaseTransaction();
        CitiTransaction transactions = new CitiTransaction();
        boolean accountmade = false;
        
        
        //if account exists, login. If not, make an account with either chase or citi.
        while (!accountmade) {
            String temp;
            System.out.println("Do you have an account? y/n");
            temp = in.nextLine();
            if (temp.equals("y") || temp.equals("n")) {
                if (ynCheck(temp)) {
                    System.out.println("Is your account a Chase account? y/n");
                    temp = in.nextLine();
                    if(temp.equals("y") || temp.equals("n")){
                        if(ynCheck(temp)){
                          account = "chase";
                          System.out.println("Enter your name to log into your Chase account:");
                          chaseuser.name = in.nextLine();
                          if(!chaseuser.checkName(chaseuser.name)){
                              System.out.println("Account does not exist. Please try again.");
                              System.exit(0);
                          }

                          System.out.println("Enter your password:");
                          chaseuser.password = in.nextLine();
                          if(!chaseuser.checkPassword(chaseuser.name, chaseuser.password)){
                              System.out.println("Password incorrect. Please try again.");
                              System.exit(0);
                          }
                          break;
                        }
                        else{
                           account = "citi";
                           System.out.println("Enter your name to log in to your Citi account:");
                           citiuser.name = in.nextLine();
                           
                           if(!citiuser.checkName(citiuser.name)){
                               System.out.println("Account does not exist. Please try again.");
                               System.exit(0);
                           }
                           
                           System.out.println("Enter your password:");
                           citiuser.password = in.nextLine();
                           
                           if(!citiuser.checkPassword(citiuser.name , citiuser.password)){
                               System.out.println("Password incorrect. Please try again.");
                               System.exit(0);
                           }
                           break;
                        }
                    }
                    else{
                     System.out.println("Invalid input. Please try again.");
                     System.exit(0);
                    }
                } else {
                    System.out.println("Would you like to create a Chase account? y/n");
                    temp = in.nextLine();
                    if (temp.equals("y") || temp.equals("n")) {
                        if (ynCheck(temp)) {
                            ChaseAccountCreate chasecreate = new ChaseAccountCreate();
                            chaseuser = chasecreate.createUser();
                            System.out.println("Account created. Please log in.");
                            System.exit(0);
                        } else {
                            System.out.println("Would you like to create a Citi account? y/n");
                            temp = in.nextLine();
                            if (temp.equals("y") || temp.equals("n")) {
                                if (ynCheck(temp)) {
                                    CitiAccountCreate citicreate = new CitiAccountCreate();
                                    citiuser = citicreate.createUser();
                                    System.out.println("Account created. Please log in.");
                                    System.exit(0);
                                } else {
                                    System.out.println("Well, there is nothing for you here, then.");
                                    System.exit(0);
                                }
                            } else {
                                System.out.println("Invalid input. Please try again.");
                                System.exit(0);
                            }
                        }
                    } else {
                        System.out.println("Invalid input. Please try again.");
                        System.exit(0);
                    }

                }
            } else {
                System.out.println("Invalid input. Please try again.");
                System.exit(0);
            }
        }
        

        System.out.println(citiuser.name);
        System.out.println(citiuser.password);
        
        System.out.println("What would you like to do?");
        System.out.println("Enter the number to perform an action:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Delete account");
        System.out.println("4. Exit application");
        String action = in.nextLine();
        
        if(Integer.parseInt(action) == 1){
            if(account.equals("chase")){
                System.out.println("How much would you like to deposit?");
                int deposit = in.nextInt();
                System.out.println(transaction.chaseDeposit(chaseuser, deposit) + "");
            }
            else if(account.equals("citi")){
                System.out.println("How much would you like to deposit?");
                int deposit = in.nextInt();
                System.out.println(transactions.citiDeposit(citiuser, deposit));
            }
            else{
                System.out.println("Error.");
                System.exit(0);
            }
        }
        else if(Integer.parseInt(action) == 2){
            if(account.equals("chase")){
                System.out.println("How much would you like to withdraw?");
                int withdraw = in.nextInt();
                System.out.println(transaction.chaseWithdraw(chaseuser, withdraw));
            }
            else if(account.equals("citi")){
                System.out.println("How much would you like to withdraw?");
                int withdraw = in.nextInt();
                System.out.println(transactions.citiWithdraw(citiuser, withdraw));
            }
        }
        else if (Integer.parseInt(action) == 3){
            
            if(account.equals("chase")){
                DeleteAccount delete = new DeleteAccount(chaseuser);
                
            }
            else if(account.equals("citi")){
                DeleteAccount deletes = new DeleteAccount(citiuser);
                
            }
            
        }
        else{
            System.out.println("Incorrect input. Please enter the number for the action you want to perform.");
        }
        
       
        
       
        System.out.println("All actions complete. Please log back in if you want to perform another transaction. Now exiting.");
        System.exit(0);
    }

    static boolean ynCheck(String st) {
        boolean answer = false;
        if (st.equals("y")) {
            answer = true;
        } else if (st.equals("n")) {
            answer = false;
        }
        return answer;
    }
}
