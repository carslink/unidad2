<%-- 
    Document   : lista_documentos
    Created on : 23-sep-2016, 13:59:52
    Author     : carlos arriaga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de documentos</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Activo</th>
                    <th>Universidad</th>
                    <th>Carrera</th>
                </tr>
            </thead>
            <tbody>
                <core:forEach items="${documentos}" var="documento">
                    <tr>
                        <td>${documento.idDocumento}</td>
                        <td>${documento.nombre}</td>
                        <td>${documento.descripcion}</td>
                        <td>${documento.activo}</td>
                        <td>${documento.universidad}</td>
                        <td>${documento.carrera}</td>
                        <td>
                            <a href="DocumentoController?action=cambiar&idDocumento=${documento.idDocumento}">Cambiar</a>
                        </td>
                        <td>
                            <a href="DocumentoController?action=borrar&idDocumento=${documento.idDocumento}">Borrar</a>
                        </td>
                    </tr>
                </core:forEach>
            </tbody>
        </table>
        <p>
            <a href="DocumentoController?action=agregar">Agregar documento</a>
            <a href="index.jsp">Regresar</a>
        </p>
</html>
