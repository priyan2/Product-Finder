package com.example.ProductFinder.FindProduct.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductFinder.FindProduct.Entity.Feedback;
import com.example.ProductFinder.FindProduct.Repository.FeedbackRepository;
import com.example.ProductFinder.FindProduct.Service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

 @Autowired
 private FeedbackRepository feedbackRepository;

	 @Override
	 public Feedback saveFeedback(Feedback feedback) {
	     return feedbackRepository.save(feedback);
	 }
 
	 public List<Feedback> getAllFeedback() {
	     return feedbackRepository.findAll();
	 }
}
