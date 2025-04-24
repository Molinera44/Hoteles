/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Molinera
 */
public class Salones {
    
    String dniCliente;
    Date fecha;
    int numPersonas;
    String caterin;
    double precio;
    String dniEmpleado;
    final double PrecioconAlmuerzo = 60.00;
    final double PrecioconComida = 90.00;
    final double PrecioconDesayuno = 75.00;
    final double PrecioconCena = 80.00;

    public Salones(String dniCliente, Date fecha, int numPersonas, String caterin, double precio, String dniEmpleado) {
        this.dniCliente = dniCliente;
        this.fecha = fecha;
        this.numPersonas = numPersonas;
        this.caterin = caterin;
        this.precio = precio;
        this.dniEmpleado = dniEmpleado;
    }

    public Salones(String text, Date date, int parseInt, String toString, String guardarDNI) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public String getCaterin() {
        return caterin;
    }

    public void setCaterin(String caterin) {
        this.caterin = caterin;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }
    
    
}
