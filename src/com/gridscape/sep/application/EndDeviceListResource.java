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
import com.gridscape.sep.org.zigbee.sep.EndDevice;
import com.gridscape.sep.org.zigbee.sep.EndDeviceList;

public interface EndDeviceListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    EndDeviceList GETEndDeviceList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADEndDeviceList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTEndDeviceList(EndDevice enddevice);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTEndDeviceList(EndDevice enddevice);

    @DELETE
    void DELETEEndDeviceList();

}