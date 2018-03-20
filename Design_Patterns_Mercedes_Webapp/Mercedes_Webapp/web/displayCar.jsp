<%-- 
    Document   : displayCar
    Created on : Apr 28, 2015, 7:40:12 PM
    Author     : Dylan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body background = "C:\Users\Nitin\Desktop\set7.jpg">
        <%
            // This is the final page, and should display the 
            // final string of what the user chose
            
            String model = request.getParameter("model");
            String audio = request.getParameter("audio");
            String bluetooth = request.getParameter("bluetooth");
            String navigation = request.getParameter("navigation");
            String city = (String)session.getAttribute("city");
            
            
            // use model to call the model that the user chose
            
            // use city to call what city they chose
            
            
            // the optional features will read "ON" if they are chosen
            
            // use audio to call the audio
            // use bluetooth to call bluetooth 
            // use navigation to call navigation
            
            
            //below is an example of how to display the function
            %>
            <%= city%><br>
            <%= model  %><br>
            <%= audio  %><br>
            <%= bluetooth  %><br>
            <%= navigation  %><br>
            
        
        
        
    </body>
</html>
