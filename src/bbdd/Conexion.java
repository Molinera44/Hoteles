/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Molinera
 */
public class Conexion {
    
    static Connection conn;

    public static void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hotel", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cerrarConexion() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static boolean acceder (String user, String pass){
        try{
            String consulta = "SELECT usuario, contrasenya FROM empleados where usuario=? and contrasenya=?";
            
            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs;
            
            pst.setString(1, user);
            pst.setString(2, pass);
            
            rs = pst.executeQuery();
            
            return rs.next();
        }catch (SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean guardarNombreApellidos(JLabel lb, String usuario) {
        
        try {
            String consulta = "SELECT CONCAT(nombre, ' ', apellidos) FROM empleados WHERE usuario = ?";
            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs;

            pst.setString(1, usuario);

            rs = pst.executeQuery();
            if (rs.next()) {
                lb.setText("Bienvenid@ " + rs.getString(1));  
            }
            
            return rs.next();

        }catch (SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
