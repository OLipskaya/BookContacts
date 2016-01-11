package parsing;

import model.Contact;
import model.entity.Address;
import model.entity.Mail;
import model.entity.Phone;
import model.entity.enums.Flag;
import model.entity.enums.ViewMail;
import model.entity.enums.ViewPhone;

import java.util.ArrayList;
import java.util.List;

//Converter JSON to Java.class
public class Parser {

    private Contact cn = new Contact();

    private boolean check = false;

    private List<Mail> mailList = new ArrayList<Mail>();
    private List<Phone> phoneList = new ArrayList<Phone>();

    private final String PHONES = "phones";
    private final String MAILES = "mailes";

    private final String ID = "id";
    private final String LASTNAME = "lastname";
    private final String FIRSTNAME = "firstname";
    private final String PATRONYMIC = "patronymic";
    private final String ADDRESS = "address";
    private final String DATE = "dateBirth";
    private final String MAIL = "mail";
    private final String PHONE = "phone";

    private final String VIEW = "view";
    private final String FLAG = "flag";
    private final String WORKING = "working";
    private final String MOBILE = "mobile";
    private final String HOME = "home";
    private final String DEFAULT = "default";
    private final String NODEFAULT = "no_default";


    public Parser(String inputLine) {
        init(inputLine);
        if(mailList.size()!=0){
            check = true;
            cn.setMailList(mailList);
        }
        if(phoneList.size()!=0){
            check = true;
            cn.setPhoneList(phoneList);
        }
    }

    public Contact getCn() {
        return cn;
    }

    public boolean isCheck() {
        return check;
    }

    private void init(String output){
        //input line
        String input = output.substring(output.indexOf("{")+1, output.lastIndexOf("}")).replace("\"","");

        //parametrs
        String params = input.substring(0, input.indexOf(PHONES));
        String[] array = params.split(",");

        for(String param : array){
            parseLine(param);
        }

        //parametrs list [{}]
        String lists = input.substring(input.indexOf(PHONES));
        String phoneList = lists.substring(lists.indexOf(PHONES)+7, lists.indexOf(MAILES)-1);
        String mailList = lists.substring(lists.indexOf(MAILES)+7);

        parseList(phoneList);
        parseList(mailList);
    }

    private void parseLine(String str){
        String[] line = str.split(":");
        String name = line[0].replace("\"","");
        String value = line[1].replace("\"","");

        if(name.equals(ID)){  cn.setId(value); }

        if(name.equals(FIRSTNAME)){  cn.setFirstName(value); }

        if(name.equals(LASTNAME)){  cn.setLastName(value); }

        if(name.equals(DATE)){  cn.setDateBirth(value); }

        if(name.equals(PATRONYMIC)){  cn.setPatronymicName(value); }

        if(name.equals(ADDRESS)){  cn.setAddress(new Address(value)); }

    }

    private void parseList(String list){
        if(list.indexOf("[") >= 0){
            list = list.substring(list.indexOf("[")+1, list.lastIndexOf("]"));
        }

        String[] array = list.split("}");

        for(String term : array){
            term = term.substring(term.indexOf("{")+1);
            parseTerm(term);
        }
    }

    private void parseTerm(String term){
        String[] arr = term.split(",");

        for(String str: arr){
            if(term.indexOf(PHONE) >= 0){
                Phone phone = createPhone(str);
                if(!phone.equals(null)){
                    phoneList.add(phone);
                }
            } else {
                Mail mail = createMail(str);
                if(!mail.equals(null)){
                    mailList.add(mail);
                }
            }
        }
    }

    private ViewMail checkViewMail(String view){
        ViewMail viewMail = ViewMail.HOME;
        if(view.equals(WORKING)){ viewMail = ViewMail.WORKING; }
        if(view.equals(HOME)){ viewMail = ViewMail.HOME; }
        return viewMail;
    }

    private ViewPhone checkViewPhone(String view){
        ViewPhone viewPhone = ViewPhone.MOBILE;
        if(view.equals(WORKING)){ viewPhone = ViewPhone.WORKING; }
        if(view.equals(MOBILE)){ viewPhone = ViewPhone.MOBILE; }
        if(view.equals(HOME)){ viewPhone = ViewPhone.HOME; }
        return viewPhone;
    }

    private Flag checkFlag(String value){
        Flag flag = Flag.DEFAULT;
        if(value.equals(DEFAULT)){ flag = Flag.DEFAULT; }
        if(value.equals(NODEFAULT)){ flag = Flag.NODEFAULT; }
        return flag;
    }

    private Phone createPhone(String line){
        Phone phone = new Phone();
        String[] prm = line.split(":");
        String name = prm[0];
        String value = prm[1];

        if(name.equals(PHONE)) { phone.setNumberPhone(value); }
        if(name.equals(VIEW)) { phone.setView(checkViewPhone(value)); }
        if(name.equals(FLAG)) { phone.setFlag(checkFlag(value)); }

        return phone;
    }

    private Mail createMail(String line){
        Mail mail = new Mail();
        String[] prm = line.split(":");
        String name = prm[0];
        String value = prm[1];

        if(name.equals(MAIL)){ mail.setMailAddress(value); }
        if(name.equals(VIEW)){ mail.setView(checkViewMail(value)); }
        if(name.equals(FLAG)){ mail.setFlag(checkFlag(value)); }

        return mail;
    }

}
