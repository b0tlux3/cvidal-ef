package ef.adm.modelo;

import ef.modelo.Clientes;
import java.util.ArrayList;

public interface IMantenimientoClientesSQLOra {

    public ArrayList listarClientes();

    public void addClientes(Clientes client);

    public void updateClientes(Clientes client);

    public void deleteClientes(Clientes client);

}
