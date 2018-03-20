<%-- 
    Document   : index
    Created on : Apr 26, 2015, 9:03:29 PM
    Author     : Dylan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body background = "C:\Users\Nitin\Desktop\mercedes-benz_sl-class_r231_model_navigation_960x298_12-2011.jpg">
        <h1>Please Login:</h1>
        <form name="formLogin" action="createAccount" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Username : </td>
                        <td><input type="text" name="username" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password : </td>
                        <td><input type="text" name="password" value="" /></td>
                    </tr>
                            
                </tbody>
            </table>
            <a href="http://localhost:8080/GroupProject2/createAccount.jsp">Create Account</a>  
            <input type="submit" value="Submit" name="submit" />
                      

           
        </form>
        
    </body>
</html>
