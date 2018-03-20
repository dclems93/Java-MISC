/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 *
 * @author Nitin
 */
@WebServlet(name = "createAccount", urlPatterns = {"/createAccount"})
public class createAccount extends HttpServlet {

    
	private Connection conn = null;
	  private Statement stat = null;
	  private PreparedStatement pstmt = null;
	  private ResultSet resultSet = null;
	
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet createAccount</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createAccount at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    /*   String firstname = request.getParameter("firstname") +
        request.getParameter("lastname");
        String gender = request.getParameter("gender");
        String username = request.getParameter("username"); 
        String password = request.getParameter("password");
        String address = request.getParameter("address"); 
        PrintWriter out = response.getWriter();
		out.println(username+" "+password+" "+address);
		
		Singleton conn=(Singleton) Singleton.getInstance();
		PreparedStatement pstmt = null;
		try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection myConn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/webdbase",
                            "root", "");
            
            Statement myStmt = myConn.createStatement();
                ResultSet myRs = myStmt.executeQuery("insert into webdbase (firstname, gender, username, password, address) values("
                + firstname+ ", " + gender + ", " + username + ", " + password + ", " + address + " )");
            //conn = (Singleton) DriverManager.getConnection("jdbc:mysql://localhost:3306/webdbase","root","");
            //pstmt = ((Connection) conn).prepareStatement("insert into webdbase (firstname, gender, username, password, address) values(?,?,?,?,?)");
            //pstmt.setString(1,firstname);
            //pstmt.setString(2,gender);
            //pstmt.setString(3,username);
            //pstmt.setString(4,password);
            //pstmt.setString(5,address);
            //int i =pstmt.executeUpdate();
    
        }   
         catch(Exception e){
        	 System.out.println(e);
            // JOptionPane.showMessageDialog(null,e);
         } 
        
        //User user = new User();
        //user.createUser(username,password,firstname,address,gender);
        //*/
        
        
        String firstname = request.getParameter("firstname") +
                 request.getParameter("lastname");
                 String gender = request.getParameter("gender");
                 String username = request.getParameter("username"); 
                 String password = request.getParameter("password");
                 String address = request.getParameter("address"); 
                 PrintWriter out = response.getWriter();
         		
         		
         		
         		try{
                           // out.println("yes");
                     Class.forName("com.mysql.jdbc.Driver");
                     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdbase","root","");
                    stat = conn.createStatement();
                     pstmt = conn.prepareStatement("insert into webdbase values(?,?,?,?,?)");
                     pstmt.setString(1,firstname);
                     pstmt.setString(2,gender);
                     pstmt.setString(3,username);
                     pstmt.setString(4,password);
                     pstmt.setString(5,address);
                     int i =pstmt.executeUpdate();
                     
                     out.println(i+" hhvg");
                     if (i>0){
                     	out.println("yes");
                    	
                       //  JOptionPane.showMessageDialog(null, "Account successfullly Created!");
                     }
                     else{
                     	out.println("not");
                        
                        // JOptionPane.showMessageDialog(null,"Accout not Created");
                     }
                 }   
                  catch(Exception e){
                 	 System.out.println(e);
                     // JOptionPane.showMessageDialog(null,e);
                  } 
         		finally{
         			
         		}
                 
         
         
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
