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
import javax.ws.rs.QueryParam;
import com.gridscape.sep.org.zigbee.sep.IPInterface;
import com.gridscape.sep.org.zigbee.sep.IPInterfaceList;

public interface IPInterfaceListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    IPInterfaceList GETIPInterfaceList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADIPInterfaceList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTIPInterfaceList(IPInterface ipinterface);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTIPInterfaceList(IPInterface ipinterface);

    @DELETE
    void DELETEIPInterfaceList();

}