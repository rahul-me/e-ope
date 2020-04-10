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
import com.gridscape.sep.org.zigbee.sep.IPInterface;

public interface IPInterfaceResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    IPInterface GETIPInterface();

    @HEAD
    void HEADIPInterface();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTIPInterface(IPInterface ipinterface);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTIPInterface(IPInterface ipinterface);

    @DELETE
    @Produces("application/xml")
    IPInterface DELETEIPInterface();

}