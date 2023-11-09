package business.controller.VehicleComparisionCntlr;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
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
	private final String JSPXFILE = "/index/oneItem.jspx";

	public VehicleComparisionCntlr() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		catalogDAO itemDAO = catalogDAO.getInstance();

//		String id = request.getParameter("id");
//		Item item = itemDAO.getVehicleById(id);
//		request.setAttribute("item", item);
		
		if (MAX_NUM_VEHICLES_TO_COMPARE <= 3) {
			int[] carIDs = {1, 5};
			List<Item> t = itemDAO.compareVehicles(carIDs);
			
			for (int i = 0; i < t.size(); i ++) {
				System.out.println(t.get(i).getVid());
				System.out.println(t.get(i).getName());

			}
		}
		else {
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
