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

import com.gridscape.sep.org.zigbee.sep.Notification;
import com.gridscape.sep.org.zigbee.sep.Subscription;
import com.gridscape.sep.org.zigbee.sep.SubscriptionList;

public interface SubscriptionListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    SubscriptionList GETSubscriptionList(@PathParam("id") Long deviceId, @QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADSubscriptionList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTSubscriptionList(Subscription subscription);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTSubscriptionList(@PathParam("id") Long deviceId, Subscription subscription);

    @DELETE
    void DELETESubscriptionList();
    
    

}