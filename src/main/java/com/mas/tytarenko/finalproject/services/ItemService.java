package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Item;
import com.mas.tytarenko.finalproject.models.Wishlist;
import java.util.List;

/**
 * Service interface for managing {@link Item} entities.
 *
 * <p>Provides operations for creating, editing, removing, and retrieving items, as well as managing
 * their association with {@link Wishlist} entities.
 */
public interface ItemService {
  /**
   * Creates and persists a new item.
   *
   * @param item the item to be created
   */
  void createItem(Item item);

  /**
   * Updates an existing item.
   *
   * @param item the item with updated data
   */
  void editItem(Item item);

  /**
   * Removes an item by its ID.
   *
   * @param id the ID of the item to remove
   */
  void removeItem(Long id);

  /**
   * Retrieves an item by its ID.
   *
   * @param id the ID of the item
   * @return the item with the given ID
   */
  Item getItemById(Long id);

  /**
   * Retrieves all items.
   *
   * @return a list of all items
   */
  List<Item> getItems();

  /**
   * Adds an item to a wishlist.
   *
   * @param itemId the ID of the item to add
   * @param wishlistId the ID of the wishlist to which the item will be added
   */
  void addToWishlist(Long itemId, Long wishlistId);

  /**
   * Retrieves all wishlists that include a specific item.
   *
   * @param id the ID of the item
   * @return a list of wishlists containing the item
   */
  List<Wishlist> getWishlists(Long id);
}
