/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.MesaDAO;
import dao.RolDAO;
import dao.SesionAtencionDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Mesa;
import modelo.Rol;
import modelo.SesionAtencion;
import modelo.Usuario;

/**
 *
 * @author BlueOcean
 */
@WebServlet(name = "MesaEstablecer", urlPatterns = {"/MesaEstablecer"})
public class MesaEstablecer extends HttpServlet {

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
        //DATA ACCESS OBJETCS
        MesaDAO mesaDAO = new MesaDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        RolDAO rolDAO = new RolDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        //VARIABLES TIPO LISTAS
        ArrayList<Mesa> listaMesas = new ArrayList<>();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Rol> listaRoles = new ArrayList<>();
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

        listaUsuarios = usuarioDAO.listarGarzonesSinObjetos();
        listaMesas = mesaDAO.listar();
        listaRoles = rolDAO.listar();
        listaFuncionarios = funcionarioDAO.listar();

        //ASIGNACION DE FUNCIONARIO Y ROL A LOS USUARIOS
        for (Usuario usu : listaUsuarios) {
            for (Funcionario fun : listaFuncionarios) {
                if (usu.getRutFuncionario().equals(fun.getRun())) {
                    usu.setFuncionario(fun);
                }
            }
            for (Rol rol : listaRoles) {
                if (usu.getId_rol() == rol.getId()) {
                    usu.setRol(rol);
                }
            }
        }
        
        request.setAttribute("mesas", listaMesas);
        request.setAttribute("usuarios", listaUsuarios);

        request.getRequestDispatcher("mesaEstablecer.jsp").forward(request, response);

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
        HttpSession session = request.getSession();
        MesaDAO mesaDAO = new MesaDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        int numeroMesa = Integer.parseInt(request.getParameter("seleccionMesa"));
        String nombreCliente = request.getParameter("nombreCliente");
        String nombreUsuario = request.getParameter("usuarioSeleccionado");
        int cantComensales = Integer.parseInt(request.getParameter("cantComensales"));

        Cliente cliente = new Cliente(0, nombreCliente);
        clienteDAO.registrarRetornar(cliente);

        Mesa mesaEscogida = mesaDAO.buscar(numeroMesa);
//        Usuario usuario = usuarioDAO.buscar(nombreUsuario);
        try {
            //dateInicio = "25-10-2019";
            //BLOQUE PARA OBTENER LA FECHA ACTUAL
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();

            java.util.Date fechaAux = cal.getTime();
            java.sql.Date fechaInicio = new java.sql.Date(fechaAux.getTime());

            //INSTANCIACION DE SESIONATENCION Y REGISTRO EN LA BASE DE DATOS
            //fechaTermino DEBE SER NULL, ASÍ SABREMOS QUE SESION_ATENCION ESTAN SIENDO ATENDIDAS EN EL RESTORANT
            SesionAtencion sesionAtencion = new SesionAtencion(0, fechaInicio, null, cantComensales, cliente.getId(), numeroMesa, nombreUsuario);
            SesionAtencionDAO saDAO = new SesionAtencionDAO();
            saDAO.registrar(sesionAtencion);
        } catch (Exception e) {
            e.getStackTrace();
        }

        //session.setAttribute("mesaEstablecida", mesaEscogida);
        //request.getRequestDispatcher("index.jsp").forward(request, response);
        response.sendRedirect("MesaEstablecer");
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
