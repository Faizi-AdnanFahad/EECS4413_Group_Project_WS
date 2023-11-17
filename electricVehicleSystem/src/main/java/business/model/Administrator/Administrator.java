package business.model.Administrator;

import java.util.List;
import presistence.daoLayer.UserDAO;

public class Administrator extends Feedback{
	private UserDAO userDAO;

	public Administrator() {
		this.userDAO = UserDAO.getInstance();
	}

	public boolean postNewFeedback(Feedback feedback) {
		return this.userDAO.postFeedback(feedback);
	}
}
