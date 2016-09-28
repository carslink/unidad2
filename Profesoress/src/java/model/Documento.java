/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author carlos arriaga
 */
public class Documento {
    private int idDocumento;
    private String nombre;
    private String descripcion;
    private String activo;
    private String universidad;
    private String carrera;

    public Documento(int idDocumento, String nombre, String descripcion, String activo, String universidad, String carrera) {
        this.idDocumento = idDocumento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
        this.universidad = universidad;
        this.carrera = carrera;
    }
     public Documento(){
        this(0, "","","", "", "");
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Documento{" + "idDocumento=" + idDocumento + ", nombre=" + nombre + ", descripcion=" + descripcion + ", activo=" + activo + ", universidad=" + universidad + ", carrera=" + carrera + '}';
    }
    
}
