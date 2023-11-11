package business.controller.CatalogCntlr;

import java.util.List;
import business.model.Vehicle.Item;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import presistence.daoLayer.catalogDAO;

@Path("/items")
public class CatalogCntlr {
	private catalogDAO itemDAO = catalogDAO.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getAllCatalogs() {
		return itemDAO.listAllVehicles();
	}
	
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
	
//	// SORT BASED ON A QUERY PARAMETER e.g., sortByPrice=true
//	@GET
//    @Path("?sortByPrice=true")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Item> sortByPrice() {
//        List<Item> catalogList = itemDAO.sortByPrice();
//        return catalogList;
//    }
//	
	
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

