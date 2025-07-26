package com.example.ProductFinder.FindProduct.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ProductFinder.FindProduct.Entity.Feedback;
import com.example.ProductFinder.FindProduct.Service.FeedbackService;
import org.springframework.ui.Model;

@Controller
public class FeedbackController {

	    @Autowired
	    private FeedbackService feedbackService;
 
	    @GetMapping("/feedback")
	    public String showFeedbackForm(Model model) {
	        model.addAttribute("feedback", new Feedback());
	        return "feedback";
	    }

	    @PostMapping("/feedback")
	    public String submitFeedback(@ModelAttribute Feedback feedback, Model model) {
	        feedbackService.saveFeedback(feedback);
	        model.addAttribute("success", "Thank you for your feedback!");
	        model.addAttribute("feedback", new Feedback());
	        return "feedback";
	    }
	    
	    @GetMapping("/admin/feedbacks")
	    public String viewAllFeedbacks(Model model) {
	        List<Feedback> feedbackList = feedbackService.getAllFeedback();
	        model.addAttribute("feedbacks", feedbackList);
	        return "adminfeedback";
	    }

	}
