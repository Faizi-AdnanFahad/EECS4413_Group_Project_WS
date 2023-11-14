package business.controller.VehicleCntlr;

import java.util.List;
import business.model.Rating.ItemRatingModel;
import business.model.Rating.Rating;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
}
