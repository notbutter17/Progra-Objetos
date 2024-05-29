package pe.edu.upeu.syscenterlife.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.syscenterlife.connx.ConnS;
import pe.edu.upeu.syscenterlife.modelo.Cliente;

public class ClienteDao {
    ConnS instance = ConnS.getInstance();
    Connection connection = instance.getConnection();
    PreparedStatement p;
    ResultSet r;

    public List<Cliente> listarCliente() {
        List<Cliente> lista=new ArrayList<>();
         try {
            p=connection.prepareStatement("select * from cliente");
            r=p.executeQuery();
            while (r.next()) {
               lista.add(Cliente.builder()
                       .dniruc(r.getString("dniruc"))
                       .nombres(r.getString("nombres"))
                       .documento(r.getString("documento"))
                       .build());
            }
             System.out.println(lista.get(0).getDniruc());
        } catch (Exception e) {
             System.err.println("Error"+e.getMessage());
        }
        return lista;
    }
}
