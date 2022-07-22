package com.pdev.Controller;

import com.google.gson.Gson;
import com.pdev.Dao.ProductoDAO;
import com.pdev.Model.Producto;
import com.pdev.Util.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletProductos", urlPatterns = {"/productos"})
public class ServletProductos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String opcion = req.getParameter("opcion");
        if(Helper.isNullOrEmpty(opcion)){
            req.setAttribute("esAccedidoAtravesDeServlet", true);
            req.setAttribute("menuActive", "productos");
            req.getRequestDispatcher("paginas/productos.jsp").forward(req, resp);
        }else if(opcion.equals("listar")){
            listar(resp);
        }else if(opcion.equals("editar")){
            String strId_producto = req.getParameter("id_producto");
            int id_producto = Helper.toInt(strId_producto);
            editar(resp, id_producto);
        }else{
            req.setAttribute("esAccedidoAtravesDeServlet", true);
            req.setAttribute("menuActive", "productos");
            req.getRequestDispatcher("paginas/productos.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String data = getJson(req);
        Producto producto = new Gson().fromJson(data, Producto.class);
        ProductoDAO.registrar(producto);
        printJson(resp, data);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPut(req, resp);
        String data = getJson(req);
        Producto productoAActualizar = new Gson().fromJson(data, Producto.class);
        Producto productoActualizado = ProductoDAO.actualizar(productoAActualizar);
        data = new Gson().toJson(productoActualizado);
        printJson(resp, data);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doDelete(req, resp);
        String strId_producto = req.getParameter("id_producto");
        int id_producto = Helper.isNullOrEmpty(strId_producto) ? 0: Helper.toInt(strId_producto);
        Producto productoEliminado = ProductoDAO.eliminar(id_producto);
        String data = new Gson().toJson(productoEliminado);
        printJson(resp, data);

    }

    private void listar(HttpServletResponse resp) throws IOException{
        String data = new Gson().toJson(ProductoDAO.listar());
        printJson(resp, data);
    }

    private void editar(HttpServletResponse resp, int id_producto) throws IOException{
        String data = new Gson().toJson(ProductoDAO.encontrarPorId(id_producto));
        printJson(resp, data);
    }

    private void printJson(HttpServletResponse resp, String data) throws IOException{
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(data);
        out.flush();
    }
    private String getJson(HttpServletRequest req) throws IOException{
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            sb.append(line + "\n");
            line = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }
}
