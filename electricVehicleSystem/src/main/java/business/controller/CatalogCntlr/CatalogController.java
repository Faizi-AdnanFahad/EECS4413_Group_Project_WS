package business.controller.CatalogCntlr;

import java.util.List;
import business.model.Catalog.Catalog;
import business.model.Rating.ItemRatingModel;
import business.model.Rating.Rating;
import business.model.Vehicle.Item;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/items")
public class CatalogController {
	private Catalog catalog = new Catalog();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getAllCatalogs() {
		return this.catalog.listVehicles();
	}
	
	@GET
	@Path("Deals")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getDeals() {
		return this.catalog.listDeals();
	}
	
	@GET
	@Path("/sort")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> sortByP(@PathParam("sort") String sort, @QueryParam("sorting") String sorting) {

		return this.catalog.sortBy(sorting);
	}
	

	@GET
	@Path("/filter")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> filterByModel(@PathParam("filter") String filter, @QueryParam("model") String model) {
		String capitalized = capitalizeFirstLetter(model);

		return catalog.filterByModel(capitalized);
	}
	
	/*
	 * Given a string, capitalizes and returns the capitalized string.
	 */
	private static String capitalizeFirstLetter(String input) {
		if (input == null || input.isEmpty()) {
			return input; // Return unchanged if input is null or empty
		}

		// Capitalize the first letter and append the rest of the string
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}
}
