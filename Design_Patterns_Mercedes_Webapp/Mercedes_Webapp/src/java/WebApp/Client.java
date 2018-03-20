package WebApp;

import java.sql.SQLException;
import java.sql.*;

public class Client {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		User user = new User();
		//user.createUser("jn", "12", "JohnB", "America", "Male");
		user.login("jn", "12");
	//	user.logout("4");

	}
}
