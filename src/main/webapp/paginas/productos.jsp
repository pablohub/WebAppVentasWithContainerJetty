<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../layouts/cabecera.jsp" />

<%
    String baseURL = request.getAttribute("baseURL").toString();
    Object objEsAccedidoAtravesDeServlet = request.getAttribute("esAccedidoAtravesDeServlet");
    if(objEsAccedidoAtravesDeServlet == null ||
        !Boolean.valueOf(objEsAccedidoAtravesDeServlet.toString())){
        response.sendRedirect( baseURL + "productos");
        return;
    }
%>

<div class="row mt-5">
    <div class="col-lg-4">
        <form action="productos" method="POST">
            <fieldset>
                <legend>Registro Producto</legend>
                <div class="form-group">
                    <label for="txtDescripcion">Descripción:</label>
                    <input type="text" class="form-control" id="txtDescripcion" name="txtDescripcion" placeholder="Descripción">
                </div>
                <div class="form-group">
                    <label for="txtPrecio">Precio:</label>
                    <input type="number" min="0" step="0.01" class="form-control" id="txtPrecio" name="txtPrecio" placeholder="Precio">
                </div>
                <div class="form-group">
                    <label for="txtStock">Stock:</label>
                    <input type="number" min="0" step="1" class="form-control" id="txtStock" name="txtStock" placeholder="Stock">
                </div>
                <button type="submit" id="btnGuardar" class="btn btn-primary">Guardar</button>
            </fieldset>
        </form>
        <div class="alert alert-dismissible alert-danger mt-2" style='display:none' id="divErrors">
        </div>
    </div>
    <div class="col-lg-8">
        <table id="tblProductos" class="table table-hover">
            <thead>
                <tr class="table-primary">
                    <th scope="col">#</th>
                    <th scope="col">Descripción</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Stock</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <a class='btn btn-outline-success btn-sm' href="" >
                            <i class='fas fa-edit'></i>
                        </a>
                        <a class='btn btn-outline-danger btn-sm' href="">
                            <i class='fas fa-trash-alt'></i>
                        </a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>

<script type="text/javascript" src="<%=baseURL%>public/js/producto.js"></script>
<jsp:include page="../layouts/pie.jsp" />