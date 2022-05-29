<%-- 
    Document   : displroom
    Created on : 25-mag-2022, 15.13.27
    Author     : elisa
--%>


<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Bliss Rooms</title>
    </head>
    <body>
        <h1> Welcome user ${lista}</h1>
        <div>
                        <c:forEach items= "${lista}" var="stanza">
                        
                          
                       
                       
                         <option name="stanzaScelta">${stanza.id}</option>
                       
                    </c:forEach>
        </div>
    </body>
</html>
