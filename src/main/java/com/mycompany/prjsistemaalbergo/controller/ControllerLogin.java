/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.prjsistemaalbergo.controller;

import com.mycompany.prjsistemaalbergo.dao.DAORoom;
import com.mycompany.prjsistemaalbergo.dao.DAOUser;
import com.mycompany.prjsistemaalbergo.model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ciao elisa
 *
 * @author elisa
 */
@WebServlet(name = "ControllerLogin", urlPatterns = {"/ControllerLogin"})
public class ControllerLogin extends HttpServlet {

    protected DAOUser daoUser;

    public ControllerLogin() {
        daoUser = new DAOUser();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        String msg = "";
        String next = "";
        try {
            /* TODO output your page here. You may use following sample code. */
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Users user = null;
            user = daoUser.checkLogin(email, password);
            if (user == null) {

                request.setAttribute("msg", msg);
                next = "index.jsp";
                msg = "Login fallito";
                RequestDispatcher rd = request.getRequestDispatcher(next);
                System.out.println("aoooo");
                rd.forward(request, response);
                // TODO messaggio utente non trovato 
            } else {
                request.setAttribute("lista", DAORoom.getStanzeLibere());
                next = "displroom.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(next);
                System.out.println("aaaaaa");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
