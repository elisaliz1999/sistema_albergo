/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjsistemaalbergo.dao;

import com.mycompany.prjsistemaalbergo.model.DB;
import com.mycompany.prjsistemaalbergo.model.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;

/**
 *
 * @author elisa
 */
public class DAOUser {
    public Users checkLogin(String email, String password) throws SQLException ,
            ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/sistema_albergo";
        String dbUser = "root";
        String dbPassword = "";    //adattare il CheckLogin, capire come
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM users WHERE email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        Users user = null;
 
        if (result.next()) { //moves the pointer of the current (ResultSet) object to the next row, from the current position.
            user = new Users();
            user.setNome(result.getString("nome"));
            user.setCognome(result.getString("cognome"));
            user.setEmail(email);
        }
 
        connection.close();
 
        return user;
    }
    public void nuovoContatto(Users user) throws NamingException, SQLException{
        insert(user);
    }
    public void insert(Users user) throws NamingException, SQLException{
        Boolean ret;
        Connection conn=null;
        conn = DB.connection();
        String query = "INSERT INTO USERS (NOME, COGNOME, TELEFONO, EMAIL, PASSWORD) VALUES (?, ?, ?, ?, ?)";
        //PreparedStatement stmt = conn.prepareStatement(query);
        PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        Integer idLast=0;
        stmt.setString(1, user.getNome());
        stmt.setString(2, user.getCognome());
        stmt.setString(3, user.getTelefono());
        stmt.setString(4, user.getEmail());
        stmt.setString(5, user.getPassword());
        stmt.executeUpdate();
        ResultSet rs=stmt.getGeneratedKeys();
        if (rs.next()){
            idLast=rs.getInt(1);
            user.setId(idLast);
        }
        conn.close(); 
    }
}
