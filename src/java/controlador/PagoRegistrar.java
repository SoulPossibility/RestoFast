/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.PagoDAO;
import dao.SesionAtencionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pago;
import modelo.SesionAtencion;

/**
 *
 * @author BlueOcean
 */
@WebServlet(name = "RegistrarPago", urlPatterns = {"/RegistrarPago"})
public class PagoRegistrar extends HttpServlet {

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
            throws ServletException, IOException {

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
        //int atencionObtenida = Integer.parseInt(request.getParameter("idAtencion"));

        PagoDAO pagoDAO = new PagoDAO();
        SesionAtencionDAO sesionAtencionDAO = new SesionAtencionDAO();
        Pago pago = null;
        SesionAtencion sesionAtencion = null;

        sesionAtencion = sesionAtencionDAO.buscar(1);

        //dateInicio = "25-10-2019";
        
        Date date = new Date(System.currentTimeMillis());
        //SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
        java.sql.Date fechaSQL = new java.sql.Date(date.getTime());
        pago = new Pago(0, fechaSQL, 1000, "VISA", "Sin observaciones", sesionAtencion);
        pagoDAO.registrar(pago);
        System.out.println("hola");
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
