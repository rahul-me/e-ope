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
import com.gridscape.sep.org.zigbee.sep.SelfDevice;

public interface SelfDeviceResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    SelfDevice GETSelfDevice();

    @HEAD
    void HEADSelfDevice();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTSelfDevice(SelfDevice selfdevice);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTSelfDevice(SelfDevice selfdevice);

    @DELETE
    void DELETESelfDevice();

}