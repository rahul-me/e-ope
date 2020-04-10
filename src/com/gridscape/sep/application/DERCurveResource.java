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
import com.gridscape.sep.org.zigbee.sep.DERCurve;

public interface DERCurveResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DERCurve GETDERCurve(@PathParam("derp_id") Long derpId, @PathParam("dc_id") Long dcId);

    @HEAD
    void HEADDERCurve();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDERCurve(DERCurve dercurve);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDERCurve(DERCurve dercurve);

    @DELETE
    @Produces("application/xml")
    DERCurve DELETEDERCurve();

}