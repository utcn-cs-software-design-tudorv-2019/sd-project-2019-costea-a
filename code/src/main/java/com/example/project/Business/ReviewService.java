package com.example.project.Business;

import com.example.project.Persistence.Entity.Play;
import com.example.project.Persistence.Entity.Review;
import com.example.project.Persistence.Repo.ReviewRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ReviewService {
        @Inject
        ReviewRepository reviewRepository;

        public List<Review> getAllReviews()
        {
            return reviewRepository.findAll();
        }

        public Review create(Review newReview)
        {
            return reviewRepository.save(newReview);
        }

        public void update(Review newReview, Review oldReview) {
            if (oldReview == null) {
                System.out.println("ERROR! Review does not exist !!!");
            } else {
                newReview.setId(oldReview.getId());
                newReview.setNamePlay(newReview.getNamePlay());
                newReview.setTypePlay(newReview.getTypePlay());
                newReview.setAuthorReview(newReview.getAuthorReview());
                newReview.setTextReview(newReview.getTextReview());

                reviewRepository.save(newReview);
            }
        }

        public void delete(Review review){
            reviewRepository.delete(review);
        }



}
