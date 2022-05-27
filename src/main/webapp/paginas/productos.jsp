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
            Productos
            <button type="button" id="btnConsultar">Consultar</button>
        </div>

<script type="text/javascript" src="<%=baseURL%>public/js/producto.js"></script>
<jsp:include page="../layouts/pie.jsp" />