package com.example.ProductFinder.FindProduct.Repository;

import com.example.ProductFinder.FindProduct.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
