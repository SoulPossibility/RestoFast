/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Listar;

import dao.ProveedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Proveedor;

/**
 *
 * @author BlueOcean
 */
@WebServlet(name = "ListarProveedor", urlPatterns = {"/ListarProveedor"})
public class ListarProveedor extends HttpServlet {

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
        //Instancia de variables
        ArrayList<Proveedor> listaProveedores = new ArrayList<>();
        //Instancia de clases de tipo consulta
        ProveedorDAO proveedorDAO = new ProveedorDAO(); 
        
        //Listo todos los proveedores desde la BDD y los asigno a la variable lista de proveedores previamente creada
        listaProveedores = proveedorDAO.listar();
        
        //Asigno que objetos quiero mandar hacia una página JSP, para su posterior visualización
        //Puede ser cualquier objeto, arraylist, int, string, etc...
        request.setAttribute("proveedores", listaProveedores);
        
        //Un ejemplo adicional con un string y un int
        request.setAttribute("nombreSistema", "RESTOFAST");
        request.setAttribute("cantidad", listaProveedores.size());
        
        //Redirecciono a la página deseada, internamente manda los atributos recien seteados
        request.getRequestDispatcher("listarProveedor.jsp").forward(request, response);
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
