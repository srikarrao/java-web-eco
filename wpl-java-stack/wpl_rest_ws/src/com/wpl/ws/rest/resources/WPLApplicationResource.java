package com.wpl.ws.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.wpl.ws.rest.model.vo.reponses.WPLApplicationStatusResponseVO;
import com.wpl.ws.rest.model.vo.requests.WPLPersistPickedApplicationsRequestVO;
import static com.wpl.ws.rest.util.WPLConstants.*;
import static com.wpl.ws.rest.util.WPLUtilities.*;

@Path("/wplApplication")
public class WPLApplicationResource {

	@GET
	@Path("/getStatus/{appId}")
	@Produces(MediaType.APPLICATION_JSON)
	public WPLApplicationStatusResponseVO getApplicationStatusInJSON(
			@PathParam("appId") int appId) {
		WPLApplicationStatusResponseVO applicationStatus = null;
		try {
			applicationStatus = new WPLApplicationStatusResponseVO();
			applicationStatus.setAppId(appId);
			applicationStatus.setStatus("Approved");
			applicationStatus.setStatusMessage("Change of status from October");
			applicationStatus.setYears(3);
			applicationStatus.setStartDate(APP_DATE);
			System.out.println(applicationStatus);
		} catch (Exception e) {
			errorLogger.error("Error occurred at GET method " + e);
		}
		return applicationStatus;
	}

	@POST
	@Path("/publishApplications")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response persistPickedApplications(
			WPLPersistPickedApplicationsRequestVO persistPickedApplicationsRequestVO) {
		String json = "";
		try {
			// json = new Gson().toJson(applicationStatus);
		} catch (Exception e) {
			errorLogger.error("Error occurred at POST method " + e);
		}
		return Response.status(200).entity(json).build();
	}
}