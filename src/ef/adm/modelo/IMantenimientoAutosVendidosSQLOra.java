package ef.adm.modelo;

import ef.modelo.AutosVendidos;
import java.util.ArrayList;

public interface IMantenimientoAutosVendidosSQLOra {

    public ArrayList listarAutosVendidos();

    public void addAutosVendidos(AutosVendidos autoven);

    public void updateAutosVendidos(AutosVendidos autoven);

    public void deleteAutosVendidos(AutosVendidos autoven);

}
