<%-- 
    Document   : registration
    Created on : 25-mag-2022, 14.45.27
    Author     : elisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register to Hotel Bliss</title>
    </head>
    <body>
        <h3>  </h3>
         <h1>Register Account</h1>
        <form action="<%= request.getContextPath() %>/ControllerRegistration" method="post">
            <table style="width: 20%">
                <tr>
                    <td>First name</td>
                    <td><input type="text" name="nome" required /></td>
                </tr>
                <tr>
                    <td>Last name</td>
                    <td><input type="text" name="cognome" required/></td>
                </tr>
                <tr>
                    <td>Phone number</td>
                    <td><input type="text" name="telefono" required/></td>
                </tr>
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
            <a href="index.jsp">Already registered with us?</a>
        </form>
    </body>