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
import com.gridscape.sep.org.zigbee.sep.SupportedLocale;
import com.gridscape.sep.org.zigbee.sep.SupportedLocaleList;

public interface SupportedLocaleListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    SupportedLocaleList GETSupportedLocaleList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADSupportedLocaleList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTSupportedLocaleList(SupportedLocale supportedlocale);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTSupportedLocaleList(SupportedLocale supportedlocale);

    @DELETE
    void DELETESupportedLocaleList();

}