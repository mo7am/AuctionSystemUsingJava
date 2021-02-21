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
public class Creditcard implements I_PaymentMethod{

    public int ID;
    public String Name;
    public int CardNumber;
    public int CVV;
    public String Date_Of_Expire;
    @Override
public double Charge(double Money) {
        
        return Money-10;
    }
    
}
