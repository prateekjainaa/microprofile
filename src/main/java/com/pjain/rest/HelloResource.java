package com.pjain.rest;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

import com.pjain.rest.config.HelloConfiguration;

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

    @Inject
    private HelloConfiguration config;
    
    @Inject
    @ConfigProperty(name="userName", defaultValue="duke")
    String user;
    
    @GET
    @Path("/hello")
    @Produces("application/json")
    @Timed(displayName="onMethod")
    @Metered(absolute=true, name="meteredOnMethod")
    public Response helloCall(@QueryParam("name") final String name) {
        return Response.status(200).entity("Hello! " + name).build();
    }
    
    @GET
    @Path("/hello-config")
    @Produces("application/json")
    @Timed(displayName="onConfig")
    @Metered(absolute=true, name="meteredOnConfigMethod")
    public Response helloConfigCall() {
    	//String user = user.getUser();
        //return Response.status(200).entity("Hello! " + user).build();
    	return Response.status(200).entity("Hello! " + config.getUser()).build();
    }
    
    
}