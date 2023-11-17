package business.controller.VehicleCntlr;

import java.util.List;
import business.model.Rating.ItemRatingModel;
import business.model.Rating.Rating;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/rating")
public class RatingController {
	private Rating rating = new Rating();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Rating> getAllRatings() {
		List<Rating> temp = this.rating.listRatings();
		return temp;
	}

	@GET
	@Path("/{vid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Rating> getRatingByParameter(@PathParam("vid") String vid) {
		ItemRatingModel irm = new ItemRatingModel();
		return irm.getRatingsByVid(vid);
	}

	@POST
	@Path("/{vid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Rating createPlant(@PathParam("vid") String vid, @QueryParam("rateNum") String rateNum,
			@QueryParam("comment") String comment, @QueryParam("userId") String userId) {

		int rateNumInt = Integer.parseInt(rateNum);
		int vidInt = Integer.parseInt(vid);
		int userIdInt = Integer.parseInt(userId);

		Rating newRating = new Rating(rateNumInt, comment, vidInt, userIdInt);
		ItemRatingModel irm = new ItemRatingModel();
		irm.postNewRating(newRating);
		return newRating;
	}
}