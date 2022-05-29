<%-- 
    Document   : index
    Created on : 25-mag-2022, 10.20.24
    Author     : elisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Bliss</title>
    <h1> Hotel Bliss </h1>
</head>
<body>
    <h1>Benvenuto! <br> Welcome! <br> Willkommen! <br> Добро пожаловать! <br> Bienvenue! </h1>
    <div>
        <form action="<%= request.getContextPath()%>/ControllerLogin" method="post">
            <table style="width: 20%">
                <tr>
                    <td>email</td>
                    <td><input type="text" name="email" required/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" required/></td> <!<!-- password va slegata dall'utente. NON deve essere salvata -->
                </tr>
            </table>
            <input type="submit" value="Submit" />
        </form>
    </div>
    <a href="displroom.jsp">Look for available rooms</a>
    <a href="registration.jsp"><br>Register</a>
</body>
</html>