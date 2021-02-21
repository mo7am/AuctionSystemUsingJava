/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author emad
 */
public class Actor extends Staff{
    HashMap<String,String> AddidtionalAttributes;
    ArrayList<Integer> Functionalites;
    public Actor(HashMap<String,String> AddidtionalAttributes,ArrayList<Integer> Functionalites)
    {
        this.AddidtionalAttributes=AddidtionalAttributes;
        this.Functionalites=Functionalites;
    }
}
