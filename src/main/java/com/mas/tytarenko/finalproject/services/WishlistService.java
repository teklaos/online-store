package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Item;
import com.mas.tytarenko.finalproject.models.User;
import com.mas.tytarenko.finalproject.models.Wishlist;
import java.util.List;

/**
 * Service interface for managing {@link Wishlist} entities.
 *
 * <p>Provides methods to create, edit, remove, and retrieve wishlists, as well as accessing
 * associated items and their owners.
 */
public interface WishlistService {

  /**
   * Creates and persists a new wishlist.
   *
   * @param wishlist the wishlist to create
   */
  void createWishlist(Wishlist wishlist);

  /**
   * Updates an existing wishlist.
   *
   * @param wishlist the wishlist to update
   */
  void editWishlist(Wishlist wishlist);

  /**
   * Removes a wishlist by its unique identifier.
   *
   * @param id the unique identifier of the wishlist to remove
   */
  void removeWishlist(Long id);

  /**
   * Retrieves a wishlist by its unique identifier.
   *
   * @param id the unique identifier of the wishlist to retrieve
   * @return the wishlist with the specified id
   */
  Wishlist getWishlistById(Long id);

  /**
   * Retrieves all wishlists.
   *
   * @return a list of all wishlists
   */
  List<Wishlist> getAllWishlists();

  /**
   * Retrieves the list of items associated with a given wishlist.
   *
   * @param id the unique identifier of the wishlist
   * @return a list of items in the wishlist
   */
  List<Item> getItems(Long id);

  /**
   * Retrieves the owner of a wishlist.
   *
   * @param id the unique identifier of the wishlist
   * @return the user who owns the wishlist
   */
  User getOwner(Long id);
}
