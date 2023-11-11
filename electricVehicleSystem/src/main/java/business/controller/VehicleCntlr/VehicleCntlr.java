package business.controller.VehicleCntlr;

import business.model.Vehicle.Item;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/items")
public class VehicleCntlr {
	private Item item = new Item();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Item getPrice(@DefaultValue("1") @PathParam("id") String id) {
		return this.item.getVehicleById(id);
	}
}
