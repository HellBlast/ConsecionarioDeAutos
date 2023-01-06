package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Proceso {

    ConexcionOracle con = new ConexcionOracle();
    public static boolean error = true;

    public void InsertarCliente(String tipo, int numero, String nombre, String apellido, String direccion, String telefono) {
        Connection cn = con.getConnection();
        int id = 0;
        if (tipo.equals("TARGETA DE IDENTIDAD")) {
            id = 1;
        } else if (tipo.equals("CEDULA CIUDADANIA")) {
            id = 2;
        } else if (tipo.equals("CEDULA EXTRANGERA")) {
            id = 3;
        }
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO DISCLIENTE(cliid,tipid,cliident,clinom,cliape,clidir,clitel) "
                    + "VALUES(dis_cliente.nextval,?,?,?,?,?,?)");
            pst.setInt(1, id);
            pst.setInt(2, numero);
            pst.setString(3, nombre);
            pst.setString(4, apellido);
            pst.setString(5, direccion);
            pst.setString(6, telefono);
            pst.execute();
            pst.close();
            System.out.println("Datos Guardados con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo guardar correstamente \n " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Esta persona ya se encuentra registrada en el sistema\n"
                    + "puede omitir este paso");
            InformacionPersonal(numero);
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo guardar correstamente \n " + e.getMessage());
            }
        }
    }

    public void InsertarEmpleado(String tipo, int numero, String nombre, String apellido, String direccion, String telefono) {
        Connection cn = con.getConnection();

        int id = 0;
        if (tipo.equals("TARGETA DE IDENTIDAD")) {
            id = 1;
        } else if (tipo.equals("CEDULA CIUDADANIA")) {
            id = 2;
        } else if (tipo.equals("CEDULA EXTRANGERA")) {
            id = 3;
        }
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO DISEMPLEADO(empid,tipid,empident,empnom,empape,empdir,emptel) "
                    + "VALUES(dis_empleado.nextval,?,?,?,?,?,?)");
            pst.setInt(1, id);
            pst.setInt(2, numero);
            pst.setString(3, nombre);
            pst.setString(4, apellido);
            pst.setString(5, direccion);
            pst.setString(6, telefono);
            pst.execute();
            pst.close();
            System.out.println("Datos Guardados con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo guardar correstamente \n " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo guardar correstamente \n " + e.getMessage());

            }
        }
    }

    public void InsertarProveedor(String nombre, String direccion, String telefono) {
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO DISPROVEEDORES(proid,pronom,prodir,protel) "
                    + "VALUES(dis_proveedores.nextval,?,?,?)");
            pst.setString(1, nombre);
            pst.setString(2, direccion);
            pst.setString(3, telefono);
            pst.execute();
            pst.close();
            System.out.println("Datos Guardados con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo guardar correstamente \n " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo guardar correstamente \n " + e.getMessage());

            }
        }
    }

    public void InsertarMarca(String nombre, int proid) {
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO DISMARCA(marid,marnom,proid) "
                    + "VALUES(dis_marca.nextval,?,?)");
            pst.setString(1, nombre);
            pst.setInt(2, proid);
            pst.execute();
            pst.close();
            System.out.println("Datos Guardados con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo guardar correstamente id: \n " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo guardar correstamente \n " + e.getMessage());

            }
        }
    }

    public void InsertarModelo(String nombre, int marid) {
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO DISMODELO(modid,modrnom,marid) "
                    + "VALUES(dis_modelo.nextval,?,?)");
            pst.setString(1, nombre);
            pst.setInt(2, marid);
            pst.execute();
            pst.close();
            System.out.println("Datos Guardados con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo guardar correstamente id: \n " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo guardar correstamente \n " + e.getMessage());

            }
        }
    }

    public void InsertarAuto(String color, String kilometrage, int modi) {
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO DISAUTO(autid,autcolor,autkilom,modid) "
                    + "VALUES(dis_auto.nextval,?,?,?)");
            pst.setString(1, color);
            pst.setString(2, kilometrage);
            pst.setInt(3, modi);
            pst.execute();
            pst.close();
            System.out.println("Datos Guardados con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo guardar correstamente id: \n " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo guardar correstamente \n " + e.getMessage());

            }
        }
    }

    public void InsertarPrecio(int precio, Date fin, int autid) {
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO DISPRECIO(preid,preprecio,prefechaant,prefechafin,autid) "
                    + "VALUES(dis_precio.nextval,?,sysdate,?,?)");
            pst.setInt(1, precio);
            pst.setDate(2, fin);
            pst.setInt(3, autid);
            pst.execute();
            pst.close();
            System.out.println("Datos Guardados con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo guardar correstamente id: \n " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo guardar correstamente \n " + e.getMessage());

            }
        }
    }

    public void InsertarEncVenta(int cliid, int empid, String codigo) {
        error = true;
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO DISENCVENTA(venid,cliid,empid,vencodi,venfecha) "
                    + "VALUES(dis_encventa.nextval,?,?,?,sysdate)");
            pst.setInt(1, cliid);
            pst.setInt(2, empid);
            pst.setString(3, codigo);
            pst.execute();
            pst.close();
            System.out.println("Datos Guardados con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo guardar correstamente compra fallida id: \n " + e.getMessage());
            JOptionPane.showMessageDialog(null, "posible mente este codigo de venta ya se encuentra en uso");
            error = false;
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo guardar correstamente \n " + e.getMessage());

            }
        }
    }

    public void InsertarDetVenta(int venta, int auto, int cantidad) {
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO DISDETVENTA(venid,autid,detcant) "
                    + "VALUES(?,?,?)");
            pst.setInt(1, venta);
            pst.setInt(2, auto);
            pst.setInt(3, cantidad);
            pst.execute();
            pst.close();
            System.out.println("Datos Guardados con exito");
            JOptionPane.showMessageDialog(null, "COMPRA EXITOSA");

        } catch (SQLException e) {
            System.out.println("No se pudo guardar correstamente detalles compra fallida id: \n " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo guardar correstamente \n " + e.getMessage());

            }
        }
    }

    public void InsertarEncPrestamo(int cliid, int empid, String codigo) {
        error = true;
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO DISENCPRESTAMO(prestaid,cliid,empid,prestacodi,prestafecha) "
                    + "VALUES(dis_encprestamo.nextval,?,?,?,sysdate)");
            pst.setInt(1, cliid);
            pst.setInt(2, empid);
            pst.setString(3, codigo);
            pst.execute();
            pst.close();
            System.out.println("Datos Guardados con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo guardar correstamente compra fallida id: \n " + e.getMessage());
            JOptionPane.showMessageDialog(null, "posible mente este codigo de venta ya se encuentra en uso");
            error = false;
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo guardar correstamente \n " + e.getMessage());

            }
        }
    }

    public void InsertarDetPrestamo(int venta, int auto, int cantidad, Date fecha) {
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO DISDETPRESTAMO(prestaid,autid,pretamocant,pretamofin) "
                    + "VALUES(?,?,?,?)");
            pst.setInt(1, venta);
            pst.setInt(2, auto);
            pst.setInt(3, cantidad);
            pst.setDate(4, fecha);
            pst.execute();
            pst.close();
            System.out.println("Datos Guardados con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo guardar correstamente detalles compra fallida id: \n " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo guardar correstamente \n " + e.getMessage());

            }
        }
    }

    public void ModificaProveedor(String nombre, String direccion, String telefono, int id) {
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE DISENCVENTA SET venfecha = ? "
                    + "WHERE venid = ?");
            pst.setString(1, nombre);
            pst.setString(2, direccion);
            pst.setString(2, telefono);
            pst.setInt(4, id);
            pst.execute();
            pst.close();
            System.out.println("Datos Actualizado con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo Actualizar correstamente \n " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo Actulizar correstamente \n " + e.getMessage());

            }
        }
    }

    public void ModificaMarca(String nombre, int id) {
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE DISMARCA SET marnom = ? "
                    + "WHERE marid = ?");
            pst.setString(1, nombre);
            pst.setInt(2, id);
            pst.execute();
            pst.close();
            System.out.println("Datos Actualizado con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo Actualizar correstamente \n " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo Actulizar correstamente \n " + e.getMessage());

            }
        }
    }

    public void ModificaPrecio(int preid) {
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE DISPRECIO SET prefechafin = sysdate WHERE preid = ?");
            pst.setInt(1, preid);
            pst.execute();
            pst.close();
            System.out.println("Datos Actualizado con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo Actualizar correstamente \n " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo Actulizar correstamente \n " + e.getMessage());

            }
        }
    }

    public void ModificaCliente(int identidad, int id) {
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE DISCLIENTE SET cliident = ? WHERE cliid = ?");
            pst.setInt(1, identidad);
            pst.setInt(2, id);
            pst.execute();
            pst.close();
            System.out.println("Datos Actualizado con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo Actualizar correstamente \n " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo Actulizar correstamente \n " + e.getMessage());

            }
        }
    }

    public int IdCliente(int cedula) {
        int id = 0;
        Connection cn = con.getConnection();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("select c.cliid from DISCLIENTE c where c.cliident='" + cedula + "'");
            rs.next();
            id = rs.getInt(1);
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al ejecutar la buscqueda " + e.getMessage());
        }
        return id;
    }

    public int IdEmpleado(int cedula, String nombre) {

        int id = 0;
        Connection cn = con.getConnection();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("select e.empid from DISEMPLEADO e where e.empident=" + cedula + " and e.empnom='" + nombre + "'");
            rs.next();
            id = rs.getInt(1);
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al ejecutar la buscqueda " + e.getMessage());
        }
        return id;
    }

    public int Idproveedor(String nombre) {
        Connection cn = con.getConnection();
        Statement st;
        int id = 0;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("select p.proid from DISPROVEEDORES p where p.pronom='" + nombre + "'");
            rs.next();
            id = Integer.parseInt(rs.getString(1));
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al ejecutar la buscqueda " + e.getMessage());
        }
        return id;
    }

    public int Idmarca(String nombre) {
        Connection cn = con.getConnection();
        Statement st;
        int id = 0;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("select m.marid from DISMARCA m where m.marnom='" + nombre + "'");
            rs.next();
            id = Integer.parseInt(rs.getString(1));
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al ejecutar la buscqueda " + e.getMessage());
        }
        return id;
    }

    public int Idmodelo(String nombre) {
        Connection cn = con.getConnection();
        Statement st;
        int id = 0;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("select m.modid from DISMODELO m where m.modrnom='" + nombre + "'");
            rs.next();
            id = Integer.parseInt(rs.getString(1));
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al ejecutar la buscqueda Id Modelo" + e.getMessage());
        }
        return id;
    }

    public int IdVenta(String nombre) {
        Connection cn = con.getConnection();
        Statement st;
        int id = 0;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("select v.venid  from DISENCVENTA v where v.vencodi ='" + nombre + "'");
            rs.next();
            id = Integer.parseInt(rs.getString(1));
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al ejecutar la buscqueda Id Modelo" + e.getMessage());
        }
        return id;
    }

    public int IdPrestamo(String nombre) {
        Connection cn = con.getConnection();
        Statement st;
        int id = 0;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("select pre.prestaid from DISENCPRESTAMO pre where pre.prestacodi ='" + nombre + "'");
            rs.next();
            id = Integer.parseInt(rs.getString(1));
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al ejecutar la buscqueda Id del prestamo" + e.getMessage());
        }
        return id;
    }

    public int IdAuto(String color, String kilometrage, String modelo, String marca) {
        Connection cn = con.getConnection();
        Statement st;
        int id = 0;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT a.autid FROM dismodelo mo INNER JOIN dismarca ma on mo.marid = ma.marid "
                    + "INNER JOIN disproveedores p on p.proid=ma.proid "
                    + "INNER JOIN disauto a on a.modid=mo.modid "
                    + "WHERE a.autcolor='" + color + "' and a.autkilom='" + kilometrage + "' and mo.modrnom='" + modelo + "' and ma.marnom='" + marca + "'");
            rs.next();
            id = Integer.parseInt(rs.getString(1));
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al ejecutar la buscqueda  Id auto" + e.getMessage());
        }
        return id;
    }

    public int IdPrecio(int precio, String color, String kilometraje, String modelo) {
        Connection cn = con.getConnection();
        Statement st;
        int id = 0;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT P.PREID "
                    + "FROM DISPROVEEDORES PO INNER JOIN DISMARCA MA ON PO.PROID=MA.PROID "
                    + "INNER JOIN DISMODELO MO ON MO.MARID=MA.MARID "
                    + "INNER JOIN DISAUTO A ON A.MODID=MO.MODID "
                    + "INNER JOIN DISPRECIO P ON P.AUTID=A.AUTID "
                    + "WHERE P.PREPRECIO=" + precio + " AND A.AUTCOLOR='" + color + "' AND A.AUTKILOM='" + kilometraje + "' AND MO.MODRNOM='" + modelo + "'");
            rs.next();
            id = Integer.parseInt(rs.getString(1));
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al ejecutar la buscqueda  Id auto" + e.getMessage());
        }
        return id;
    }

    public void Eliminar(int id) {
        Connection cn = con.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement("DELETE FROM disproveedores WHERE proid = ?");
            pst.setInt(1, id);
            pst.execute();
            System.out.println(id);
            pst.close();
            System.out.println("Datos Eliminado con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo Actualizar correstamente \n " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("No se pudo Actulizar correstamente \n " + e.getMessage());

            }
        }
    }

    public void ListaClientes(JTable table) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"ID", "TIPO DE DOCUMENTACION", "NUMERO", "NOMBRE", "APELLIDO", "DIRECCION", "TELEFONO"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[7];
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT c.cliid, (select tipnom from distipo where tipid=c.tipid)as tipo, c.cliident, c.clinom, c.cliape, c.clidir, c.clitel      \n"
                    + "FROM discliente c");
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }

    }

    public void ListaClientesNombre(JTable table, int cedula) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"NOMBRE"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[1];
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT c.clinom||' '||c.cliape Nombre FROM discliente c WHERE c.cliident=" + cedula + "");
            rs.next();

            filas[0] = rs.getString(1);

            model.addRow(filas);

            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se a encontrado ninguna persona con este tipo de cedula");

        }

    }

    public void ListaEmplado(JTable table) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"ID", "TIPO DE DOCUMENTACION", "NUMERO", "NOMBRE", "APELLIDO", "DIRECCION", "TELEFONO"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[7];
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT d.empid, (select tipnom from distipo where tipid=d.tipid)as tipo, d.empident, d.empnom, d.empape, d.empdir, d.emptel      \n"
                    + "FROM disempleado d");
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }

    }

    public void ListaProveedores(JTable table) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "DIRECCION", "TELEFONO"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[4];
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM DISPROVEEDORES");
            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }

    }

    public void ListaMarca(JTable table) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "PROVEEDOR"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[3];
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT m.marid, m.marnom, (SELECT PRONOM FROM DISPROVEEDORES WHERE PROID = m.PROID)as proveedor from DISMARCA m");
            while (rs.next()) {
                for (int i = 0; i < 3; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }
    }

    public void ListaModelo(JTable table) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "MARCA"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[3];
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT m.modid, m.modrnom, (select marnom from dismarca  where marid=m.marid)as marca \n"
                    + "FROM DISMODELO m");
            while (rs.next()) {
                for (int i = 0; i < 3; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }
    }

    public void ListaAgregarAuto(JTable table) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "MARCA", "PROVEEDOR"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[4];
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT mo.modid, mo.modrnom, ma.marnom, p.pronom "
                    + "FROM dismodelo mo INNER JOIN dismarca ma on mo.marid = ma.marid "
                    + "INNER JOIN disproveedores p on p.proid=ma.proid");
            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }
    }

    public void ListaProveedorDetallaAuto(JTable table, String nombre) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "MARCA", "PROVEEDOR"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[4];
        Statement st;

        String consulta = "SELECT mo.modid, mo.modrnom, ma.marnom, p.pronom FROM dismodelo mo "
                + "INNER JOIN dismarca ma on mo.marid = ma.marid "
                + "INNER JOIN disproveedores p on p.proid=ma.proid "
                + "WHERE p.pronom='" + nombre + "'";

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }
    }

    public void ListaMarcaDetallaAuto(JTable table, String nombre) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "MARCA", "PROVEEDOR"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[4];
        Statement st;

        String consulta = "SELECT mo.modid, mo.modrnom, ma.marnom, p.pronom "
                + "FROM dismodelo mo INNER JOIN dismarca ma on mo.marid = ma.marid "
                + "INNER JOIN disproveedores p on p.proid=ma.proid "
                + "WHERE ma.marnom='" + nombre + "'";

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }
    }

    public void ListaProveedorMarcaModeloAuto(JTable table) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"ID", "PRECIO", "FECHA", "COLOR", "KILOMETRAJE", "MODELO", "MARCA", "PROVEEDOR"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[8];
        Statement st;

        String consulta = "SELECT A.AUTID, P.PREPRECIO, to_char(P.PREFECHAANT, 'dd/month/yyyy')FECHA, A.AUTCOLOR, A.AUTKILOM, MO.MODRNOM, MA.MARNOM, PO.PRONOM "
                + "FROM DISPROVEEDORES PO INNER JOIN DISMARCA MA ON PO.PROID=MA.PROID "
                + "INNER JOIN DISMODELO MO ON MO.MARID=MA.MARID "
                + "INNER JOIN DISAUTO A ON A.MODID=MO.MODID "
                + "INNER JOIN DISPRECIO P ON P.AUTID=A.AUTID "
                + "WHERE P.PREFECHAFIN IS NULL "
                + "ORDER BY A.AUTID";

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                for (int i = 0; i < 8; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }
    }

    public void InformacionPersonal(int cedula) {
        Connection cn = con.getConnection();

        String informacion = "";
        Statement st;

        String consulta = "SELECT (select tipnom from distipo where tipid=c.tipid)as tipo, c.cliident, c.clinom, c.cliape, c.clidir, c.clitel "
                + "FROM discliente c "
                + "WHERE c.cliident=" + cedula + "";

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            rs.next();

            informacion = "TIPO: " + rs.getString(1) + "\n"
                    + "CEDULA: " + rs.getString(2) + "\n"
                    + "NOMBRE: " + rs.getString(3) + "\n"
                    + "APELLIDO: " + rs.getString(4) + "\n"
                    + "DIRECCION: " + rs.getString(5) + "\n"
                    + "TELEFONO: " + rs.getString(6);

            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }
        JOptionPane.showMessageDialog(null, informacion);
    }

    public void ListaMarcaDetallaAutoComprarMarca(JTable table, String nombre) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"ID", "PRECIO", "FECHA", "COLOR", "KILOMETRAJE", "MODELO", "MARCA", "PROVEEDOR"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[8];
        Statement st;

        String consulta = "SELECT A.AUTID, P.PREPRECIO, to_char(P.PREFECHAANT, 'dd/month/yyyy')FECHA, A.AUTCOLOR, A.AUTKILOM, MO.MODRNOM, MA.MARNOM, PO.PRONOM\n"
                + "FROM DISPROVEEDORES PO INNER JOIN DISMARCA MA ON PO.PROID=MA.PROID\n"
                + "INNER JOIN DISMODELO MO ON MO.MARID=MA.MARID\n"
                + "INNER JOIN DISAUTO A ON A.MODID=MO.MODID\n"
                + "INNER JOIN DISPRECIO P ON P.AUTID=A.AUTID\n"
                + "WHERE P.PREFECHAFIN is NULL and MA.MARNOM='" + nombre + "'";

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                for (int i = 0; i < 8; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }
    }

    public void ListaVenta(JTable table) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"CLIENTE", "EMPLEADO", "CODIGO VENTA", "FECHA", "PRECIO", "CANTIDAD", "TOTAL", "COLOR", "KILOMETRAJE", "MODELO", "MARCA", "PROVEEDOR"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[12];
        Statement st;

        String consulta = "SELECT C.CLINOM||' '||C.CLIAPE CLIENTE, E.EMPNOM||' '||E.EMPAPE EMPLEADO, EN.VENCODI, to_char(EN.VENFECHA, 'dd/month/yyyy')FECHA, P.PREPRECIO, DE.DETCANT,(P.PREPRECIO*DE.detcant)TOTAL,  A.AUTCOLOR, A.AUTKILOM, MO.MODRNOM, MA.MARNOM, PO.PRONOM\n"
                + "FROM DISCLIENTE C INNER JOIN DISENCVENTA EN ON EN.CLIID=C.CLIID\n"
                + "INNER JOIN DISEMPLEADO E ON E.EMPID=EN.EMPID\n"
                + "INNER JOIN DISDETVENTA DE ON DE.VENID=EN.VENID\n"
                + "INNER JOIN DISAUTO A ON A.AUTID=DE.AUTID\n"
                + "INNER JOIN DISPRECIO P ON P.AUTID=A.AUTID\n"
                + "INNER JOIN DISMODELO MO ON MO.MODID=A.MODID\n"
                + "INNER JOIN DISMARCA MA ON MA.MARID=MO.MARID\n"
                + "INNER JOIN DISPROVEEDORES PO ON PO.PROID=MA.PROID\n"
                + "WHERE EN.VENFECHA>=P.PREFECHAANT AND (EN.VENFECHA<=P.PREFECHAFIN OR P.PREFECHAFIN IS NULL)\n"
                + "ORDER BY EN.VENID";

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                for (int i = 0; i < 12; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }
    }

    public void AutoMasVendido(JTable table) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"COLOR", "KILOMETRAJE", "MODELO", "MARCA", "PROVEEDOR", "CANTIDAD"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[6];
        Statement st;

        String consulta = "SELECT  A.AUTCOLOR, A.AUTKILOM, MO.MODRNOM, MA.MARNOM, PO.PRONOM, sum(de.detcant)\n"
                + "FROM DISCLIENTE C INNER JOIN DISENCVENTA EN ON EN.CLIID=C.CLIID\n"
                + "INNER JOIN DISEMPLEADO E ON E.EMPID=EN.EMPID\n"
                + "INNER JOIN DISDETVENTA DE ON DE.VENID=EN.VENID\n"
                + "INNER JOIN DISAUTO A ON A.AUTID=DE.AUTID\n"
                + "INNER JOIN DISPRECIO P ON P.AUTID=A.AUTID\n"
                + "INNER JOIN DISMODELO MO ON MO.MODID=A.MODID\n"
                + "INNER JOIN DISMARCA MA ON MA.MARID=MO.MARID\n"
                + "INNER JOIN DISPROVEEDORES PO ON PO.PROID=MA.PROID\n"
                + "WHERE EN.VENFECHA>=P.PREFECHAANT AND (EN.VENFECHA<=P.PREFECHAFIN OR P.PREFECHAFIN IS NULL)\n"
                + "GROUP BY A.AUTCOLOR, A.AUTKILOM, MO.MODRNOM, MA.MARNOM, PO.PRONOM\n"
                + "HAVING sum(de.detcant)=(SELECT  MAX(sum(de.detcant)) \n"
                + "FROM DISCLIENTE C INNER JOIN DISENCVENTA EN ON EN.CLIID=C.CLIID\n"
                + "INNER JOIN DISEMPLEADO E ON E.EMPID=EN.EMPID\n"
                + "INNER JOIN DISDETVENTA DE ON DE.VENID=EN.VENID\n"
                + "INNER JOIN DISAUTO A ON A.AUTID=DE.AUTID\n"
                + "INNER JOIN DISPRECIO P ON P.AUTID=A.AUTID\n"
                + "INNER JOIN DISMODELO MO ON MO.MODID=A.MODID\n"
                + "INNER JOIN DISMARCA MA ON MA.MARID=MO.MARID\n"
                + "INNER JOIN DISPROVEEDORES PO ON PO.PROID=MA.PROID\n"
                + "WHERE EN.VENFECHA>=P.PREFECHAANT AND (EN.VENFECHA<=P.PREFECHAFIN OR P.PREFECHAFIN IS NULL)\n"
                + "GROUP BY A.AUTCOLOR, A.AUTKILOM, MO.MODRNOM, MA.MARNOM, PO.PRONOM)";

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }
    }

    public void EmpleadoMasEficiente(JTable table) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"NOMBRE", "VENTAS"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[2];
        Statement st;

        String consulta = "SELECT E.EMPNOM||' '||E.EMPAPE EMPLEADO, sum(de.detcant)\n"
                + "FROM DISCLIENTE C INNER JOIN DISENCVENTA EN ON EN.CLIID=C.CLIID\n"
                + "INNER JOIN DISEMPLEADO E ON E.EMPID=EN.EMPID\n"
                + "INNER JOIN DISDETVENTA DE ON DE.VENID=EN.VENID\n"
                + "INNER JOIN DISAUTO A ON A.AUTID=DE.AUTID\n"
                + "INNER JOIN DISPRECIO P ON P.AUTID=A.AUTID\n"
                + "INNER JOIN DISMODELO MO ON MO.MODID=A.MODID\n"
                + "INNER JOIN DISMARCA MA ON MA.MARID=MO.MARID\n"
                + "INNER JOIN DISPROVEEDORES PO ON PO.PROID=MA.PROID\n"
                + "WHERE EN.VENFECHA>=P.PREFECHAANT AND (EN.VENFECHA<=P.PREFECHAFIN OR P.PREFECHAFIN IS NULL)\n"
                + "GROUP BY E.EMPNOM, E.EMPAPE\n"
                + "HAVING sum(de.detcant)=(SELECT max(sum(de.detcant))\n"
                + "FROM DISCLIENTE C INNER JOIN DISENCVENTA EN ON EN.CLIID=C.CLIID\n"
                + "INNER JOIN DISEMPLEADO E ON E.EMPID=EN.EMPID\n"
                + "INNER JOIN DISDETVENTA DE ON DE.VENID=EN.VENID\n"
                + "INNER JOIN DISAUTO A ON A.AUTID=DE.AUTID\n"
                + "INNER JOIN DISPRECIO P ON P.AUTID=A.AUTID\n"
                + "INNER JOIN DISMODELO MO ON MO.MODID=A.MODID\n"
                + "INNER JOIN DISMARCA MA ON MA.MARID=MO.MARID\n"
                + "INNER JOIN DISPROVEEDORES PO ON PO.PROID=MA.PROID\n"
                + "WHERE EN.VENFECHA>=P.PREFECHAANT AND (EN.VENFECHA<=P.PREFECHAFIN OR P.PREFECHAFIN IS NULL)\n"
                + "GROUP BY E.EMPNOM, E.EMPAPE)";

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                for (int i = 0; i < 2; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }
    }

    public void TotalDeVenta(JTable table) {
        Connection cn = con.getConnection();

        DefaultTableModel model;
        String[] columnas = {"TOTAL DE VENTAS"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[1];
        Statement st;

        String consulta = "SELECT SUM(P.PREPRECIO*DE.DETCANT) TOTAL_DE_VENTA\n"
                + "FROM DISCLIENTE C INNER JOIN DISENCVENTA EN ON EN.CLIID=C.CLIID\n"
                + "INNER JOIN DISEMPLEADO E ON E.EMPID=EN.EMPID\n"
                + "INNER JOIN DISDETVENTA DE ON DE.VENID=EN.VENID\n"
                + "INNER JOIN DISAUTO A ON A.AUTID=DE.AUTID\n"
                + "INNER JOIN DISPRECIO P ON P.AUTID=A.AUTID\n"
                + "INNER JOIN DISMODELO MO ON MO.MODID=A.MODID\n"
                + "INNER JOIN DISMARCA MA ON MA.MARID=MO.MARID\n"
                + "INNER JOIN DISPROVEEDORES PO ON PO.PROID=MA.PROID\n"
                + "WHERE EN.VENFECHA>=P.PREFECHAANT AND (EN.VENFECHA<=P.PREFECHAFIN OR P.PREFECHAFIN IS NULL)";

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                for (int i = 0; i < 1; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            table.setModel(model);
            cn.close();
        } catch (Exception e) {
            System.out.println("No se puede listar la tabla");

        }
    }

}
