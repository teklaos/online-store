package com.mas.tytarenko.finalproject.controllers;

import com.mas.tytarenko.finalproject.services.ItemService;
import com.mas.tytarenko.finalproject.services.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsible for handling HTTP requests related to {@code Item} entities.
 *
 * <p>Provides endpoints to:
 *
 * <ul>
 *   <li>List all items
 *   <li>View details of a single item
 *   <li>Display a store view combining items and wishlists
 *   <li>Add an item to a wishlist
 * </ul>
 *
 * <p>All endpoints are prefixed with {@code /items}. This controller relies on {@link ItemService}
 * and {@link WishlistService} for business logic operations.
 */
@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemService;
  private final WishlistService wishlistService;

  @GetMapping
  public String listItems(Model model) {
    model.addAttribute("items", itemService.getItems());
    return "item/list";
  }

  @GetMapping("/{id}")
  public String viewItem(@PathVariable Long id, Model model) {
    model.addAttribute("item", itemService.getItemById(id));
    model.addAttribute("wishlists", wishlistService.getAllWishlists());
    return "item/detail";
  }

  @GetMapping("/store")
  public String showStore(Model model) {
    model.addAttribute("items", itemService.getItems());
    model.addAttribute("wishlists", wishlistService.getAllWishlists());
    return "item/store";
  }

  @PostMapping("/{itemId}/add")
  public String addItemToWishlist(@PathVariable Long itemId, @RequestParam Long wishlistId) {
    itemService.addToWishlist(itemId, wishlistId);
    return "redirect:/items/store";
  }
}
