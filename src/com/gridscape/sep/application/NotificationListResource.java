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
import com.gridscape.sep.org.zigbee.sep.Notification;
import com.gridscape.sep.org.zigbee.sep.NotificationList;

public interface NotificationListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    NotificationList GETNotificationList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADNotificationList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTNotificationList(Notification notification);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTNotificationList(Notification notification);

    @DELETE
    void DELETENotificationList();

}