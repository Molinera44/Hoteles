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
public class Habitaciones {
    
    String dniCliente;
    Date fechaEntrada;
    Date fachaSalida;
    String tiposHabitacion;
    int noches;
    double precioTotal;
    String dniEmpleado;

    final double PrecioNocheSencilla = 60.00;
    final double PrecioNocheDoble = 100.00;

    public Habitaciones(String dniCliente, Date fechaEntrada, Date fachaSalida, String tiposHabitacion, int noches, String dniEmpleado) {

        this.dniCliente = dniCliente;
        this.fechaEntrada = fechaEntrada;
        this.fachaSalida = fachaSalida;
        this.tiposHabitacion = tiposHabitacion;
        this.noches = noches;
        if (this.tiposHabitacion.equals("sencilla")) {
            this.precioTotal = noches * PrecioNocheSencilla;
        } else {
            this.precioTotal = noches * PrecioNocheDoble;
        }
        this.dniEmpleado = dniEmpleado;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFachaSalida() {
        return fachaSalida;
    }

    public void setFachaSalida(Date fachaSalida) {
        this.fachaSalida = fachaSalida;
    }

    public String getTiposHabitacion() {
        return tiposHabitacion;
    }

    public void setTiposHabitacion(String tiposHabitacion) {
        this.tiposHabitacion = tiposHabitacion;
    }

    public int getNoches() {
        return noches;
    }

    public void setNoches(int noches) {
        this.noches = noches;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    @Override
    public String toString() {
        return "Dni Cliente: " + dniCliente + "\nFechaEntrada: " + fechaEntrada + "\nFechaSalida: " + fachaSalida + "\nNoches Reservadas: " + noches + "\nTipo de Habitacion: " + tiposHabitacion + "\nTotal de factura: " + precioTotal;

    }
}
