package presistence.daoLayer;

import java.sql.Connection; 
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
				item.setVid(rs.getInt("vid"));
				item.setName(rs.getString("name"));
				item.setDescription(rs.getString("description"));
				item.setModel(rs.getString("model"));
				item.setQuanitity(rs.getInt("quanitity"));
				item.setPrice(rs.getInt("price"));
				item.setMileage(rs.getInt("mileage"));
				item.setMileage(rs.getInt("history"));
			
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return item;
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

}
