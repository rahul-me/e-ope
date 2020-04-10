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
import com.gridscape.sep.org.zigbee.sep.CustomerAgreement;
import com.gridscape.sep.org.zigbee.sep.CustomerAgreementList;

public interface CustomerAgreementListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    CustomerAgreementList GETCustomerAgreementList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADCustomerAgreementList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTCustomerAgreementList(CustomerAgreement customeragreement);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTCustomerAgreementList(CustomerAgreement customeragreement);

    @DELETE
    void DELETECustomerAgreementList();

}