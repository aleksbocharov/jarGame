package com.teamtreehouse;

import java.util.Random;

public class Jar {
    private String mItemName;
    private int mMaxQuantity;
    private int mItemsQuantity;

    public Jar(String itemName, int maxQuantity) {
        mItemName = itemName;
        mMaxQuantity = maxQuantity;
    }

    public Jar generateQuantity() {
        Random rand = new Random();
        mItemsQuantity = rand.nextInt(mMaxQuantity-1)+1;
        return this;
    }

    public String getItemName() {
        return mItemName;
    }

    public int getMaxQuantity() {
        return mMaxQuantity;
    }

    public int getItemsQuantity() {
        return mItemsQuantity;
    }

}
