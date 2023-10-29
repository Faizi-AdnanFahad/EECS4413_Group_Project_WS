package controller.CatalogCntlr;

import jakarta.ws.rs.*;

import jakarta.ws.rs.core.MediaType;
import model.Item;
import presistence.daoLayer.*;

import java.util.List;


@Path("/items")
public class CatalogController {
	private CatalogDAO catalogDAO = new CatalogDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getAllStudents() {
		return catalogDAO.readAll();
	}
}
