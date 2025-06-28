package com.mas.tytarenko.finalproject.controllers;

import com.mas.tytarenko.finalproject.services.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsible for handling HTTP requests related to {@code Wishlist} entities.
 *
 * <p>Provides endpoints to:
 *
 * <ul>
 *   <li>List all wishlists
 *   <li>View details of a specific wishlist by its ID
 * </ul>
 *
 * <p>All endpoints are prefixed with {@code /wishlists}. This controller depends on {@link
 * WishlistService} to perform business logic operations related to wishlists.
 */
@Controller
@RequestMapping("/wishlists")
@RequiredArgsConstructor
public class WishlistController {

  private final WishlistService wishlistService;

  @GetMapping
  public String listWishlists(Model model) {
    model.addAttribute("wishlists", wishlistService.getAllWishlists());
    return "wishlist/list";
  }

  @GetMapping("/{id}")
  public String viewWishlist(@PathVariable Long id, Model model) {
    model.addAttribute("wishlists", wishlistService.getAllWishlists());
    model.addAttribute("wishlist", wishlistService.getWishlistById(id));
    return "wishlist/detail";
  }
}
