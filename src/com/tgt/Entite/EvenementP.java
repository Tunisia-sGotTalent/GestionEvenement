/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Entite;

/**
 *
 * @author 21695
 */
public class EvenementP {
    
    
    
   private int id;
    private int idUser;
     private int idEvenement;

    public EvenementP(int id, int idUser, int idEvenement) {
        this.id = id;
        this.idUser = idUser;
        this.idEvenement = idEvenement;
    }

    public EvenementP(int idUser, int idEvenement) {
        this.idUser = idUser;
        this.idEvenement = idEvenement;
    }

    public EvenementP() {
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }
      @Override
    public String toString() {
        return "EvenementP{" + "id=" + id + ", idUser=" + idUser + ", idEvenement=" + idEvenement + '}';
    }
   
    
}
