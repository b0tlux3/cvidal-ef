package ef.adm.modelo;

import ef.dao.Conexion;
import ef.modelo.Revisiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MantenimientoRevisionesAdm implements IMantenimientoRevisionesSQLOra {

    @Override
    public ArrayList<Revisiones> listarRevisiones() {

        ArrayList listaRevisiones = new ArrayList();
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select r.nro_revision as Numero, r.cambio_aceite as Aceite, r.cambio_filtro as Filtro, r.revision_frenos as Frenos, r.otros, a.marca as Auto from tb_revisiones r, tb_autos_vendidos a where r.nro_placa=a.nro_placa and r.activo='1' order by nro_revision");
            while (rs.next()) {
                Revisiones revi = new Revisiones();
                revi.setNro_revision(rs.getString(1));
                revi.setCambio_aceite(rs.getString(2));
                revi.setCambio_filtro(rs.getString(3));
                revi.setRevision_frenos(rs.getString(4));
                revi.setOtros(rs.getString(5));
                revi.setNro_placa(rs.getString(6));
                listaRevisiones.add(revi);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo obtener los registros de la base de datos. Mensaje: " + e.getMessage());
        }

        return listaRevisiones;

    }

    @Override
    public void addRevisiones(Revisiones rev) {
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            String nroRevision = rev.getNro_revision();
            String aceiteRevision = rev.getCambio_aceite();
            String filtroRevision = rev.getCambio_filtro();
            String frenosRevision = rev.getRevision_frenos();
            String otrosRevision = rev.getOtros();
            String marcaRevision = rev.getNro_placa();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO tb_revisiones (nro_revision, cambio_aceite, cambio_filtro, revision_frenos, otros, nro_placa, activo) values (?,?,?,?,?,?,?)");

            pst.setString(1, nroRevision);
            pst.setString(2, aceiteRevision);
            pst.setString(3, filtroRevision);
            pst.setString(4, frenosRevision);
            pst.setString(5, otrosRevision);
            pst.setString(6, marcaRevision);
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
    public void updateRevisiones(Revisiones rev) {

        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            String nroRevision = rev.getNro_revision();
            String aceiteRevision = rev.getCambio_aceite();
            String filtroRevision = rev.getCambio_filtro();
            String frenosRevision = rev.getRevision_frenos();
            String otrosRevision = rev.getOtros();
            String marcaRevision = rev.getNro_placa();
            PreparedStatement pst = conn.prepareStatement("update tb_revisiones set cambio_aceite=?, cambio_filtro=?, revision_frenos=?, otros=?, nro_placa=? where nro_revision=?");

            pst.setString(1, aceiteRevision);
            pst.setString(2, filtroRevision);
            pst.setString(3, frenosRevision);
            pst.setString(4, otrosRevision);
            pst.setString(5, marcaRevision);
            pst.setString(6, nroRevision);
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }

    }

    @Override
    public void deleteRevisiones(Revisiones rev) {

        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            String nroRevision = rev.getNro_revision();
            PreparedStatement pst = conn.prepareStatement("update tb_revisiones set activo=? where nro_revision=?");

            pst.setString(1, "0");
            pst.setString(2, nroRevision);
            pst.executeUpdate();
            pst.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }

    }

}
