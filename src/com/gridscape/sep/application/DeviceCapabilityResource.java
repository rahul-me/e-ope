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
import com.gridscape.sep.org.zigbee.sep.DeviceCapability;

public interface DeviceCapabilityResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DeviceCapability GETDeviceCapability();

    @HEAD
    void HEADDeviceCapability();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDeviceCapability(DeviceCapability devicecapability);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDeviceCapability(DeviceCapability devicecapability);

    @DELETE
    void DELETEDeviceCapability();

}