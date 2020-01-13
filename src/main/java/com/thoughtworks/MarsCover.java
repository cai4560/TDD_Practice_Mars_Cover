package com.thoughtworks;

import com.thoughtworks.model.Context;

public class MarsCover {

    private Context context;

    public MarsCover(Context context) {
        this.context = context;
    }

    public void move() {
        context.executeMove();
    }

    public Context getContext() {
        return context;
    }
}
