/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Service;

import com.tgt.Entite.Evenement1;
import com.tgt.IService.IServiceEvenement;
import com.tgt.Utils.DataBase;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
//import com.esprit.Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author 21695
 */
public class ServiceEvenement implements IServiceEvenement<Evenement1> {

    private final Connection con;
    private Statement ste;
     //private ResultSet rs;

    public ServiceEvenement() {
        con = DataBase.getInstance().getConnection();

    }
    

    @Override
    public void ajouter(Evenement1 t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tgt`.`evenement` (`Id_Evenement`, `Nom_Evenement`, `Date_Debut_Evenement`, `Date_Fin_Evenement`, `Lieu_Evenement`,`Nombre_max_Evenement`,`Description_Evenement`,`Image_Evenement`) VALUES (NULL, '" + t.getNom_Evenement() + "','" + t.getDate_Debut_Evenement() + "','" + t.getDate_Fin_Evenement() + "','" + t.getLieu_Evenement() + "','" + t.getNombre_max_Evenement() +"','" + t.getDescription_Evenement() + "','" + t.getImage_Evenement() + "');";
        System.out.println(requeteInsert);
        ste.executeUpdate(requeteInsert);
    }

    public void ajouter1(Evenement1 p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `tgt`.`evenement` (`Id_Evenement`, `Nom_Evenement`, `Date_Debut_Evenement`, `Date_Fin_Evenement`, `Lieu_Evenement`,`Nombre_max_Evenement`,`Description_Evenement`,`Image_Evenement`) VALUES( ?, ?, ?,?,?,?);");
        pre.setString(1, p.getNom_Evenement());
        pre.setString(2, p.getDate_Debut_Evenement());
        pre.setString(3, p.getDate_Fin_Evenement());
        pre.setString(4, p.getLieu_Evenement());
        pre.setInt(5, p.getNombre_max_Evenement());

        pre.executeUpdate();
    }
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    /**
     *
     * @param id_Evenement
     * @param nombre_max
     * @param nom
     * @param id
     * @throws java.sql.SQLException
     */
    public void supprimer(int id_Evenement) throws SQLException {
     
       
   ste = con.createStatement();
            String q = "delete from evenement where Id_Evenement= "+id_Evenement;
            PreparedStatement pre = con.prepareStatement(q);
          //  pre.setString(1, E.getNom());
            ste.executeUpdate(q);
            System.out.println("tu as bien supprimé");

      
        

    }
       public  ObservableList<Evenement1> afficher( ) throws SQLException {
           
       ObservableList<Evenement1> arr =FXCollections.observableArrayList();
   ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from evenement");
        while (rs.next()) {
    arr.add(new Evenement1(rs.getInt("Id_Evenement") ,rs.getString("Nom_Evenement"),rs.getString("Date_Debut_Evenement"),rs.getString("Date_Fin_Evenement"),rs.getString("Lieu_Evenement"),rs.getInt("Nombre_max_Evenement"),rs.getString("Description_Evenement"),rs.getString("Image_Evenement")));
           
          
        
        

        }
        return arr;

    }
      public  ObservableList<Evenement1> afficherClient( ) throws SQLException {
           
       ObservableList<Evenement1> arr =FXCollections.observableArrayList();
   ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from evenement where archive="+0);
        while (rs.next()) {
    arr.add(new Evenement1(rs.getInt("Id_Evenement") ,rs.getString("Nom_Evenement"),rs.getString("Date_Debut_Evenement"),rs.getString("Date_Fin_Evenement"),rs.getString("Lieu_Evenement"),rs.getInt("Nombre_max_Evenement"),rs.getString("Description_Evenement"),rs.getString("Image_Evenement")));
           
          
        
        

        }
        return arr;

    }
        
         public void modifier(Evenement1 E,int id) throws SQLException
    {
                                                                                                                                      
        try {  
            System.out.println("hahhahahaha");
            if((E.getNom_Evenement()!="")&&(E.getDate_Debut_Evenement()!="")&& (E.getDate_Fin_Evenement()!="")&& (E.getLieu_Evenement()!="")&&(E.getNombre_max_Evenement()!=0)&&(E.getDescription_Evenement()!="")&&(E.getImage_Evenement()!=""))
                            {  String query="update evenement set Nom_Evenement='"+E.getNom_Evenement()+"',Date_Debut_Evenement='"+E.getDate_Debut_Evenement()+"',Date_Fin_Evenement='"+E.getDate_Fin_Evenement()+"',Lieu_Evenement='"+E.getLieu_Evenement()+"',Nombre_max_Evenement='"+E.getNombre_max_Evenement()+"',Description_Evenement='"+E.getDescription_Evenement()+"',Image_Evenement='"+E.getImage_Evenement()+"' where evenement.Id_Evenement="+id;

        ste=con.createStatement();
           ste.executeUpdate(query);
           System.out.println("hohoohoho");
           
            System.out.println("bien modifiée");
             
            }
            else System.out.println("tu dois inserer tous les elements");
        } catch (SQLException ex) {
           
        }
        
        
    }
                  public void modifierClient(Evenement1 E,int id) throws SQLException
    {
                                                                                                                                      
        try {  
            System.out.println("hahhahahaha");
            if((E.getNom_Evenement()!="")&&(E.getDate_Debut_Evenement()!="")&& (E.getDate_Fin_Evenement()!="")&& (E.getLieu_Evenement()!="")&&(E.getNombre_max_Evenement()!=-1)&&(E.getDescription_Evenement()!="")&&(E.getImage_Evenement()!=""))
                            {  String query="update evenement set archive=1 where evenement.Id_Evenement="+id;
                            

        ste=con.createStatement();
           ste.executeUpdate(query);
           System.out.println(id);
           
           
            System.out.println("bien modifiée");
             
            }
            else System.out.println("tu dois inserer tous les elements");
        } catch (SQLException ex) {
           
        }
        
        
    }
      public void RestartClient() throws SQLException
    {
                                                                                                                                      
        try {  
            System.out.println("hahhahahaha");
            String query="update evenement set archive=0 where evenement.archive=1";
                            

        ste=con.createStatement();
           ste.executeUpdate(query);
     //      System.out.println(id);
           
           
            System.out.println("bien modifiée");
             
            
           
        } catch (SQLException ex) {
           
        }
        
        
    }


        /*
             public void rechercher(Evenement1 E,String chercher) 
    {try {
        String rechercher1 = "'"+E.getNom()+"'";
           String req="select * from evenement where nom LIKE"+chercher+"%";
        
            ste=con.createStatement();
            ste.executeQuery(req);
       
    
  
        } catch (SQLException ex) {
           
        }
}
*/

    @Override
    public boolean delete(Evenement1 t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Evenement1 t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Evenement1> readAll() throws SQLException {
        return null;
       
    }

    @Override
    public void supprimer(String nom) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    
          public  Evenement1 afficher_indice( int i) throws SQLException {
           
  Evenement1    arr =new Evenement1();
   ste = con.createStatement();
   int nombre=0;
        ResultSet rs = ste.executeQuery("select * from evenement where archive="+0);
        while (rs.next()) {
            if (i==nombre)
            {
                 arr = new Evenement1(rs.getInt("Id_Evenement") ,rs.getString("Nom_Evenement"),rs.getString("Date_Debut_Evenement"),rs.getString("Date_Fin_Evenement"),rs.getString("Lieu_Evenement"),rs.getInt("Nombre_max_Evenement"),rs.getString("Description_Evenement"),rs.getString("Image_Evenement"));
      
            }
        
          
        
        nombre++;

        }
        return arr;

    }
    
    
    
        
          public  Evenement1 afficher_indice1( int i) throws SQLException {
           
  Evenement1    arr =new Evenement1();
   ste = con.createStatement();
   int nombre=0;
        ResultSet rs = ste.executeQuery("select * from evenement where archive="+0);
        while (rs.next()) {
            if (i==nombre)
            {
                 arr = new Evenement1(rs.getInt("Id_Evenement") ,rs.getString("Nom_Evenement"),rs.getString("Date_Debut_Evenement"),rs.getString("Date_Fin_Evenement"),rs.getString("Lieu_Evenement"),rs.getInt("Nombre_max_Evenement"),rs.getString("Description_Evenement"),rs.getString("Image_Evenement"));
      
            }
        
          
        
        nombre--;

        }
        return arr;

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
}
