package parsing;

import model.Contact;
import model.entity.Mail;
import model.entity.Phone;
import model.entity.enums.Flag;

import javax.json.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Converter Contact.class to JSON
public class ConverterToJson {

    private String ID = "id";
    private String LASTNAME = "lastname";
    private String FIRSTNAME = "firstname";
    private String PATRONYMIC = "patronymic";
    private String ADDRESS = "address";
    private String DATE = "dateBirth";
    private String MAIL = "mail";
    private String PHONE = "phone";

    public ConverterToJson() {}

    public JsonArray converterList(List<Contact> list){
        Map<String, Object> config = new HashMap<String, Object>();
        JsonBuilderFactory factory = Json.createBuilderFactory(config);
        JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();
        for (Contact cn : list) {
            arrayBuilder.add(createJsonObject(factory, cn));
        }
        JsonArray jsonArray = arrayBuilder.build();
        return jsonArray;
    }

    public JsonArray converterContact(Contact contact){
        Map<String, Object> config = new HashMap<String, Object>();
        JsonBuilderFactory factory = Json.createBuilderFactory(config);
        JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();
        arrayBuilder.add(createJsonObject(factory, contact));
        return arrayBuilder.build();
    }

    private JsonObjectBuilder createJsonObject(JsonBuilderFactory factory, Contact contact) {
        JsonObjectBuilder user = factory.createObjectBuilder();

        user.add(ID, contact.getId());
        user.add(FIRSTNAME, contact.getFirstName());
        user.add(LASTNAME, contact.getLastName());
        user.add(PATRONYMIC, contact.getPatronymicName());
        user.add(DATE, contact.getDateBirth());
        user.add(ADDRESS, contact.getAddress().getValue());

        for (Phone phone : contact.getPhoneList()) {
            if (phone.getFlag().equals(Flag.DEFAULT)) {
                user.add(PHONE, phone.getNumberPhone());
            }
        }
        for (Mail mail : contact.getMailList()) {
            if (mail.getFlag().equals(Flag.DEFAULT)) {
                user.add(MAIL, mail.getMailAddress());
            }
        }
        return user;
    }
}
