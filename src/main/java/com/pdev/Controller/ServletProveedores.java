package com.pdev.Controller;

import com.google.gson.Gson;
import com.pdev.Dao.ProveedorDAO;
import com.pdev.Model.Proveedor;
import com.pdev.Util.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletProveedores", urlPatterns = {"/proveedores"})
public class ServletProveedores extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String opcion = req.getParameter("opcion");
        if(Helper.isNullOrEmpty(opcion)){
            req.setAttribute("esAccedidoAtravesDeServlet", true);
            req.setAttribute("menuActive", "proveedores");
            req.getRequestDispatcher("paginas/proveedores.jsp").forward(req, resp);
        }else if(opcion.equals("listar")){
            listar(resp);
        }else if(opcion.equals("editar")){
            String strId_proveedor = req.getParameter("id_proveedor");
            int id_proveedor = Helper.toInt(strId_proveedor);
            editar(resp, id_proveedor);
        }else{
            req.setAttribute("esAccedidoAtravesDeServlet", true);
            req.setAttribute("menuActive", "proveedores");
            req.getRequestDispatcher("paginas/proveedores.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String data = Helper.getJson(req);
        Proveedor proveedor = new Gson().fromJson(data, Proveedor.class);
        ProveedorDAO.agregar(proveedor);
        Helper.printJson(resp, data);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPut(req, resp);
        String data = Helper.getJson(req);
        Proveedor proveedorAActualizar = new Gson().fromJson(data, Proveedor.class);
        Proveedor proveedorActualizado = ProveedorDAO.actualizar(proveedorAActualizar);
        data = new Gson().toJson(proveedorActualizado);
        Helper.printJson(resp, data);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doDelete(req, resp);
        String strId_proveedor = req.getParameter("id_proveedor");
        int id_proveedor = Helper.isNullOrEmpty(strId_proveedor) ? 0: Helper.toInt(strId_proveedor);
        Proveedor proveedorEliminado = ProveedorDAO.eliminar(id_proveedor);
        String data = new Gson().toJson(proveedorEliminado);
        Helper.printJson(resp, data);
    }

    private void listar(HttpServletResponse resp) throws IOException{
        String data = new Gson().toJson(ProveedorDAO.listar());
        Helper.printJson(resp, data);
    }

    private void editar(HttpServletResponse resp, int id_proveedor) throws IOException{
        String data = new Gson().toJson(ProveedorDAO.encontrarPorId(id_proveedor));
        Helper.printJson(resp, data);
    }

}
