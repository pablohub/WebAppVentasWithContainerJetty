<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../layouts/cabecera.jsp" />

<%
    String baseURL = request.getAttribute("baseURL").toString();
    Object objEsAccedidoAtravesDeServlet = request.getAttribute("esAccedidoAtravesDeServlet");
    if(objEsAccedidoAtravesDeServlet == null ||
        !Boolean.valueOf(objEsAccedidoAtravesDeServlet.toString())){
        response.sendRedirect( baseURL + "proveedores");
        return;
    }
%>

<div class="row mt-5">
    <div class="col-lg-4">
        <form action="proveedores" method="POST">
            <fieldset>
                <legend>Registro Cliente</legend>
                <div class="form-group">
                    <label for="txtRuc">RUC:</label>
                    <input type="text" class="form-control" id="txtRuc" name="txtRuc" placeholder="RUC">
                </div>
                <div class="form-group">
                    <label for="txtRazonSocial">Razón Social:</label>
                    <input type="text" class="form-control" id="txtRazonSocial" name="txtRazonSocial" placeholder="Razón Social">
                </div>
                <div class="form-group">
                    <label for="txtNombreComercial">Nombre Comercial:</label>
                    <input type="text" class="form-control" id="txtNombreComercial" name="txtNombreComercial" placeholder="Nombre Comercial">
                </div>
                <button type="submit" id="btnGuardar" class="btn btn-primary">Guardar</button>
            </fieldset>
        </form>
        <div class="alert alert-dismissible alert-danger mt-2" style='display:none' id="divErrors">
        </div>
    </div>
    <div class="col-lg-8">
        <table id="tblProveedores" class="table table-hover">
            <thead>
                <tr class="table-primary">
                    <th scope="col">#</th>
                    <th scope="col">RUC</th>
                    <th scope="col">Razón Social</th>
                    <th scope="col">Nombre Comercial</th>
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

<script type="text/javascript" src="<%=baseURL%>public/js/proveedor.js"></script>
<jsp:include page="../layouts/pie.jsp" />