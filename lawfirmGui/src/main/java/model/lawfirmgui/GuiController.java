package model.lawfirmgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class GuiController implements Initializable {

    @FXML
    Tab clienttab;

    @FXML
    public TableView<Lawyer> tvLawyer;
    @FXML
    public TableColumn<Lawyer, String> tcld;
    @FXML
    public TableColumn<Lawyer, String> tcFName;
    @FXML
    public TableColumn<Lawyer, String> tcLName;
    @FXML
    public TableColumn<Lawyer, String> tcContact;
    @FXML
    public TableColumn<Lawyer, String> tcPosition;
    @FXML
    public TableColumn<Lawyer, String> tcSalary;
    @FXML
    public TableColumn<Lawyer, String> tcId_case;

    @FXML
    private TextField idFld;
    @FXML
    private TextField fnameFld;
    @FXML
    private TextField lnameFld;
    @FXML
    private TextField contactFld;
    @FXML
    private TextField positionFld;
    @FXML
    private TextField salaryFld;
    @FXML
    private TextField idcaseFld;

    @FXML
    private Label CheckInTimeDisplay, CheckOutTimeDisplay;


    @FXML
    private Button btnDeletelaw, btnUpdate;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Lawyer tableview
        tcld.setCellValueFactory(new PropertyValueFactory<>("LawyerID"));
        tcFName.setCellValueFactory(new PropertyValueFactory<>("LawyerFirstName"));
        tcLName.setCellValueFactory(new PropertyValueFactory<>("LawyerLastName"));
        tcContact.setCellValueFactory(new PropertyValueFactory<>("LawyerContact"));
        tcPosition.setCellValueFactory(new PropertyValueFactory<>("LawyerPosition"));
        tcSalary.setCellValueFactory(new PropertyValueFactory<>("LawyerSalary"));
        tcId_case.setCellValueFactory(new PropertyValueFactory<>("LawyerCase"));

        tvLawyer.setItems(observableList);


        FXMLLoader loader = new FXMLLoader();
        try{
            AnchorPane secondscene = loader.load(getClass().getResource("client.fxml"));
            clienttab.setContent(secondscene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    ObservableList<Lawyer> observableList = FXCollections.observableArrayList(
            new Lawyer("AB1", "Huda", "Nabilah", "05345223", "High Council", "4500", "C1D3"),
            new Lawyer("AB2", "Syafie", "Nazmi", "04345123", "Mid Council", "3500", "C1S3"),
            new Lawyer("AB3", "Sofea", "Taufik", "06345478", "Intern Council", "1500", "CTS8")
    );

    //Add New controller
    public void handleButtonClick(ActionEvent event) {
        Lawyer addLawyer = new Lawyer(idFld.getText(), fnameFld.getText(), lnameFld.getText(), contactFld.getText(),
                positionFld.getText(), salaryFld.getText(), idcaseFld.getText());
        tvLawyer.getItems().add(addLawyer);
    }


    //Remove controller
    public void handleButtonClick2(ActionEvent event) {
        if(event.getSource() == btnDeletelaw) {
            tvLawyer.getItems().remove(tvLawyer.getSelectionModel().getSelectedItem());
        }
    }

    //Update controller
    public void handleButtonClick3(ActionEvent event) {
        if(event.getSource() == btnUpdate){
            tvLawyer.setEditable(true);
            tcld.setCellFactory(TextFieldTableCell.forTableColumn());
            tcFName.setCellFactory(TextFieldTableCell.forTableColumn());
            tcLName.setCellFactory(TextFieldTableCell.forTableColumn());
            tcContact.setCellFactory(TextFieldTableCell.forTableColumn());
            tcPosition.setCellFactory(TextFieldTableCell.forTableColumn());
            tcSalary.setCellFactory(TextFieldTableCell.forTableColumn());
            tcId_case.setCellFactory(TextFieldTableCell.forTableColumn());
        }
    }

    public void CheckInOnAction (ActionEvent e){

        String formatCheckIn;

        LocalDateTime CheckIn = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formatCheckIn = CheckIn.format(format);

        CheckInTimeDisplay.setText("Time: "+formatCheckIn);
    }

    public void CheckOutOnAction (ActionEvent e){

        String formatCheckOut;

        LocalDateTime CheckOut = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formatCheckOut = CheckOut.format(format);

        CheckOutTimeDisplay.setText("Time: "+formatCheckOut);
    }


}