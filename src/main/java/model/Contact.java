package model;

import model.entity.Address;
import model.entity.Mail;
import model.entity.Phone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Contact {
    @Id
    @GeneratedValue
    private String id;
    @Column(nullable = false)
    private String lastName = "";
    @Column(nullable = false)
    private String firstName = "";
    @Column(nullable = false)
    private String patronymicName = "";
    @Column(nullable = false)
    private String dateBirth = "";

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address = new Address();

    @OneToMany
    private Mail mail = new Mail();
    @OneToMany
    private Phone phone = new Phone();

    private List<Mail> mailList = new ArrayList<Mail>();
    private List<Phone> phoneList = new ArrayList<Phone>();

    public Contact() {}

    public Contact(String lastName, String firstName, String patronymicName, String dateBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.dateBirth = dateBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public List<Mail> getMailList() {
        return mailList;
    }

    public void setMailList(List<Mail> mailList) {
        this.mailList = mailList;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
