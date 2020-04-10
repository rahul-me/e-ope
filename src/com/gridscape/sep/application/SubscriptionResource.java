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
import com.gridscape.sep.org.zigbee.sep.Subscription;

public interface SubscriptionResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    Subscription GETSubscription(@PathParam("deviceId") Long deviceId, @PathParam("subId") Long subscriptionId);

    @HEAD
    void HEADSubscription();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTSubscription(Subscription subscription, @PathParam("deviceId") Long deviceId, @PathParam("subId") Long subscriptionId);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTSubscription(Subscription subscription);

    @DELETE
    @Produces("application/xml")
    Subscription DELETESubscription(@PathParam("deviceId") Long deviceId, @PathParam("subId") Long subscriptionId);

}