/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.FuncionarioDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Funcionario;

/**
 *
 * @author Javier
 */
@WebServlet(name = "RegistrarFuncionario", urlPatterns = {"/RegistrarFuncionario"})
public class RegistrarFuncionario extends HttpServlet {

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

        int sueldo_base = Integer.parseInt(request.getParameter("sueldo_base"));
        String fecha_nacimiento = request.getParameter("fecha_nacimiento");

        try {
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechaAux = simpleDate.parse(fecha_nacimiento);
            java.sql.Date fecha = new java.sql.Date(fechaAux.getTime());

            String run = request.getParameter("run");
            String nombres = request.getParameter("nombres");
            String apellido_paterno = request.getParameter("apellido_paterno");
            String apellido_materno = request.getParameter("apellido_materno");
            String sexo = request.getParameter("sexo");
            String nacionalidad = request.getParameter("nacionalidad");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");

            //Instancia de variables
            Funcionario fun = new Funcionario();
            //Instancia de clases de tipo consultas (Base de datos)
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            /*//Reviso en la consola si se estan pasando bien los parametros (La info aparece en Pestaña de GlassFish Server)*/
            System.out.println("Nombre: " + nombres + ", Direccion: " + direccion + ", Telefono: " + telefono + ",Email: " + email);

            //Se asigna un proveedor nuevo a la variable prov
            // El 0 puede ser cualquier valor INT,  por que en ProveedorDAO se genera la id automaticamente de todas formas.
            fun = new Funcionario(run, nombres, apellido_paterno, apellido_materno, sexo, nacionalidad, fecha, direccion, telefono, email, sueldo_base);
            //run, nombres, apellido_paterno, apellido_materno, sexo, nacionalidad, fecha_nacimiento, direccion, telefono, email, sueldo_base

            //Registrar funcionario en la base de datos
            funcionarioDAO.registrar(fun);
        } catch (Exception e) {
        }

        //Redirecciono hacia otra página
        request.getRequestDispatcher("adminMenu.jsp").forward(request, response);

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
