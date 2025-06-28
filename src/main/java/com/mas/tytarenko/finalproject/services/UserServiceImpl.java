package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public void blockUser(Long id) {
    var user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User not found."));
    user.setBlocked(true);
    userRepository.save(user);
  }

  @Override
  public void unblockUser(Long id) {
    var user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User not found."));
    user.setBlocked(false);
    userRepository.save(user);
  }
}
