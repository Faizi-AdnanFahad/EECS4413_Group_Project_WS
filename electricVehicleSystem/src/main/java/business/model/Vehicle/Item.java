package business.model.Vehicle;

import presistence.daoLayer.ItemDAO;

public class Item {
	private int vid;
	private String name;
	private String description;
	private String model;
	private int quanitity;
	private int price;
	private int mileage;
	private int historyId;
	private ItemDAO itemDao;
	private String interiorColor;
	private int discount=10;

	public Item() {
		this.itemDao = ItemDAO.getInstance();
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getQuanitity() {
		return quanitity;
	}

	public void setQuanitity(int quanitity) {
		this.quanitity = quanitity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public Item getVehicleById(String id) {
		return this.itemDao.getVehicleById(id);
	}

	public Item customizeInteriorColour(String color, int id) {
		return this.itemDao.updateInteriorColour(color, id);
	}

	public void customizeExteriorColour(String id, String newColour) {
		// TBD
	}

	public void customizeFabric(String id, String newFabric) {
		// TBD
	}

	public String getInteriorColor() {
		return interiorColor;
	}

	public void setInteriorColor(String interiorColor) {
		this.interiorColor = interiorColor;
	}
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount+5;
	}
}
