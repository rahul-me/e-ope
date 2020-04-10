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
import com.gridscape.sep.org.zigbee.sep.DeviceInformation;

public interface DeviceInformationResource {
	/**
	 * Required API
	 * @return
	 */
    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DeviceInformation GETDeviceInformation(@PathParam("edevId") Long edevId);

    @HEAD
    void HEADDeviceInformation();
    
    /**
     * Required API
     * @param deviceinformation
     */
    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDeviceInformation(DeviceInformation deviceinformation, @PathParam("edevId") Long edevId);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDeviceInformation(DeviceInformation deviceinformation);

    @DELETE
    @Produces("application/xml")
    DeviceInformation DELETEDeviceInformation();

}