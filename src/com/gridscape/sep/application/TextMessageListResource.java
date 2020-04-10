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
import com.gridscape.sep.org.zigbee.sep.TextMessage;
import com.gridscape.sep.org.zigbee.sep.TextMessageList;

public interface TextMessageListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    TextMessageList GETTextMessageList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADTextMessageList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTTextMessageList(TextMessage textmessage);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTTextMessageList(TextMessage textmessage);

    @DELETE
    void DELETETextMessageList();

}