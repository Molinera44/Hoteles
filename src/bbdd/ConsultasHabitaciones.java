/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd;

import static bbdd.Conexion.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Habitaciones;

/**
 *
 * @author Molinera
 */
public class ConsultasHabitaciones {
    
    public static boolean registrarHabitacion(Habitaciones h) {
        try {
            String consulta = "Insert into reserva_habitacion (dniCliente, fechaentrada, fechasalida, tipohabitacion, noches, preciototal, dniEmpleado) "
                    + "Values (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(1, h.getDniCliente());
            pst.setDate(2, new java.sql.Date(h.getFechaEntrada().getTime()));
            pst.setDate(3, new java.sql.Date(h.getFachaSalida().getTime()));
            pst.setString(4, h.getTiposHabitacion());
            pst.setInt(5, h.getNoches());
            pst.setDouble(6, h.getPrecioTotal());
            pst.setString(7, h.getDniEmpleado());

            pst.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void listadoHabitacionesHis(DefaultTableModel mimodelo) {
        try {
           Object[] registro = new Object[7];

            String consulta = "select idReserva, dniCliente, fechaentrada, fechasalida, tipohabitacion, noches, preciototal from reserva_habitacion where fechaentrada < ?";
            PreparedStatement pst = conn.prepareStatement(consulta);
            pst.setDate(1, new java.sql.Date(new Date().getTime()));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idReserva");
                registro[1] = rs.getString("dniCliente");
                registro[2] = rs.getString("fechaentrada");
                registro[3] = rs.getString("fechasalida");
                registro[4] = rs.getString("tipohabitacion");
                registro[5] = rs.getString("noches");
                registro[6] = rs.getString("preciototal");

                mimodelo.addRow(registro);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void listadoHabitacionesActual(DefaultTableModel mimodelo) {
        try {
            Object[] registro = new Object[7];

            String consulta = "select idReserva, dniCliente, fechaentrada, fechasalida, tipohabitacion, noches, preciototal from reserva_habitacion where fechaentrada >= ?";
            PreparedStatement pst = conn.prepareStatement(consulta);
            pst.setDate(1, new java.sql.Date(new Date().getTime()));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idReserva");
                registro[1] = rs.getString("dniCliente");
                registro[2] = rs.getString("fechaentrada");
                registro[3] = rs.getString("fechasalida");
                registro[4] = rs.getString("tipohabitacion");
                registro[5] = rs.getString("noches");
                registro[6] = rs.getString("preciototal");

                mimodelo.addRow(registro);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void listadoHabitacionesFecha(DefaultTableModel mimodelo, Date fecha) {
        try {
            Object[] registro = new Object[7];

            String consulta = "select idReserva, dniCliente, fechaentrada, fechasalida, tipohabitacion, noches, preciototal from reserva_habitacion where fechaentrada = ?";
            PreparedStatement pst = conn.prepareStatement(consulta);
            pst.setDate(1, new java.sql.Date(fecha.getTime()));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idReserva");
                registro[1] = rs.getString("dniCliente");
                registro[2] = rs.getString("fechaentrada");
                registro[3] = rs.getString("fechasalida");
                registro[4] = rs.getString("tipohabitacion");
                registro[5] = rs.getString("noches");
                registro[6] = rs.getString("preciototal");

                mimodelo.addRow(registro);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
