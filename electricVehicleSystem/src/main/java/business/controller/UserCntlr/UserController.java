package business.controller.UserCntlr;

import java.util.List;

import business.model.User.User;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import presistence.daoLayer.UserDAO;


@Path("/users") 
public class UserController {
	private UserDAO userDAO = new UserDAO();
	
	@GET 
    @Produces(MediaType.APPLICATION_JSON) 
    public List<User> getAllUsers() { 
		System.out.println("in getAllUsers!");
        return userDAO.selectAllUsers(); 
    } 
	
	@POST
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean login(User temp) {
	    System.out.println("in login!");
	    
	    User user = userDAO.getByUsername(temp.getEmail());
	    
	    if (user != null && (user.getPassword().equals(temp.getPassword()))) {
	    	System.out.println("OK");
	        return true;
	    } else {
	    	System.out.println("NOT OK!");
	        return false;
	    }
	}
}
