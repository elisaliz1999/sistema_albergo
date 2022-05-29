/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjsistemaalbergo.model;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author elisa
 */
public class DB {
    public static Connection connection() throws NamingException, SQLException{
        Context initContext = new InitialContext();
        Context envContext = (Context)initContext.lookup("java:/comp/env"); //allows defining a variable pointing directly to this node
        DataSource ds = (DataSource)envContext.lookup("jdbc/sistema_albergo"); // short for:   DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/sistema_albergo");
        Connection conn = ds.getConnection();
        return conn;
    }
}
