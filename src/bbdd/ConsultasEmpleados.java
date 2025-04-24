/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd;

import static bbdd.Conexion.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;

/**
 *
 * @author Molinera
 */
public class ConsultasEmpleados {
    
    public static String guardarDNI(String usuario) {
        try {
            String consulta = "select dniEmpleado from empleados where usuario = ?";
            PreparedStatement pst = conn.prepareStatement(consulta);

            ResultSet rs;

            pst.setString(1, usuario);

            rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString("dniEmpleado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public static boolean registrarEmpleado(Empleado e) {
        try {
            String consulta = "Insert into empleados (dniEmpleado, nombre, apellidos, telefono, email, fechaContrato, turno, salarioBase, usuario, contrasenya) "
                    + "Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(1, e.getDni());
            pst.setString(2, e.getNombre());
            pst.setString(3, e.getApellidos());
            pst.setInt(4, e.getTelefono());
            pst.setString(5, e.getEmail());
            pst.setDate(6, new java.sql.Date(e.getFechaContrato().getTime()));
            pst.setString(7, e.getTurno());
            pst.setDouble(8, e.getSalarioBase());
            pst.setString(9, e.getUsuario());
            pst.setString(10, e.getContrasenya());

            pst.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void listadoEmpleadosTodos(DefaultTableModel mimodelo) {
        try {
            Object[] registro = new Object[7];

            String consulta = "select dniEmpleado, nombre, apellidos, telefono, email, turno from empleados";

            ResultSet rs = conn.createStatement().executeQuery(consulta);

            while (rs.next()) {
                registro[0] = rs.getString("dniEmpleado");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("telefono");
                registro[4] = rs.getString("email");
                registro[5] = rs.getString("turno");

                mimodelo.addRow(registro);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void listadoEmpleadosMañanas(DefaultTableModel mimodelo) {
        try {
            Object[] registro = new Object[7];

            String consulta = "select dniEmpleado, nombre, apellidos, telefono, email, turno from empleados where turno = 'mañanas'";

            ResultSet rs = conn.createStatement().executeQuery(consulta);

            while (rs.next()) {
                registro[0] = rs.getString("dniEmpleado");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("telefono");
                registro[4] = rs.getString("email");
                registro[5] = rs.getString("turno");

                mimodelo.addRow(registro);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void listadoEmpleadosTardes(DefaultTableModel mimodelo) {
        try {
            Object[] registro = new Object[7];

            String consulta = "select dniEmpleado, nombre, apellidos, telefono, email, turno from empleados where turno = 'tardes'";

            ResultSet rs = conn.createStatement().executeQuery(consulta);

            while (rs.next()) {
                registro[0] = rs.getString("dniEmpleado");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("telefono");
                registro[4] = rs.getString("email");
                registro[5] = rs.getString("turno");

                mimodelo.addRow(registro);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void listadoEmpleadosNoches(DefaultTableModel mimodelo) {
        try {
            Object[] registro = new Object[7];

            String consulta = "select dniEmpleado, nombre, apellidos, telefono, email, turno from empleados where turno = 'noches'";

            ResultSet rs = conn.createStatement().executeQuery(consulta);

            while (rs.next()) {
                registro[0] = rs.getString("dniEmpleado");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("telefono");
                registro[4] = rs.getString("email");
                registro[5] = rs.getString("turno");

                mimodelo.addRow(registro);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void listadoEmpleadosPartido(DefaultTableModel mimodelo) {
        try {
            Object[] registro = new Object[7];

            String consulta = "select dniEmpleado, nombre, apellidos, telefono, email, turno from empleados where turno = 'partido'";

            ResultSet rs = conn.createStatement().executeQuery(consulta);

            while (rs.next()) {
                registro[0] = rs.getString("dniEmpleado");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("telefono");
                registro[4] = rs.getString("email");
                registro[5] = rs.getString("turno");

                mimodelo.addRow(registro);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
