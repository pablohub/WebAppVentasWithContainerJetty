<html>
<body>
<%
    String url = request.getRequestURL().toString();
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
    response.sendRedirect(baseURL + "productos");

%>
</body>
</html>
