
package ef.adm.modelo;

import ef.dao.Conexion;
import ef.modelo.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MantenimientoClientesAdm implements IMantenimientoClientesSQLOra{

    @Override
    public ArrayList<Clientes> listarClientes() {
         ArrayList listaClientes = new ArrayList();
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select cod_cliente as Codigo, nombre, apellido as Apellidos, dni, direccion, distrito, telefono from tb_clientes where activo='1' order by cod_cliente");
            while (rs.next()) {
                Clientes client = new Clientes();
                client.setCod_cliente(rs.getString(1));
                client.setNombre(rs.getString(2));
                client.setApellido(rs.getString(3));
                client.setDni(rs.getString(4));
                client.setDireccion(rs.getString(5));
                client.setDistrito(rs.getString(6));
                client.setTelefono(rs.getString(7));
                listaClientes.add(client);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo obtener los registros de la base de datos. Mensaje: " + e.getMessage());
        }

        return listaClientes;
    }

    @Override
    public void addClientes(Clientes client) {
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            String codCliente = client.getCod_cliente();
            String nomCliente = client.getNombre();
            String apellCliente = client.getApellido();
            String dniCliente = client.getDni();
            String dirCliente = client.getDireccion();
            String distCliente = client.getDistrito();
            String telfCliente = client.getTelefono();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO tb_clientes (cod_cliente, nombre, apellido, dni, direccion, distrito, telefono, activo) values (?,?,?,?,?,?,?,?)");

            pst.setString(1, codCliente);
            pst.setString(2, nomCliente);
            pst.setString(3, apellCliente);
            pst.setString(4, dniCliente);
            pst.setString(5, dirCliente);
            pst.setString(6, distCliente);
            pst.setString(7, telfCliente);
            pst.setString(8, "1");
            ResultSet rs = pst.executeQuery();

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }
        
    }

    @Override
    public void updateClientes(Clientes client) {
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            String codCliente = client.getCod_cliente();
            String nomCliente = client.getNombre();
            String apellCliente = client.getApellido();
            String dniCliente = client.getDni();
            String dirCliente = client.getDireccion();
            String distCliente = client.getDistrito();
            String telfCliente = client.getTelefono();
            PreparedStatement pst = conn.prepareStatement("update tb_clientes set nombre=?, apellido=?, dni=?, direccion=?, distrito=?, telefono=? where cod_cliente=?");

            pst.setString(1, nomCliente);
            pst.setString(2, apellCliente);
            pst.setString(3, dniCliente);
            pst.setString(4, dirCliente);
            pst.setString(5, distCliente);
            pst.setString(6, telfCliente);
            pst.setString(7, codCliente);
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }
        
    }

    @Override
    public void deleteClientes(Clientes client) {
        
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            String idProducto = client.getCod_cliente();
            PreparedStatement pst = conn.prepareStatement("update tb_clientes set activo=? where cod_cliente=?");

            pst.setString(1, "0");
            pst.setString(2, idProducto);
            pst.executeUpdate();
            pst.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }
        
    }
    
}
