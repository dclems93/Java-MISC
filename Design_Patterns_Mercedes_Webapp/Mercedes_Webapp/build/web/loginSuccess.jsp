<%-- 
    Document   : loginSuccess
    Created on : Apr 28, 2015, 6:40:38 PM
    Author     : Dylan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <body background = "C:\Users\Nitin\Desktop\set4.jpg">
        <h1>Account successfully logged in! <br><br>
            Please choose a city : <br><br>
            <form name="city" action="chooseOptions.jsp" method="POST">
                <input type="radio" name="cities" value="Bloomington" /> Bloomington<br>
                <input type="radio" name="cities" value="Chicago" /> Chicago<br>
                <input type="radio" name="cities" value="NewYorkCity" /> New York City<br>
                <input type="submit" value="submit" name="submit" /> <br>
            </form>
    </body>
</html>
