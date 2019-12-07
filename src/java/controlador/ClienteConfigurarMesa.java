/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.MesaDAO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Mesa;

/**
 *
 * @author BlueOcean
 */
@WebServlet(name = "ClienteConfigurarMesa", urlPatterns = {"/ClienteConfigurarMesa"})
public class ClienteConfigurarMesa extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteConfigurarMesa</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteConfigurarMesa at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String numeroMesa = request.getParameter("EstablecerMesa");
//FLUJO INICIAL CARGAR MESAS PARA ELEGIR UNA POSTERIORMENTE
        if (numeroMesa == null) {
            ArrayList<Mesa> listaMesas = new ArrayList<>();
            MesaDAO mesaDAO = new MesaDAO();

            listaMesas = mesaDAO.listar();
            request.setAttribute("mesas", listaMesas);
            request.getRequestDispatcher("clienteConfigurarMesa.jsp").forward(request, response);
//FLUJO DE SETEAR MESA SI numeroMesa NO ES NULL
        } else {
            ArrayList<Mesa> listaMesas = new ArrayList<>();
            MesaDAO mesaDAO = new MesaDAO();
            listaMesas = mesaDAO.listar();
            
            int numero = Integer.parseInt(numeroMesa);
//            String directory = System.getProperty("user.home");
//            String fileName = "numeroMesaRestoFast.txt";
//            String absolutePath = directory + File.separator + fileName;
//
//            // ESCRIBE CONTENIDO EN UN ARCHIVO EN EL DIRECTORIO USER -> USUARIOACTUAL DE WINDOWS
//            // EL NUMERO DE LA MESA DE ESTE DISPOSITIVO SE LEERA DESDE EL ARCHIVO CREADO Y SE REEMPLAZARA ANTE CAMBIOS
//            try (FileWriter fileWriter = new FileWriter(absolutePath)) {
//                String fileContent = "" + numero;
//                fileWriter.write(fileContent);
//            } catch (IOException e) {
//                // exception handling
//            }
            
            HttpSession sesionMesa = request.getSession();
            sesionMesa.setAttribute("configuracionMesa", numero);
            
            Cookie mesaCookie = new Cookie("numeroMesa.numero", ""+numero);
            mesaCookie.setMaxAge(60*60*24);
            response.addCookie(mesaCookie);
            
            request.setAttribute("mesas", listaMesas);
            request.setAttribute("msgInfo", "Se ha establecido el dispositivo a la mesa " + numero);
            request.getRequestDispatcher("clienteConfigurarMesa.jsp").forward(request, response);
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
