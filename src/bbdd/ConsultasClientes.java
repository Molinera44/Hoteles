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
import modelo.Cliente;

/**
 *
 * @author Molinera
 */
public class ConsultasClientes {
    
    public static boolean comprobarDni(String dniCliente){
        try {
            String consulta = "SELECT dniCliente FROM clientes WHERE dniCliente = ?";
            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs;

            pst.setString(1, dniCliente);

            rs = pst.executeQuery();
            
            return rs.next();

        }catch (SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
    public static Cliente rescataDatosCliente(String dniCliente){
        Cliente c = null;
        try{
            String consulta = "select dniCliente, nombre, apellidos, telefono, email, direccion, cp, localidad from clientes where dniCliente = ?";
            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs;
            
            pst.setString(1, dniCliente);
                
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new Cliente(
                        rs.getString("dniCliente"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getInt("telefono"),
                        rs.getString("email"),
                        rs.getString("direccion"),
                        rs.getInt("cp"),
                        rs.getString("localidad")
                );   
            }
        }catch (SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
       
    public static boolean registrarCliente (Cliente c){
        try{
            String consulta = "Insert into clientes (dniCliente, nombre, apellidos, telefono, email, direccion, cp, localidad) "
                    + "Values (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pst = conn.prepareStatement(consulta);
            
            pst.setString(0, c.getDni());
            pst.setString(1, c.getNombre());
            pst.setString(2, c.getApellidos());
            pst.setInt(3, c.getTelefono());
            pst.setString(4, c.getEmail());
            pst.setString(5, c.getDireccion());
            pst.setInt(6, c.getCp());
            pst.setString(7, c.getLocalidad());
            
            pst.execute();
            return true;
  
        }catch (SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
