<%-- 
    Document   : createAccount
    Created on : Apr 26, 2015, 9:27:33 PM
    Author     : Dylan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body background = "C:\Users\Nitin\Desktop\Mercedes-Benz-Logo-Art.png">
        <form name="accountCreate" action="createAccount" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th>First Name : </th>
                        <th><input type="text" name="firstname" value="" /></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Last Name : </td>
                        <td><input type="text" name="lastname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Gender : </td>
                        <td><input type="text" name="gender" value="" /></td>
                    </tr>
                    <tr>
                        <td>Username : </td>
                        <td><input type="text" name="username" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password : </td>
                        <td><input type="text" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td> Address : </td>
                        <td>
                            <input type="text" name="address" value="" />
                        </td>
                        
                    </tr>
                    
                    <tr>
                        <td>
                            <input type="submit" value="submit" name="Submit" /> 
                        </td>
                        
                    </tr>

                </tbody>
                
            </table>

        
        
        </form>
        
    </body>
</html>
