/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Molinera
 */
public class Cliente extends DatosPersona{
    
    String direccion;
    int cp;
    String localidad;
    
    public Cliente(String dni, String nombre, String apellidos, int telefono, String email, String direccion, int cp, String localidad) {
        super(dni, nombre, apellidos, telefono, email);
        this.direccion = direccion;
        this.cp = cp;
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
