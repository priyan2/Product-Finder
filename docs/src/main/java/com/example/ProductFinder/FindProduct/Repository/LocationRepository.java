package com.example.ProductFinder.FindProduct.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ProductFinder.FindProduct.Entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}