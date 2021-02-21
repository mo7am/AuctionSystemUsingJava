package Threads;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import GUI.ManagerHome;
import GUI.ManagerHome;
import auctionsystem.Sys;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author emad
 */
public class ThreadBalance extends Thread{
    private int PersonID;
    public ThreadBalance(int Personid)
    {
        this.PersonID=Personid;
    }
    @Override
    public void run()
    {
        while(true)
        {
            try {
                double Balance=Sys.GetSystem().Get_Balance(PersonID);
                ManagerHome.Balance.setText("   My Balance: "+Balance);
                this.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadBalance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
