package presistence.daoLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import business.model.Catalog.Catalog;
import business.model.Vehicle.Item;
import presistence.DatabaseConnection;

public class ItemDAO {

	/* Singleton Design Pattern */
	private static ItemDAO instance;

	private ItemDAO() {

	}

	public static ItemDAO getInstance() {
		if (instance == null) {
			instance = new ItemDAO();
		}
		return instance;
	}

	public List<Item> listAllVehicles() {
		String sql = "SELECT vid, name, model, price, mileage FROM Item";

		Catalog catalog = new Catalog();

		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Item item = new Item();
				item.setVid(rs.getInt("vid"));
				item.setName(rs.getString("name"));
				item.setModel(rs.getString("model"));
				item.setPrice(rs.getInt("price"));
				item.setMileage(rs.getInt("mileage"));

				// add items to the catalog
				catalog.addVehicles(item);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return catalog.getVehicles();
	}

	/*
	 * Runs only a query to retrieve a particular vehicle from the database
	 */
	public Item getVehicleById(String id) {
		String sql = "SELECT * FROM Item WHERE vid=" + id;

		Item item = new Item();

		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				item = helper(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return item;
	}

	public List<Item> compareVehicles(String[] cars) {
		String compareList = this.helperCreateList(cars);

		String sql = "SELECT * FROM Item WHERE vid in " + compareList;

		Catalog catalog = new Catalog();

		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Item item = helper(rs);

				// add items to the catalog
				catalog.addVehicles(item);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return catalog.getVehicles();
	}

	private Item helper(ResultSet rs) {
		Item item = new Item();

		try {
			item.setVid(rs.getInt("vid"));
			item.setName(rs.getString("name"));
			item.setDescription(rs.getString("description"));
			item.setModel(rs.getString("model"));
			item.setQuanitity(rs.getInt("quanitity"));
			item.setPrice(rs.getInt("price"));
			item.setMileage(rs.getInt("mileage"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	private String helperCreateList(String[] cars) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (int i = 0; i < cars.length; i++) {
			sb.append(cars[i]);
			if (i < cars.length - 1) {
				sb.append(", ");
			}
		}
		sb.append(")");
		return sb.toString();
	}

	public List<Item> sortByPriceDESC() {
		String sql = "SELECT * FROM Item ORDER BY price desc";
		Catalog catalog = new Catalog();
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
				item.setHistoryId(rs.getInt("history"));

				catalog.addVehicles(item);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return catalog.getVehicles();
	}

	public List<Item> sortByPriceASC() {
		String sql = "SELECT * FROM Item ORDER BY price asc";
		Catalog catalog = new Catalog();
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
				item.setHistoryId(rs.getInt("history"));

				catalog.addVehicles(item);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return catalog.getVehicles();
	}

	public List<Item> sortByMileageHTL() {
		String sql = "SELECT * FROM Item ORDER BY mileage desc";
		Catalog catalog = new Catalog();
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
				item.setHistoryId(rs.getInt("history"));

				catalog.addVehicles(item);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return catalog.getVehicles();
	}

	public List<Item> sortByMileageLTH() {
		String sql = "SELECT * FROM Item ORDER BY mileage asc";
		Catalog catalog = new Catalog();
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
				item.setHistoryId(rs.getInt("history"));

				catalog.addVehicles(item);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return catalog.getVehicles();
	}

	public boolean createVehicle(Item item) {
		String createCommand = "INSERT INTO Item (name, description, model, quanitity, price, mileage) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = DatabaseConnection.connect();
				PreparedStatement statement = conn.prepareStatement(createCommand)) {
			statement.setString(1, item.getName());
			statement.setString(2, item.getDescription());
			statement.setString(3, item.getModel());
			statement.setInt(4, item.getQuanitity());
			statement.setInt(5, item.getPrice());
			statement.setInt(6, item.getMileage());

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteVehicle(int vid) {
		String deleteCommand = "DELETE FROM Item WHERE vid = ?";

		try (Connection conn = DatabaseConnection.connect();
				PreparedStatement statement = conn.prepareStatement(deleteCommand)) {
			statement.setInt(1, vid);
			int rowsAffected = statement.executeUpdate();

			// Check if any rows were affected to determine if the deletion was successful
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}