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
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelo.Salones;

/**
 *
 * @author Molinera
 */
public class ConsultasSalones {
    
    public static void cargarComboCaterin(DefaultComboBoxModel modeloCombo) {
        try {
            String consulta = "SELECT caterin FROM reserva_salon";

            ResultSet rs = conn.createStatement().executeQuery(consulta);

            modeloCombo.addElement("SELECCIONE");

            while (rs.next()) {
                modeloCombo.addElement(rs.getString("caterin"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean registrarSalon(Salones s) {
        try {
            String consulta = "Insert into reserva_salon (dniCliente, fecha, numPersonas, caterin, precio, dniEmpleado) "
                    + "Values (?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(0, s.getDniCliente());
            pst.setDate(1, new java.sql.Date(s.getFecha().getTime()));
            pst.setInt(2, s.getNumPersonas());
            pst.setString(3, s.getCaterin());
            pst.setDouble(4, s.getPrecio());
            pst.setString(5, s.getDniEmpleado());

            pst.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void listadosalonesActual(DefaultTableModel mimodelo) {
        try {
            Object[] registro = new Object[7];

            String consulta = "select idReserva, dniCliente, fecha, numPersonas, caterin, precio from reserva_salon where fecha >= ?";
            PreparedStatement pst = conn.prepareStatement(consulta);
            pst.setDate(1, new java.sql.Date(new Date().getTime()));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idReserva");
                registro[1] = rs.getString("dniCliente");
                registro[2] = rs.getString("fecha");
                registro[3] = rs.getString("numPersonas");
                registro[4] = rs.getString("caterin");
                registro[5] = rs.getString("precio");

                mimodelo.addRow(registro);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void listadosalonesHis(DefaultTableModel mimodelo) {
        try {
            Object[] registro = new Object[7];

            String consulta = "select idReserva, dniCliente, fecha, numPersonas, caterin, precio from reserva_salon where fecha < ?";
            PreparedStatement pst = conn.prepareStatement(consulta);
            pst.setDate(1, new java.sql.Date(new Date().getTime()));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idReserva");
                registro[1] = rs.getString("dniCliente");
                registro[2] = rs.getString("fecha");
                registro[3] = rs.getString("numPersonas");
                registro[4] = rs.getString("caterin");
                registro[5] = rs.getString("precio");

                mimodelo.addRow(registro);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void listadosalonesFecha(DefaultTableModel mimodelo, Date fecha) {
        try {
            Object[] registro = new Object[7];

            String consulta = "select idReserva, dniCliente, fecha, numPersonas, caterin, precio from reserva_salon where fecha = ?";
            PreparedStatement pst = conn.prepareStatement(consulta);
            pst.setDate(1, new java.sql.Date(fecha.getTime()));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idReserva");
                registro[1] = rs.getString("dniCliente");
                registro[2] = rs.getString("fecha");
                registro[3] = rs.getString("numPersonas");
                registro[4] = rs.getString("caterin");
                registro[5] = rs.getString("precio");

                mimodelo.addRow(registro);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
