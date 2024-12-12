package com.bridgelabz.wishlistservice.service;

import com.bridgelabz.wishlistservice.exception.WishlistNotFoundByIdException;
import com.bridgelabz.wishlistservice.mapper.WishlistMapper;
import com.bridgelabz.wishlistservice.model.Wishlist;
import com.bridgelabz.wishlistservice.repository.WishlistRepository;
import com.bridgelabz.wishlistservice.responsedto.WishlistResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class WishlistService {

    private final WishlistRepository wishlistRepo;
    private final WishlistMapper wishlistMapper;

    public WishlistResponse addToWishlist(long userId, long bookId) {
        Wishlist wishlist = new Wishlist();
        wishlist.setUserId(userId);
        wishlist.setBookId(bookId);
        wishlist.setAddedDate(LocalDate.now());
        wishlistRepo.save(wishlist);
        return wishlistMapper.mapToWishlistResponse(wishlist);
    }

    public List<WishlistResponse> getWishlist(long userId) {
        return wishlistRepo.findAllByUserId(userId).stream()
                .map(wishlistMapper::mapToWishlistResponse).toList();
    }


    public WishlistResponse removeFromWishlist(Long wishlistId) {
        return wishlistRepo.findById(wishlistId)
                .map(wishlist -> {
                    wishlistRepo.delete(wishlist);
                    return wishlistMapper.mapToWishlistResponse(wishlist);
                }).orElseThrow(()->new WishlistNotFoundByIdException("Failed to find wishlist"));
    }
}
