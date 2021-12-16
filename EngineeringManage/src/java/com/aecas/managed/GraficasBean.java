
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngTaskListView;// inportacion de clase EngTaskLisView
import com.aeroman.aees.entities.GraficaCustomer;// inportacion de clase
import com.aeroman.aees.entities.GraficaCustomer2;// inportacion de clase
import com.aeroman.aees.entities.GraficaCustomer3;//inportacion de clase
import com.aeroman.aees.entities.grant.ContCheck; //inportacion de clase
import com.aeroman.aees.entities.grant.CoreEngineersListV; //inportacion de clase
import com.aeroman.aees.facades.EngRequestFacade;//inportacion de clase
import com.aeroman.aees.facades.EngTaskListViewFacade;// inportacion de clase
import com.aeroman.aees.facades.Sequences;// inportacion de clase
import com.aeroman.aees.facades.grant.ContCheckFacade;//inportacion de clase
import com.aeroman.aees.facades.grant.CoreEngineersListVFacade;//inportacion de clase
import java.io.Serializable;// libreriara seralizable
import java.util.ArrayList;// libreria Array list
import java.util.Date;// libreria  date
import java.util.List;// libreria Listas
import javax.annotation.PostConstruct;// libreria Constructor
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria managedBean
import javax.faces.bean.ViewScoped;// Viewscoped
import javax.faces.context.FacesContext; //libreria faces Context

/**
 *
 * @author saplic11
 */
@ManagedBean(name = "graficas")
@ViewScoped
public class GraficasBean implements Serializable {

    private List<GraficaCustomer> cargrafica = new ArrayList<>();//variable de lista
    private List<GraficaCustomer2> cargrafica2 = new ArrayList<>();//variable de lista
    private List<GraficaCustomer3> cargrafica3 = new ArrayList<>();//variable de lista
    private List<String> label = new ArrayList<>();//variable de lista
    private List<Integer> dato = new ArrayList<>();//variable de lista
    private transient List<Object[]> conteos = new ArrayList<>();//variable de lista
    private List<GraficaCustomer3> graficaCustomer = new ArrayList<>();//variable de lista
    private List<EngTaskListView> listadoverde = new ArrayList<>();//variable de lista
    private List<EngTaskListView> listadoamarillo = new ArrayList<>();//variable de lista
    private List<EngTaskListView> listadorojo = new ArrayList<>();//variable de lista
    private List<EngTaskListView> listadogenral = new ArrayList<>();//variable de lista
    private List<String> labelEsrAvion = new ArrayList<>();//variable de lista
    private List<Integer> datoEsrAvion = new ArrayList<>();//variable de lista
    private List<String> labelEsrIngeniero = new ArrayList<>();//variable de lista
    private List<Integer> datoEsrIngeniero = new ArrayList<>();//variable de lista
    private List<String> labelClientes = new ArrayList<>();//variable de lista
    private List<Integer> datoClientes = new ArrayList<>();//variable de lista

    private Boolean filall; //declaracion de variable
    private Date fechaAct = new Date(); //declaracion de variable
    private String idCusto;//declaracion de variable
    private Integer conteo;//declaracion de variable
    private Boolean all = false;//declaracion de variable
    private int porcentajeVerde;//declaracion de variable
    private int porcentajeAmarillo;//declaracion de variable
    private int porcentajeRojo;//declaracion de variable
    private int max = 0;//declaracion de variable
    private String porcentaje;//declaracion de variable

    @EJB
    private Sequences sec; //declaracion de clases Facade
    @EJB
    private EngTaskListViewFacade taskviewfacade;//declaracion de clases Facade
    @EJB
    private ContCheckFacade contFacade;//declaracion de clases Facade
    @EJB
    private EngRequestFacade engRequestFacade;//declaracion de clases Facade
    @EJB
    private CoreEngineersListVFacade coreEngineersListVFacade;//declaracion de clases Facade
//metodo constructor
    @PostConstruct
    public void init() {
        customer();
        filall = false;
        graficoEsrPorAvion();
        graficoEsrPorIngeniero();
    }
// detodo que estiende el tiempo
    public void extendtimeGrafia() {
        FacesContext faces = FacesContext.getCurrentInstance();
        if (faces != null) {
            faces.getExternalContext().setSessionMaxInactiveInterval(900);
        }
    }
//metodo que crea la cles
    public void customer() {
        extendtimeGrafia();
        conteo = 0;
        label.clear();
        dato.clear();
        listadoamarillo = new ArrayList<>();
        listadorojo = new ArrayList<>();
        listadogenral = new ArrayList<>();
        cargrafica = sec.graficaCustomer();
//for para iterar
        for (int i = 0; i < cargrafica.size(); i++) {
            int x = Integer.parseInt(cargrafica.get(i).getCounT());

            max = max + x;
        }
// for para iterar y agregar "/"
        for (GraficaCustomer cargrafica5 : cargrafica) {
            labelClientes.add("\"" + cargrafica5.getEngId() + "\"");
            datoClientes.add(Integer.parseInt(cargrafica5.getCounT()));
        }

        cargrafica2 = sec.graficaCustomer2();
        cargrafica3 = sec.graficaCustomer3();
        // for para iterar y agregar a la lista
        for (GraficaCustomer3 cargrafica4 : cargrafica3) {
            label.add(cargrafica4.getCompany());
            dato.add(cargrafica4.getCounT());
        }
//busca todas las Task
        listadogenral = taskviewfacade.findAll();
        int x = 0;
        while (x < listadogenral.size()) {
            EngTaskListView color = (EngTaskListView) listadogenral.get(x);
            if (color.getReqFechaIns() != null) {
                int coloritem = this.verFecha(color.getReqFechaIns());
                if (coloritem == 1) {
                    listadoverde.add(color);
                } else if (coloritem == 2) {
                    listadoamarillo.add(color);
                } else {
                    listadorojo.add(color);
                }
            }
            x++;
        }
        double ol;
        if(!listadoverde.isEmpty()){
            int sumaverde = listadoverde.size()*100;
            ol = (double) sumaverde/listadogenral.size();
            porcentajeVerde = (int)Math.round(ol);
        }else{
            porcentajeVerde = 0;
        }
        
        if(!listadoamarillo.isEmpty()){
            int sumamarillo = listadoamarillo.size()*100;
            ol = (double) sumamarillo/listadogenral.size();
            porcentajeAmarillo = (int)Math.round(ol);
        }else{
            porcentajeAmarillo = 0;
        }
        
        if(!listadorojo.isEmpty()){
            int sumarojo = listadorojo.size()*100;
            ol = (double) sumarojo/listadogenral.size();
            porcentajeRojo = (int)Math.round(ol);
        }else{
            porcentajeRojo = 0;
        }
    }
//metodo que genera las graficas
    public void generarGrafica() {
        extendtimeGrafia();
        conteo = 0;
        label.clear();
        dato.clear();

        graficaCustomer = sec.graficaCustomerManager(idCusto);
        for (GraficaCustomer3 g : graficaCustomer) {
            label.add(g.getCompany());
            dato.add(g.getCounT());
            conteo += g.getCounT();
        }
        conteos = sec.countByCustomer(idCusto);
    }
//metodo que genera las graficas
    public void generarGraficacheck() {
        extendtimeGrafia();
        conteo = 0;
        label.clear();
        dato.clear();

        if (!filall) {
            graficaCustomer = sec.graficaCustomerManager(idCusto);
            for (GraficaCustomer3 g : graficaCustomer) {
                label.add(g.getCompany());
                dato.add(g.getCounT());
                conteo += g.getCounT();
            }
            conteos = sec.countByCustomer(idCusto);
            filall = false;
        } else {
            graficaCustomer = sec.graficaCustomerManagerall();
            for (GraficaCustomer3 g : graficaCustomer) {
                label.add(g.getCompany());
                dato.add(g.getCounT());
                conteo += g.getCounT();
            }
            conteos = sec.countByCustomerall();
            filall = true;
        }
    }
//valida fechas
    public int verFecha(Date fecha) {
        extendtimeGrafia();
        Long days;
        Long difference;
        int ret = 0;
        if (fecha != null) {
            days = fechaAct.getTime() - fecha.getTime();
            difference = days / (1000 * 60 * 60 * 24);
            if (difference.intValue() <= 1) {
                ret = 1;
            }
            if (difference.intValue() == 2) {
                ret = 2;
            }
            if (difference.intValue() >= 3) {
                ret = 3;
            }
            return ret;
        }
        return 3;
    }
//metodo que genera las graficas
    public void graficoEsrPorAvion() {
        extendtimeGrafia();
        List<ContCheck> chequeosActivos = contFacade.findChecksActivos();

        StringBuilder sb = new StringBuilder();
        for (ContCheck cheq : chequeosActivos) {
            sb.append("'");
            sb.append(cheq.getChkRegistry().trim());
            sb.append("', ");
        }
        sb.append("' '");

        List<GraficaCustomer3> esrList = engRequestFacade.findByAvionesChecksActivos(sb.toString());

        for (GraficaCustomer3 cargrafica4 : esrList) {
            labelEsrAvion.add(cargrafica4.getCompany());
            datoEsrAvion.add(cargrafica4.getCounT());
        }
    }
//metodo que genera las graficas
    public void graficoEsrPorIngeniero() {
        extendtimeGrafia();
        List<CoreEngineersListV> ingeniierios = coreEngineersListVFacade.findAllJpa();

        StringBuilder sb = new StringBuilder();
        for (CoreEngineersListV ingen : ingeniierios) {
            sb.append("'");
            sb.append(ingen.getCodigo86().trim());
            sb.append("', ");
        }
        sb.append("' '");

        List<GraficaCustomer3> esrIngList = engRequestFacade.findByIngenierosEncargados(sb.toString());

        for (GraficaCustomer3 cargrafica4 : esrIngList) {
            labelEsrIngeniero.add(cargrafica4.getCompany());
            datoEsrIngeniero.add(cargrafica4.getCounT());
        }
    }
    // get y set de variable
    public List<GraficaCustomer> getCargrafica() {
        return cargrafica;
    }
    
// get y set de variable
    public void setCargrafica(List<GraficaCustomer> cargrafica) {
        this.cargrafica = cargrafica;
    }
// get y set de variable
    public List<GraficaCustomer2> getCargrafica2() {
        return cargrafica2;
    }
    
// get y set de variable
    public void setCargrafica2(List<GraficaCustomer2> cargrafica2) {
        this.cargrafica2 = cargrafica2;
    }
// get y set de variable
    public List<GraficaCustomer3> getCargrafica3() {
        return cargrafica3;
    }
    
// get y set de variable
    public void setCargrafica3(List<GraficaCustomer3> cargrafica3) {
        this.cargrafica3 = cargrafica3;
    }
// get y set de variable
    public List<String> getLabel() {
        return label;
    }
    
// get y set de variable
    public void setLabel(List<String> label) {
        this.label = label;
    }
// get y set de variable
    public List<Integer> getDato() {
        return dato;
    }
    
// get y set de variable
    public void setDato(List<Integer> dato) {
        this.dato = dato;
    }
// get y set de variable
    public int getMax() {
        return max;
    }
    
// get y set de variable
    public void setMax(int max) {
        this.max = max;
    }
// get y set de variable
    public String getIdCusto() {
        return idCusto;
    }
    
// get y set de variable    
    public void setIdCusto(String idCusto) {
        this.idCusto = idCusto;
    }
// get y set de variable
    public String getPorcentaje() {
        return porcentaje;
    }
    
// get y set de variable    
    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }
// get y set de variable
    public Integer getConteo() {
        return conteo;
    }
    
// get y set de variable
    public void setConteo(Integer conteo) {
        this.conteo = conteo;
    }
// get y set de variable
    public Boolean getAll() {
        return all;
    }
    
// get y set de variable
    public void setAll(Boolean all) {
        this.all = all;
    }
// get y set de variable
    public List<Object[]> getConteos() {
        return conteos;
    }
    
// get y set de variable
    public void setConteos(List<Object[]> conteos) {
        this.conteos = conteos;
    }
// get y set de variable
    public List<GraficaCustomer3> getGraficaCustomer() {
        return graficaCustomer;
    }
    
// get y set de variable
    public void setGraficaCustomer(List<GraficaCustomer3> graficaCustomer) {
        this.graficaCustomer = graficaCustomer;
    }
// get y set de variable
    public Boolean getFilall() {
        return filall;
    }
    
// get y set de variable
    public void setFilall(Boolean filall) {
        this.filall = filall;
    }
// get y set de variable
    public Date getFechaAct() {
        return fechaAct;
    }
    
// get y set de variable
    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }
// get y set de variable
    public List<EngTaskListView> getListadoverde() {
        return listadoverde;
    }
    
// get y set de variable
    public void setListadoverde(List<EngTaskListView> listadoverde) {
        this.listadoverde = listadoverde;
    }
// get y set de variable
    public List<EngTaskListView> getListadoamarillo() {
        return listadoamarillo;
    }
    
// get y set de variable
    public void setListadoamarillo(List<EngTaskListView> listadoamarillo) {
        this.listadoamarillo = listadoamarillo;
    }
// get y set de variable
    public List<EngTaskListView> getListadorojo() {
        return listadorojo;
    }
    
// get y set de variable
    public void setListadorojo(List<EngTaskListView> listadorojo) {
        this.listadorojo = listadorojo;
    }
// get y set de variable
    public List<EngTaskListView> getListadogenral() {
        return listadogenral;
    }
    
// get y set de variable
    public void setListadogenral(List<EngTaskListView> listadogenral) {
        this.listadogenral = listadogenral;
    }
// get y set de variable
    public List<String> getLabelEsrAvion() {
        return labelEsrAvion;
    }
    
// get y set de variable
    public void setLabelEsrAvion(List<String> labelEsrAvion) {
        this.labelEsrAvion = labelEsrAvion;
    }
// get y set de variable
    public List<Integer> getDatoEsrAvion() {
        return datoEsrAvion;
    }
    
// get y set de variable
    public void setDatoEsrAvion(List<Integer> datoEsrAvion) {
        this.datoEsrAvion = datoEsrAvion;
    }
// get y set de variable
    public List<String> getLabelEsrIngeniero() {
        return labelEsrIngeniero;
    }
    
// get y set de variable
    public void setLabelEsrIngeniero(List<String> labelEsrIngeniero) {
        this.labelEsrIngeniero = labelEsrIngeniero;
    }
// get y set de variable
    public List<Integer> getDatoEsrIngeniero() {
        return datoEsrIngeniero;
    }
    
// get y set de variable
    public void setDatoEsrIngeniero(List<Integer> datoEsrIngeniero) {
        this.datoEsrIngeniero = datoEsrIngeniero;
    }
// get y set de variable
    public List<String> getLabelClientes() {
        return labelClientes;
    }
    
// get y set de variable
    public void setLabelClientes(List<String> labelClientes) {
        this.labelClientes = labelClientes;
    }
// get y set de variable
    public List<Integer> getDatoClientes() {
        return datoClientes;
    }
    
// get y set de variable
    public void setDatoClientes(List<Integer> datoClientes) {
        this.datoClientes = datoClientes;
    }
// get y set de variable
    public int getPorcentajeVerde() {
        return porcentajeVerde;
    }
    
// get y set de variable
    public void setPorcentajeVerde(int porcentajeVerde) {
        this.porcentajeVerde = porcentajeVerde;
    }
// get y set de variable
    public int getPorcentajeAmarillo() {
        return porcentajeAmarillo;
    }
    
// get y set de variable
    public void setPorcentajeAmarillo(int porcentajeAmarillo) {
        this.porcentajeAmarillo = porcentajeAmarillo;
    }
// get y set de variable
    public int getPorcentajeRojo() {
        return porcentajeRojo;
    }
    
// get y set de variable
    public void setPorcentajeRojo(int porcentajeRojo) {
        this.porcentajeRojo = porcentajeRojo;
    }

}
