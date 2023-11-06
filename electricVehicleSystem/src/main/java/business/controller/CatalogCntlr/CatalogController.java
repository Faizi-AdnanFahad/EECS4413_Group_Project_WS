package business.controller.CatalogCntlr;

import jakarta.ws.rs.*;  

import jakarta.ws.rs.core.MediaType;
import presistence.daoLayer.ItemDAO;

import java.util.List;

import business.model.Catalog.Catalog;

@Path("/items")
public class CatalogController {
	private ItemDAO catalogDAO = new ItemDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Catalog> getAllCatalogs() {
		return catalogDAO.readAll();
	}
}

