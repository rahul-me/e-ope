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
import com.gridscape.sep.org.zigbee.sep.ServiceSupplier;

public interface ServiceSupplierResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    ServiceSupplier GETServiceSupplier();

    @HEAD
    void HEADServiceSupplier();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTServiceSupplier(ServiceSupplier servicesupplier);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTServiceSupplier(ServiceSupplier servicesupplier);

    @DELETE
    @Produces("application/xml")
    ServiceSupplier DELETEServiceSupplier();

}