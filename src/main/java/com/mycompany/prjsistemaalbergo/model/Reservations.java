/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjsistemaalbergo.model;

import java.sql.Date;

/**
 *
 * @author elisa
 */
public class Reservations {
private int idRservation;
private int idUsers;
private int idRoom;
private Date date;

    public int getIdRservation() {
        return idRservation;
    }

    public void setIdRservation(int idRservation) {
        this.idRservation = idRservation;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    
}
