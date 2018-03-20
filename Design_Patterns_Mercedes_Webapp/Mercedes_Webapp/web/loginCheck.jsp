<%-- 
    Document   : loginCheck
    Created on : Apr 28, 2015, 6:54:12 PM
    Author     : Dylan



--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
 
    <% 
        String username=request.getParameter("username"); 
        String password=request.getParameter("password"); 
        
        // this page acts as a login redirect to check the user
        // information against the server. if the username is in the server,
        // the page will redirect you to loginSuccess.jsp
        
        // right here we need to define passcheck and usercheck so 
        // we know that if this user exists on the database, their
        // password is correct. if not, it will redirect you to error.
        
        // passcheck and usercheck need to come from the database table
        
        if((username.equals("admin") && password.equals("admin"))){  
            response.sendRedirect("loginSuccess.jsp"); 
            } 
            else response.sendRedirect("Error.jsp"); 
    %>


</html>
