/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Service;

import com.tgt.Entite.EvenementP;
import com.tgt.Utils.DataBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 21695
 */
public class ServiceEvenementP {
     private final Connection con;
    private Statement ste;
     //private ResultSet rs;

    public ServiceEvenementP() {
        con = DataBase.getInstance().getConnection();

    }
    
    
    
     public void ajouter(EvenementP t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tgt`.`evenetuser` (`id`, `idUser`, `idEvenement`) VALUES (NULL, '"+ t.getIdUser() + "','" + t.getIdEvenement() +"');";
        System.out.println(requeteInsert);
        ste.executeUpdate(requeteInsert);
    }
     
     
 
    
}
