package com.example.ProductFinder.FindProduct.Service;

import java.util.List;

import com.example.ProductFinder.FindProduct.Entity.Feedback;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);
    
   List<Feedback> getAllFeedback();

}
