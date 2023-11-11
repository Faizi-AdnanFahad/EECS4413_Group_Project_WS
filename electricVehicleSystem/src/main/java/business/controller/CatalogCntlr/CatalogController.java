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

	// SORT BASED ON A QUERY PARAMETER e.g., sortByPrice=true
//	@GET
//	@Path("?sortByPrice=true")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Item> sortByPrice() {
//
//		List<Item> catalogList = itemDAO.listAllVehicles();
//		// call relevant model
////        catalogList.sort(Comparator.comparing(Item::getPrice));
//		return catalogList;
//	}

//	@GET
//	@Path("/filter/{model}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Catalog> filterByModel(@PathParam("model") String model) {
//	    List<Catalog> catalogList = itemDAO.readAll();
//	    List<Catalog> filteredCatalogList = new ArrayList<>();
//
//	    for (Catalog catalog : catalogList) {
//	        if (catalog.getModel().equalsIgnoreCase(model)) {
//	            filteredCatalogList.add(catalog);
//	        }
//	    }
//
//	    return filteredCatalogList;
//	}
}
