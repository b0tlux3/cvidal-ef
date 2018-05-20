package ef.adm.modelo;

import ef.modelo.Revisiones;
import java.util.ArrayList;

public interface IMantenimientoRevisionesSQLOra {

    public ArrayList listarRevisiones();

    public void addRevisiones(Revisiones rev);

    public void updateRevisiones(Revisiones rev);

    public void deleteRevisiones(Revisiones rev);

}
