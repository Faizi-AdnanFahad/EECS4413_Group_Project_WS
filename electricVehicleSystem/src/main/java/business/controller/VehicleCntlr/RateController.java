package business.controller.VehicleCntlr;

import java.io.IOException;
import business.model.Rating.ItemRatingModel;
import business.model.Rating.Rating;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RateController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// retrieve information from the query parameters passed by the user
		int vid = Integer.parseInt(request.getParameter("vid"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		String comment = (String) request.getParameter("comment");
		
		
		if (session.getAttribute("userId") == null) { // if user is not logged in, redirect it to the login page
			response.sendRedirect("index/SignInView.html");
		} else {
			// create the rating and redirect back to the same page
			int userId = (int) session.getAttribute("userId");
			Rating newRating = new Rating(rating, comment, vid, userId);
			ItemRatingModel irm = new ItemRatingModel();
			irm.postNewRating(newRating);
			response.sendRedirect("http://localhost:8080/electricVehicleSystem/VehicleController?id=" + vid);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}