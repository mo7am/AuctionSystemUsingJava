/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import GUI.ManagerHome;
import auctionsystem.Sys;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emad
 */
public class ThreadMessage extends Thread{
    private int PersonID;
    public ThreadMessage(int id)
    {
        this.PersonID=id;
    }
    
    @Override
    public void run()
    {
                    int i=0;
        while(true)
        {
            i=Sys.GetSystem().MyMessagesNumber(this.PersonID);
            ManagerHome.jLabel7.setText(""+i);
                        try {
                            this.sleep(5000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ThreadMessage.class.getName()).log(Level.SEVERE, null, ex);
                        }
        }
    }
}
