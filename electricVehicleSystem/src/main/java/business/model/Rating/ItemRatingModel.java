package business.model.Rating;

import java.util.List;

import business.model.Rating.Rating;
import presistence.daoLayer.RatingDAO;

public class ItemRatingModel extends Rating {
	private RatingDAO ratingDAO;

	public ItemRatingModel() {
		this.ratingDAO = RatingDAO.getInstance();
	}
	
	public List<Rating> getRatingsByVid(String vid) {
		return this.ratingDAO.listRatingsByVehicle(vid);
	}
}
