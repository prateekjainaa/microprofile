package com.pjain.rest;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

/**
*
* Just to test. create new resource for project.
*
*/
@Path("/")
public class HelloResource {

    @Context
    private HttpServletRequest servletRequest;

    @Context
    private UriInfo uriInfo;

    @GET
    @Path("/hello")
    @Produces("application/json")
    @Timed(displayName="onMethod")
    @Metered(absolute=true, name="meteredOnMethod")
    public Response helloCall(@QueryParam("name") final String name) {
        return Response.status(200).entity("Hello! " + name).build();
    }
}