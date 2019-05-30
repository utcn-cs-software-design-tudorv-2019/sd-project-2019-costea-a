package com.example.project.Controller;

import com.example.project.Business.ReviewService;
import com.example.project.Persistence.Entity.Review;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ReviewController {
    @Inject
    ReviewService reviewService;

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public ModelAndView getReviews()
    {
        List<Review> reviewList = reviewService.getAllReviews();

        ModelAndView mav = new ModelAndView("review_view");
        mav.addObject("reviewList", reviewList);
        mav.addObject("newReview", new Review());
        return mav;

    }


    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public ModelAndView postReviews(@RequestParam(value = "action") String action, @ModelAttribute(value = "newReview") Review newReview)
    {
        if(action.equals("Create Review"))
            reviewService.create(newReview);
        else if(action.equals("Update Review"))
            reviewService.update(new Review(), newReview);
        else
            reviewService.delete(newReview);
        return new ModelAndView("redirect:review");
    }
}
