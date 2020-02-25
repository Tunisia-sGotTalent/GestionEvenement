/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Entite;

import java.util.Objects;

/**
 *
 * @author 21695
 */
public class Evenement1 {
    
    
    
    private int Id_Evenement;
    private String Nom_Evenement;
    private String Date_Debut_Evenement;
    private String Date_Fin_Evenement;
    private String Lieu_Evenement;
    private int Nombre_max_Evenement;
    private String Description_Evenement;
    private String Image_Evenement;
    private int archive;
    
    
    
public Evenement1()
{}

    public Evenement1(int Id_Evenement, String Nom_Evenement, String Date_Debut_Evenement, String Date_Fin_Evenement, String Lieu_Evenement, int Nombre_max_Evenement, String Description_Evenement, String Image_Evenement) {
        this.Id_Evenement = Id_Evenement;
        this.Nom_Evenement = Nom_Evenement;
        this.Date_Debut_Evenement = Date_Debut_Evenement;
        this.Date_Fin_Evenement = Date_Fin_Evenement;
        this.Lieu_Evenement = Lieu_Evenement;
        this.Nombre_max_Evenement = Nombre_max_Evenement;
        this.Description_Evenement = Description_Evenement;
        this.Image_Evenement = Image_Evenement;
    }

    public Evenement1(String Nom_Evenement, String Date_Debut_Evenement, String Date_Fin_Evenement, String Lieu_Evenement, int Nombre_max__Evenement, String Description_Evenement, String Image_Evenement) {
        this.Nom_Evenement = Nom_Evenement;
        this.Date_Debut_Evenement = Date_Debut_Evenement;
        this.Date_Fin_Evenement = Date_Fin_Evenement;
        this.Lieu_Evenement = Lieu_Evenement;
        this.Nombre_max_Evenement = Nombre_max_Evenement;
        this.Description_Evenement = Description_Evenement;
        this.Image_Evenement = Image_Evenement;
    }

    public int getId_Evenement() {
        return Id_Evenement;
    }

    public void setId_Evenement(int Id_Evenement) {
        this.Id_Evenement = Id_Evenement;
    }

    public String getNom_Evenement() {
        return Nom_Evenement;
    }

    public void setNom_Evenement(String Nom_Evenement) {
        this.Nom_Evenement = Nom_Evenement;
    }

    public String getDate_Debut_Evenement() {
        return Date_Debut_Evenement;
    }

    public void setDate_Debut_Evenement(String Date_Debut_Evenement) {
        this.Date_Debut_Evenement = Date_Debut_Evenement;
    }

    public String getDate_Fin_Evenement() {
        return Date_Fin_Evenement;
    }

    public void setDate_Fin_Evenement(String Date_Fin_Evenement) {
        this.Date_Fin_Evenement = Date_Fin_Evenement;
    }

    public String getLieu_Evenement() {
        return Lieu_Evenement;
    }

    public void setLieu_Evenement(String Lieu_Evenement) {
        this.Lieu_Evenement = Lieu_Evenement;
    }

    public int getNombre_max_Evenement() {
        return Nombre_max_Evenement;
    }

    public void setNombre_max_Evenement(int Nombre_max_Evenement) {
        this.Nombre_max_Evenement = Nombre_max_Evenement;
    }

    public String getDescription_Evenement() {
        return Description_Evenement;
    }

    public void setDescription_Evenement(String Description_Evenement) {
        this.Description_Evenement = Description_Evenement;
    }

    public String getImage_Evenement() {
        return Image_Evenement;
    }

    public void setImage_Evenement(String Image_Evenement) {
        this.Image_Evenement = Image_Evenement;
    }

    public int getArchive() {
        return archive;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }
    

    @Override
    public String toString() {
        return "Evenement1{" + "Id_Evenement=" + Id_Evenement + ", Nom_Evenement=" + Nom_Evenement + ", Date_Debut_Evenement=" + Date_Debut_Evenement + ", Date_Fin_Evenement=" + Date_Fin_Evenement + ", Lieu_Evenement=" + Lieu_Evenement + ", Nombre_max_Evenement=" + Nombre_max_Evenement + ", Description_Evenement=" + Description_Evenement + ", Image_Evenement=" + Image_Evenement + '}';
    }
    
   

   
    
}
