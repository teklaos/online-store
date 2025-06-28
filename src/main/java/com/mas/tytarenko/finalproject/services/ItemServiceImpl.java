package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Item;
import com.mas.tytarenko.finalproject.models.Wishlist;
import com.mas.tytarenko.finalproject.repositories.ItemRepository;
import com.mas.tytarenko.finalproject.repositories.WishlistRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

  private final ItemRepository itemRepository;
  private final WishlistRepository wishlistRepository;

  @Override
  public void createItem(Item item) {
    itemRepository.save(item);
  }

  @Override
  public void editItem(Item item) {
    itemRepository.save(item);
  }

  @Override
  public void removeItem(Long id) {
    var item =
        itemRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Item not found."));
    itemRepository.delete(item);
  }

  @Override
  public Item getItemById(Long id) {
    return itemRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Item not found."));
  }

  @Override
  public List<Item> getItems() {
    var items = itemRepository.findAll();
    return StreamSupport.stream(items.spliterator(), false).toList();
  }

  @Override
  public List<Wishlist> getWishlists(Long id) {
    var item =
        itemRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Item not found."));
    return item.getWishlists().stream().toList();
  }

  @Override
  public void addToWishlist(Long itemId, Long wishlistId) {
    var item =
        itemRepository
            .findById(itemId)
            .orElseThrow(() -> new EntityNotFoundException("Item not found."));
    var wishlist =
        wishlistRepository
            .findById(wishlistId)
            .orElseThrow(() -> new EntityNotFoundException("Wishlist not found."));
    if (wishlist.getItems().add(item)) {
      item.getWishlists().add(wishlist);
      wishlistRepository.save(wishlist);
      itemRepository.save(item);
    }
  }
}
