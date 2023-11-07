package business.controller.UserCntlr;

import java.util.List;

import business.model.User.User;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import presistence.daoLayer.UserDAO;


@Path("/users") 
public class SignInController {
	private UserDAO userDAO = new UserDAO();
	@GET 
    @Produces(MediaType.APPLICATION_JSON) 
    public List<User> getAllUsers() { 
        return userDAO.readAll(); 
    } 
	
}
