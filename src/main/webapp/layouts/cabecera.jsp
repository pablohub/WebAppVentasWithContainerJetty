<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String url = request.getRequestURL().toString();
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
    request.setAttribute("baseURL", baseURL);
%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
    <meta charset="utf-8">
    <title>Sistema Ventas</title>
    <link rel="stylesheet" href="public/css/bootstrap.min.css">
    <link rel="stylesheet" href="public/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
    </head>
    <body>

    <jsp:include page="menu.jsp" />

    <div class="content">
        <div class="container">