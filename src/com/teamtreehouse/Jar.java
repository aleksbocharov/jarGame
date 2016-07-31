package com.teamtreehouse;

import java.util.Random;

/**
 * Created by User on 26-Jul-16.
 */
public class Jar {
    private String mItemName;
    private int mMaxQuantity;
    private int mItemsQuantity;

    public Jar(String itemName, int maxQuantity) {
        mItemName = itemName;
        mMaxQuantity = maxQuantity;
        mItemsQuantity = generateQuantity();
    }

    public String getItemName() {
        return mItemName;
    }

    public int getMaxQuantity() {
        return mMaxQuantity;
    }

    private int generateQuantity() {
        Random rand = new Random();
        int quantity = rand.nextInt(mMaxQuantity-1)+1;
        return quantity;
    }

    public int getItemsQuantity() {
        return mItemsQuantity;
    }

    public void printInfo(){
        System.out.println("Max quantity: " + mMaxQuantity);
        System.out.println("Guess quantity: " + mItemsQuantity);
    }
}
