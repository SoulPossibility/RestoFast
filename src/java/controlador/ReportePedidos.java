/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DetallePedidoDAO;
import dao.PedidoDAO;
import dao.ProductoDAO;
import dao.ProveedorDAO;
import dao.UsuarioDAO;
import dto.PedidosGraficoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DetallePedido;
import modelo.Pedido;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Usuario;

/**
 *
 * @author BlueOcean
 */
@WebServlet(name = "ReportePedidos", urlPatterns = {"/ReportePedidos"})
public class ReportePedidos extends HttpServlet {

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
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        ArrayList<DetallePedido> detallePedidos = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Proveedor> listaProveedores = new ArrayList<>();
        ArrayList<PedidosGraficoDTO> listaPedidosGraph = new ArrayList<>();
        
        PedidoDAO pedidoDAO = new PedidoDAO();
        DetallePedidoDAO detallePedidoDAO = new DetallePedidoDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        
        listaPedidos = pedidoDAO.listar();
        detallePedidos = detallePedidoDAO.listar();
        listaProductos = productoDAO.listar();
        listaUsuarios = usuarioDAO.listarSinObjetos();
        listaProveedores = proveedorDAO.listar();

        //PRODUCTOS
        for (Producto producto : listaProductos) {
            for (Proveedor proveedor : listaProveedores) {
                if (producto.getIdProveedor() == proveedor.getId()) {
                    producto.setProveedor(proveedor);
                }
            }
        }

        //PEDIDOS
        for (Pedido pedido : listaPedidos) {
            for (Usuario usuario : listaUsuarios) {
                if (pedido.getUsuario_nombre_usuario().equals(usuario.getNombre_usuario())) {
                    pedido.setUsuario(usuario);
                }
            }
        }

        //DETALLE PEDIDOS
        for (DetallePedido detalle : detallePedidos) {
            for (Pedido pedido : listaPedidos) {
                if (detalle.getPedido_id() == pedido.getId()) {
                    detalle.setPedido(pedido);
                }
            }
            for (Producto producto : listaProductos) {
                if (detalle.getProducto_id() == producto.getId()) {
                    detalle.setProducto(producto);
                }
            }
        }
        
        for (int mes = 0; mes < 12; mes++) {
            
            PedidosGraficoDTO pedGrafico = new PedidosGraficoDTO();
            listaPedidosGraph.add(pedGrafico);
            ArrayList<DetallePedido> detallesPed = new ArrayList<>();
            int cantidadMaxima = 0;
            int valorMaximo = 0;
            int cantidadDias = obtenerDiasDeMes();
            
            for (int i = 0; i < cantidadDias; i++) {
                detallesPed.add(null);
            }
            
            for (int dia = 0; dia < cantidadDias; dia++) {
                for (Pedido pedido : listaPedidos) {
                    //CORRESPONDE AL MES DEL CICLO?
                    if (pedido.getFecha_solicitud().getMonth() == mes + 1 && pedido.getFecha_solicitud().getDay() == dia + 1 && pedido.getEstado().equalsIgnoreCase("aprobado")) {
                        cantidadMaxima = calcularCantidad(pedido, detallePedidos);
                        valorMaximo = calcularValorMaximo(pedido, detallePedidos);
                        for (DetallePedido dp : detallePedidos) {
                            if (dp.getPedido_id() == pedido.getId()) {
                                detallesPed.set(dia, dp);
                            }
                        }
                        pedGrafico.setValorMaximo(valorMaximo);
                        pedGrafico.setCantidadMaxima(listaPedidosGraph.get(mes).getCantidadMaxima() + cantidadMaxima);
                        pedGrafico.setListaDetalle(detallesPed);
                    }
                }
            }
        }
        
//        for (int i = 0; i < listaPedidosGraph.size(); i++) {
//            for (int j = 0; j < listaPedidosGraph.get(i).getListaDetalle().size(); j++) {
//                for (int k = 0; k < listaProductos.size(); k++) {
//                    if (listaProductos.get(k).getId() == listaPedidosGraph.get(i).getListaDetalle().get(j).getProducto_id()) {
//                        listaPedidosGraph.get(i).getListaDetalle().get(j).setProducto(listaProductos.get(k));
//                        
//                    }
//                }
//            }
//        }
        
//        for (PedidosGraficoDTO pedidosGraficoDTO : listaPedidosGraph) {
//            for (DetallePedido detallePedido : pedidosGraficoDTO.getListaDetalle()) {
//                System.out.println("-- " + detallePedido.getProducto().getNombre());
//            }
//        }
        
        for (PedidosGraficoDTO pgdto : listaPedidosGraph) {
            System.out.println("info Valor: " + pgdto.getValorMaximo());
            System.out.println("info Cantidad: " + pgdto.getCantidadMaxima());
        }
        
        request.setAttribute("pedidosGraph", listaPedidosGraph);
        request.getRequestDispatcher("reportePedidos.jsp").forward(request, response);
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

    private int calcularCantidad(Pedido pedido, ArrayList<DetallePedido> detallePedidos) {
        int suma = 0;
        for (DetallePedido det : detallePedidos) {
            if (det.getPedido().getId() == pedido.getId()) {
                suma += det.getCantidad();
            }
        }
        return suma;
    }
    
    private int calcularValorMaximo(Pedido pedido, ArrayList<DetallePedido> detallePedidos) {
        int suma = 0;
        for (DetallePedido det : detallePedidos) {
            if (det.getPedido().getId() == pedido.getId()) {
                suma += det.getValor();
            }
        }
        return suma;
    }

    /*OBTIENE LA CANTIDAD DE DÍAS DE UN EN DETERMINADO AÑO*/
    private int obtenerDiasDeMes() {
        int anno = 2019;
        int mes = Calendar.NOVEMBER;
        int dia = 1;
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(anno, mes, dia);
        
        int maxDiasMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return maxDiasMes;
    }
    
}
