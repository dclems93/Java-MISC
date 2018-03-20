<%-- 
    Document   : chooseOptions
    Created on : Apr 28, 2015, 7:13:02 PM
    Author     : Dylan
--%>

<%@page import="WebApp.MercedesStore"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
    <body background = "C:\Users\Nitin\Desktop\set5.png">
        <form action="displayCar.jsp" method="POST">
            <table border="0">
                
                <%
                    String city = request.getParameter("cities");
                    session.setAttribute("city", city);
                %>
                <tbody>
                    <tr>
                        <td>Choose a model:</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><input type="radio" name="model" value="ModelOne" /></td>
                        <td>Model One</td>
                    </tr>
                    <tr>
                        <td><input type="radio" name="model" value="ModelTwo" /></td>
                        <td>Model Two</td>
                    </tr>
                    <tr>
                        <td><input type="radio" name="model" value="ModelThree" /></td>
                        <td>Model Three</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Choose optional features:</td>
                        <td></td>
                    </tr>
                    
                    <tr>
                        <td><input type="checkbox" name="audio" value="ON" /></td>
                        <td>Audio</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="bluetooth" value="ON" /></td>
                        <td>Bluetooth</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="Navigation" value="ON" /></td>
                        <td>Navigation</td>
                    </tr>
                            <tr><td>
                                    <input type="submit" value="submit" name="submit" />
                        </td></tr>
                </tbody>
            </table>

        
        
        </form>
            
            
        
    </body>
</html>
