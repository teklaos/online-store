package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.User;

/**
 * Service interface for managing {@link User} entities.
 *
 * <p>Provides functionality to block and unblock users by their unique identifier.
 */
public interface UserService {
  /**
   * Blocks the user with the specified ID.
   *
   * @param id the unique identifier of the user to block
   */
  void blockUser(Long id);

  /**
   * Unblocks the user with the specified ID.
   *
   * @param id the unique identifier of the user to unblock
   */
  void unblockUser(Long id);
}
