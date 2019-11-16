/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Registrar;

import dao.DetallePedidoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DetallePedido;

/**
 *
 * @author femxn
 */
@WebServlet(name = "RegistrarDetallePedido", urlPatterns = {"/RegistrarDetallePedido"})
public class RegistrarDetallePedido extends HttpServlet {

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
               
        int pedido_id = Integer.parseInt(request.getParameter("pedido_id"));
        int producto_id = Integer.parseInt(request.getParameter("producto_id"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        int valor = Integer.parseInt(request.getParameter("valor"));
        String descripcion = request.getParameter("descripcion");
        
        //Instancia de variables
        DetallePedido detPedido = new DetallePedido();
        
        //Instancia de clases de tipo consultas (Base de datos)
        DetallePedidoDAO detPedidoDAO = new DetallePedidoDAO();
        
        System.out.println("Código Pedido: " + pedido_id + ", Código prd    : " + producto_id + ", Cantidad: " + cantidad + ", Valor: " + valor + ", Descripción: " + descripcion);
        
        detPedido = new DetallePedido(pedido_id, producto_id, cantidad, valor, descripcion);
        
        //Detalle pedido se registra en base de datos
        detPedidoDAO.registrar(detPedido);
        
        request.getRequestDispatcher("ListarDetallePedido").forward(request, response);
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

