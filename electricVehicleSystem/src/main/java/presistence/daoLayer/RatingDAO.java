package presistence.daoLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import business.model.Rating.Rating;
import business.model.Vehicle.Item;
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
}
