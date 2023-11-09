package business.controller.VehicleCntlr;

import business.model.Vehicle.Item;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import presistence.daoLayer.catalogDAO;

@Path("/items")
public class VehicleCntlr {
	private catalogDAO itemDAO = catalogDAO.getInstance();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Item getPrice(@DefaultValue("1") @PathParam("id") String id) {
		return itemDAO.getVehicleById(id);
	}
}
