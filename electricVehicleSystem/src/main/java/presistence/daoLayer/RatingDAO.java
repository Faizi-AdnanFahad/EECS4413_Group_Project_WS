package presistence.daoLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import business.model.Rating.Rating;
import presistence.DatabaseConnection;

public class RatingDAO {

	/* Singleton Design Pattern */
	private static RatingDAO instance;

	private RatingDAO() {

	}

	public static RatingDAO getInstance() {
		if (instance == null) {
			instance = new RatingDAO();
		}
		return instance;
	}
	
	/*
	 * Get a list of all ratings in the database
	 */
	public List<Rating> listAllRatings() {
		String sql = "SELECT id AS rateID, rateNum, reviewDescription, itemId, userId FROM Rating";

		List<Rating> allRatings = new ArrayList<>();
		
		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Rating rating = new Rating();
				rating.setRateId(rs.getInt("rateID"));
				rating.setRateNum(rs.getInt("rateNum"));
				rating.setReviewDescription(rs.getString("reviewDescription"));
				rating.setItemId(rs.getInt("itemId"));
				rating.setUserId(rs.getInt("userId"));

				allRatings.add(rating);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return allRatings;
	}
	
	/*
	 * Lists all rating in the database
	 */
	public List<Rating> listRatingsByVehicle(String vid) {
		String sql = "SELECT id AS rateID, rateNum, reviewDescription, itemId, userId FROM Rating WHERE itemId=" + vid;

		List<Rating> allRatings = new ArrayList<>();
		
		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Rating rating = new Rating();
				rating.setRateId(rs.getInt("rateID"));
				rating.setRateNum(rs.getInt("rateNum"));
				rating.setReviewDescription(rs.getString("reviewDescription"));
				rating.setItemId(rs.getInt("itemId"));
				rating.setUserId(rs.getInt("userId"));

				allRatings.add(rating);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return allRatings;
	}
	
	/*
	 * Create a new rating in the database
	 */
	public boolean postRating(Rating rating) {
		String createCommand = "INSERT INTO Rating (rateNum,reviewDescription,itemId,userId) VALUES (?,?,?,?)";
		try (Connection conn = DatabaseConnection.connect();
				PreparedStatement statement = conn.prepareStatement(createCommand)) {
			statement.setInt(1, rating.getRateNum());
			statement.setString(2, rating.getReviewDescription());
			statement.setInt(3, rating.getItemId());
			statement.setInt(4, rating.getUserId());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean deleteRating(int rateId) {
	    String deleteCommand = "DELETE FROM Rating WHERE id = ?";
	    
	    try (Connection conn = DatabaseConnection.connect();
	         PreparedStatement statement = conn.prepareStatement(deleteCommand)) {
	        statement.setInt(1, rateId);
	        int rowsAffected = statement.executeUpdate();

	        // Check if any rows were affected to determine if the deletion was successful
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        return false;
	    }
	}
	
	
}
