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
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
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
        String comando = request.getParameter("comando");
        System.out.println("comando: " + comando);
        OrdenDAO ordenDAO = new OrdenDAO();
        MenuDAO menuDAO = new MenuDAO();
        SesionAtencionDAO sesionAtenDAO = new SesionAtencionDAO();

        switch (comando) {
            case "cargar":
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

                for (Orden orden : listaRevertida) {
//                    Calendar calendar = Calendar.getInstance();
//                    calendar.setTimeInMillis(orden.getFecha().getTime());
//
//                    int mYear = calendar.get(Calendar.YEAR);
//                    int mHour = calendar.get(Calendar.HOUR);
//                    int mMinute = calendar.get(Calendar.MINUTE);
//
//                    long minutes = TimeUnit.MILLISECONDS.toMinutes(orden.getFecha().getTime());
//                    long hours = TimeUnit.MILLISECONDS.toHours(orden.getFecha().getTime());
                    //to_char(orden.getFecha().DATE_ARCH , 'HH:MI');
                    System.out.println("nuevo: " + orden.getFecha().getTime());
                    System.out.println("fecha: " + orden.getFecha());
                    //                    System.out.println("horas: " + mHour);
                    //                    System.out.println("minutos: " + mMinute);

                }
                long millis = System.currentTimeMillis();
                Date fechaActual = new Date(millis);
                //listaSesionAtencion = sesionAtencionDAO.listar();
                request.setAttribute("fechaActual", fechaActual);
                request.setAttribute("ordenesPendientes", listaRevertida);
                request.getRequestDispatcher("cocineroPedidos.jsp").forward(request, response);
                break;
            case "actualizar":
                int idOrden = Integer.parseInt(request.getParameter("orden"));
                System.out.println("hola!");
                try {
                    Orden orden;
                    System.out.println("buscando");
                    orden = ordenDAO.buscar(idOrden);
                    orden.setEstado("finalizado");

                    System.out.println("orden : " + orden.getCodigoMenu());
                    System.out.println("orden : " + orden.getEstado());

                    ordenDAO.actualizar(orden);

                    //SECCION SUSTRACCION ENTRE FECHAS (DEMORA EN LA ORDEN)
//                    int dia = 0;
//                    int mes = 0;
//                    int anno = 0;
//
//                    Calendar cal = Calendar.getInstance();
//                    cal.setTimeInMillis(orden.getFecha().getTime());
//                    dia = cal.get(Calendar.DAY_OF_YEAR);
//                    mes = cal.get(Calendar.MONTH);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }

                request.setAttribute("msgExito", "Actualización éxitosa");
                response.sendRedirect("CocineroPedidos?comando=cargar");
                break;
            default:
                throw new AssertionError();
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

        //processRequest(request, response);
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
