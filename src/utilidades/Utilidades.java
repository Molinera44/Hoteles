/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.awt.Component;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Molinera
 */
public class Utilidades {
    
    public static boolean campoVacio(JTextField campo) {
        return "".equals((campo.getText()));
    }

    public static void lanzaAlertaCampoVacio(Component ventanaPadre, String mensaje) {
        JOptionPane.showMessageDialog(ventanaPadre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean enteroCorrecto(JTextField campo) {
        try {
            String texto = campo.getText();
            int numero = Integer.parseInt(texto);
            if (numero > 0) {
                return true;
            }
        } catch (NumberFormatException e) {

        }
        return false;
    }

    public static void lanzarAlertaEntero(Component ventanaPadre, String mensaje) {
        JOptionPane.showMessageDialog(ventanaPadre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean combosSinSeleccionar(String opcion) {
        return opcion.equals("SELECCIONE");
    }

    public static void lanzaAlertaComboVacio(Component ventanaPadre, JComboBox combo) {
        JOptionPane.showMessageDialog(ventanaPadre, "El combo " + combo.getName() + " es obligatoria");
    }

    public static boolean formatoDNI(String compruebaFormatoDNI) {
        String patronDNI = "[0-9]{8}[A-Z]{1}";
        return Pattern.matches(patronDNI, compruebaFormatoDNI);
    }

    public static void lanzarformatodni(Component ventanaPadre, String mensaje) {
        JOptionPane.showMessageDialog(ventanaPadre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean dniValido(String validacionDNI) {
        char[] letra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        if (formatoDNI(validacionDNI)) {
            String numeroDNI = validacionDNI.substring(0, 8);
            int indiceLetra = Integer.parseInt(numeroDNI) % 23;
            return validacionDNI.charAt(8) == letra[indiceLetra];
        }
        return false;
    }

    public static void lanzarformatodniValido(Component ventanaPadre, String mensaje) {
        JOptionPane.showMessageDialog(ventanaPadre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean formatoTelefono(String compruebaFormatoTelefono) {
        String patronTelefono = "[6-9]{1}[0-9]{8}";
        return Pattern.matches(patronTelefono, compruebaFormatoTelefono);
    }

    public static void lanzarTelefono(Component ventanaPadre, String mensaje) {
        JOptionPane.showMessageDialog(ventanaPadre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean formatoTelefonoFijo(String compruebaFormatoTelefonoFijo) {
        String patronTelefonoFijo = "[8-9]{1}[0-8]{2}[0-9]{6}";
        return Pattern.matches(patronTelefonoFijo, compruebaFormatoTelefonoFijo);
    }

    public static void lanzarTelefonoFijo(Component ventanaPadre, String mensaje) {
        JOptionPane.showMessageDialog(ventanaPadre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean correoCorrecto(JTextField campo) {
        String patronEmail = "[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*";
        return campo.getText().matches(patronEmail);
    }

    public static void lanzaAlertaCorreo(Component ventanaPadre, String mensaje) {
        JOptionPane.showMessageDialog(ventanaPadre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean formatoCP(String compruebaFormatoCP) {
        String patronCP = "^[0-5]{1}[0-9]{1}[0]{1}[0-9]{2}$";
        return Pattern.matches(patronCP, compruebaFormatoCP);
    }

    public static void lanzaAlertaCp(Component ventanaPadre, String mensaje) {
        JOptionPane.showMessageDialog(ventanaPadre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void lanzaAlerta(Component ventanaPadre, String mensaje) {
        JOptionPane.showMessageDialog(ventanaPadre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
