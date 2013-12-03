/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio1.service;

import com.mycompany.ejercicio1.Dao.DAOExcepcion;
import com.mycompany.ejercicio1.Dao.clienteDao;
import com.mycompany.ejercicio1.model.Cliente;
import java.util.Collection;

/**
 *
 * @author Administrador
 */
public class GestionCliente {
    public static void main(String[] args) throws DAOExcepcion {
         GestionCliente.listar1();
    }
    public static Cliente listar1() throws DAOExcepcion {
        clienteDao dao = new clienteDao();
         Collection<Cliente> resultado=dao.listar();
                 
           for  (Cliente  categoria : resultado){
               System.out.println(categoria.getCodCliente()+ " " + categoria.getNombre());
             }
        return null;
    }
}
