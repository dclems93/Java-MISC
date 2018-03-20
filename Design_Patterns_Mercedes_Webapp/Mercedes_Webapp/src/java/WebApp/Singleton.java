package WebApp;
import java.sql.*;

public class Singleton{

	volatile static Connection con;

	public static Connection getInstance(){
		if(con == null){
			synchronized(Singleton.class){
				if(con == null){
					try{
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdbase", "root", "");
					}
					catch(SQLException se){
						System.out.println(se.getMessage());
					}

					catch(Exception e){
						System.out.println("exception");

					}
				}

			}
		}
		return con;
	}


}