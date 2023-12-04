package presistence.daoLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.model.Administrator.Feedback;
import business.model.User.User;
import presistence.DatabaseConnection;

public class UserDAO {

	/* Singleton Design Pattern */
	private static UserDAO instance;

	private UserDAO() {

	}

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	public List<User> selectAllUsers() {
		String sql = "SELECT * FROM User";
		List<User> users = new ArrayList<>();

		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getString("type"));
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return users;
	}

	public boolean CreateUser(User user) {
		String createCommand = "INSERT INTO User (firstName,lastName,email,password,type) VALUES (?,?,?,?,?)";
		try (Connection conn = DatabaseConnection.connect();
				PreparedStatement statement = conn.prepareStatement(createCommand)) {
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getType());
			System.out.println("before");
			statement.executeUpdate();
			conn.commit();
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public User getByUsername(String username) {
	    User user = new User();
	    String selectUser = "SELECT id, firstName, lastName, email, password, type FROM User WHERE email=?";
	    
	    try (Connection conn = DatabaseConnection.connect();
	         PreparedStatement preparedStatement = conn.prepareStatement(selectUser)) {

	        // Set the parameter safely
	        preparedStatement.setString(1, username);

	        try (ResultSet rs = preparedStatement.executeQuery()) {
	            while (rs.next()) {
	                user.setId(rs.getInt("id"));
	                user.setFirstName(rs.getString("firstName"));
	                user.setLastName(rs.getString("lastName"));
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
	                user.setType(rs.getString("type"));
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }

	    return user;
	}

	public String getUserPassword(String username) {
		String password = null;
		String selectPassword = "SELECT * FROM User WHERE email='" + username + "'";
		try (Connection conn = DatabaseConnection.connect();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(selectPassword)) {
			while (rs.next()) {
				password = rs.getString("password");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return password;
	}

	public List<Feedback> listAllFeedback() {
		String sql = "SELECT description, userId FROM Feedback";

		List<Feedback> allFeedbacks = new ArrayList<>();

		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Feedback feedback = new Feedback();
				feedback.setFeedback(rs.getString("description"));
				feedback.setUserId(rs.getInt("userId"));

				allFeedbacks.add(feedback);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return allFeedbacks;
	}

	/*
	 * Create a new feedback in the database
	 */
	public boolean postFeedback(Feedback feedback) {
		String createCommand = "INSERT INTO Feedback (description,userId) VALUES (?,?)";
		try (Connection conn = DatabaseConnection.connect();
				PreparedStatement statement = conn.prepareStatement(createCommand)) {
			System.out.println(feedback.getFeedback());
			System.out.println(feedback.getUserId());
			statement.setString(1, feedback.getFeedback());
			statement.setInt(2, feedback.getUserId());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

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

	public User getByUserByID(String id) {
		User user = new User();
		String selectUser = "SELECT * FROM User WHERE id='" + id + "'";
		try (Connection conn = DatabaseConnection.connect();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(selectUser)) {
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getString("type"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return user;
	}

}