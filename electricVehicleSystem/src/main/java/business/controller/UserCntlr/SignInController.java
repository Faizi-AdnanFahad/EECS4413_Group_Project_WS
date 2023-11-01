package business.controller.UserCntlr;

import jakarta.ws.rs.*; 

import jakarta.ws.rs.core.MediaType; 

import java.util.List;

import business.model.User.User;
import business.model.User.UserDAO; 

  
@Path("/users") 

public class SignInController {
	
	private UserDAO userDAO = new UserDAO();
	
	@GET 

    @Produces(MediaType.APPLICATION_JSON) 

    public List<User> getAllStudents() { 

        return userDAO.readAll(); 

    } 
	
	@POST 

    @Consumes(MediaType.APPLICATION_JSON) 

    @Produces(MediaType.APPLICATION_JSON) 

    public User createStudent(User user) { 

        return userDAO.create(user); 

    } 
	
	 @GET 

	 @Path("/{id}") 

	 @Produces(MediaType.APPLICATION_JSON) 

	 public User getStudent(@PathParam("id") int id) { 
		 
		 return userDAO.read(id); 

	    } 
	 
	 @PUT 

	 @Path("/{id}") 

	 @Consumes(MediaType.APPLICATION_JSON) 

	 @Produces(MediaType.APPLICATION_JSON) 

	 public User updateStudent(@PathParam("id") int id, User user) { 
		 
		 return userDAO.update(id, user); 

	    } 

	  

	 @DELETE 

	 @Path("/{id}") 

	 @Produces(MediaType.APPLICATION_JSON) 

	 public void deleteStudent(@PathParam("id") int id) { 
		 
		 userDAO.delete(id); 

	    } 
}
