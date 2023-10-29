package presistence.daoLayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.name.studentapp.DatabaseConnection;

import model.Item;
public class CatalogDAO {
	public List<Item> readAll() {
		String sql = "SELECT * FROM Item";
		List<Item> items = new ArrayList<>();

		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Item item = new Item();
				item.setVid(rs.getInt("vid"));
				item.setName(rs.getString("name"));
				item.setDescription(rs.getString("description"));
				item.setModel(rs.getString("model"));
				item.setQuanitity(rs.getInt("quanitity"));
				item.setPrice(rs.getInt("price"));
				item.setMileage(rs.getInt("mileage"));
				item.setMileage(rs.getInt("history"));
				items.add(item);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return items;
	}
}
