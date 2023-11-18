package business.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

import business.model.Catalog.Catalog;
import business.model.Vehicle.Item;
import presistence.daoLayer.CartDAO;

public class ShoppingCart {
	private Catalog catalog;
	private List<Item> vehiclesInCart;
	private CartDAO cartDAO;

	public ShoppingCart() {
		this.catalog = new Catalog();
		this.vehiclesInCart = new ArrayList<Item>();
		this.cartDAO = CartDAO.getInstance();
	}

	public void loadItemsToCatalog(List<Integer> vids) {
		List<Item> itemsInCatalog = this.catalog.listVehicles();
		this.vehiclesInCart = new ArrayList<>();

		for (Item item : itemsInCatalog) {
			// Check if the vid of the item is in the vids list
			if (vids.contains(item.getVid())) {
				this.vehiclesInCart.add(item);
			}
		}
	}

	public List<Item> getVehiclesInCart() {
		return this.vehiclesInCart;
	}

	public boolean addToCart(int userId, int vid) {
		return this.catalog.addVehicleToCart(userId, vid);
	}

	public List<Integer> getAllVidsForUser(int userId) {
		return this.cartDAO.getVehiclesInCart(userId);
	}

}
