/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem;

import GUI.LoginFrame;
import Validation.Validation;
import java.util.ArrayList;



/**
 *
 * @author emad
 */
public class AuctionSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        LoginFrame L=new LoginFrame();
        L.setVisible(true);
        //Validation V=Validation.Get_Validation_Instance();
        System.out.println(Validation.Get_Validation_Instance().Is_Emil("mohamed@yahoo.com"));
        //S.CheckSessionForReserved();
        //System.out.println(Validation.Get_Validation_Instance().Is_Date("1995-07-05"));
// Output "2012-09-26"       Manager M=new Manager();
  /*     HashMap <String,String>H=M.OthersPersonTable(4);
       for(Map.Entry<String,String>entry:H.entrySet())
       {
           System.out.println(entry.getKey()+" "+entry.getValue());
       }
*/
        ArrayList<Integer>s=new  ArrayList<>();
    }




}
