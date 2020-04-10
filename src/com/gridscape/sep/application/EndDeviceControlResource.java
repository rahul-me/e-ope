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
import com.gridscape.sep.org.zigbee.sep.EndDeviceControl;

public interface EndDeviceControlResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    EndDeviceControl GETEndDeviceControl();

    @HEAD
    void HEADEndDeviceControl();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTEndDeviceControl(EndDeviceControl enddevicecontrol);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTEndDeviceControl(EndDeviceControl enddevicecontrol);

    @DELETE
    @Produces("application/xml")
    EndDeviceControl DELETEEndDeviceControl();

}