package business.controller.AdministratorCntlr;

import java.io.IOException;
import java.io.PrintWriter;

import business.model.Administrator.Administrator;
import business.model.Administrator.Feedback;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FeedbackController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String feedback = (String) request.getParameter("feedback");
		System.out.println(feedback);
		if (session.getAttribute("userId") == null) { // if user is not logged in, redirect it to the login page
			response.sendRedirect("index/SignInView.html");
		} else {
			// create the feedback and redirect back to the same page
			int userId = (int) session.getAttribute("userId");
			Feedback newFeedback = new Feedback(feedback, userId);
			Administrator admin = new Administrator();
			admin.postNewFeedback(newFeedback);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Feedback saved successfully!');");
			out.println("location='" + request.getContextPath() + "';");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
