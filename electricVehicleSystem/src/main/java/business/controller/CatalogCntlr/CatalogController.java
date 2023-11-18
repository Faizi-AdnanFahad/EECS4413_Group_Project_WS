package business.controller.CatalogCntlr;

import java.util.List;
import business.model.Catalog.Catalog;
import business.model.Vehicle.Item;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/items")
public class CatalogController {
	private Catalog catalog = new Catalog();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getAllCatalogs() {
		return this.catalog.listVehicles();
	}
}
