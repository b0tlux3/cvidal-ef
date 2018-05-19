package ef.adm.modelo;

import ef.dao.Conexion;
import ef.modelo.AutosVendidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MantenimientoAutosVendidosAdm implements IMantenimientoAutosVendidosSQLOra {

    @Override
    public ArrayList<AutosVendidos> listarAutosVendidos() {

        ArrayList listaAutosVendidos = new ArrayList();
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select a.nro_placa, a.marca, a.modelo, a.color, a.precio, c.nombre from tb_autos_vendidos a, tb_clientes c where a.cod_cliente=c.cod_cliente and a.activo='1' order by nro_placa");
            while (rs.next()) {
                AutosVendidos av = new AutosVendidos();
                av.setNro_placa(rs.getString(1));
                av.setMarca(rs.getString(2));
                av.setModelo(rs.getString(3));
                av.setColor(rs.getString(4));
                av.setPrecio(rs.getString(5));
                av.setCod_cliente(rs.getString(6));
                listaAutosVendidos.add(av);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo obtener los registros de la base de datos. Mensaje: " + e.getMessage());
        }

        return listaAutosVendidos;

    }

    @Override
    public void addAutosVendidos(AutosVendidos autoven) {
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            String nroPlacaAutoVen = autoven.getNro_placa();
            String marcaAutoVen = autoven.getMarca();
            String modeloAutoVen = autoven.getModelo();
            String colorAutoVen = autoven.getColor();
            String precioAutoVen = autoven.getPrecio();
            String clienteAutoVen = autoven.getCod_cliente();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO tb_autos_vendidos (nro_placa, marca, modelo, color, precio, nombre, activo) values (?,?,?,?,?,?,?)");

            pst.setString(1, nroPlacaAutoVen);
            pst.setString(2, marcaAutoVen);
            pst.setString(3, modeloAutoVen);
            pst.setString(4, colorAutoVen);
            pst.setString(5, precioAutoVen);
            pst.setString(6, clienteAutoVen);
            pst.setString(7, "1");
            ResultSet rs = pst.executeQuery();

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }

    }

    @Override
    public void updateAutosVendidos(AutosVendidos autoven) {

        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            String nroPlacaAutoVen = autoven.getNro_placa();
            String marcaAutoVen = autoven.getMarca();
            String modeloAutoVen = autoven.getModelo();
            String colorAutoVen = autoven.getColor();
            String precioAutoVen = autoven.getPrecio();
            String clienteAutoVen = autoven.getCod_cliente();
            PreparedStatement pst = conn.prepareStatement("update tb_autos_vendidos set marca=?, modelo=?, color=?, precio=?, cod_cliente=? where nro_placa=?");

            pst.setString(1, nroPlacaAutoVen);
            pst.setString(2, marcaAutoVen);
            pst.setString(3, modeloAutoVen);
            pst.setString(4, colorAutoVen);
            pst.setString(5, precioAutoVen);
            pst.setString(6, clienteAutoVen);
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }

    }

    @Override
    public void deleteAutosVendidos(AutosVendidos autoven) {

        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            String nroPlacaAutoVen = autoven.getNro_placa();
            PreparedStatement pst = conn.prepareStatement("update tb_autos_vendidos set activo=? where nro_placa=?");

            pst.setString(1, "0");
            pst.setString(2, nroPlacaAutoVen);
            pst.executeUpdate();
            pst.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }

    }

}
