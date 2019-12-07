/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.RolDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ServicioLocal;
import java.io.PrintWriter;
import static java.lang.System.console;
import java.util.ArrayList;
import static java.util.Objects.hash;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author macev
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAO();
    Usuario u = new Usuario();
    int r;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        //SI ESTADO = 1, TODAS LAS SESIONES Y SUS ATRIBUTOS SE CIERRAN, VUELVE A LA PAGINA DE LOGIN
        String cerrarSesion = request.getParameter("estado");
        if (cerrarSesion != null && cerrarSesion.equals("1")) {
            session.invalidate();
            response.sendRedirect("Login.jsp");
            //EJECUCION NOMRAL DE INICIO DE SESION SEGÚN ROL
        } else {
            String accion = request.getParameter("bt");
            if (accion.equals("iniciar")) {
                String nom = request.getParameter("txtNombre_U");
                String pas = request.getParameter("txtPass");
                u.setNombre_usuario(nom);
                u.setPassword(pas);
                r = dao.iniciarSesion(u);
                if (r == 1) {
                    Usuario user = dao.buscar(u.getNombre_usuario());
                    u = user;
                    int rolUsuario = u.getRol().getId();
                    System.out.println(rolUsuario);

                    if (rolUsuario == 1) {//ADMINISTRADOR
                        session.setAttribute("sesionUsuario", user);
                        request.getRequestDispatcher("adminMenu.jsp").forward(request, response);
                    } else if (rolUsuario == 2) {//
                        session.setAttribute("sesionUsuario", user);
                        request.getRequestDispatcher("registrarProveedor.jsp").forward(request, response);
                    } else if (rolUsuario == 3) {//COCINERO
                        session.setAttribute("sesionUsuario", user);
                        request.getRequestDispatcher("CocineroPedidos?comando=cargar").forward(request, response);
                    } else if (rolUsuario == 4) {//BARTENDER
                        session.setAttribute("sesionUsuario", user);
                        request.getRequestDispatcher("registrarProveedor.jsp").forward(request, response);
                    } else if (rolUsuario == 5) {//GARZON
                        session.setAttribute("sesionUsuario", user);
                        request.getRequestDispatcher("adminMenu.jsp").forward(request, response);
                    } else if (rolUsuario == 6) {//BODEGUERO
                        session.setAttribute("sesionUsuario", user);
                        request.getRequestDispatcher("menuBodeguero.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("msg", "Error, usuario no reconocido");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            }
        }
    }

    /*
    protected void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre_usuario = request.getParameter("nombre_usuario");
        String clave = request.getParameter("clave");
        int nivel = 0;

        Usuario user = servicio.iniciarSesion(nombre_usuario,clave);
        RolDAO rolDao = new RolDAO();
        
        try{
           if (user != null) {
            if (user.getRol().equals("1")) {
                request.getSession().setAttribute("admin", user);
                response.sendRedirect("index.html");
           
        } else {
            request.setAttribute("msg", "Usuario incorrecto");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
           
    }
            } catch (Exception e) {
            System.err.println(e);
        }
     }*/
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
