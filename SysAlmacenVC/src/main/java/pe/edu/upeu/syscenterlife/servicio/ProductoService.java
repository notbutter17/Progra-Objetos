/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.syscenterlife.servicio;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Level;
import pe.com.syscenterlife.autocomp.ModeloDataAutocomplet;
import pe.edu.upeu.syscenterlife.modelo.Producto;
import pe.edu.upeu.syscenterlife.repositorio.ProductoRepository;
import pe.edu.upeu.syscenterlife.util.ErrorLogger;

@Service
public class ProductoService {

    ErrorLogger log=new ErrorLogger("ProductoService.class");
     
    @Autowired
    ProductoRepository productoRepository;

    // Create
    public Producto guardarEntidad(Producto producto) {
        return productoRepository.save(producto);
    }

    // Report
    public List<Producto> listarEntidad() {
        return productoRepository.findAll();
    }

    // Update
    public Producto actualizarEntidad(Producto producto) {
        return productoRepository.save(producto);
    }

    // Delete
    public void eliminarRegEntidad(Integer idProducto) {
        productoRepository.deleteById(idProducto);
    }

    // Buscar por ID
    public Producto buscarProducto(Integer idProducto) {
        return productoRepository.findById(idProducto).orElse(null);
    }

    public List<ModeloDataAutocomplet> listAutoCompletProducto(String nombre) {
        List<ModeloDataAutocomplet> listarProducto = new ArrayList<>();
        try {
            for (Producto producto : productoRepository.listAutoCompletProducto(nombre + "%")) {
                ModeloDataAutocomplet data = new ModeloDataAutocomplet();
                ModeloDataAutocomplet.TIPE_DISPLAY = "ID";
                data.setIdx(producto.getNombre());
                data.setNombreDysplay(String.valueOf(producto.getIdProducto()));
                data.setOtherData(producto.getPu() + ":" + producto.getStock());
                listarProducto.add(data);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al realizar la busqueda", e);
        }
        return listarProducto;
    }

}
