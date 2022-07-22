package com.pdev.Controller;

import com.google.gson.Gson;
import com.pdev.Dao.ClienteDAO;
import com.pdev.Model.Cliente;
import com.pdev.Util.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletClientes", urlPatterns = {"/clientes"})
public class ServletClientes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String opcion = req.getParameter("opcion");
        if(Helper.isNullOrEmpty(opcion)){
            req.setAttribute("esAccedidoAtravesDeServlet", true);
            req.setAttribute("menuActive", "clientes");
            req.getRequestDispatcher("paginas/clientes.jsp").forward(req, resp);
        }else if(opcion.equals("listar")){
            listar(resp);
        }else if(opcion.equals("editar")){
            String strId_cliente = req.getParameter("id_cliente");
            int id_cliente = Helper.toInt(strId_cliente);
            editar(resp, id_cliente);
        }else{
            req.setAttribute("esAccedidoAtravesDeServlet", true);
            req.setAttribute("menuActive", "clientes");
            req.getRequestDispatcher("paginas/clientes.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String data = Helper.getJson(req);
        Cliente cliente = new Gson().fromJson(data, Cliente.class);
        ClienteDAO.agregar(cliente);
        Helper.printJson(resp, data);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPut(req, resp);
        String data = Helper.getJson(req);
        Cliente clienteAActualizar = new Gson().fromJson(data, Cliente.class);
        Cliente clienteActualizado = ClienteDAO.actualizar(clienteAActualizar);
        data = new Gson().toJson(clienteActualizado);
        Helper.printJson(resp, data);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doDelete(req, resp);
        String strId_cliente = req.getParameter("id_cliente");
        int id_cliente = Helper.isNullOrEmpty(strId_cliente) ? 0: Helper.toInt(strId_cliente);
        Cliente clienteEliminado = ClienteDAO.eliminar(id_cliente);
        String data = new Gson().toJson(clienteEliminado);
        Helper.printJson(resp, data);
    }

    private void listar(HttpServletResponse resp) throws IOException{
        String data = new Gson().toJson(ClienteDAO.listar());
        Helper.printJson(resp, data);
    }

    private void editar(HttpServletResponse resp, int id_cliente) throws IOException{
        String data = new Gson().toJson(ClienteDAO.encontrarPorId(id_cliente));
        Helper.printJson(resp, data);
    }
}
