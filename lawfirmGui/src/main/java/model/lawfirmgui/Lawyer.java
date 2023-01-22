package model.lawfirmgui;

import javafx.beans.property.SimpleStringProperty;

public class Lawyer {

    private SimpleStringProperty lawyerID;
    private SimpleStringProperty lawyerFirstName;
    private SimpleStringProperty lawyerLastName;
    private SimpleStringProperty lawyerContact;
    private SimpleStringProperty lawyerPosition;
    private SimpleStringProperty lawyerSalary;
    private SimpleStringProperty lawyercase;

    public Lawyer(String idlaw, String firstname, String lastname, String contact, String position, String salary, String idcase)
    {
        this.lawyerID = new SimpleStringProperty(idlaw);
        this.lawyerFirstName = new SimpleStringProperty(firstname);
        this.lawyerLastName = new SimpleStringProperty(lastname);
        this.lawyerContact = new SimpleStringProperty(contact);
        this.lawyerPosition = new SimpleStringProperty(position);
        this.lawyerSalary = new SimpleStringProperty(salary);
        this.lawyercase = new SimpleStringProperty(idcase);
    }

    public String getLawyerID() { return lawyerID.get(); }
    public void setLawyerID(String idlaw) { this.lawyerID.set(idlaw); }

    public String getLawyerFirstName() { return lawyerFirstName.get(); }
    public void setLawyerFirstName(String firstname) { this.lawyerFirstName.set(firstname); }

    public String getLawyerLastName() { return lawyerLastName.get(); }
    public void setLawyerLastNameName(String lastname) { this.lawyerLastName.set(lastname); }

    public String getLawyerContact() { return lawyerContact.get(); }
    public void setLawyerContact(String contact) { this.lawyerContact.set(contact); }

    public String getLawyerPosition() { return lawyerPosition.get(); }
    public void setLawyerPosition(String position) { this.lawyerPosition.set(position); }

    public String getLawyerSalary() { return lawyerSalary.get(); }
    public void setLawyerSalary(String salary) { this.lawyerSalary.set(salary); }

    public String getLawyerCase() { return lawyercase.get(); }
    public void setLawyerCase(String idcase) { this.lawyercase.set(idcase); }
}
