package business.controller.CatalogCntlr;

import java.io.IOException;
import java.util.List;

import business.model.Catalog.Catalog;
import business.model.Vehicle.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DealsController
 */
public class DealsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String JSPXFILE = "/index/viewHotDeals.jspx";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Catalog itemModel = new Catalog();
		List<Item> item = itemModel.listDeals();
		request.setAttribute("item", item);

		// Forward the request to the JSP page that will display the item details
		request.getRequestDispatcher(JSPXFILE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
