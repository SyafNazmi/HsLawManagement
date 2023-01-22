package model.lawfirmgui;

import javafx.beans.property.SimpleStringProperty;

public class Client {

    private SimpleStringProperty clientcase;
    private SimpleStringProperty clientID;
    private SimpleStringProperty clientName;
    private SimpleStringProperty clientContact;
    private SimpleStringProperty clientPayment;
    private SimpleStringProperty clientDob;

    public Client(String clientcase, String clientID, String clientName, String clientContact, String clientPayment, String dob) {
        this.clientcase = new SimpleStringProperty(clientcase);
        this.clientID = new SimpleStringProperty(clientID);
        this.clientName = new SimpleStringProperty(clientName);
        this.clientContact = new SimpleStringProperty(clientContact);
        this.clientPayment = new SimpleStringProperty(clientPayment);
        this.clientDob = new SimpleStringProperty(dob);
    }

    public String getClientcase() {
        return clientcase.get();
    }


    public void setClientcase(String clientcase) {
        this.clientcase.set(clientcase);
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

    public String getClientDob() {
        return clientDob.get();
    }

    public void setClientDob(String clientDob) {
        this.clientDob.set(clientDob);
    }
}

