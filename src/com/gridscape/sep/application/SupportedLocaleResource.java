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
import com.gridscape.sep.org.zigbee.sep.SupportedLocale;

public interface SupportedLocaleResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    SupportedLocale GETSupportedLocale();

    @HEAD
    void HEADSupportedLocale();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTSupportedLocale(SupportedLocale supportedlocale);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTSupportedLocale(SupportedLocale supportedlocale);

    @DELETE
    @Produces("application/xml")
    SupportedLocale DELETESupportedLocale();

}