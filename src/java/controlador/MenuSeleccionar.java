/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.MenuDAO;
import dto.MenuCantidadDTO;
import javax.jms.Session;
import javax.servlet.http.HttpSession;
import modelo.Menu;
import utilidades.SeleccionMenu;

/**
 *
 * @author BlueOcean
 */
@WebServlet(name = "MenuSeleccionar", urlPatterns = {"/MenuSeleccionar"})
public class MenuSeleccionar extends HttpServlet {

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

        HttpSession session = request.getSession();
        ArrayList<MenuCantidadDTO> carrito = (ArrayList) session.getAttribute("carrito");
        ArrayList<Menu> listaMenus = new ArrayList<>();
        ArrayList<Menu> listaPlatos = new ArrayList<>();
        ArrayList<Menu> listaBebidas = new ArrayList<>();
        ArrayList<Menu> listaPostres = new ArrayList<>();
        MenuDAO menuDAO = new MenuDAO();

        listaMenus = menuDAO.listar();
        //AGREGAR A SU CORRESPONDIENTE LISTA, SI MENU CORRESPONDE AL TIPO PLATO O BEBIDA
        for (Menu menu : listaMenus) {
            if (menu.getTipo().equalsIgnoreCase("plato")) {
                listaPlatos.add(menu);
            } else if (menu.getTipo().equalsIgnoreCase("bebida") || menu.getTipo().equalsIgnoreCase("alcohol")) {
                listaBebidas.add(menu);
            } else if (menu.getTipo().equalsIgnoreCase("postre")) {
                listaPostres.add(menu);
            }
        }

        request.setAttribute("productosCarrito", session.getAttribute("carrito"));
        request.setAttribute("platos", listaPlatos);
        request.setAttribute("bebidas", listaBebidas);
        request.setAttribute("postres", listaPostres);

        //== SECCION TABLA CARRITO ==
        if (request.getParameter("codigoMenu") != null) {
            //ArrayList<MenuCantidadDTO> carrito = (ArrayList) session.getAttribute("carrito");
            String codigoMenu = request.getParameter("codigoMenu");
            
            int cantidadPersonas = Integer.parseInt(request.getParameter("cantidadPersonas"));
            int totalCarrito = 0;
            
            Menu menu = menuDAO.buscar(codigoMenu);
            System.out.println("menu : " + menu.getNombre());
            System.out.println("cantidad personas: " + cantidadPersonas);
            MenuCantidadDTO menuCantidadDTO = new MenuCantidadDTO(menu, cantidadPersonas);
            carrito.add(menuCantidadDTO);

            
            if (carrito.size() > 0) {
                for (MenuCantidadDTO car : carrito) {
                    totalCarrito += car.getPrecio();
                }
                request.setAttribute("totalCarrito", totalCarrito);
            }
        }

        String personas = request.getParameter("opcionPersonas");
        System.out.println("cantidad de personas: " + personas);

        request.getRequestDispatcher("menuSeleccionar.jsp").forward(request, response);
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
