package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Item;
import com.mas.tytarenko.finalproject.models.User;
import com.mas.tytarenko.finalproject.models.Wishlist;
import com.mas.tytarenko.finalproject.repositories.WishlistRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

  private final WishlistRepository wishlistRepository;

  @Override
  public void createWishlist(Wishlist wishlist) {
    wishlistRepository.save(wishlist);
  }

  @Override
  public void editWishlist(Wishlist wishlist) {
    wishlistRepository.save(wishlist);
  }

  @Override
  public void removeWishlist(Long id) {
    var wishlist =
        wishlistRepository
            .findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Wishlist not found."));
    wishlistRepository.delete(wishlist);
  }

  @Override
  public List<Item> getItems(Long id) {
    var wishlist =
        wishlistRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Wishlist not found."));
    return wishlist.getItems().stream().toList();
  }

  @Override
  public User getOwner(Long id) {
    var wishlist =
        wishlistRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Wishlist not found."));
    return wishlist.getBuyer();
  }

  public List<Wishlist> getAllWishlists() {
    var wishlist = wishlistRepository.findAll();
    return StreamSupport.stream(wishlist.spliterator(), false).toList();
  }

  public Wishlist getWishlistById(Long id) {
    return wishlistRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Wishlist not found"));
  }
}
