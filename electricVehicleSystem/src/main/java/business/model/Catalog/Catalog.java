package business.model.Catalog;

import java.util.ArrayList;
import java.util.List;

import business.model.Vehicle.Item;

public class Catalog {
	private List<Item> vehicles;
	
	public Catalog() {
		this.vehicles = new ArrayList<Item>();
	}

	public void addVehicles(Item item) {
		this.vehicles.add(item);
	}
	
	public List<Item> getVehicles() {
		return this.vehicles;
	}
	
	public List<Item> sortByPriceAsc() {
		// implement the sort here and call the catalogDAO.sortByPriceAsc to perform the sort query
		return this.vehicles;
	}
	
}
