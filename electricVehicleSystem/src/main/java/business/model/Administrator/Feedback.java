package business.model.Administrator;

import java.util.List;

import presistence.daoLayer.UserDAO;

public class Feedback {
	private String feedback;
	private UserDAO userDAO;
	private int userId;
	
	public Feedback(String Feedback,int userId) {
		super();
		this.feedback=Feedback;
		this.userId = userId;
	}
	
	public Feedback() {
		this.userDAO=UserDAO.getInstance();
	}
	
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public List<Feedback> listFeedbacks(){
		List<Feedback> temp=this.userDAO.listAllFeedback();
		return temp;
	}

}
