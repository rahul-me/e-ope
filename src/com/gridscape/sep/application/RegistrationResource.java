/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.gridscape.sep.application;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import com.gridscape.sep.org.zigbee.sep.Registration;

public interface RegistrationResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    Registration GETRegistration(@PathParam("id") String id);

    @HEAD
    void HEADRegistration();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTRegistration(Registration registration);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTRegistration(Registration registration);

    @DELETE
    @Produces("application/xml")
    Registration DELETERegistration();

}