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

import com.gridscape.sep.org.zigbee.sep.EndDeviceControl;
import com.gridscape.sep.org.zigbee.sep.EndDeviceControlList;

public interface ActiveEndDeviceControlList {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    EndDeviceControlList GETActiveEndDeviceControlList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADActiveEndDeviceControlList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTActiveEndDeviceControlList(EndDeviceControl enddevicecontrol);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })	
    void POSTActiveEndDeviceControlList(EndDeviceControl enddevicecontrol);

    @DELETE
    void DELETEActiveEndDeviceControlList();

}