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
import com.gridscape.sep.org.zigbee.sep.IPAddr;
import com.gridscape.sep.org.zigbee.sep.IPAddrList;

public interface IPAddrListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    IPAddrList GETIPAddrList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADIPAddrList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTIPAddrList(IPAddr ipaddr);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTIPAddrList(IPAddr ipaddr);

    @DELETE
    void DELETEIPAddrList();

}