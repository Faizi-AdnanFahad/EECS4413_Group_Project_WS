package business.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	private static List<User> users = new ArrayList<>();
	
	public User create(User user)
	{ 	
    	users.add(user); 
        return user; 
    } 
	
	public List<User> readAll()
	{
		return users;
	}
	
	 public User read(int id)
	 { 
		 return users.stream().filter(s -> s.getId() == id).findFirst().orElse(null); 
	 } 
	
	 public User update(int id, User student)
	 { 

		 User updatedStudent = null;
		 
		 for (int i = 0; i < users.size(); i++) 
		 {
		 	if (users.get(i).getId() == id) 
		 	{
	    		users.set(i, student);
	    		updatedStudent = users.get(i);
		 	}
		 }
		 	
		 return updatedStudent;
	 } 
	 
	 public void delete(int id) 
	 { 
		 users.removeIf(s -> s.getId() == id); 
	 } 
}
