/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlogin;

import com.jfoenix.controls.JFXTextField;
import com.tgt.Service.ServiceEvenement;
import com.tgt.Service.ServiceEvenementP;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import static testlogin.ConnexionController.indice_evenment;

/**
 * FXML Controller class
 *
 * @author 21695
 */
public class EvenementClientController implements Initializable {

    @FXML
    private JFXTextField tnom_6;
    @FXML
    private ScrollPane scrollpane;
    @FXML
    private HBox hbox;
    @FXML
    private ImageView refreshEvent;
           public void setTnom6(JFXTextField tnom1) {
        this.tnom_6.setText(tnom1.getText());    }

    public JFXTextField getTnom6() {
        return tnom_6;
    }

    /**
     * Initializes the controller class.
     */
          

    public HBox getTnom1() {
        return hbox;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    
        ServiceEvenement service = new ServiceEvenement();
            int taille;
        try {
            taille = service.afficherClient().size();
               Node[] nodes = new Node[taille]  ;
                    for (indice_evenment=0 ; indice_evenment<service.afficherClient().size() ; indice_evenment++)
        {
            
                try {
                    nodes[indice_evenment]=FXMLLoader.load(getClass().getResource("/testlogin/Item.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(EvenementClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                hbox.getChildren().add(nodes[indice_evenment]);
            
        }
            
            
            
            
           
       
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementClientController.class.getName()).log(Level.SEVERE, null, ex);
        }

         
            
  

        
        
    }    
    
   

    @FXML
    private void RefreshSor(MouseEvent event) {
           Image img = new Image("/testlogin/image/refresh.png");
                    
                     refreshEvent.setImage(img);
        
      refreshEvent.setImage(img);
        
    }

    @FXML
    private void refreshEn(MouseEvent event) {
           Image img = new Image("/testlogin/image/refresh2.png");
                    
                   refreshEvent.setImage(img);
        
      refreshEvent.setImage(img);
        
    }

    @FXML
    private void refreshTout(MouseEvent event) {
        ItemController apc = new ItemController();
        
            ServiceEvenement ser = new ServiceEvenement();
            try {
//         
                ser.RestartClient();
                apc.RefreshTout();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
    }
   
}
