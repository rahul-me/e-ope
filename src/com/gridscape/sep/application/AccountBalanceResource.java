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

import com.gridscape.sep.org.zigbee.sep.AccountBalance;

public interface AccountBalanceResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    AccountBalance GETAccountBalance();	

    @HEAD
    void HEADAccountBalance();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTAccountBalance(AccountBalance accountbalance);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTAccountBalance(AccountBalance accountbalance);

    @DELETE
    void DELETEAccountBalance();

}