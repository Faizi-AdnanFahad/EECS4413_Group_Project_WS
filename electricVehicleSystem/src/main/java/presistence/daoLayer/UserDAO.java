package presistence.daoLayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import business.model.User.User;
import presistence.DatabaseConnection;

public class UserDAO {
	
	
	public List<User> readAll() {
		String sql = "SELECT * FROM User";
		List<User> users = new ArrayList<>();

		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("uid"));
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
	
}

