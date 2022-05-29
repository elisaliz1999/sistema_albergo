/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.prjsistemaalbergo.controller;

import com.mycompany.prjsistemaalbergo.dao.DAOUser;
import com.mycompany.prjsistemaalbergo.model.Users;
import com.mycompany.prjsistemaalbergo.services.AES256;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elisa
 */
@WebServlet(name = "ControllerRegistration", urlPatterns = {"/ControllerRegistration"})
public class ControllerRegistration extends HttpServlet {
protected DAOUser daoUser;

    public ControllerRegistration() {
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException{
        //response.setContentType("text/html;charset=UTF-8");    GIA DIAMO LA RISPOSTA 
        String firstName = request.getParameter("nome");
        String lastName = request.getParameter("cognome");
        String phoneNumber = request.getParameter("telefono");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       // System.out.println("HelloWorld2"); 
       // RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
       // rd.forward(request, response);
        Users user = new Users();
        user.setNome(firstName);
        user.setCognome(lastName);
        user.setTelefono(phoneNumber);
        user.setEmail(email);
        user.setPassword(password);
        daoUser.nuovoContatto(user);
        response.sendRedirect("index.jsp");
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
        try {
        processRequest(request, response);
        }  catch(Exception e){
         e.printStackTrace(); // metodo che stampa il tracciamento dell'errore partito
        }
        
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
                try {
        processRequest(request, response);
        }  catch(Exception e){
         e.printStackTrace();
        }
        
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
