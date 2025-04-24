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
public class Empleado extends DatosPersona {
    
    Date fechaContrato;
    String turno;
    double salarioBase;
    String usuario;
    String contrasenya;

    public Empleado(String dni, String nombre, String apellidos, int telefono, String email, Date fechaContrato, String turno, double salarioBase, String usuario, String contrasenya) {
        super(dni, nombre, apellidos, telefono, email);
        this.fechaContrato = fechaContrato;
        this.turno = turno;
        this.salarioBase = salarioBase;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    
    
}
