package com.example.ProductFinder.FindProduct.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ProductFinder.FindProduct.Entity.Location;
import com.example.ProductFinder.FindProduct.Service.LocationService;

@Controller
@RequestMapping("/locations/view")
public class LocationViewController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public String showLocationPage(Model model) {
        model.addAttribute("location", new Location());
        model.addAttribute("locations", locationService.getAllLocations());
        return "locations";
    }
}
