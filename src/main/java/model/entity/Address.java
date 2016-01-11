package model.entity;

import model.Contact;

import javax.persistence.*;

@Entity
@Table
public class Address {
    @Id
    @GeneratedValue
    private String id;

    @Column(nullable = false)
    private String value = "";

    @OneToOne(mappedBy = "address")
    private Contact contact;

    public Address() {}

    public Address(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
