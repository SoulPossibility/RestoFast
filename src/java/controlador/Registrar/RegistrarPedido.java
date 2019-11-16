/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Registrar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pedido;
import dao.PedidoDAO;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author femxn
 */
@WebServlet(name = "RegistrarPedido", urlPatterns = {"/RegistrarPedido"})
public class RegistrarPedido extends HttpServlet {

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

        //Obtiene el contenido de cada input text según su atributo 'name'
        int pedido_id = Integer.parseInt(request.getParameter("pedido_id"));
        String fecha_solicitud = request.getParameter("fecha_solicitud");

        try {
            SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date fechaAux = simpleDate.parse(fecha_solicitud);
            java.sql.Date fecha = new java.sql.Date(fechaAux.getTime());

            String estado = request.getParameter("estado");
            String usuario_nombre_usuario = request.getParameter("usuario_nombre_usuario");

            Pedido pedi = new Pedido();
            PedidoDAO pedidoDAO = new PedidoDAO();

            System.out.println("Código Pedido: " + pedido_id + ", Fecha Solicitud: " + fecha_solicitud
                    + ", Estado: " + estado + ", Nombre de Funcionario: " + usuario_nombre_usuario);

            pedi = new Pedido(0, fecha, estado, usuario_nombre_usuario);

            //Registrar proveedor en la base de datos
            pedidoDAO.registrar(pedi);

        } catch (Exception e) {
        }
        //Redirecciono hacia otra página
        request.getRequestDispatcher("ListarPedido").forward(request, response);
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
