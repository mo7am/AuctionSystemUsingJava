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
public class UserDecorator implements I_Decorator{
    protected User User;

    public UserDecorator(User User) 
    {
        this.User=User;
    }

    @Override
    public void Profits() {
    }
    
}
