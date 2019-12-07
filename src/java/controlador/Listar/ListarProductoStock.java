/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Listar;

import dao.DetallePedidoDAO;
import dao.PedidoDAO;
import dao.ProductoDAO;
import dao.UsuarioDAO;
import dto.ProductoStock;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DetallePedido;
import modelo.Pedido;
import modelo.Producto;
import modelo.Usuario;

/**
 *
 * @author femxn
 */
@WebServlet(name = "ListarProductoStock", urlPatterns = {"/ListarProductoStock"})
public class ListarProductoStock extends HttpServlet {

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

        String[] productos = request.getParameterValues("producto");
        String[] cantidades = request.getParameterValues("cantidad");

        ProductoDAO productoDao = new ProductoDAO();
        DetallePedidoDAO detallePedidoDAO = new DetallePedidoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = null;
        usuario = usuarioDAO.buscar("Nelly");
        ArrayList<ProductoStock> listaProdStocks = new ArrayList();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();

            java.util.Date fechaAux = cal.getTime();
            java.sql.Date fechaInicio = new java.sql.Date(fechaAux.getTime());

            Pedido pedido = new Pedido(0, fechaInicio, "en espera", usuario.getNombre_usuario());
            pedidoDAO.registrarConRetorno(pedido);

            System.out.println("prods");
            printArray(productos);
            System.out.println("cant");
            printArray(cantidades);

            for (int i = 0; i < productos.length; i++) {
                Producto pro = productoDao.buscar(Integer.parseInt(productos[i]));
                ProductoStock proStock = new ProductoStock(pro, Integer.parseInt(cantidades[i]));
                int total = Integer.parseInt(cantidades[i]) * pro.getPrecio();
                System.out.println("qwert" + pedido.getId() + pro.getId() + Integer.parseInt(cantidades[i]) + pro.getPrecio() + "");
                DetallePedido detallePedido = new DetallePedido(pedido.getId(), pro.getId(), Integer.parseInt(cantidades[i]), total, pro.getNombre());
                detallePedidoDAO.registrar(detallePedido);

                listaProdStocks.add(proStock);
            }
        } catch (Exception e) {
        }

        request.setAttribute("listaProdStocks", listaProdStocks);
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

    private void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("indice : " + arr[i]);
        }
    }
}
