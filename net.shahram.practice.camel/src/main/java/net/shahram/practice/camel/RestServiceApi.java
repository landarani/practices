package net.shahram.practice.camel;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public interface RestServiceApi {
    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    ResponseObject goodResponse(@QueryParam("id") int id);

    @POST
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    ResponseObject badResponse(@PathParam("id") int id);

}
