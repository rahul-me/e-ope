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
import com.gridscape.sep.org.zigbee.sep.IPAddr;

public interface IPAddrResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    IPAddr GETIPAddr();

    @HEAD
    void HEADIPAddr();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTIPAddr(IPAddr ipaddr);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTIPAddr(IPAddr ipaddr);

    @DELETE
    @Produces("application/xml")
    IPAddr DELETEIPAddr();

}