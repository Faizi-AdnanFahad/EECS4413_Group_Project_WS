package business.controller.UserCntlr;

import jakarta.ws.rs.*; 
import jakarta.ws.rs.core.MediaType;
import presistence.daoLayer.UserDAO;
import java.util.List;
import business.model.User.User;


@Path("/users") 

public class SignInController {
	private UserDAO userDAO = new UserDAO();
	@GET 
    @Produces(MediaType.APPLICATION_JSON) 
    public List<User> getAllUsers() { 
        return userDAO.readAll(); 
    } 
	
}
