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
import javax.ws.rs.Produces;
import com.gridscape.sep.org.zigbee.sep.LoadShedAvailability;

public interface LoadShedAvailabilityResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    LoadShedAvailability GETLoadShedAvailability();

    @HEAD
    void HEADLoadShedAvailability();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTLoadShedAvailability(LoadShedAvailability loadshedavailability);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTLoadShedAvailability(LoadShedAvailability loadshedavailability);

    @DELETE
    @Produces("application/xml")
    LoadShedAvailability DELETELoadShedAvailability();

}