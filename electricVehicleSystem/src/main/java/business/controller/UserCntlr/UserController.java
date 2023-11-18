package business.controller.UserCntlr;

import java.util.List;

import business.model.User.User;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
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

}