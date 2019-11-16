 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.EstadoMesaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EstadoM;

/**
 *
 * @author Asus
 */
@WebServlet(name = "EstadoMesa", urlPatterns = {"/EstadoMesa"})
public class EstadoMesa extends HttpServlet {

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
       
       //Instancia de variables
        ArrayList<EstadoM> listaMesas = new ArrayList<>();
       
        //Instancia de clases de tipo consultas (Base de datos)
        EstadoMesaDAO estadoMesaDAO = new EstadoMesaDAO();
    
       
            //Listo todos las mesas desde la BDD y los asigno a la variable lista de proveedores previamente creada
        listaMesas = estadoMesaDAO.listar();
     

       
        
        //Asigno que objetos quiero mandar hacia una página JSP, para su posterior visualización
        //Puede ser cualquier objeto, arraylist, int, string, etc...
        request.setAttribute("Estado", listaMesas);
        
                //Un ejemplo adicional con un string y un int
        request.setAttribute("nombreSistema", "RESTOFAST");
        request.setAttribute("mesas", listaMesas.size());
        
        
        
        
        
   
       //Registrar Estado en la base de datos
       
       
       
        //Redirecciono hacia otra página
        
        request.getRequestDispatcher("EstadoMesas.jsp").forward(request, response);
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
