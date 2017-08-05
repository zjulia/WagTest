package com.apps.zhaojulia.wagtest.Utils;

import java.util.List;

/**
 * Created by admin on 8/5/17.
 */

public class ListWrapper<T> {
    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}