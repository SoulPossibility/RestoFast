/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.MenuDAO;
import dao.OrdenDAO;
import dao.SesionAtencionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Menu;
import modelo.Orden;
import modelo.SesionAtencion;

/**
 *
 * @author BlueOcean
 */
@WebServlet(name = "CocineroPedidos", urlPatterns = {"/CocineroPedidos"})
public class CocineroPedidos extends HttpServlet {

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
        HttpSession session = request.getSession();

        OrdenDAO ordenDAO = new OrdenDAO();
        MenuDAO menuDAO = new MenuDAO();
        SesionAtencionDAO sesionAtenDAO = new SesionAtencionDAO();

        ArrayList<Orden> listaOrdenes = new ArrayList<>();
        ArrayList<Orden> listaRevertida = new ArrayList<>();
        ArrayList<Menu> listaMenu = new ArrayList<>();
        ArrayList<SesionAtencion> listaSesionAten = new ArrayList<>();
        
        
        listaOrdenes = ordenDAO.listarPendientesSinObjetos();
        listaMenu = menuDAO.listar();
        listaSesionAten = sesionAtenDAO.listarSinObjetos();
        
        for (Orden orden : listaOrdenes) {
            for (Menu menu : listaMenu) {
                if (menu.getCodigo().equals(orden.getCodigoMenu())) {
                    orden.setMenu(menu);
                }
            }
            
            for (SesionAtencion sesionAtencion : listaSesionAten) {
                if (sesionAtencion.getId() == orden.getIdSesion()) {
                    orden.setSesionAtencion(sesionAtencion);
                }
            }
        }
        
        for (int i = listaOrdenes.size() - 1; i >= 0; i--) {
            listaRevertida.add(listaOrdenes.get(i));
        }

        //listaSesionAtencion = sesionAtencionDAO.listar();
        request.setAttribute("ordenesPendientes", listaRevertida);
        request.getRequestDispatcher("cocineroPedidos.jsp").forward(request, response);
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
