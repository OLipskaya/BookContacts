package controller;

import model.Contact;
import model.entity.Address;
import model.entity.Mail;
import model.entity.Phone;
import model.entity.enums.Flag;
import model.entity.enums.ViewMail;
import model.entity.enums.ViewPhone;
import parsing.Parser;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/control")
public class Controller {
    /* Test Contacts list */
    private List<Contact> list = createList();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray getAll() {
        return createArray();
    }

    @GET
    @Path("/all/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray getAllId(@PathParam("id") String id) {
        Map<String, Object> config = new HashMap<String, Object>();
        JsonBuilderFactory factory = Json.createBuilderFactory(config);
        JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();
        for (Contact cn : list) {
            if(cn.getId().equals(id)){
                arrayBuilder.add(createJsonObject(factory, cn));
            }
        }
        JsonArray value = arrayBuilder.build();
        return value;
    }

    @POST
    @Path("/create")
    public Response createContact(String contactToJson){
        Parser parser = new Parser(contactToJson);
        Contact contact = parser.getCn();
        list.add(contact);
        return Response.ok().build();
    }

    @POST
    @Path("/save/{id}")
    public Response updateContact(@PathParam("id") String id, String contactToJson){
        Parser parser = new Parser(contactToJson);
        Contact contact = parser.getCn();
        for(int i=0; i<list.size(); ++i){
            if(list.get(i).getId().equals(id)){
                list.set(i, contact);
            }
        }
        return Response.ok().build();
    }


    private JsonObjectBuilder createJsonObject(JsonBuilderFactory factory, Contact contact) {
        JsonObjectBuilder user = factory.createObjectBuilder();

        user.add("id", contact.getId());
        user.add("firstname", contact.getFirstName());
        user.add("lastname", contact.getLastName());
        user.add("patronymic", contact.getPatronymicName());
        user.add("dateBirth", contact.getDateBirth());
        user.add("address", contact.getAddress().getValue());

        for (Phone phone : contact.getPhoneList()) {
            if (phone.getFlag().equals(Flag.DEFAULT)) {
                user.add("phone", phone.getNumberPhone());
                user.add("phone_view", "working");
                user.add("phone_flag", "default");
            }
        }
        for (Mail mail : contact.getMailList()) {
            if (mail.getFlag().equals(Flag.DEFAULT)) {
                user.add("mail", mail.getMailAddress());
                user.add("mail_view", "working");
                user.add("mail_flag", "default");
            }
        }
        return user;
    }

    private JsonArray createArray(){
        Map<String, Object> config = new HashMap<String, Object>();
        JsonBuilderFactory factory = Json.createBuilderFactory(config);
        JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();
        List<Contact> list = createList();
        for (Contact cn : list) {
            arrayBuilder.add(createJsonObject(factory, cn));
        }
        JsonArray value = arrayBuilder.build();
        return value;
    }

    /* test */
    private List<Contact> createList(){
        List<Contact> users = new ArrayList<Contact>();
        Contact contact1 = create();
        Contact contact2 = create();
        Contact contact3 = create();
        contact1.setId("1");
        contact2.setId("2");
        contact3.setId("3");
        users.add(contact1);
        users.add(contact2);
        users.add(contact3);
        return users;
    }

    private Contact create(){
        Contact contact = new Contact();

        contact.setFirstName("Ivan");
        contact.setLastName("Ivanovich");
        contact.setPatronymicName("Ivanov");
        contact.setDateBirth("1993");

        Address address = new Address();
        address.setValue("Minsk");

        Mail mail = new Mail();
        mail.setMailAddress("ivan1993@gmail.com");
        mail.setView(ViewMail.WORKING);
        mail.setFlag(Flag.DEFAULT);

        List<Mail> mlist = new ArrayList<Mail>();
        mlist.add(mail);

        Phone phone = new Phone();
        phone.setNumberPhone("80292301922");
        phone.setView(ViewPhone.MOBILE);
        phone.setFlag(Flag.DEFAULT);

        List<Phone> plist = new ArrayList<Phone>();
        plist.add(phone);

        contact.setAddress(address);
        contact.setMailList(mlist);
        contact.setPhoneList(plist);

        return contact;
    }
}
