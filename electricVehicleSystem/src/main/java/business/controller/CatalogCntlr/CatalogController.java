package business.controller.CatalogCntlr;

import java.util.List;
import business.model.Vehicle.Item;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import presistence.daoLayer.catalogDAO;

@Path("/items")
public class CatalogController {
	private catalogDAO itemDAO = new catalogDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getAllCatalogs() {
		return itemDAO.listAllVehicles();
	}
	
	// SORT BASED ON A QUERY PARAMETER e.g., sortByPrice=true
	@GET
    @Path("sort")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> sortByPrice() {
		
		 return itemDAO.sortByPriceAsc();
    }
	
	
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

