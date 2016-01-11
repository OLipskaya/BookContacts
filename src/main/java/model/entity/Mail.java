package model.entity;

import model.Contact;
import model.entity.enums.Flag;
import model.entity.enums.ViewMail;

import javax.persistence.*;

@Entity
@Table
public class Mail {
    @Id
    @GeneratedValue
    private String id;
    @Column(nullable = false)
    private String mailAddress = "";

    private ViewMail view = ViewMail.WORKING;
    private Flag flag = Flag.DEFAULT;

    @OneToOne(mappedBy = "mail")
    private Contact contact;

    public Mail() {}

    public Mail(String mailAddress, ViewMail view, Flag flag) {
        this.mailAddress = mailAddress;
        this.view = view;
        this.flag = flag;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public ViewMail getView() {
        return view;
    }

    public void setView(ViewMail view) {
        this.view = view;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }
}
