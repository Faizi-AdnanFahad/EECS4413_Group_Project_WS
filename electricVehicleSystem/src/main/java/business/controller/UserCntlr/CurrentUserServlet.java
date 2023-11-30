package business.controller.UserCntlr;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.model.Analytics.Analytics;
import business.model.Catalog.Catalog;

import business.model.User.User;
import jakarta.servlet.http.HttpSession;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class CurrentUserServlet
 */

@WebServlet("/getCurrentUser")
public class CurrentUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Get the session from the request
        HttpSession session = request.getSession();
        
        // Retrieve a value from the session
        String userId = (String) session.getAttribute("userId");
        
        // Do something with the value
        if (userId != null) {
            System.out.println("userId from session: " + userId);
        } else {
            System.out.println("userId not found in session.");
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
