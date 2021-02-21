/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import GUI.ManagerHome;
import auctionsystem.Admin;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emad
 */
public class ThreadNotificationAdmin extends Thread{
    private Admin admin;
    public ThreadNotificationAdmin(Admin A)
    {
        this.admin=A;
    }
    
    @Override
    public void run()
    {
                    int i=0;
        while(true)
        {
            i=this.admin.IsStateChanged();
            ManagerHome.Noti.setText(""+i);
                        try {
                            this.sleep(5000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ThreadMessage.class.getName()).log(Level.SEVERE, null, ex);
                        }
        }
    }
}
