package com.bridgelabz.wishlistservice.mapper;


import com.bridgelabz.wishlistservice.model.Wishlist;
import com.bridgelabz.wishlistservice.responsedto.WishlistResponse;
import org.springframework.stereotype.Component;

@Component
public class WishlistMapper {

    public WishlistResponse mapToWishlistResponse(Wishlist wishlist) {
        WishlistResponse wishlistResponse = new WishlistResponse();
        wishlistResponse.setId(wishlist.getId());
        wishlistResponse.setBookId(wishlist.getBookId());
        wishlistResponse.setUserId(wishlist.getUserId());
        wishlistResponse.setAddedDate(wishlist.getAddedDate());
        return wishlistResponse;
    }
}
