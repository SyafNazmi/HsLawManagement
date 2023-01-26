package model.lawfirmgui;

import javafx.beans.property.SimpleStringProperty;

public class Client {

    private SimpleStringProperty Idcase;
    private SimpleStringProperty clientID;
    private SimpleStringProperty clientName;
    private SimpleStringProperty clientContact;
    private SimpleStringProperty clientPayment;


    public Client(String IDcase, String clientID, String clientName, String clientContact, String clientPayment) {
        this.Idcase = new SimpleStringProperty(IDcase);
        this.clientID = new SimpleStringProperty(clientID);
        this.clientName = new SimpleStringProperty(clientName);
        this.clientContact = new SimpleStringProperty(clientContact);
        this.clientPayment = new SimpleStringProperty(clientPayment);
    }

    public String getIdcase(){
        return  Idcase.get();
    }
    public  void setIdcase(String IDcase){
        this.Idcase.set(IDcase);
    }

    public String getClientID() {
        return clientID.get();
    }


    public void setClientID(String clientID) {
        this.clientID.set(clientID);
    }

    public String getClientName() {
        return clientName.get();
    }


    public void setClientName(String clientName) {
        this.clientName.set(clientName);
    }

    public String getClientContact() {
        return clientContact.get();
    }


    public void setClientContact(String clientContact) {
        this.clientContact.set(clientContact);
    }

    public String getClientPayment() {
        return clientPayment.get();
    }


    public void setClientPayment(String clientPayment) {
        this.clientPayment.set(clientPayment);
    }

}

