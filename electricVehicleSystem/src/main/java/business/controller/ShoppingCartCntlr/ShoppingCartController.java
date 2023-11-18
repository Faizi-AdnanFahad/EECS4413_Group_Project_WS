package business.controller.ShoppingCartCntlr;

import java.util.List;

import business.model.ShoppingCart.ShoppingCart;
import business.model.Vehicle.Item;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/cart")
public class ShoppingCartController {
	private ShoppingCart cart = new ShoppingCart();

	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getAllCatalogs(@PathParam("userId") String userId) {
		List<Integer> vids = cart.getAllVidsForUser(Integer.parseInt(userId));
		cart.loadItemsToCatalog(vids);
		return cart.getVehiclesInCart();
	}

	@POST
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean createPlant(@PathParam("userId") String userId, @QueryParam("vid") String vid) {
		ShoppingCart sc = new ShoppingCart();
		return sc.addToCart(Integer.parseInt(userId), Integer.parseInt(vid));
	}
}
