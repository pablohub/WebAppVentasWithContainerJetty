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
        </div>

<jsp:include page="../layouts/pie.jsp" />