package com.thoughtworks;

@SuppressWarnings("unused")
public class MarsCover {

    private Context context;

    public MarsCover(Context context) {
        this.context = context;
    }

    public void move() {
        context.executeMove();
    }

    public String print() {
        return context.executePrint();
    }
}
