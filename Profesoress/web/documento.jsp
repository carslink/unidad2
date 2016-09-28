<%-- 
    Document   : documento
    Created on : 23-sep-2016, 14:07:36
    Author     : carlos arriaga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de documentos</title>
    </head>
    <body>
        <form action="DocumentoController" method="post">
            <fieldset>
                <legend>Registro de documentos </legend>
                <div>
                    <label for="idDocumento">Id documento:</label>
                    <input type="text" name="idDocumento"
                           value="${documento.idDocumento}"
                           placeholder="Id de documento"
                           readonly="readonly"/> 
                </div>
                <div>
                    <label for="nombre">Nombre:</label>
                    <input type="text" name="nombre"
                           value="${documento.nombre}"
                           placeholder="Nombre del documento"
                           /> 
                </div>
                <div>
                    <label for="descripcion">Descripcion:</label>
                    <input type="text" name="descripcion"
                           value="${documento.descripcion}"
                           placeholder="Descripcion de documento"
                           /> 
                </div>
                <div>
                    <label for="activo">Activo:</label>
                    <input type="text" name="activo"
                           value="${documento.activo}"
                           placeholder="El documento esta activo"
                           /> 
                </div>
                <div>
                    <label for="universidad">Universidad:</label>
                    <input type="text" name="universidad"
                           value="${documento.universidad}"
                           placeholder="Universidad"
                           /> 
                </div>
                <div>
                    <label for="carrera">Carrera:</label>
                    <input type="text" name="carrera"
                           value="${documento.carrera}"
                           placeholder="Carrera"
                           /> 
                </div>  
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
        </form>
            
    </body>
</html>
