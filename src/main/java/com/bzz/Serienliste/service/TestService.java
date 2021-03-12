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

        Map<String, Serie> seriemap = DataHandler.getserieMap();
        Map<String, Liste> listeMap = DataHandler.getListemap();
        //Serie serie = DataHandler.readSerie("0");
        Liste liste = DataHandler.readListe("0");

        return Response
                .status(200)
                .entity(seriemap)
                .entity("{\"Data\":\"foobar\"}")
                .build();
    }
}
