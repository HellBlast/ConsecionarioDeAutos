package control;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Fecha {

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private Date fecha;

    public Date getFecha(String xfecha) throws ParseException {
        java.util.Date nfecha = formato.parse(xfecha);
        fecha = new java.sql.Date(nfecha.getTime());
        return fecha;
    }

}
