package Threads;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import GUI.LoginFrame;
import GUI.ManagerHome;
import javax.swing.JOptionPane;

/**
 *
 * @author emad
 */
public class ThreadTimer extends Thread{
    static int time;
    static int flag;
    public ThreadTimer()
    {
        
    }
    @Override
    public void run()
    {
        for(int i=0;i<500;i++)
        {
                this.time++;
                ManagerHome.Timer.setText("      Time : "+this.time+" Sec");            
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
        JOptionPane.showMessageDialog(new LoginFrame(), "Your Session Finished"+System.lineSeparator()+"App Will Close");        
        System.exit(0);
    }
}
