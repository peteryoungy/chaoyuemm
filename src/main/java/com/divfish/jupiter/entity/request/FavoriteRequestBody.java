package com.divfish.jupiter.entity.request;

import com.divfish.jupiter.entity.db.Item;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FavoriteRequestBody {
    private final Item favoriteItem;

    @JsonCreator
    public FavoriteRequestBody(@JsonProperty("favorite") Item favoriteItem) {
        this.favoriteItem = favoriteItem;
    }

    public Item getFavoriteItem() {
        return favoriteItem;
    }
}

