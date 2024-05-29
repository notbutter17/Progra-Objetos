package pe.edu.upeu.syscenterlife.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.syscenterlife.autocomp.ModeloDataAutocomplet;
import pe.edu.upeu.syscenterlife.modelo.Cliente;
import pe.edu.upeu.syscenterlife.repositorio.ClienteRepository;
import pe.edu.upeu.syscenterlife.util.ErrorLogger;

@Service
public class ClienteService {
    ErrorLogger log=new ErrorLogger("ClienteService.class");
    
    @Autowired
    ClienteRepository clienteRepository;

    //Create
    public Cliente guardarEntidad(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //Report
    public List<Cliente> listarEntidad() {
        return clienteRepository.findAll();
    }

    //Update
    public Cliente actualizarEntidad(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //Delete
    public void eliminarRegEntidad(String dniruc) {
        clienteRepository.delete(clienteRepository.findById(dniruc).get());
    }

    //Buscar
    public Cliente buscarCliente(String dniruc) {
        return clienteRepository.findById(dniruc).get();
    }

    //Buscar
    public List<Cliente> buscarClienteNombre(String nombre) {
        return clienteRepository.findByNombre("%" + nombre + "%");
    }

    public List<ModeloDataAutocomplet> listAutoComplet(String dato) {
        List<ModeloDataAutocomplet> listarclientes = new ArrayList<>();
        try {
            for (Cliente cliente : clienteRepository.listAutoCompletCliente(dato + "%")) {
                ModeloDataAutocomplet data = new ModeloDataAutocomplet();
                ModeloDataAutocomplet.TIPE_DISPLAY = "ID";
                data.setIdx(cliente.getDniruc());
                data.setNombreDysplay(cliente.getNombrers());
                data.setOtherData(cliente.getDocumento());
                listarclientes.add(data);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "create", e);
        }
        return listarclientes;
    }

}
