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
import com.gridscape.sep.org.zigbee.sep.RateComponent;
import com.gridscape.sep.org.zigbee.sep.RateComponentList;

public interface RateComponentListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    RateComponentList GETRateComponentList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADRateComponentList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTRateComponentList(RateComponent ratecomponent);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTRateComponentList(RateComponent ratecomponent);

    @DELETE
    void DELETERateComponentList();

}