package model.entity;

import model.Contact;
import model.entity.enums.Flag;
import model.entity.enums.ViewPhone;

import javax.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private String id;
    @Column(nullable = false)
    private String numberPhone = "";
    private ViewPhone view = ViewPhone.WORKING;
    private Flag flag = Flag.DEFAULT;

    @OneToOne(mappedBy = "phone")
    private Contact contact;

    public Phone() {}

    public Phone(String numberPhone, ViewPhone view, Flag flag) {
        this.numberPhone = numberPhone;
        this.view = view;
        this.flag = flag;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public ViewPhone getView() {
        return view;
    }

    public void setView(ViewPhone view) {
        this.view = view;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }
}
