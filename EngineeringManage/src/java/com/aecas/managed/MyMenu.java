package com.aecas.managed;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saplic02
 */

@ManagedBean
@SessionScoped
public class  MyMenu implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public static class MenuOpt implements Serializable{
        private static final long serialVersionUID = 1L;
        private String label;
        private String link;
        private MenuOpt parentOpt;
        private List<MenuOpt> childrenOpt;
        private byte[] image;
        
        public MenuOpt(){
            super();
            
        }
        
        public MenuOpt(String label, String link, byte[] image, MenuOpt parent, MenuOpt... children){
            this.label = label;
            this.link = link;
            if (image != null){
                this.image = image.clone();
            }
            if (parent != null){
                parentOpt = parent;
                parent.getChildrenOpt().add(this);
            }
            this.childrenOpt = Arrays.asList(children);
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
        
        public String getFormatedId() {
            return this.label.trim().replaceAll(" ", "");
        }

        public byte[] getImage() {
            return image;
        }

        public void setImage(byte[] image) {
            this.image = image;
        }

        public MenuOpt getParentOpt() {
            return parentOpt;
        }

        public void setParentOpt(MenuOpt parentOpt) {
            this.parentOpt = parentOpt;
            parentOpt.getChildrenOpt().add(this);
        }

        public List<MenuOpt> getChildrenOpt() {
            return childrenOpt;
        }

        public void setChildrenOpt(List<MenuOpt> childrenOpt) {
            this.childrenOpt = childrenOpt;
        }
        
        public boolean isHasChildren() {
            return !childrenOpt.isEmpty();
        }
    }
    
    private List<MenuOpt> mainMenu;
    
    @PostConstruct
    public void init(){
        mainMenu = new ArrayList();
        mainMenu.add(new MenuOpt("Worskscope Planning","", null, null));
        mainMenu.add(new MenuOpt("Engineering Manage","/pages/navigation/catalogs.xhtml",null,null,
                                new MenuOpt("ATAs","/pages/catalogs/contAtas1.xhtml",null,null),
                                new MenuOpt("Action Type","/pages/catalogs/engActionTypes.xhtml",null,null),
                                new MenuOpt("Distribution List","/pages/catalogs/engDistlistConfig.xhtml",null,null),
                                new MenuOpt("Status","/pages/catalogs/engEoStatus.xhtml",null,null),
                                new MenuOpt("Prefixes","/pages/catalogs/engPrefixes.xhtml",null,null),
                                new MenuOpt("Priorities","/pages/catalogs/engPriorities.xhtml",null,null),
                                new MenuOpt("WorkType","/pages/catalogs/engWorkTypes.xhtml",null,null),
                                new MenuOpt("Units","/pages/catalogs/matUnits.xhtml",null,null),
                                new MenuOpt("Approvals","/pages/catalogs/approvals.xhtml",null,null),
                                new MenuOpt("Email Check","/pages/catalogs/contCheckEmails.xhtml",null,null),
                                new MenuOpt("Fleet","/pages/catalogs/contFleets.xhtml",null,null),
                                new MenuOpt("Eng Activity","/pages/catalogs/engactividad.xhtml",null,null),
                                new MenuOpt("Order Notes","/pages/catalogs/EosOrderNotes.xhtml",null,null)
                                ));
        
        mainMenu.add(new MenuOpt("hangar","/pages/navigation/esr.xhtml", null, null,
            new MenuOpt("esr","/pages/esr/engSupportRequest.xhtml",null,null)
        ));
        mainMenu.add(new MenuOpt("eas","/pages/eas/easNavigation.xhtml", null, null,
            new MenuOpt("all","/pages/eas/allEAs.xhtml",null,null),
            new MenuOpt("detail","/pages/eas/detailEA.xhtml",null,null),
            new MenuOpt("doc","/pages/eas/docsEA.xhtml",null,null)
        ));
        mainMenu.add(new MenuOpt("Eng Eo","/pages/eos/eosNavigation.xhtml", null, null,
                new MenuOpt("All EO","/pages/eos/allEos.xhtml",null,null),
                new MenuOpt("Replace","/pages/eos/detailEO.xhtml",null,null),
                new MenuOpt("references","/pages/eos/effectivities.xhtml",null,null),
                new MenuOpt("Support Docs","/pages/eos/supportDocs.xhtml",null,null),
                new MenuOpt("Est Hours","/pages/eos/estimatedHours.xhtml",null,null),
                new MenuOpt("Mat Parts","/pages/eos/partMaterials.xhtml" ,null,null),
                new MenuOpt("instructions","/pages/eos/instructions.xhtml",null,null),
                new MenuOpt("distribution","/pages/eos/distribution.xhtml",null,null),
                new MenuOpt("publications","/pages/eos/publications.xhtml",null,null)
        ));
        mainMenu.add(new MenuOpt("enghours","/pages/engHours/engHours.xhtml", null, null,
            new MenuOpt("enghours","/pages/engHours/engHours.xhtml",null,null)
        ));
        mainMenu.add(new MenuOpt("sisrep","/pages/reportes/repNavigation.xhtml", null, null,
                new MenuOpt("forgen","/pages/reportes/esrGeneral.xhtml",null,null),
                new MenuOpt("rsc","/pages/reportes/reporteSeguiCheq.xhtml",null,null),
                new MenuOpt("repesrre","/pages/reportes/contAtas.xhtml",null,null),
                new MenuOpt("asman","/pages/consultas/maintenAdviceForm.xhtml",null,null),
                new MenuOpt("repeas","/pages/motoresdbusqueda/motoresDeBusqueda.xhtml",null,null),
                new MenuOpt("esr","/pages/reportes/contAtas2.xhtml",null,null),
                new MenuOpt("repeo","/pages/reportes/contAtas3.xhtml",null,null)
        ));
        mainMenu.add(new MenuOpt("HR & Manpower Planning","", null, null,
            new MenuOpt("ATAs","/pages/catalogs/contAtas2.xhtml",null,null)
        ));
        mainMenu.add(new MenuOpt("Finance & Accounting","", null, null,
            new MenuOpt("ATAs","/pages/catalogs/contAtas3.xhtml",null,null))
        ); 
        mainMenu.add(new MenuOpt("Security","",null,null,new MenuOpt("Accounts","",null,null),new MenuOpt("User","",null,null,new MenuOpt("See All","",null,null), new MenuOpt("See Assets","",null,null))));
       
    }

    public List<MenuOpt> getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(List<MenuOpt> mainMenu) {
        this.mainMenu = mainMenu;
    }
}
