/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio1.Dao;

import com.mycompany.ejercicio1.model.Cliente;
import com.mycompany.ejercicio1.zelper.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class clienteDao extends BaseDAO {

    public Collection<Cliente> listar() throws DAOExcepcion {
        Collection<Cliente> c = new ArrayList<Cliente>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            con = ConexionBD.obtenerConexion();
            String query = "select top 10 IdCliente,nombre,email from cliente order by nombre";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente vo = new Cliente();
                vo.setCodCliente(rs.getString("IdCliente"));
                vo.setNombre(rs.getString("nombre"));
                vo.setEmail(rs.getString("email"));
                c.add(vo);
            }



        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());


        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }


        return c;
    }
}
