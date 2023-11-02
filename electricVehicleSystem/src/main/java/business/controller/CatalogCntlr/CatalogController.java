package business.controller.CatalogCntlr;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import presistence.daoLayer.CatalogDAO;
import java.util.List;
import business.model.Vehicle.Item;

@Path("/items")
public class CatalogController {
	private CatalogDAO studentDAO = new CatalogDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getAllStudents() {
		return studentDAO.readAll();
	}
}
