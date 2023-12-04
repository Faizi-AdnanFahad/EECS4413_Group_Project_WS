package presistence.daoLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.model.Vehicle.Item;
import presistence.DatabaseConnection;

public class VisitEventDAO {
	
	public List<Item> getAllVehicleSold()
	{
		String sql = "SELECT itemid FROM PurchaseOrderItem";
		
		List<Item> itemsSold = new ArrayList<>();
		List<Integer> itemIds = new ArrayList<>();
		
		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) 
			{
				itemIds.add(rs.getInt("itemid"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		for(int i = 0; i < itemIds.size();i++)
		{
			sql = "SELECT * FROM Item WHERE vid=" + itemIds.get(i);
			
			try (Connection conn = DatabaseConnection.connect();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql)) {

				while (rs.next()) 
				{
					Item newItem = new Item();
					newItem.setVid(rs.getInt("vid"));
					newItem.setName(rs.getString("name"));
					newItem.setDescription(rs.getString("description"));
					newItem.setModel(rs.getString("model"));
					newItem.setPrice(rs.getInt("price"));
					newItem.setMileage(rs.getInt("mileage"));
					itemsSold.add(newItem);
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return itemsSold;
	}
	

}
