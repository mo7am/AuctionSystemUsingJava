/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem;

/**
 *
 * @author emad
 */
public class Item {
    public Item(float Wieght,int DateOfUsage,double MinimumPrice)
    {
        this.DateOfUsage=DateOfUsage;
        this.MinimumPrice=MinimumPrice;
        this.Wieght=Wieght;
    }
    private float Wieght;
    private int DateOfUsage;
    private double MinimumPrice;



    public int getDateOfUsage() {
        return DateOfUsage;
    }
    public double getMinimumPrice() {
        return MinimumPrice;
    }

    public float getWieght() {
        return Wieght;
    }
    
}
