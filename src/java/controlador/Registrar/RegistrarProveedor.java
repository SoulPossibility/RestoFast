/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Registrar;

import dao.ProveedorDAO;
import java.io.IOException;
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
@WebServlet(name = "RegistrarProveedor", urlPatterns = {"/RegistrarProveedor"})
public class RegistrarProveedor extends HttpServlet {

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
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        
        //Instancia de variables
        Proveedor prov = new Proveedor();
        //Instancia de clases de tipo consultas (Base de datos)
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        
        
        //Reviso en la consola si se estan pasando bien los parametros (La info aparece en Pestaña de GlassFish Server)
        System.out.println("Nombre: " + nombre + ", Direccion: " + direccion +
                ", Telefono: " + telefono + ",Email: " + email);
        
        //Se asigna un proveedor nuevo a la variable prov
        // El 0 puede ser cualquier valor INT,  por que en ProveedorDAO se genera la id automaticamente de todas formas.
        prov = new Proveedor(0, nombre, direccion, telefono, email);

        //Registrar proveedor en la base de datos
        proveedorDAO.registrar(prov);

        //Redirecciono hacia otra página
        request.getRequestDispatcher("index.html").forward(request, response);
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
