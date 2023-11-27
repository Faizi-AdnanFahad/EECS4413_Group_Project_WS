package business.model.Catalog;

import java.util.ArrayList;
import java.util.List;

import business.model.Vehicle.Item;
import presistence.daoLayer.ItemDAO;

public class Catalog {
	private List<Item> vehicles;
	private ItemDAO itemDao;

	public Catalog() {
		this.vehicles = new ArrayList<Item>();
		this.itemDao = ItemDAO.getInstance();
	}
	
	// Adds a vehicle to the list of vehicles in the catalog.
	public void addVehicles(Item item) {
		this.vehicles.add(item);
	}

	public List<Item> getVehicles() {
		return this.vehicles;
	}
	
	public List<Item> listVehicles() {
		return this.itemDao.listAllVehicles();
	}

	public List<Item> compareVehicles(String[] cars) {
		return this.itemDao.compareVehicles(cars);
	}

	public Item getVehicleById(String id) {
		return this.itemDao.getVehicleById(id);
	}

	/* Create a new vehicle in the database */
	public boolean createNewVehicle(Item item) {
		return this.itemDao.createVehicle(item);
	}

	public boolean deleteVehicle(int vid) {
		return this.itemDao.deleteVehicle(vid);
	}

    // Filters vehicles by model using ItemDAO given a vehicle brand/model
	public List<Item> filterByModel(String model) {
		return itemDao.filterByModel(model);
	}

	public boolean addVehicleToCart(int userId, int vid) {
		return this.itemDao.insertCartItem(userId, vid);
	}

	public List<Item> listDeals() {
		return this.itemDao.listAllDeals();
	}

	public List<Item> sortBy(String sort) {
		return this.itemDao.sortBy(sort);
	}
}
