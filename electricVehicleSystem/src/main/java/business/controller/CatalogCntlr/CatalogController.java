package business.controller.CatalogCntlr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import business.model.Catalog.Catalog;
import business.model.Vehicle.Item;
import jakarta.websocket.server.PathParam;
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
    @Path("sortASC")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> sortByPrice() {
		
		 return itemDAO.sortByPriceAsc();
    }
	
	@GET
    @Path("sortDESC")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> sortByPriceDESC() {
		
		 return itemDAO.sortByPriceDESC();
    }
	
	@GET
    @Path("/filter/Tesla")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> filterByBrands1(String model) {
		model="Tesla";
		 return itemDAO.filter_tesla(model);
    }
	
	@GET
    @Path("/filter/Toyota")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> filterByBrands2(String model) {
		model="Toyota";
		 return itemDAO.filter_toyota(model);
    }
	
	@GET
    @Path("/filter/BYD")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> filterByBrands3(String model) {
		model="BYD";
		 return itemDAO.filter_BYD(model);
    }
	
	@GET
    @Path("/filter/KIA")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> filterByBrands4(String model) {
		model="KIA";
		 return itemDAO.filter_KIA(model);
    }
	
//	@GET
//	@Path("/filter/{model}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Item> filterByModel(@PathParam("model") String model) {
//	    List<Item> catalogList = itemDAO.listAllVehicles();
//	    List<Item> filteredCatalogList = new ArrayList<>();
//
//	    for (Item catalog : catalogList) {
//	        if (catalog.getName().equalsIgnoreCase(model)) {
//	        	Item item = new Item();
//				item.setVid(catalog.getVid());
//				item.setName(catalog.getName());
//				item.setDescription(catalog.getDescription());
//				item.setModel(catalog.getModel());
//				item.setQuanitity(catalog.getQuanitity());
//				item.setPrice(catalog.getPrice());
//				item.setMileage(catalog.getMileage());
//				item.setHistoryId(catalog.getHistoryId());
//				
//				catalog.addVehicles(item);
//	        }
//	    }
//
//	    return filteredCatalogList;
//	}
}

