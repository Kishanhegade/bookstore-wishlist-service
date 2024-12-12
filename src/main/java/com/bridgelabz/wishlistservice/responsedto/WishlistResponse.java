package com.bridgelabz.wishlistservice.responsedto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class WishlistResponse {

    private Long id;

    private long userId;

    private long bookId;

    private LocalDate addedDate;
}
