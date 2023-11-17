package business.controller.AdministratorCntlr;

import java.io.IOException;
import java.io.PrintWriter;

import business.model.Administrator.Administrator;
import business.model.Administrator.Feedback;
import business.model.Rating.Rating;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class FeedbackController
 */
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String feedback = (String) request.getParameter("feedback");
		
		if (session.getAttribute("userId") == null) { // if user is not logged in, redirect it to the login page
			response.sendRedirect("index/SignInView.html");
		} else {
			// create the feedback and redirect back to the same page
			int userId = (int) session.getAttribute("userId");
			Feedback newFeedback= new Feedback(feedback,userId);
			Administrator admin=new Administrator();
			admin.postNewFeedback(newFeedback);
			out.println("<script type=\"text/javascript\">");
            out.println("alert('Feedback saved successfully!');");
            out.println("location='" + request.getContextPath() + "';");
            out.println("</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
