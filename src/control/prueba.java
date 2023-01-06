/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class prueba {

    public static void main(String[] args) throws ParseException {
        Proceso obj = new Proceso();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String xfecha = "27/11/2020";
        Date fecha;
        java.util.Date nfecha = formato.parse(xfecha);
        fecha = new java.sql.Date(nfecha.getTime());
        obj.ModificaCliente(900, 33);
        //obj.InsertarPrecio(200000, fecha, null, 41);
        //obj.ModificaPrecio(61, fecha);
        //int id=obj.IdPrecio(200000, "AZUL", "6.66", "GOLF 2020", "VOLKSWAGEN", "OSRAM");
        //System.out.println(id);

    }

}
