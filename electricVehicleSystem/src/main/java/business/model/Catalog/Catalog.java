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

	public void addVehicles(Item item) {
		this.vehicles.add(item);
	}

	public List<Item> getVehicles() {
		return this.vehicles;
	}

	public List<Item> sortByPriceAsc() {
		return this.itemDao.sortByPriceASC();
	}

	public List<Item> sortByPriceDesc() {
		return this.itemDao.sortByPriceDESC();
	}

	public List<Item> listVehicles() {
		return this.itemDao.listAllVehicles();
	}

	public List<Item> compareVehicles(String[] cars) {
		return this.itemDao.compareVehicles(cars);
	}

	public List<Item> sortByMileageHTL() {
		return this.itemDao.sortByMileageHTL();
	}

	public List<Item> sortByMileageLTH() {
		return this.itemDao.sortByMileageLTH();
	}

	public Item getVehicleById(String id) {
		return this.itemDao.getVehicleById(id);
	}

	public boolean createNewVehicle(Item item) {
		return this.itemDao.createVehicle(item);
	}

	public boolean deleteVehicle(int vid) {
		return this.itemDao.deleteVehicle(vid);
	}

	public List<Item> filterByModel(String model) {
		return itemDao.filterByModel(model);
	}
}
