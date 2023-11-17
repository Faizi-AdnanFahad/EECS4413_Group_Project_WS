package business.controller.AdministratorCntlr;

import business.model.Administrator.Administrator;
import business.model.Rating.Rating;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/feedback")
public class AdministrationController {
	Administrator admin=new Administrator();
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String Feedback(@QueryParam("Feedback") String Feedback) {
		return admin.Feedback(Feedback);
	}
}
