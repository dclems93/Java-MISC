package WebApp;
import java.sql.*;

public class User {
	
	Connection con = Singleton.getInstance();
	
	
	public void createUser(String usn, String password, String name, String address, String gender) throws SQLException, ClassNotFoundException{

			String dtring = "N";
		
			PreparedStatement insertion = con.prepareStatement("INSERT INTO webdbase(ID, PASS, NAME, ADDRESS, GENDER, ACTIVE)" + " VALUES(?, ?, ?, ?, ?, ?)");
			insertion.setString(1, usn);
			insertion.setString(2, password);
			insertion.setString(3, name);
			insertion.setString(4, address);
			insertion.setString(5, gender);
			insertion.setString(6, dtring);
			insertion.executeUpdate();
		

	}
	
	public void login(String tempName, String tempPass) throws SQLException{

		int makesure = 0;

			String sql = "SELECT * from webdb";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()){
				if(rs.getString("ID").equals(tempName) && rs.getString("Pass").equals(tempPass) && rs.getString("Active").equals("N")){
					System.out.println("Welcome you are logged in.");
					makesure++;
					PreparedStatement fix = con.prepareStatement("UPDATE webdb SET Active = ? WHERE ID = ?" );;
					fix.setString(1, "Y");
					fix.setString(2, tempName);
					fix.executeUpdate();
					
				}
				else if(makesure == 0){System.out.println("User not found or logged in elsewhere");}
			}

	}
	
	public void logout(String tempName) throws SQLException{
		
		PreparedStatement fix = con.prepareStatement("UPDATE webdbase SET Active = ? WHERE ID = " + tempName);;
		fix.setString(1, "N");
		fix.executeUpdate();
		
	}
	
		public void delete(String username) throws SQLException{
		
		String dob;
		int makesure = 0;
		
		String sql = "SELECT * from webdbase";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		
		while(rs.next()){
				PreparedStatement deleter = con.prepareStatement("DELETE FROM webdbase WHERE ID = ? AND PASS = ?");
				deleter.setString(1, username);
				deleter.executeUpdate();
				makesure++;
			}
		
	}


}
