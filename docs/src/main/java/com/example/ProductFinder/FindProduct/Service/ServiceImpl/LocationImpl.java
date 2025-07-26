package com.example.ProductFinder.FindProduct.Service.ServiceImpl;
import com.example.ProductFinder.FindProduct.Entity.Location;
import com.example.ProductFinder.FindProduct.Repository.LocationRepository;
import com.example.ProductFinder.FindProduct.Service.LocationService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(int id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public Location updateLocation(int id, Location newLocation) {
        Location existing = getLocationById(id);
        if (existing != null) {
            existing.setSection(newLocation.getSection());
            existing.setShelf(newLocation.getShelf());
            existing.setAisle(newLocation.getAisle());
            return locationRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteLocation(int id) {
        locationRepository.deleteById(id);
    }

}
