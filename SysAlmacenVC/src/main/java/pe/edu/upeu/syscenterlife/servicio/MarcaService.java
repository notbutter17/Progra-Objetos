package pe.edu.upeu.syscenterlife.servicio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.ComboBoxOption;
import pe.edu.upeu.syscenterlife.modelo.Marca;
import pe.edu.upeu.syscenterlife.repositorio.MarcaRepository;

@Service
public class MarcaService {
    @Autowired
    MarcaRepository repository;
    
    // Crear
    public Marca guardarEntidad(Marca marca){
        return repository.save(marca);
    }
    
    // Leer todos los elementos
    public List<Marca> listarEntidad(){
        return repository.findAll();
    }
    
    // Actualizar
    public Marca actualizarEntidad(Marca marca){
        return repository.save(marca);
    }
    
    // Eliminar
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    // Buscar por ID
    public Marca buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
    public List <ComboBoxOption> listaMarcaCombobox(){
        List <ComboBoxOption> listar=new ArrayList<>();
        for (Marca marca : repository.findAll()) {
            listar.add(new ComboBoxOption(String.valueOf(marca.getIdMarca()),
                    marca.getNombre()));
        }
        return listar;
    }
}
