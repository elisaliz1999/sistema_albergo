/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjsistemaalbergo.dao;

import com.mycompany.prjsistemaalbergo.model.DB;
import com.mycompany.prjsistemaalbergo.model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author elisa
 */
public class DAORoom {

    public static ArrayList<Room> getStanzeLibere() throws NamingException, SQLException {
        ArrayList<Room> rooms = new ArrayList<>();
        Connection conn = DB.connection();
        String query = "SELECT * FROM ROOM WHERE disponibilita = 1"; //il filtro che seleziona quali stanze verranno inserite nell'array di stanze LIBERE
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Room room = new Room();
            room.setId(Integer.parseInt(rs.getString("id")));
            room.setDisponibilita(rs.getBoolean("disponibilita"));
            room.setBalcone(rs.getBoolean("balcone"));
            room.setPostiLetto(rs.getInt("postiLetto"));
            room.setPostiAuto(rs.getInt("postiAuto"));
            room.setWifi(rs.getBoolean("wifi"));
            rooms.add(room);  //inserisce tutti i record del primo elemento room dell'Array, continua con gli elementi successivi fintanto che si trova nel ciclo
        }
        
        return rooms;
    }
}
