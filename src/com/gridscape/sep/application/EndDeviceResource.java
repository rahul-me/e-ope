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
import com.gridscape.sep.org.zigbee.sep.EndDevice;

public interface EndDeviceResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    EndDevice GETEndDevice(@PathParam("id") String id);

    @HEAD
    void HEADEndDevice();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTEndDevice(EndDevice enddevice);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTEndDevice(EndDevice enddevice);

    @DELETE
    @Produces("application/xml")
    EndDevice DELETEEndDevice();

}