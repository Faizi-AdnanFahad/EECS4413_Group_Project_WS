package business.controller.VehicleCntlr;

import business.model.Catalog.Catalog;
import business.model.Rating.ItemRatingModel;
import business.model.Vehicle.Item;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/items")
public class VehicleCntlr {
	private Item item = new Item();
	private Catalog catalog = new Catalog();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Item getPrice(@DefaultValue("1") @PathParam("id") String id) {
		return this.item.getVehicleById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Item createPlant(@QueryParam("name") String name, @QueryParam("description") String description,
			@QueryParam("model") String model, @QueryParam("quanitity") String quanitity,
			@QueryParam("price") String price, @QueryParam("mileage") String mileage) {

		Item item = new Item();
		item.setName(name);
		item.setDescription(description);
		item.setModel(model);
		item.setPrice(Integer.parseInt(price));
		item.setQuanitity(Integer.parseInt(quanitity));
		item.setMileage(Integer.parseInt(mileage));
		
		catalog.createNewVehicle(item);
		return item;
	}
	
	@DELETE
	@Path("/{vid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean deletePlant(@PathParam("vid") String vid) {
		return this.catalog.deleteVehicle(Integer.parseInt(vid));
	}
}
