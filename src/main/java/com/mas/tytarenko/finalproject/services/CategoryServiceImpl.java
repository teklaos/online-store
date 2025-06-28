package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Category;
import com.mas.tytarenko.finalproject.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  public void createCategory(Category category) {
    categoryRepository.save(category);
  }
}
