package business.controller.VehicleCntlr;

import java.io.IOException;

import business.model.Vehicle.Item;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import presistence.daoLayer.catalogDAO;

public class VehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VehicleController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        ServletContext context = getServletContext();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		catalogDAO itemDAO = new catalogDAO();
		
	    String id = request.getParameter("id");
		Item item = itemDAO.getVehicleById(id);
        request.setAttribute("item", item);

        // Forward the request to the JSP page that will display the item details
        request.getRequestDispatcher("/index/oneItem.jspx").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
