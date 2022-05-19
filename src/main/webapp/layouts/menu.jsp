<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String baseURL = request.getAttribute("baseURL").toString();
    Object objMenuActive = request.getAttribute("menuActive");
    String menuActive = objMenuActive != null ? objMenuActive.toString() : "";

%>

            <input type="checkbox" id="check" checked>
            <!--header area start-->
            <header id="header">
              <label for="check">
                <i class="fas fa-bars" id="sidebar_btn"></i>
              </label>
              <div class="left_area">
                <h3>app<span>Ventas</span></h3>
              </div>
              <div class="right_area">
                <a href="#" class="logout_btn">Logout</a>
              </div>
            </header>
            <!--header area end-->
            <!--sidebar start-->
            <div class="sidebar">
              <a class='<%=menuActive.equalsIgnoreCase("productos")?"active":""%>' href="<%=baseURL%>productos"><i class="fas fa-desktop"></i><span>Productos</span></a>
              <a class='<%=menuActive.equalsIgnoreCase("clientes")?"active":""%>' href="<%=baseURL%>clientes"><i class="fas fa-database"></i><span>Clientes</span></a>
              <a class='<%=menuActive.equalsIgnoreCase("proveedores")?"active":""%>' href="<%=baseURL%>proveedores"><i class="fas fa-building"></i><span>Proveedores</span></a>
            </div>
            <!--sidebar end-->