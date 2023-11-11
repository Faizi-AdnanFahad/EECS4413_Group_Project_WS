package presistence.daoLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import business.model.Catalog.Catalog;
import business.model.Vehicle.Item;
import presistence.DatabaseConnection;

public class catalogDAO {

	/* Singleton Design Pattern */
	private static catalogDAO instance;

	private catalogDAO() {

	}

	public static catalogDAO getInstance() {
		if (instance == null) {
			instance = new catalogDAO();
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

	public List<Item> sortByPriceAsc() {
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
				item.setMileage(rs.getInt("history"));
				
				catalog.addVehicles(item);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return catalog.getVehicles();
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
				item.setMileage(rs.getInt("history"));
				
				catalog.addVehicles(item);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return catalog.getVehicles();
	}

	public List<Item> filter_tesla(String m) {
//		m="Tesla";		 
		String sql = String.format("Select * from Item Where name=\"%s\"",m);
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
					item.setMileage(rs.getInt("history"));
					
					catalog.addVehicles(item);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return catalog.getVehicles();
		
	}

	public List<Item> filter_toyota(String model) {
		String sql = String.format("Select * from Item Where name=\"%s\"",model);
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
					item.setMileage(rs.getInt("history"));
					
					catalog.addVehicles(item);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return catalog.getVehicles();
	}

	public List<Item> filter_BYD(String model) {
		String sql = String.format("Select * from Item Where name=\"%s\"",model);
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
					item.setMileage(rs.getInt("history"));
					
					catalog.addVehicles(item);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return catalog.getVehicles();
	}

	public List<Item> filter_KIA(String model) {
		String sql = String.format("Select * from Item Where name=\"%s\"",model);
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
					item.setMileage(rs.getInt("history"));
					
					catalog.addVehicles(item);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return catalog.getVehicles();
	}

//	public List<Item> sortByPrice() {
//		String sql = "SELECT vid, name, model, price, mileage FROM Item ORDER BY price asc";
//
//		Catalog catalog = new Catalog();
//
//		try (Connection conn = DatabaseConnection.connect();
//				Statement stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery(sql)) {
//
//			while (rs.next()) {
//				Item item = new Item();
//				item.setVid(rs.getInt("vid"));
//				item.setName(rs.getString("name"));
//				item.setModel(rs.getString("model"));
//				item.setPrice(rs.getInt("price"));
//				item.setMileage(rs.getInt("mileage"));
//
//				// add items to the catalog
//				catalog.addVehicles(item);
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		return catalog.getVehicles();
//	}

	
}
