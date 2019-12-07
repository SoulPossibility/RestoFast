/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.FuncionarioDAO;
import dao.RolDAO;
import dao.SesionAtencionDAO;
import dao.UsuarioDAO;
import dto.GarzonGraficoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Funcionario;
import modelo.Rol;
import modelo.SesionAtencion;
import modelo.Usuario;

/**
 *
 * @author BlueOcean
 */
@WebServlet(name = "ReporteGarzon", urlPatterns = {"/ReporteGarzon"})
public class ReporteGarzon extends HttpServlet {

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

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        SesionAtencionDAO sesionAtencionDAO = new SesionAtencionDAO();
        RolDAO rolDAO = new RolDAO();

        ArrayList<SesionAtencion> listaSesionAten = new ArrayList<>();
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        ArrayList<Rol> listaRol = new ArrayList<>();

        ArrayList<GarzonGraficoDTO> listaGraphGarzones = new ArrayList<>();

        listaFuncionario = funcionarioDAO.listar();
        listaUsuario = usuarioDAO.listarGarzonesSinObjetos();
        listaSesionAten = sesionAtencionDAO.listarSinObjetos();
        listaRol = rolDAO.listar();

        for (Usuario usuario : listaUsuario) {
            for (Funcionario funcionario : listaFuncionario) {
                if (usuario.getRutFuncionario().equals(funcionario.getRun())) {
                    usuario.setFuncionario(funcionario);
                }
            }

            for (Rol rol : listaRol) {
                if (usuario.getId_rol() == rol.getId()) {
                    usuario.setRol(rol);
                }
            }
        }

        for (SesionAtencion aten : listaSesionAten) {
            for (Usuario usuario : listaUsuario) {
                if (aten.getUsuario().equals(usuario.getNombre_usuario())) {
                    aten.setUsuarioObject(usuario);
                }
            }
        }

        //FILTRAR POR FECHA
        for (Usuario usu : listaUsuario) {
            GarzonGraficoDTO graph = new GarzonGraficoDTO();
            int cantidadAnual = 0;
            for (SesionAtencion aten : listaSesionAten) {
                if (usu.getRutFuncionario().equals(aten.getUsuarioObject().getFuncionario().getRun())) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(aten.getFecha_inicio().getTime());
                    int mYear = calendar.get(Calendar.YEAR);
                    int mMonth = calendar.get(Calendar.MONTH);
                    int mHour = calendar.get(Calendar.HOUR);
                    int mMinute = calendar.get(Calendar.MINUTE);

                    if (mYear == 2019) {
                        cantidadAnual += aten.getCantidad_comensales();
                    }
                }
            }
            graph.setFuncionario(usu.getFuncionario());
            graph.setUsuario(usu);
            //DEFINIR CANTIDAD
            graph.setCantidadAnual(cantidadAnual);
            listaGraphGarzones.add(graph);
        }
        
        for (GarzonGraficoDTO gar : listaGraphGarzones) {
            System.out.println("data: " + gar.getCantidadAnual());
            System.out.println("data2: " + gar.getFuncionario().getNombres());
            System.out.println("data3: " + gar.getUsuario().getNombre_usuario());
        }
        
        request.setAttribute("graphGarzon", listaGraphGarzones);
        request.getRequestDispatcher("reporteGarzon.jsp").forward(request, response);
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
