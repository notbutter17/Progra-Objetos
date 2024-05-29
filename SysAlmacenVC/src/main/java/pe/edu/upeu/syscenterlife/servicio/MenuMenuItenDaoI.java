package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import java.util.Properties;
import pe.edu.upeu.syscenterlife.modelo.MenuMenuItenTO;

public interface MenuMenuItenDaoI {
    public List<MenuMenuItenTO> listaAccesos(String perfil, Properties idioma);
}
