/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlogin;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.tgt.Entite.Evenement1;
import  API.Mail;
import com.tgt.Service.ServiceEvenement;
import java.io.File;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author 21695
 */
public class GestionEvenementController implements Initializable {

    @FXML
    private JFXTextField tnombre_max;

    @FXML
    private JFXTextField tlieu;
    @FXML
    private JFXTextField tImage;
    @FXML
    private JFXDatePicker t_Date_Debut;
    @FXML
    private JFXDatePicker t_Date_Fin;
    @FXML
    private JFXTextArea tDescription;
    @FXML
    private TableColumn<Evenement1, Integer> col_id;
    @FXML
    private TableColumn<Evenement1, String> col_date_d;
    @FXML
    private TableColumn<Evenement1, String> col_date_f;
    @FXML
    private TableColumn<Evenement1, String> col_description;
    @FXML
    private TableColumn<Evenement1, String> col_image;
    @FXML
    private TableColumn<Evenement1, Integer> col_nombre_max;
    @FXML
    private TableColumn<Evenement1, String> col_lieu;
    // List<Evenement1> arr = new ArrayList<>();
    ObservableList<Evenement1> oblist = FXCollections.observableArrayList();
    private List<Evenement1> arr = new ArrayList<>();
    @FXML
    private TableView<Evenement1> table;
    @FXML
    private JFXTextField tnom5;
    @FXML
    private TableColumn<Evenement1, String> col_nom5;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView update;
    @FXML
    private ImageView Browse;
String path;
MediaPlayer mediaplayer;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {

        Evenement1 E = new Evenement1();

        ServiceEvenement ser = new ServiceEvenement();
        col_id.setCellValueFactory(new PropertyValueFactory<>("Id_Evenement"));
        col_nom5.setCellValueFactory(new PropertyValueFactory<>("Nom_Evenement"));
        col_date_d.setCellValueFactory(new PropertyValueFactory<>("Date_Debut_Evenement"));
        col_date_f.setCellValueFactory(new PropertyValueFactory<>("Date_Fin_Evenement"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("Description_Evenement"));
        col_image.setCellValueFactory(new PropertyValueFactory<>("Image_Evenement"));
        col_nombre_max.setCellValueFactory(new PropertyValueFactory<>("Nombre_max_Evenement"));
        col_lieu.setCellValueFactory(new PropertyValueFactory<>("Lieu_Evenement"));

        //col_nombreMax.setCellValueFactory(new PropertyValueFactory<>("nombre_max"));
        try {

            // col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            arr = ser.afficher(E);

            table.setItems((ObservableList<Evenement1>) arr);

            // defaultTableModel model
        } catch (SQLException ex) {

        }
 
        String[] centers = {"Ariana centre","Béja center","Ben Arous center","Bizerte center","Gabès center","Gafsa center","Jendouba center","Kairouan center","Kasserine center","Kebili center","Kef center"," Mahdia center","Manouba center","Medenine center","Monastir center","Nabeul center","Sfax center","SidiBouzid center","Siliana center","Sousse center","Tataouine center","Sousse center","Tozeur center","Tunis center"};
        TextFields.bindAutoCompletion(tlieu, centers);
        
        
    }

    public void refresh() {
        Evenement1 E = new Evenement1();

        ServiceEvenement ser = new ServiceEvenement();
        col_id.setCellValueFactory(new PropertyValueFactory<>("Id_Evenement"));
        col_nom5.setCellValueFactory(new PropertyValueFactory<>("Nom_Evenement"));
        col_date_d.setCellValueFactory(new PropertyValueFactory<>("Date_Debut_Evenement"));
        col_date_f.setCellValueFactory(new PropertyValueFactory<>("Date_Fin_Evenement"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("Description_Evenement"));
        col_image.setCellValueFactory(new PropertyValueFactory<>("Image_Evenement"));
        col_nombre_max.setCellValueFactory(new PropertyValueFactory<>("Nombre_max_Evenement"));
        col_lieu.setCellValueFactory(new PropertyValueFactory<>("Lieu_Evenement"));

        //col_nombreMax.setCellValueFactory(new PropertyValueFactory<>("nombre_max"));
        try {

            // col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            arr = ser.afficher(E);

            table.setItems((ObservableList<Evenement1>) arr);

            // defaultTableModel model
        } catch (SQLException ex) {

        }

    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException, SQLException, Exception {
    
        Evenement1 E = new Evenement1();

        E.setNom_Evenement(tnom5.getText());
        E.setNombre_max_Evenement(Integer.parseInt(tnombre_max.getText()));

        E.setDate_Debut_Evenement(t_Date_Debut.getEditor().getText());
        E.setDate_Fin_Evenement(t_Date_Fin.getEditor().getText());
         E.setLieu_Evenement(tlieu.getText());

        E.setImage_Evenement(tImage.getText());
        E.setDescription_Evenement(tDescription.getText());

        E.setLieu_Evenement(tlieu.getText());

        ServiceEvenement ser = new ServiceEvenement();
        try {
//         
            ser.ajouter(E);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        try {
                String host = "smtp.gmail.com";
                String user = "moncef.mansour@esprit.tn";
                String pass = "Renzolovecs1.6!";
                //System.out.println(userInit.getEmail());
                String to = "moncef.mansour@esprit.tn";
                String from = "tunisiangottalentesprit@gmail.com";
                String subject = "Un nouveau Evement Disponible";
                String messageText = "Welcome  " + "Mr."+E.getNom_Evenement() ;
                boolean sessionDebug = false;

                Properties props = System.getProperties();

                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.required", "true");

                java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                Session mailSession = Session.getDefaultInstance(props, null);
                mailSession.setDebug(sessionDebug);
                Message msg = new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(to)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(subject);
                msg.setSentDate(new Date());
                msg.setText(messageText);

                Transport transport = mailSession.getTransport("smtp");
                transport.connect(host, user, pass);
                transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();
                System.out.println("message send successfully");
            } catch (Exception ex) {
                System.out.println(ex);

            }


        refresh();
       
           Notifications NotificationBuilder = Notifications.create()
                   .title("Downloads complet")
                   .text("Saved to  home/downolad")
                     .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hellooooooooo");
            }
                    
    
    
    });
           Media musicFile = new Media("file:///C://Users//21695//Documents//NetBeansProjects//TestLogin//src//testlogin//image/son.mp3");

         mediaplayer = new MediaPlayer(musicFile);
        mediaplayer.setAutoPlay(true);
        mediaplayer.setVolume(0.1);
           
           NotificationBuilder.darkStyle();
        NotificationBuilder.showConfirm();
        Mail.sendMail("moncef.mansour@esprit.tn");
        String H="siTIH4gMO00-PK5ULgP1yZBdQ1j11NJNEfXH8xnE78";
        String M="21625810661";
        String A="fffffffffff";
        String C="sSSSS";
        
        
       
    }

    @FXML
    private void supprimer(MouseEvent event) {

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        Alert.AlertType type = Alert.AlertType.CONFIRMATION;
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setContentText("vous voulez bien le supprimer ?");
        alert.getDialogPane().setHeaderText("hhhhhh");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {

            ObservableList<Evenement1> oblist;
            oblist = table.getSelectionModel().getSelectedItems();
            int max = oblist.get(0).getId_Evenement();
            System.out.println(oblist.get(0).getId_Evenement());
            Evenement1 E = new Evenement1();
            //table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
//        E.setNombre_max_Evenement(Integer.parseInt(tnombre_max.getText()));
            ServiceEvenement ser = new ServiceEvenement();
            // TGT ser = new TGT();
            //  E.Integer.parseInt(t_nombreMax.getText());
//

            // TGT ser = new TGT();
            //  E.Integer.parseInt(t_nombreMax.getText());
            try {
//         
                ser.supprimer(max);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            refresh();
        } else if (result.get() == ButtonType.CANCEL) {

        }

    }

    @FXML
    private void SelectItemes(MouseEvent event) {
        ObservableList<Evenement1> oblist;
        oblist = table.getSelectionModel().getSelectedItems();
        if (oblist != null) {
            tnom5.setText(oblist.get(0).getNom_Evenement());
            //E.Integer.parseInt(t_nombreMax.getText());
            int max = oblist.get(0).getNombre_max_Evenement();

            //int max;
            max = oblist.get(0).getId_Evenement();

             tnombre_max.setText(""+oblist.get(0).getNombre_max_Evenement());
            t_Date_Debut.getEditor().setText(oblist.get(0).getDate_Debut_Evenement());
            t_Date_Fin.getEditor().setText(oblist.get(0).getDate_Fin_Evenement());
            tlieu.setText(oblist.get(0).getLieu_Evenement());
            tImage.setText(oblist.get(0).getImage_Evenement());
            tDescription.setText(oblist.get(0).getDescription_Evenement());

        }

    }

    @FXML
    private void update(MouseEvent event) {
        Evenement1 E = new Evenement1();
        E.setNom_Evenement(tnom5.getText());
        E.setNombre_max_Evenement(Integer.parseInt(tnombre_max.getText()));

        E.setDate_Debut_Evenement(t_Date_Debut.getEditor().getText());
        E.setDate_Fin_Evenement(t_Date_Fin.getEditor().getText());

        E.setImage_Evenement(tImage.getText());
        E.setDescription_Evenement(tDescription.getText());

        E.setLieu_Evenement(tlieu.getText());

        ObservableList<Evenement1> oblist;
        oblist = table.getSelectionModel().getSelectedItems();
        int max = oblist.get(0).getId_Evenement();
        System.out.println(oblist.get(0).getId_Evenement());

        //table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
//     E.setNombre_max_Evenement(Integer.parseInt(tnombre_max.getText()));
        ServiceEvenement ser = new ServiceEvenement();
        try {
//         
            ser.modifier(E, max);
            refresh();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        // defaultTableModel model
    }
    private String filen() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String filename = null;
            filename = f.getAbsolutePath();
             path = filename;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Veuillez mettre une image");
        }
       
        return path;
    }

    @FXML
    private void Browse(MouseEvent event) {
          String path1 = filen();
        if (path1 == null) {

        } else {
            tImage.setText(path1);
        }
        
        
        
    }

   
      /*   try {
            
			// Construct data
			String apiKey = "apikey=" + "siTIH4gMO00-NlfqWsChDuZ9qDVSozJa5FL59BeCb1";
			String message = "&message=" + "Gello";
			String sender = "&sender=" + "Me";
			String numbers = "&numbers=" + "21625810661";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
                            System.out.println(":'( :'( :'(:xxxxxxx");
				stringBuffer.append(line);
			}
			rd.close();
                        JOptionPane.showMessageDialog(null, "message"+line);
			
			//return stringBuffer.toString();
		} catch (Exception e) {
                    System.out.println(":'( :'( :'(: gggggg");
			 JOptionPane.showMessageDialog(null,e);
			
			//return "Error "+e;
		}

    }
*/

    @FXML
    private void imprimer(MouseEvent event) {
          System.out.println(" can I print?");
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob.printPage(table)) {
            printerJob.endJob();
            System.out.println("printed");
        }
    }
 public void setTnom2(JFXTextField tnom1) {
        this.tnom5.setText(tnom1.getText());    }

    public JFXTextField getTnom2() {
        return tnom5;
    }
    @FXML
    private void web(MouseEvent event) {
        
         try {
            //   try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("inscription.fxml"));
            
            
            Parent root = (Parent) fxmlLoader.load();
            InscriptionController apc=fxmlLoader.getController();
           apc.setTnom2((JFXTextField)tnom5);
           
           tnom5.getScene().setRoot(root);
           // stage.setTitle("hello");
            //       stage.setScene(new Scene(root));
          //  stage.show();
              } catch (IOException e) {
            System.out.println("can't load new window");
        }
    }
}
