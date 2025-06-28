package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Review;
import com.mas.tytarenko.finalproject.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

  private final ReviewRepository reviewRepository;

  @Override
  public void createReview(Review review) {
    reviewRepository.save(review);
  }
}
