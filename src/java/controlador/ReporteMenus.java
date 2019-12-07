/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.MenuDAO;
import dao.OrdenDAO;
import dao.SesionAtencionDAO;
import dto.MenuGraficoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Menu;
import modelo.Orden;
import modelo.SesionAtencion;

/**
 *
 * @author BlueOcean
 */
@WebServlet(name = "ReporteMenus", urlPatterns = {"/ReporteMenus"})
public class ReporteMenus extends HttpServlet {

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
//        int dia = Integer.parseInt(request.getParameter("dia"));
//        int mes = Integer.parseInt(request.getParameter("mes"));
//        int anno = Integer.parseInt(request.getParameter("anno"));

        boolean exito = true;
        String fechaMenu = request.getParameter("fechaReporteMenu");
        String[] arregloFechaMenu = fechaMenu.split("-");
        int anno = 0;
        int mes = 0;
        int dia = 0;

        try {
            anno = Integer.parseInt(arregloFechaMenu[0]);
            mes = Integer.parseInt(arregloFechaMenu[1]);
            dia = Integer.parseInt(arregloFechaMenu[2]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            exito = false;
        }

        if (exito) {
            ArrayList<Orden> listaOrden = new ArrayList<>();
            ArrayList<Orden> listaOrdenAux = new ArrayList<>();
            ArrayList<Menu> listaMenu = new ArrayList<>();
            ArrayList<SesionAtencion> listaSesionAten = new ArrayList<>();
            ArrayList<MenuGraficoDTO> ordenesGraph = new ArrayList<>();

            ArrayList<MenuGraficoDTO> listaGraphComestibles = new ArrayList<>();
            ArrayList<MenuGraficoDTO> listaGraphBebestibles = new ArrayList<>();

            OrdenDAO ordenDAO = new OrdenDAO();
            MenuDAO menuDAO = new MenuDAO();
            SesionAtencionDAO sesionAtenDAO = new SesionAtencionDAO();

            listaOrden = ordenDAO.listarSinObjetos();
            listaMenu = menuDAO.listar();
            listaSesionAten = sesionAtenDAO.listarSinObjetos();

            for (Orden orden : listaOrden) {
                for (Menu menu : listaMenu) {
                    if (menu.getCodigo().equals(orden.getCodigoMenu())) {
                        orden.setMenu(menu);
                    }
                }
            }
            for (Menu menu : listaMenu) {
                int cantidadMaxima = 0;
                int precioMaximo = 0;
                MenuGraficoDTO menuGrafico = new MenuGraficoDTO();
                menuGrafico.setMenu(menu);
                for (Orden orden : listaOrden) {
                    Date date = orden.getFecha();
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);

                    //MONTH + 1, POR QUE LOS MESES PARTEN DESDE 0 HASTA 11
                    if (menu.getCodigo().equals(orden.getCodigoMenu())
                            && anno == cal.get(Calendar.YEAR) && mes == cal.get(Calendar.MONTH) + 1 && dia == cal.get(Calendar.DAY_OF_MONTH)) {
                        cantidadMaxima += orden.getCantidad();
                        precioMaximo += orden.getMenu().getPrecio() * orden.getCantidad();
                    }
                }
                menuGrafico.setCantidad(cantidadMaxima);
                menuGrafico.setPrecioMaximo(precioMaximo);
                ordenesGraph.add(menuGrafico);

                //AGREGAR ELEMENTOS A LOS ARRAYLIST SEGÚN TIPO COMESTIBLE O BEBESTIBLE
                if (menuGrafico.getMenu().getTipo().equalsIgnoreCase("Plato") || menuGrafico.getMenu().getTipo().equalsIgnoreCase("Postre")) {
                    listaGraphComestibles.add(menuGrafico);
                } else if (menuGrafico.getMenu().getTipo().equalsIgnoreCase("Bebida") || menuGrafico.getMenu().getTipo().equalsIgnoreCase("Alcohol")) {
                    listaGraphBebestibles.add(menuGrafico);
                }
            }

            //ARREGLO QUE SE DESPLEGARA EN JAVASCRIPT
            String arregloMenus = "[";
            for (int i = 0; i < ordenesGraph.size(); i++) {
                //var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
                if (i == ordenesGraph.size() - 1) {
                    arregloMenus += "'" + ordenesGraph.get(i).getMenu().getCodigo() + "'";
                } else {
                    arregloMenus += "'" + ordenesGraph.get(i).getMenu().getCodigo() + "',";
                }
            }
            arregloMenus += "]";

            String arregloComestibles = completarComestibles(listaGraphComestibles);
            String arregloBebestibles = completarBebestibles(listaGraphBebestibles);

//        for (MenuGraficoDTO mnGraph : ordenesGraph) {
//            System.out.println("-- " + mnGraph.getMenu().getNombre());
//            System.out.println("-- " + mnGraph.getCantidad());
//            System.out.println("-- " + mnGraph.getPrecioMaximo());
//        }
            request.setAttribute("ordenesGraph", ordenesGraph);
            request.setAttribute("arregloMenus", arregloMenus);

            System.out.println(arregloComestibles);
            System.out.println(arregloBebestibles);
            for (MenuGraficoDTO listaGraphComestible : listaGraphComestibles) {
                System.out.println("comida: " + listaGraphComestible.getCantidad());
            }
            for (MenuGraficoDTO listaGraphBebestible : listaGraphBebestibles) {
                System.out.println("bebida: " + listaGraphBebestible.getCantidad());
            }
            
            String fechaEscogida = dia + "/" + mes + "/" + anno;

            request.setAttribute("listaGraphComestibles", listaGraphComestibles);
            request.setAttribute("listaGraphBebestibles", listaGraphBebestibles);
            request.setAttribute("arregloComestibles", arregloComestibles);
            request.setAttribute("arregloBebestibles", arregloBebestibles);
            request.setAttribute("fechaEscogida", fechaEscogida);

            request.getRequestDispatcher("reporteMenus.jsp").forward(request, response);
        }
        else{
            request.setAttribute("msgError", "Ingrese un formato válido en fecha");
            request.getRequestDispatcher("adminReportes.jsp").forward(request, response);
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

    private String completarComestibles(ArrayList<MenuGraficoDTO> comestibles) {
        String arregloComestibles = "[";
        for (int i = 0; i < comestibles.size(); i++) {
            //var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
            if (i == comestibles.size() - 1) {
                arregloComestibles += "'" + comestibles.get(i).getMenu().getCodigo() + "'";
            } else {
                arregloComestibles += "'" + comestibles.get(i).getMenu().getCodigo() + "',";
            }
        }
        arregloComestibles += "]";
        return arregloComestibles;
    }

    private String completarBebestibles(ArrayList<MenuGraficoDTO> bebestibles) {
        String arregloBebestibles = "[";
        for (int i = 0; i < bebestibles.size(); i++) {
            //var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
            if (i == bebestibles.size() - 1) {
                arregloBebestibles += "'" + bebestibles.get(i).getMenu().getCodigo() + "'";
            } else {
                arregloBebestibles += "'" + bebestibles.get(i).getMenu().getCodigo() + "',";
            }
        }
        arregloBebestibles += "]";
        return arregloBebestibles;
    }

}
