package business.controller.UserCntlr;

import java.util.List;

import business.model.Analytics.Analytics;
import business.model.Rating.ItemRatingModel;
import business.model.Rating.Rating;
import business.model.User.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public class UserController {
	private User user = new User();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		return this.user.selectAllUsers();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getRatingByParameter(@PathParam("id") String vid) {
		return this.user.getByUserByID(vid);
	}
	
	@GET
	@Path("/usage")
	@Produces(MediaType.APPLICATION_JSON)
	public int getAppUsage() {
		return Analytics.getAppUsage();
	}

	@POST
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public int login(User temp) {
		User user = this.user.getByUsername(temp.getEmail());

		if (user != null && (user.getPassword().equals(temp.getPassword()))) {
			return user.getId();
		} else {
			return -1;
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean deletePlant(@PathParam("id") String id) {
		return this.user.deleteUser(Integer.parseInt(id));
	}

}