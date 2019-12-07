/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Modificar;

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
@WebServlet(name = "ModificarPedido", urlPatterns = {"/ModificarPedido"})
public class ModificarPedido extends HttpServlet {

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
        String fecha_solicitud = request.getParameter("fecha_solicitud");
        
        try {
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechaAux = simpleDate.parse(fecha_solicitud);
            java.sql.Date fecha = new java.sql.Date(fechaAux.getTime());
            System.out.println(fecha);
            String estado = request.getParameter("estado");
            String usuario_nombre_usuario = request.getParameter("usuario_nombre_usuario");
           
            PedidoDAO pedidoDAO = new PedidoDAO();

            System.out.println("Código Pedido: " + pedido_id + ", Fecha Solicitud: " + fecha_solicitud
                    + ", Estado: " + estado + ", Nombre de Funcionario: " + usuario_nombre_usuario);

            Pedido pedi = pedidoDAO.buscar(pedido_id);
            
            pedi.setFecha_solicitud(fecha);
            pedi.setEstado(estado);
            pedi.setUsuario_nombre_usuario(usuario_nombre_usuario);

            //Registrar proveedor en la base de datos
            pedidoDAO.update(pedi);

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
