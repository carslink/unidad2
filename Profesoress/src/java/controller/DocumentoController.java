/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DocumentoDAO;
import dao.DocumentoDAOImp;
import model.Documento;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlos arriaga
 */

public class DocumentoController extends HttpServlet{
   
    private final String LISTA_DOCUMENTOS = "/lista_documentos.jsp";
    private final String AGREGAR_CAMBIAR = "/documento.jsp";
    private DocumentoDAO dao;
    
    public DocumentoController(){
        dao = new DocumentoDAOImp();
    }
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward = "";
        
       if(action.equalsIgnoreCase("borrar")){
           forward = LISTA_DOCUMENTOS;
           int idDocumento = Integer.parseInt(
           request.getParameter("idDocumento"));
           dao.borrarDocumento(idDocumento);
           request.setAttribute("documentos", dao.desplegarDocumentos());
        }else if(action.equalsIgnoreCase("cambiar")){
            forward = AGREGAR_CAMBIAR;
            int idDocumento = Integer.parseInt(
           request.getParameter("idDocumento"));
            Documento documento = dao.elegirDocumento(idDocumento);
            request.setAttribute("documento", documento);
        }else if(action.equalsIgnoreCase("agregar")){
            forward = AGREGAR_CAMBIAR;
        } else{
            forward = LISTA_DOCUMENTOS;
            request.setAttribute("documento", dao.desplegarDocumentos());
        }
    //permite moverme de una oagina a otra
       RequestDispatcher view = request.getRequestDispatcher(forward);
       view.forward(request, response);
    }
    //realiza las acciones 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Documento documento= new Documento();
        documento.setNombre(request.getParameter("nombre"));
        documento.setDescripcion(request.getParameter("descripcion"));
        documento.setActivo(request.getParameter("activo"));
        documento.setUniversidad(request.getParameter("universidad"));
        documento.setCarrera(request.getParameter("carrera"));
        
        String idDocumento = request.getParameter("idDocumento");
        if(idDocumento==null || idDocumento.isEmpty()){
        dao.agregarDocumento(documento);
    }else{
    documento.setIdDocumento(Integer.parseInt(idDocumento));
        dao.cambiarDocumento(documento);
}
    RequestDispatcher view =
            request.getRequestDispatcher(LISTA_DOCUMENTOS);
            request.setAttribute("documentos",dao.desplegarDocumentos());
            view.forward(request, response);
    }
}//final
