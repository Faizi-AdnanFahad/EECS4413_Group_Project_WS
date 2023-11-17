package presistence.daoLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

		System.out.println("in CreateUser");
		System.out.println(user.toString());
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
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public User getByUsername(String username) {
		User user = new User();
		String selectUser = "SELECT id,firstName,lastName,email,password,type FROM User WHERE email='" + username + "'";
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

	    public boolean addFeedback(String feedback) {
	        String sql = "INSERT INTO feedback VALUES(?);";
	        try (Connection conn = DatabaseConnection.connect();
					PreparedStatement statement = conn.prepareStatement(sql)) {
				statement.setString(1, feedback);
	            statement.executeUpdate();
	            return true;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return false;
			}
	    }

//	    public List<Feedback> getAllFeedback() {
//	        List<Feedback> feedbackList = new ArrayList<>();
//	        String sql = "SELECT id, content FROM feedback;";
//	        try {
//	            PreparedStatement pstmt = connection.prepareStatement(sql);
//	            ResultSet rs = pstmt.executeQuery();
//	            while (rs.next()) {
//	                int id = rs.getInt("id");
//	                String content = rs.getString("content");
//	                Feedback feedback = new Feedback(id, content);
//	                feedbackList.add(feedback);
//	            }
//	            rs.close();
//	        } catch (SQLException e) {
//	            System.out.println(e.getMessage());
//	        }
//	        return feedbackList;
//	    }
}
