package com.bridgelabz.wishlistservice.controller;


import com.bridgelabz.wishlistservice.responsedto.WishlistResponse;
import com.bridgelabz.wishlistservice.service.WishlistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;

    @PostMapping("/wishlist/add")
    public ResponseEntity<WishlistResponse> addToWishlist(@RequestHeader("userId") String authHeader,
                                                          @RequestParam long bookId) {
        Long userId = Long.valueOf(authHeader);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(wishlistService.addToWishlist(userId, bookId));
    }

    @GetMapping("/wishlist")
    public ResponseEntity<List<WishlistResponse>> getWishlist(@RequestHeader("userId") String authHeader) {
        Long userId = Long.valueOf(authHeader);
        List<WishlistResponse> wishlist = wishlistService.getWishlist(userId);
        return ResponseEntity.ok(wishlist);
    }

    @DeleteMapping("/wishlist/remove/{wishlistId}")
    public ResponseEntity<WishlistResponse> removeFromWishlist(@PathVariable Long wishlistId) {

        return ResponseEntity.status(HttpStatus.OK).
                body(wishlistService.removeFromWishlist(wishlistId));
    }

}
