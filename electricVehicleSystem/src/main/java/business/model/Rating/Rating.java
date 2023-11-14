package business.model.Rating;

import java.util.List;

import presistence.daoLayer.RatingDAO;

public class Rating {
	private int rateId;
	private int rateNum;
	private String reviewDescription;
	private int itemId;
	private int userId;
	private RatingDAO ratingDAO;

	public Rating() {
		this.ratingDAO = RatingDAO.getInstance();
	}

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public int getRateNum() {
		return rateNum;
	}

	public void setRateNum(int rateNum) {
		this.rateNum = rateNum;
	}

	public String getReviewDescription() {
		return reviewDescription;
	}

	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Rating> listRatings() {
		List<Rating> temp = this.ratingDAO.listAllRatings();
		return temp;
	}

}