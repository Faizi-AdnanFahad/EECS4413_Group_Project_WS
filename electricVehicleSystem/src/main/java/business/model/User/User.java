package business.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import presistence.DatabaseConnection;
import presistence.daoLayer.UserDAO;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String type;
	private UserDAO userDAO;

	public User() {
		this.userDAO = UserDAO.getInstance();
	}

	public User(int id, String firstName, String lastName, String email, String password, String type) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setType(type);
		this.userDAO = UserDAO.getInstance();
	}

	public User(String firstName, String lastName, String email, String password, String type) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setType(type);
		this.userDAO = UserDAO.getInstance();
	}

	// Setters

	public void setId(int id) {
		if (id >= 0) {
			this.id = id;
		}
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setType(String type) {
		this.type = type;
	}

	// Getters

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getType() {
		return type;

	}

	public List<User> selectAllUsers() {
		return this.userDAO.selectAllUsers();
	}

	public User getByUsername(String email) {
		return this.userDAO.getByUsername(email);
	}

	public boolean CreateUser(User user) {
		return this.userDAO.CreateUser(user);
	}

	public String getUserPassword(String email) {
		return userDAO.getUserPassword(email);
	}

	public String toString() {
		return "ID: " + id + " - Firstname: " + firstName + " - Lastname: " + lastName + " - Email: " + email
				+ " - Password: " + password + " - Type: " + type;
	}

	public boolean deleteUser(int id) {
		String deleteCommand = "DELETE FROM User WHERE id = ?";

		try (Connection conn = DatabaseConnection.connect();
				PreparedStatement statement = conn.prepareStatement(deleteCommand)) {
			statement.setInt(1, id);
			int rowsAffected = statement.executeUpdate();

			// Check if any rows were affected to determine if the deletion was successful
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
