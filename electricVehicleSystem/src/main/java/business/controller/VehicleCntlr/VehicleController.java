package business.controller.VehicleCntlr;

import java.io.IOException; 
import business.model.Vehicle.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String JSPXFILE = "/index/oneItem.jspx";
	
	public VehicleController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Item itemModel = new Item();
		String id = request.getParameter("id");
		Item item = itemModel.getVehicleById(id);
		request.setAttribute("item", item);

		// Forward the request to the JSP page that will display the item details
		request.getRequestDispatcher(JSPXFILE).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
