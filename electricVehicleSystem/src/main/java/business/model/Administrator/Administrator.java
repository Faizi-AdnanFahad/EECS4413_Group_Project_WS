package business.model.Administrator;

import presistence.daoLayer.UserDAO;

public class Administrator extends Feedback{
	public Administrator(String Feedback) {
		super(Feedback);
		// TODO Auto-generated constructor stub
	}

	private UserDAO user;
	
//	public Administrator() {
//		this.user=UserDAO.getInstance();
//	}
	
	public boolean postFeedback(String feedback) {
		return this.user.addFeedback(feedback);
	}

}
