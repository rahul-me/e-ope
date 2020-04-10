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
import com.gridscape.sep.org.zigbee.sep.Notification;

public interface NotificationResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    Notification GETNotification();

    @HEAD
    void HEADNotification();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTNotification(Notification notification);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTNotification(Notification notification);

    @DELETE
    void DELETENotification();

}