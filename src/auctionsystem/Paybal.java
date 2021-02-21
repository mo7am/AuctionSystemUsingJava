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
public class Paybal implements I_PaymentMethod{

    public int ID;
    public String Mail;
    public String Password;
    @Override
public double Charge(double Money) {
        return Money-8;
    }
    
}
