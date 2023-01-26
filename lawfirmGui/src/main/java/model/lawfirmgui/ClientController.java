package model.lawfirmgui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    
    //Client
    @FXML
    public TableView tvClient;
    @FXML
    public TableColumn tcidcase, tcIdclient, tcName, tcClientcontact, tcPayment;
    @FXML
    private TextField idClient, NameFld, Clientcontact, paymentFld, idcaseFld2;
    @FXML
    private Button btnDeleteClient;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Client tableview
        tvClient.getColumns().addAll(tcidcase, tcidcase, tcName, tcClientcontact, tcPayment);

        final ObservableList<Client> data = FXCollections.observableArrayList(
                new Client("CTS8", "C22", "Ahmad Khuzaimi", "01453644", "300"),
                new Client("CI10", "C12", "Aina Bainun", "01423414", "800")
        );

        tcidcase.setCellValueFactory(new PropertyValueFactory<>("idcase"));
        tcIdclient.setCellValueFactory(new PropertyValueFactory<>("ClientID"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("ClientName"));
        tcClientcontact.setCellValueFactory(new PropertyValueFactory<>("ClientContact"));
        tcPayment.setCellValueFactory(new PropertyValueFactory<>("ClientPayment"));

        tvClient.setItems(data);

    }


    public void deleteClick(ActionEvent event) {
        if(event.getSource() == btnDeleteClient) {
            tvClient.getItems().remove(tvClient.getSelectionModel().getSelectedItem());
        }
    }

    public void saveClient(ActionEvent event) {
        Client newClient = new Client(idcaseFld2.getText(), idClient.getText(), NameFld.getText(), Clientcontact.getText(), paymentFld.getText());
        tvClient.getItems().add(newClient);
    }

}
