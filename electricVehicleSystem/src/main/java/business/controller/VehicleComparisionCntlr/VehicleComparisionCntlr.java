package business.controller.VehicleComparisionCntlr;

import java.io.IOException;
import java.util.List;
import business.model.Vehicle.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import presistence.daoLayer.catalogDAO;

public class VehicleComparisionCntlr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final int MAX_NUM_VEHICLES_TO_COMPARE = 3;
	private final String JSPXFILE = "/index/comparisionView.jspx";

	public VehicleComparisionCntlr() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		catalogDAO itemDAO = catalogDAO.getInstance();

		String compareVehicles = request.getParameter("vehiclesToCompare");

		// Split the string by comma
		String[] compareVehiclesStringArray = compareVehicles.split(",");
//		System.out.println(compareVehiclesStringArray);
		// Create an array of integers
//		int[] intArray = new int[compareVehicles.length()];
//		for (int i = 0; i < compareVehiclesStringArray.length; i++) {
//			// Convert each element to an integer
//			intArray[i] = Integer.parseInt(compareVehiclesStringArray[i].trim());
//		}

		if (MAX_NUM_VEHICLES_TO_COMPARE <= 3) {
			List<Item> items = itemDAO.compareVehicles(compareVehiclesStringArray);
			request.setAttribute("items", items);
			request.getRequestDispatcher(JSPXFILE).forward(request, response);

		} else {
			throw new NoSuchFieldError("Maximum comparable number of vehicles are " + MAX_NUM_VEHICLES_TO_COMPARE);
		}

		// Forward the request to the JSP page that will display the item details
//		request.getRequestDispatcher(JSPXFILE).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
