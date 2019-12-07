/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClienteDAO;
import dao.MenuDAO;
import dao.MesaDAO;
import dao.OrdenDAO;
import dao.SesionAtencionDAO;
import dao.UsuarioDAO;
import dto.MenuCantidadDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.Menu;
import modelo.Mesa;
import modelo.Orden;
import modelo.SesionAtencion;
import modelo.Usuario;

/**
 *
 * @author BlueOcean
 */
@WebServlet(name = "ClienteRealizarPedido", urlPatterns = {"/ClienteRealizarPedido"})
public class ClienteRealizarPedido extends HttpServlet {

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
        HttpSession session = request.getSession();
        ArrayList<MenuCantidadDTO> carrito = (ArrayList) session.getAttribute("carrito");
        SesionAtencion atencion = (SesionAtencion) session.getAttribute("sesionAtencion");
        
        OrdenDAO ordenDAO = new OrdenDAO();

        //FECHA
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //PARA ASIGNTAR ZONA DE CHILE COMO FECHA, INDEPENDIENTE DE LA UBICACIÓN DEL SERVIDOR
        TimeZone timeZone = TimeZone.getTimeZone("America/Santiago");
        dateFormat.setTimeZone(timeZone);
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));

        java.util.Date fechaAux = cal.getTime();
        java.sql.Date fechaActual = new java.sql.Date(fechaAux.getTime());

        for (MenuCantidadDTO car : carrito) {
            Orden orden = new Orden(0, "elaborando", fechaActual, car.getMenu(), atencion, car.getCantidad());
            System.out.println("orden: " + orden.toString());
            ordenDAO.registrar(orden);
        }

        System.out.println("finalizado");
        //LIMPIANDO PRODUCTOS ASOCIADOS AL CARRITO
        carrito.clear();
        request.getRequestDispatcher("MenuSeleccionar").forward(request, response);
        //int id, String estado, Date fecha, Menu menu, SesionAtencion sesionAtencion
        
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
