package com.bzz.Serienliste.service;

import com.bzz.Serienliste.model.Serie;
import com.bzz.Serienliste.model.Liste;
import com.bzz.Serienliste.data.DataHandler;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

/**
 * short description
 * <p>
 * Bookshelf
 *
 * @author TODO
 */
@Path("test")
public class TestService {

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {
        /*
        Map<String, Book> bookMap = DataHandler.getBookMap();
        Map<String, Publisher> publisherMap = DataHandler.getPublisherMap();
        Book book = DataHandler.readBook("c746a291-0ef9-4b2a-8268-392b12d636bd");
        Publisher publisher = DataHandler.readPublisher("606cc4a5-8bfd-4e24-85c1-ecf6b9814712");
        */
        return Response
                .status(200)
                //.entity(bookMap)
                .entity("{\"Data\":\"foobar\"}")
                .build();
    }
}
