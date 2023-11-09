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

public class catalogDAO {
	public List<Item> listAllVehicles() {
		String sql = "SELECT * FROM Item";
		
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
	
}

