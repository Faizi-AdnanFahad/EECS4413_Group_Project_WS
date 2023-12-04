package business.controller.AdministratorCntlr;

import java.util.List;

import business.model.Administrator.Administrator;
import business.model.Administrator.Feedback;
import business.model.Analytics.VisitEvent;
import business.model.Vehicle.Item;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/feedback")
public class AdministrationController {
	Administrator admin = new Administrator();
	VisitEvent ve = new VisitEvent();

	@GET
	@Path("/vehiclesSale")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getVehiclesSold() {
		System.out.println("GET REQUEST");
		List<Item> vehiclesSold = ve.getSoldVehicles();
		return vehiclesSold;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Feedback> getAllFeedbacks() {
		Feedback feedback = new Feedback();
		return feedback.listFeedbacks();
	}

	/*
	 * Sends a post request to create a new feedback
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Feedback createFeedback(@QueryParam("Feedback") String feedback, @QueryParam("userId") String userId) {

		int userIdInt = Integer.parseInt(userId);
		Feedback newFeedback = new Feedback(feedback, userIdInt);
		admin.postNewFeedback(newFeedback);
		return newFeedback;
	}

	
}
