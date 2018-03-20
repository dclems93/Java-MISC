package WebApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class verifyUser
 */
@WebServlet("/verifyUser")
public class verifyUser extends HttpServlet {
	
	private Connection conn = null;
	  private Statement stat = null;
	  private PreparedStatement pstmt = null;
	  private ResultSet resultSet = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifyUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String username = request.getParameter("username"); 
         String password = request.getParameter("password");
         try{
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdbase","root","");
            stat = conn.createStatement();
            resultSet = stat.executeQuery("select * from webdbase");
            while(resultSet.next()){
            	String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                
                //PrintWriter out = response.getWriter();
         		//out.println("yes");
                if(user.equals(username) && pass.equals(password)){
                	response.sendRedirect("loginSuccess.jsp");
                }
         		
            }
         }   
          catch(Exception e){
         	 System.out.println(e);
             // JOptionPane.showMessageDialog(null,e);
          } 
 		finally{
 			
 		}
         
		
		
	}

}
