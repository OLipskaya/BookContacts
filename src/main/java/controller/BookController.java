package controller;

import model.Contact;
import parsing.ConverterToJson;
import parsing.Parser;
import service.BookService;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/contacts")
public class BookController {
    @Inject
    private BookService bookService = new BookService();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray getAll() {
        ConverterToJson converterToJson = new ConverterToJson();
        List<Contact> contacts = bookService.getAll();
        JsonArray array = converterToJson.converterList(contacts);
        return array;
    }

    @GET
    @Path("/all/{id}")
    @Produces("application/json")
    public JsonArray getContact(@PathParam("id") String id){
        ConverterToJson converterToJson = new ConverterToJson();
        Contact contact = bookService.getContact(id);
        JsonArray value = converterToJson.converterContact(contact);
        return value;
    }

    @POST
    @Path("/save/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response updateContact(@PathParam("id") String id, String contactToJson){
        Parser parser = new Parser(contactToJson);
        Contact cn = parser.getCn();
        bookService.updateContact(cn,id);
        return Response.ok().build();
    }

    @POST
    @Path("/create")
    public Response createContact(String contactToJson){
        Parser parser = new Parser(contactToJson);
        Contact contact = parser.getCn();
        bookService.addContact(contact);
        return Response.ok().build();
    }

}
