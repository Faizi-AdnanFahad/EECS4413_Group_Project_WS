package business.model.User;

public class User {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String type;
	
	public User() {}
	
	public User(int id, String firstName, String lastName, String email, String password, String type) 
	{
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setType(type);
	}
	
	// Setters
	
	public void setId(int id)
	{
		if(id >= 0)
		{
			this.id = id;
		}
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	// Getters
	
	public int getId()
	{
		return id;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getType()
	{
		return type;
	}
}
