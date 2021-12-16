
// To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngCustomer;// importacion de clase
import com.aeroman.aees.facades.EngCustomerFacade;// importacion de clase
import javax.faces.bean.ViewScoped;// libreria Serializable
import java.io.Serializable;// libreria Serializable
import java.util.ArrayList;// libreria ArrayList
import java.util.List;// libreria List
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean

/**
 *
 * @author Usuario
 */
//nombre de clase en mageBean
@ManagedBean(name = "engCustomerBean")
@ViewScoped//tipo de clase
//clase ContAtasBean con extends al crud
public class EngCustomerBean extends CrudBean<EngCustomer> implements Serializable {
    
    @EJB
    private EngCustomerFacade engcustomerFacade;//declaracion de clases Facade

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        extendtime();//extiende el tiempo
        elemento = new EngCustomer();//inicializa el elemento
        listado = engcustomerFacade.findAll();//llena el listado
        List<EngCustomer> listaMex=new ArrayList<>();//variable de lista
        List<EngCustomer> listaAE=new ArrayList<>();//variable de lista
        int x = 0;//declaracion de variable
        while (x < listado.size()) {//itera la lista
            EngCustomer company = (EngCustomer) listado.get(x);//declaracion de variable y asigna

            if (("MEX").equals(company.getEngCompany())) {//evalua la variable
                listaMex.add(company);//llena la lista

            } else {
                if (("AE").equals(company.getEngCompany()))//evalua la variable
                {
                    listaAE.add(company);//llena la lista
                }
            }
            x++;
        }
        listado2=listaMex;//asigna al listado
        listado3=listaAE;//asigna al listado
    }
//metodo generado por implements Serializable
    @Override
    void limpiar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    void agregar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
    //metodo generado por implements Serializable
    @Override
    void actualizar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    //metodo generado por implements Serializable

    @Override
    EngCustomer nuevoElemento() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
    //metodo generado por implements Serializable
    @Override
    void eliminar(EngCustomer elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
