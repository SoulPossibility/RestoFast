/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.MesaDAO;
import dao.SesionAtencionDAO;
import dto.MenuCantidadDTO;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import modelo.Menu;
import modelo.Mesa;
import modelo.SesionAtencion;

/**
 *
 * @author BlueOcean
 */
@WebServlet(name = "ClientePantallaInicio", urlPatterns = {"/ClientePantallaInicio"})
public class ClientePantallaInicio extends HttpServlet {

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
        MesaDAO mesaDAO = new MesaDAO();

        String numeroMesa = "0";
        // read the content from file
        try (FileReader fileReader = new FileReader(System.getProperty("user.home") + "\\numeroMesaRestoFast.txt")) {
            int ch = fileReader.read();
            while (ch != -1) {
                System.out.print((char) ch);
                if (ch != -1) {
                    numeroMesa+= "" + (char) ch;
                    System.out.println("mesa seleccionada: " + numeroMesa);
                }
                //PASA AL SIGUIENTE CARACTER
                ch = fileReader.read();
            }
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }

        //numeroMesa = session.getAttribute("configuracionMesa").toString();
        Cookie[] mesaCookies = request.getCookies();
        if (mesaCookies != null) {
            for (Cookie cookie : mesaCookies) {
                if ("numeroMesa.numero".equals(cookie.getName())) {
                    numeroMesa = cookie.getValue();
                    System.out.println("OBTENIENDO VALOR DE LA COOKIE: " + numeroMesa);
                    break;
                }
            }
        }
        
        
        Mesa nuevaMesa = mesaDAO.buscar(Integer.parseInt(numeroMesa));
        session.setAttribute("mesaEstablecida", nuevaMesa);
        Mesa mesaSesion = (Mesa) session.getAttribute("mesaEstablecida");

        //SE RESETEA LA ATENCIÓN Y CARGA LA ÚLTIMA GENERADA PARA ESTA MESA
        session.setAttribute("sesionAtencion", null);
        SesionAtencionDAO sesionAtencionDAO = new SesionAtencionDAO();
        ArrayList<SesionAtencion> listaAtenciones = new ArrayList<>();
        SesionAtencion sesionAtencion = null;

        listaAtenciones = sesionAtencionDAO.listarSinObjetos();
        for (SesionAtencion atencion : listaAtenciones) {
            //SI SESION_ATENCION POSEE fecha_termino null, ES UNA ATENCION NUEVA
            if ((atencion.getMesa() == mesaSesion.getNumero()) && atencion.getFecha_termino() == null) {
                sesionAtencion = sesionAtencionDAO.buscar(atencion.getId());
            }
        }

        if (sesionAtencion != null) {
            session.setAttribute("sesionAtencion", sesionAtencion);
            ArrayList<MenuCantidadDTO> carrito = new ArrayList<>();
            session.setAttribute("carrito", carrito);
            request.getRequestDispatcher("MenuSeleccionar").forward(request, response);
        } else {
            request.setAttribute("mensajeError", "No se ha solicitado la mesa desde el TÓTEM");
            request.getRequestDispatcher("clientePantallaInicio.jsp").forward(request, response);
        }

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
