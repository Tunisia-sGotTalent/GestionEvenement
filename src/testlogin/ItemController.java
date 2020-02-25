/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlogin;
import testlogin.EvenementClientController;
import com.tgt.Entite.Evenement1;
import com.tgt.Entite.EvenementP;
import com.tgt.Service.ServiceEvenement;
import com.tgt.Service.ServiceEvenementP;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static testlogin.ConnexionController.indice_evenment;

/**
 * FXML Controller class
 *
 * @author 21695
 */
public class ItemController implements Initializable {

    @FXML
    private ImageView imageview;
   
    @FXML
    private Label id_description;
    @FXML
    private Label id_nom;
    @FXML
    private HBox itemC;
    @FXML
    private Label date_D;
    @FXML
    private Label date_F;
   

    /**
     * Initializes the controller class.
     */     Evenement1 ev = new Evenement1();
      EvenementP E = new EvenementP();
      
    @FXML
    private ImageView ajoutImage;
    @FXML
    private ImageView suppImage;
    @FXML
    private ImageView imageviewQR;
    @FXML
    private Label participer;
    @FXML
    private Label cbon;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label nombre_departicipant;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
   
        ServiceEvenement service = new ServiceEvenement();
   
      try {
           
      //    ev1=service.afficher_indice1(indice_evenement);
            ev= service.afficher_indice(indice_evenment);
            System.out.println(ev.toString());
                     Class<?> clazz = this.getClass();
                     InputStream input = clazz.getResourceAsStream("/testlogin/image/"+ev.getImage_Evenement());
             //        InputStream input2 = clazz.getResourceAsStream("/testlogin/image/"+ev.getId_Evenement()+"png");
                     Image img = new Image(input);
                  
              
                   
             
                     imageview.setImage(img);
                
                     id_nom.setText(ev.getNom_Evenement());
                     id_description.setText(ev.getDescription_Evenement());
                    date_D.setText(ev.getDate_Debut_Evenement());
                       date_F.setText(ev.getDate_Fin_Evenement());
                       participer.setText("Vous pouvez participer");
                     
        } catch (SQLException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
      int i=ev.getId_Evenement();
                    System.out.println(i);
                                       Class<?> clazz = this.getClass();
                     InputStream input2 = clazz.getResourceAsStream("/testlogin/image/"+String.valueOf(ev.getId_Evenement())+".png");
                 
                     System.out.println(input2);
                        Image img2 = new Image(input2);
                            imageviewQR.setImage(img2);
       
    }
    
     public void RefreshTout(){
           ServiceEvenement service = new ServiceEvenement();
   
      try {
           
      //    ev1=service.afficher_indice1(indice_evenement);
            ev= service.afficher_indice(indice_evenment);
            System.out.println(ev.toString());
                     Class<?> clazz = this.getClass();
                     InputStream input = clazz.getResourceAsStream("/testlogin/image/"+ev.getImage_Evenement());
            //        InputStream input2 = clazz.getResourceAsStream("/testlogin/image/"+ev.getId_Evenement()+"png");
                     Image img = new Image(input);
                  
              
                   
             
                   imageview.setImage(img);
                
                     id_nom.setText(ev.getNom_Evenement());
                     id_description.setText(ev.getDescription_Evenement());
                    date_D.setText(ev.getDate_Debut_Evenement());
                       date_F.setText(ev.getDate_Fin_Evenement());
                       participer.setText("Vous pouvez participer");
                     
        } catch (SQLException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    //  int i=ev.getId_Evenement();
                 //   System.out.println(i);
                  //  Image img2 = new Image("/testlogin/image/"+i+".png");
                         //   imageviewQR.setImage(img2);
    }
    public void refresh1(){
       ServiceEvenement service = new ServiceEvenement();
         Evenement1 ev1 = new Evenement1();
   
      try {
            service.afficher_indice(indice_evenment);
            System.out.println(ev1.toString());
                     Class<?> clazz = this.getClass();
                     InputStream input2 = clazz.getResourceAsStream("/testlogin/image/"+ev1.getImage_Evenement());
                 Image img = null ;
                  imageviewQR.setImage(img);
                     imageview.setImage(img);
                     ajoutImage.setImage(img);
                     suppImage.setImage(img);
                     id_nom.setText(ev1.getNom_Evenement());
                     id_description.setText(ev1.getDescription_Evenement());
                    date_D.setText(ev1.getDate_Debut_Evenement());
                       date_F.setText(ev1.getDate_Fin_Evenement());
                       participer.setText("");
                       cbon.setText("");
                     
        } catch (SQLException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @FXML
    private void ajouterEvent(MouseEvent event) {
        int i=1;
             if (ev.getNombre_max_Evenement()==0){
             
                  Stage stage = (Stage) anchorPane.getScene().getWindow();
        Alert.AlertType type = Alert.AlertType.ERROR;
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setContentText("ce Evenement est complet nous sommes desole ");
      //  alert.getDialogPane().setHeaderText("vous voulez vraiment supprimer ? ");
        Optional<ButtonType> result = alert.showAndWait();
         if (result.get() == ButtonType.OK) {
         participer.setText("Complet desolé");}
         else if (result.get() == ButtonType.CANCEL) {
             participer.setText("Complet desolé");
              

        }
             
             }
             else{
           //     nombre_departicipant.setText(i);
           //    nombre_departicipant.Integer.parseInt(i.getText()));

            E.setIdEvenement(ev.getId_Evenement());
            E.setIdUser(20);

           cbon.setText("C bon vous etes ajouter");
           participer.setText("");

            ServiceEvenementP ser = new ServiceEvenementP();
            try {
//         
                ser.ajouter(E);

            } catch (SQLException ex) {
                System.out.println(ex);
            }
    }
    }
   
 public  void refresh2() throws IOException{
    
           
        ServiceEvenement service = new ServiceEvenement();
   
      try {
            ev= service.afficher_indice1(indice_evenment);
            System.out.println(ev.toString());
                     Class<?> clazz = this.getClass();
                     InputStream input = clazz.getResourceAsStream("/testlogin/image/");
                     Image img = new Image(input);
                     imageview.setImage(img);
                                          ajoutImage.setImage(img);
                     suppImage.setImage(img);
                     id_nom.setText(ev.getNom_Evenement());
                     id_description.setText(ev.getDescription_Evenement());
                    date_D.setText(ev.getDate_Debut_Evenement());
                       date_F.setText(ev.getDate_Fin_Evenement());
                     
        } catch (SQLException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
}
    @FXML
    private   void supprimerPar(MouseEvent event) throws IOException {
           E.setIdEvenement(ev.getId_Evenement());
              ServiceEvenement ser = new ServiceEvenement();
            try {
//         
                ser.modifierClient(ev,ev.getId_Evenement());
                
                
            refresh1();
            ev.setArchive(1);

            } catch (SQLException ex) {
                System.out.println(ex);
            }
         //    refresh1();
           
        
    }
    

    @FXML
    private void hover(MouseEvent event) {
        
      if (ev.getArchive()==1){
          
      
      }
      else{
      Image img = new Image("/testlogin/image/check.png");
                    
                     ajoutImage.setImage(img);
        
      ajoutImage.setImage(img);
        

      }
        
        
        
    }

    @FXML
    private void hover2(MouseEvent event) {
            
      if (ev.getArchive()==1){
          
      
      }
      else{
         Image img = new Image("/testlogin/image/tick.png");
                    
                     ajoutImage.setImage(img);
        
        ajoutImage.setImage(img);

      }    
    }
    
}
