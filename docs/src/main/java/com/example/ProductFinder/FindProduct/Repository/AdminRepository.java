package com.example.ProductFinder.FindProduct.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ProductFinder.FindProduct.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}

