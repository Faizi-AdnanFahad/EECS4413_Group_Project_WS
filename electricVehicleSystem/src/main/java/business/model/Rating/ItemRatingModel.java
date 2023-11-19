package business.model.Rating;

import java.util.List;

import presistence.daoLayer.RatingDAO;

public class ItemRatingModel extends Rating {
	private RatingDAO ratingDAO;

	public ItemRatingModel() {
		this.ratingDAO = RatingDAO.getInstance();
	}

	public List<Rating> getRatingsByVid(String vid) {
		return this.ratingDAO.listRatingsByVehicle(vid);
	}

	// creates a new rating in the db
	public boolean postNewRating(Rating rating) {
		return this.ratingDAO.postRating(rating);
	}
	
	public boolean deleteRating(int idInt) {
		return this.ratingDAO.deleteRating(idInt);
	}
}
