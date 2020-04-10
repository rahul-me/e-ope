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
import com.gridscape.sep.org.zigbee.sep.CustomerAccount;

public interface CustomerAccountResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    CustomerAccount GETCustomerAccount();

    @HEAD
    void HEADCustomerAccount();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTCustomerAccount(CustomerAccount customeraccount);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTCustomerAccount(CustomerAccount customeraccount);

    @DELETE
    @Produces("application/xml")
    CustomerAccount DELETECustomerAccount();

}