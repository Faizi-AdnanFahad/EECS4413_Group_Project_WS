package business.model.Catalog;

import java.util.ArrayList;
import java.util.List;

import business.model.Vehicle.Item;
import presistence.daoLayer.catalogDAO;

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
		catalogDAO c=new catalogDAO();
		
		return c.sortByPriceAsc();
	}
	
}
