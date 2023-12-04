package business.model.Analytics;

import java.util.ArrayList;
import java.util.List;

import business.model.Vehicle.Item;
import presistence.daoLayer.VisitEventDAO;

public class VisitEvent {
	
	VisitEventDAO visitEventDAO = new VisitEventDAO();

	public List<VisitEvent> listAllEvents()
	{
		List<VisitEvent> events = new ArrayList<>();
		return null;
	}
	
	public List<Item> getSoldVehicles()
	{
		return visitEventDAO.getAllVehicleSold();
	}
	
	public List<VisitEvent> getViewedVehicles()
	{
		return null;
	}
	
	public List<VisitEvent> getCartVehicles()
	{
		return null;
	}
	
	public VisitEvent getEventByDays(String day)
	{
		return null;
	}
	
	public VisitEvent getEventsByYear(String year)
	{
		return null;
	}
	
	public VisitEvent getEventByMonth(String month)
	{
		return null;
	}
	
	public void setEvents(String ipAddress, int day, String eventType, int itemId)
	{
		
	}
	
	
}
