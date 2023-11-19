package business.controller.VehicleComparisionCntlr;

import java.io.IOException;
import java.util.List;
import business.model.Catalog.Catalog;
import business.model.Vehicle.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VehicleComparisionCntlr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Catalog catalog = new Catalog();
	private final int MAX_NUM_VEHICLES_TO_COMPARE = 3;
	private final String JSPXFILE = "/index/comparisionView.jspx";
	
	public VehicleComparisionCntlr() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String compareVehicles = request.getParameter("vehiclesToCompare");

		// Split the string by comma
		String[] compareVehiclesStringArray = compareVehicles.split(",");
		
		if (MAX_NUM_VEHICLES_TO_COMPARE <= 3) {
			List<Item> items = this.catalog.compareVehicles(compareVehiclesStringArray);
			// store the list of items in the response object to be able to use in the jsp file
			request.setAttribute("items", items);
			request.getRequestDispatcher(JSPXFILE).forward(request, response);

		} else {
			// server side error handlign
			throw new NoSuchFieldError("Maximum comparable number of vehicles are " + MAX_NUM_VEHICLES_TO_COMPARE);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}