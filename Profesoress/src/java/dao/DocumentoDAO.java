/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Documento;
import java.util.List;

/**
 *
 * @author carlos arriaga
 */
public interface DocumentoDAO {
    void agregarDocumento(Documento documento);
    void borrarDocumento(int idDocumento);
    void cambiarDocumento(Documento documento);
    List<Documento> desplegarDocumentos();
    Documento elegirDocumento(int idDocumento);
    
}//final
