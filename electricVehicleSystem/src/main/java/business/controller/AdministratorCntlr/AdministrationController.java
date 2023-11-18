package business.controller.AdministratorCntlr;

import java.util.List;

import business.model.Administrator.Administrator;
import business.model.Administrator.Feedback;
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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Feedback> getAllFeedbacks() {
		Feedback feedback = new Feedback();
		return feedback.listFeedbacks();
	}

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
