/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlogin;
//import API.statistiquee;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.tgt.Entite.Evenement1;
import API.Mail;
import API.QRcode;
import com.tgt.Service.ServiceEvenement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TransferMode;
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
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

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
    private JFXTextField tDescription;
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
    public ObservableList<Evenement1> oblist = FXCollections.observableArrayList();
    // ObservableList<Evenement1> arr = new ArrayList<>();
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

    @FXML
    private JFXTextField recherche1;
    @FXML
    private ImageView imageView;
    @FXML
    private Button statistique;

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        applyValidators();
tDescription.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation(10));
           tlieu.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation(10));
           tnom5.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation(10));
           tnombre_max.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
           
//recherche();
        col_id.setCellValueFactory(new PropertyValueFactory<>("Id_Evenement"));
        col_nom5.setCellValueFactory(new PropertyValueFactory<>("Nom_Evenement"));
        col_date_d.setCellValueFactory(new PropertyValueFactory<>("Date_Debut_Evenement"));
        col_date_f.setCellValueFactory(new PropertyValueFactory<>("Date_Fin_Evenement"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("Description_Evenement"));
        col_image.setCellValueFactory(new PropertyValueFactory<>("Image_Evenement"));
        col_nombre_max.setCellValueFactory(new PropertyValueFactory<>("Nombre_max_Evenement"));
        col_lieu.setCellValueFactory(new PropertyValueFactory<>("Lieu_Evenement"));
        //recherche();

        //col_nombreMax.setCellValueFactory(new PropertyValueFactory<>("nombre_max"));
        try {
            ServiceEvenement ser = new ServiceEvenement();
            Evenement1 E = new Evenement1();
            // col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            oblist = ser.afficher();

            // defaultTableModel model
        } catch (SQLException ex) {

        }
        
        
        
        table.setItems((ObservableList<Evenement1>) oblist);
        String[] centers = {"Ariana centre", "Béja center", "Ben Arous center", "Bizerte center", "Gabès center", "Gafsa center", "Jendouba center", "Kairouan center", "Kasserine center", "Kebili center", "Kef center", " Mahdia center", "Manouba center", "Medenine center", "Monastir center", "Nabeul center", "Sfax center", "SidiBouzid center", "Siliana center", "Sousse center", "Tataouine center", "Sousse center", "Tozeur center", "Tunis center"};
        TextFields.bindAutoCompletion(tlieu, centers);
        // ObservableList<Evenement1> oblist1= FXCollections.observableArrayList();
        FilteredList<Evenement1> filteredData = new FilteredList<>(oblist, b -> true);
        recherche1.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(E -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (E.getNom_Evenement().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }// Filter matches first name.
                else {
                    return false;
                }
            });
        });
        SortedList<Evenement1> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);

    }
    
    
    public EventHandler<KeyEvent> numeric_Validation(final Integer max_Lengh) {
    return new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
            TextField txt_TextField = (TextField) e.getSource();                
            if (txt_TextField.getText().length() >= max_Lengh) {                    
                e.consume();
            }
            if(e.getCharacter().matches("[0-9.]")){ 
                if(txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]")){
                    e.consume();
                }else if(txt_TextField.getText().length() == 0 && e.getCharacter().matches("[.]")){
                    e.consume(); 
                }
            }else{
                e.consume();
            }
        }
    };
}     
   public EventHandler<KeyEvent> letter_Validation(final Integer max_Lengh) {
    return new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
            TextField txt_TextField = (TextField) e.getSource();                
            if (txt_TextField.getText().length() >= max_Lengh) {                    
                e.consume();
            }
            if(e.getCharacter().matches("[A-Za-z0-9]")){ 
            }else{
                e.consume();
            }
        }
    };
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
            oblist = ser.afficher();

            table.setItems((ObservableList<Evenement1>) oblist);

            // defaultTableModel model
        } catch (SQLException ex) {

        }

    }

    private void applyValidators() {
        ValidationSupport vs = new ValidationSupport();
        vs.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
        vs.registerValidator(tnom5, Validator.createEmptyValidator("Cannot Be Empty!", Severity.ERROR));
        ValidationSupport vtel1 = new ValidationSupport();

        vtel1.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
        vtel1.registerValidator(tnombre_max, Validator.createEmptyValidator("Il faut un nombre ", Severity.ERROR));

        ValidationSupport vdateD = new ValidationSupport();
        vdateD.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
        vdateD.registerValidator(t_Date_Debut, Validator.createEmptyValidator("Il faut un nombre " , Severity.ERROR));

        ValidationSupport vdateF = new ValidationSupport();
        vdateF.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
        vdateF.registerValidator(t_Date_Fin, Validator.createEmptyValidator("Il faut un nombre ", Severity.ERROR));
       
        
        ValidationSupport vlieu = new ValidationSupport();
        vlieu.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
        vlieu.registerValidator(tlieu, Validator.createEmptyValidator("Il faut un nom ", Severity.ERROR));
        
         ValidationSupport vs1 = new ValidationSupport();
        vs1.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
        vs1.registerValidator(tDescription, Validator.createEmptyValidator("Cannot Be Empty!", Severity.ERROR));
         ValidationSupport vs3 = new ValidationSupport();
       // vs3.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
       // vs3.registerValidator(tImage, Validator.createEmptyValidator("Cannot Be Empty!", Severity.ERROR));

    }

    private boolean checkValidInputs() {
        if (tnom5.getText().isEmpty() || t_Date_Debut.getEditor().getText().isEmpty() || !tnombre_max.getText().isEmpty()
                || t_Date_Fin.getEditor().getText().isEmpty() || !tlieu.getText().isEmpty()
                || tnom5.getText().isEmpty() || tDescription.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @FXML
    public void recherche() {
        FilteredList<Evenement1> filteredData = new FilteredList<>(oblist, b -> true);
        recherche1.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Ev -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Ev.getNom_Evenement().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }// Filter matches first name.
                else {
                    return false;
                }
            });
        });
        SortedList<Evenement1> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException, SQLException, Exception {
      //  if (checkValidInputs() == true) {

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
                 QRcode.main();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
            try {
                String host = "smtp.gmail.com";
                String user = "TunisianGottalentPidev@gmail.com";
                String pass = "Pidev123";

                String to = "moncefmansour3@gmail.com";
                String from = "tunisiangottalentesprit@gmail.com";
                String subject = "Un nouveau Evement Disponible";
                String messageText = "Welcome  " + "Mr." + E.getNom_Evenement();
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
                // transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();
                System.out.println("message send successfully");
            } catch (Exception ex) {
                System.out.println(ex);

            }

            refresh();

            Notifications NotificationBuilder = Notifications.create()
                    .title("Downloads complet")
                    .text("Evenement ajouté ")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT)
                    .onAction(new EventHandler<ActionEvent>() {
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
            String H = "siTIH4gMO00-PK5ULgP1yZBdQ1j11NJNEfXH8xnE78";
            String M = "21625810661";
            String A = "fffffffffff";
            String C = "sSSSS";
        
     

    }

    @FXML
    private void supprimer(MouseEvent event) {

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        Alert.AlertType type = Alert.AlertType.CONFIRMATION;
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setContentText("ce Evenement");
        alert.getDialogPane().setHeaderText("vous voulez vraiment supprimer ? ");
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

            tnombre_max.setText("" + oblist.get(0).getNombre_max_Evenement());
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

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        refresh();

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
        this.tnom5.setText(tnom1.getText());
    }

    public JFXTextField getTnom2() {
        return tnom5;
    }

    @FXML
    private void web(MouseEvent event) {

        try {
            //   try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("inscription.fxml"));

            Parent root = (Parent) fxmlLoader.load();
            InscriptionController apc = fxmlLoader.getController();
            apc.setTnom2((JFXTextField) tnom5);

            tnom5.getScene().setRoot(root);
            // stage.setTitle("hello");
            //       stage.setScene(new Scene(root));
            //  stage.show();
        } catch (IOException e) {
            System.out.println("can't load new window");
        }
    }

    @FXML
    private void handleDragOver(DragEvent event) {
        if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void handleDrop(DragEvent event) throws FileNotFoundException {
        List<File>files=event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        imageView.setImage(img);
   String path =files.get(0).getName();
        System.out.println(path);
   tImage.setText(path);
    }

    @FXML
    private void client(MouseEvent event) {
          try {
            //   try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EvenementClient.fxml"));
            
            
            Parent root = (Parent) fxmlLoader.load();
           EvenementClientController apc=fxmlLoader.getController();
           apc.setTnom6((JFXTextField) tnom5);
           tnom5.getScene().setRoot(root);
           // stage.setTitle("hello");
            //       stage.setScene(new Scene(root));
          //  stage.show();
              } catch (IOException e) {
            System.out.println("can't load new window");
        }
        
    }

    @FXML
    private void statistique(MouseEvent event) {
         Evenement1 E = new Evenement1();
         
         // statistiquee.main(E.getId_Evenement(), E.getNombre_max_Evenement());
        
        
        
    }
    /*
    public void recherche()
    {
    String req="select * from competition where namecomp  LIKE '"+namecomp+"%'" ;

    
    }
        */
        
        
    }
    
    
    
    
    

