/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;


import auctionsystem.Sys;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emad
 */
public class ThreadCheckSessions extends Thread{
    public ThreadCheckSessions()
    {
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            Sys.GetSystem().CheckSessionForReserved();
            Sys.GetSystem().CheckSessionForNonReserved();
                        try {
                            this.sleep(5000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ThreadMessage.class.getName()).log(Level.SEVERE, null, ex);
                        }
        }
    }
}
