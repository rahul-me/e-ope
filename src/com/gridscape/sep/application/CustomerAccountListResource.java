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
import com.gridscape.sep.org.zigbee.sep.CustomerAccount;
import com.gridscape.sep.org.zigbee.sep.CustomerAccountList;

public interface CustomerAccountListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    CustomerAccountList GETCustomerAccountList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADCustomerAccountList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTCustomerAccountList(CustomerAccount customeraccount);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTCustomerAccountList(CustomerAccount customeraccount);

    @DELETE
    void DELETECustomerAccountList();

}