package presistence.daoLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import business.model.Catalog.Catalog;
import business.model.Vehicle.Item;
import presistence.DatabaseConnection;

public class CartDAO {

	/* Singleton Design Pattern */
	private static CartDAO instance;

	private CartDAO() {

	}

	public static CartDAO getInstance() {
		if (instance == null) {
			instance = new CartDAO();
		}
		return instance;
	}

	public List<Integer> getVehiclesInCart(int userId) {
		String sql = "SELECT vid FROM Cart WHERE userId=" + userId;

		List<Integer> vids = new ArrayList<Integer>();
		
		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				vids.add(rs.getInt("vid"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return vids;
	}

}