<%-- 
    Document   : display
    Created on : Apr 28, 2015, 4:06:01 PM
    Author     : Dylan
--%>

<%@page import="WebApp.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <body>
        <h1>Account Successfully created!</h1>
    
        <%
            String name = request.getParameter("firstname") +
                    request.getParameter("lastname");
            
            String id = request.getParameter("username");
                    
            String gender = request.getParameter("gender");
                    
                    
            String address = request.getParameter("address");
                    
                    
            String password = request.getParameter("password");
                    
           //User user = new User();
           //user.createUser(id, password, name, address, gender);
           
            %>
    </body>
</html>
