package presistence.daoLayer;

import java.sql.*; 
import java.util.ArrayList;
import java.util.List;

import business.model.Catalog.Catalog;
import presistence.DatabaseConnection;

public class ItemDAO {
	public List<Catalog> readAll() {
		String sql = "SELECT * FROM Item";
		List<Catalog> catalogs = new ArrayList<>();

		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Catalog item = new Catalog();
				item.setVid(rs.getInt("vid"));
				item.setName(rs.getString("name"));
				item.setDescription(rs.getString("description"));
				item.setModel(rs.getString("model"));
				item.setQuanitity(rs.getInt("quanitity"));
				item.setPrice(rs.getInt("price"));
				item.setMileage(rs.getInt("mileage"));
				item.setMileage(rs.getInt("history"));
				catalogs.add(item);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return catalogs;
	}
}
