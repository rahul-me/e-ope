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
import javax.ws.rs.QueryParam;
import com.gridscape.sep.org.zigbee.sep.DERCurve;
import com.gridscape.sep.org.zigbee.sep.DERCurveList;

public interface DERCurveListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DERCurveList GETDERCurveList(@QueryParam("s") Integer s, @QueryParam("l") Integer l, @PathParam("derp_id") Long derpId);

    @HEAD
    void HEADDERCurveList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDERCurveList(DERCurve dercurve);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDERCurveList(DERCurve dercurve);

    @DELETE
    void DELETEDERCurveList();

}