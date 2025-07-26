package com.example.ProductFinder.FindProduct.Service;

import java.util.List;

import com.example.ProductFinder.FindProduct.Entity.Location;

public interface LocationService {
	
		Location addLocation(Location location);
	    List<Location> getAllLocations();
	    Location getLocationById(int id);
	    Location updateLocation(int id, Location newLocation);
	    void deleteLocation(int id);
		
}
