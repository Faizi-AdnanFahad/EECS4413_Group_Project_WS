package business.controller.UserCntlr;

import java.io.IOException;

import business.model.User.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import presistence.daoLayer.UserDAO;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user = new User();
	
    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
				
		String op = (String) request.getParameter("op");
		int operation = Integer.parseInt(op);
		
		if(operation == 0)
		{
			String email, password;
			email = (String) request.getParameter("username");
			password = (String) request.getParameter("password");
			
			User user = this.user.getByUsername(email);
		    
		    if (user != null && (user.getPassword().equals(password))) 
		    {
		    	session.setAttribute("id", user.getId());
		    	System.out.println(session.getAttribute("id"));
		    	response.sendRedirect("index/allItems.jspx");
		    	
		    } 
		    else 
		    {
		    	response.sendRedirect("index/SignInView.html");
		    }
		}
		else if(operation == 1)
		{
			String firstname, lastname, email, password, type;
			
			firstname = (String) request.getParameter("firstName");
			lastname = (String) request.getParameter("lastName");
			email = (String) request.getParameter("email");
			password = (String) request.getParameter("password");
			type = "normal";
			
			User user = new User(firstname,lastname,email,password,type);
			boolean isCreated = this.user.CreateUser(user);
			
			if(isCreated)
			{
				//request.getRequestDispatcher("/index/SignInView.html").forward(request, response);
				response.sendRedirect("index/SignInView.html");
			}
			else
			{
				response.sendRedirect("index/SignUpView.html");
			}
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


