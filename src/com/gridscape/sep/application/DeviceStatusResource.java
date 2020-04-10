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
import com.gridscape.sep.org.zigbee.sep.DeviceStatus;

public interface DeviceStatusResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DeviceStatus GETDeviceStatus();

    @HEAD
    void HEADDeviceStatus();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDeviceStatus(DeviceStatus devicestatus);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDeviceStatus(DeviceStatus devicestatus);

    @DELETE
    @Produces("application/xml")
    DeviceStatus DELETEDeviceStatus();

}