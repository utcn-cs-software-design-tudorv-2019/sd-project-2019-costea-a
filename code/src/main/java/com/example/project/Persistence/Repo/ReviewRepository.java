package com.example.project.Persistence.Repo;

import com.example.project.Persistence.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
