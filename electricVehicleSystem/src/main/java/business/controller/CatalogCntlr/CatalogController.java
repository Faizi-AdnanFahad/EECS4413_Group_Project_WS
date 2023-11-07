package business.controller.CatalogCntlr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import business.model.Catalog.Catalog;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import presistence.daoLayer.ItemDAO;

@Path("/items")
public class CatalogController {
	private ItemDAO itemDAO = new ItemDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Catalog> getAllCatalogs() {
		return itemDAO.readAll();
	}
	@GET
    @Path("/sort")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Catalog> sortByPrice() {
        List<Catalog> catalogList = itemDAO.readAll();
        catalogList.sort(Comparator.comparing(Catalog::getPrice));
        return catalogList;
    }
	
	@GET
	@Path("/filter/{model}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Catalog> filterByModel(@PathParam("model") String model) {
	    List<Catalog> catalogList = itemDAO.readAll();
	    List<Catalog> filteredCatalogList = new ArrayList<>();

	    for (Catalog catalog : catalogList) {
	        if (catalog.getModel().equalsIgnoreCase(model)) {
	            filteredCatalogList.add(catalog);
	        }
	    }

	    return filteredCatalogList;
	}
}

