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
import javax.xml.transform.Source;
import com.gridscape.sep.org.zigbee.sep.MirrorUsagePoint;

public interface MirrorUsagePointResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    MirrorUsagePoint GETMirrorUsagePoint();

    @HEAD
    void HEADMirrorUsagePoint();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTMirrorUsagePoint(MirrorUsagePoint mirrorusagepoint, @PathParam("mupId") Long mupId);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTMirrorUsagePoint(Source source, @PathParam("mupId") Long mupId);

    @DELETE
    @Produces("application/xml")
    MirrorUsagePoint DELETEMirrorUsagePoint(@PathParam("mupId") Long mupId);

}