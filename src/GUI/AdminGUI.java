/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import auctionsystem.Admin;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author emad
 */
public class AdminGUI extends ManagerHome{
    private Admin admin;
    public AdminGUI(Admin A)
    {
        super();
        this.admin=A;
        this.Sixth.setText("Manager Notif");
        //Admin Type
     this.First.setText("Wait Items");
     /*msh common*/this.Second.setText("Search Auction");
     /*msh common*/this.Third.setText("Give Task");
     /*msh common*/this.Fourth.setText("History");
     this.Seventh.setText("Update Profile");
     this.Noti.setText("0");
     //Other
    }

    @Override
    public void FirstActionPerformed(ActionEvent evt) {
        ArrayList<Integer> Info=this.admin.Wait_Items();
        
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        WaitItems S=new WaitItems(Info);
        this.ManagerView.add(S);
        S.setVisible(true);        
    }
    @Override
    public void SecondActionPerformed(ActionEvent evt)
    {
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        SearchAuction S=new SearchAuction(this.admin);
        this.ManagerView.add(S);
        S.setVisible(true);
    }
    public void ThirdActionPerformed(ActionEvent evt)
    {
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        GiveOrder S=new GiveOrder(this.admin);
        this.ManagerView.add(S);
        S.setVisible(true);
    }
    public void FourthActionPerformed(ActionEvent evt)
    {
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        Review S=new Review(this.admin);
        this.ManagerView.add(S);
        S.setVisible(true);
    }

    public void SixthActionPerformed(ActionEvent evt)
    {
            JOptionPane.showMessageDialog(null,this.admin.Attach());
    }
    public void SeventhActionPerformed(ActionEvent evt) {
        //To change body of generated methods, choose Tools | Templates.
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        Profile S=new Profile(this.admin);
        this.ManagerView.add(S);
        S.setVisible(true);        
    }
    public void MessageMouseClicked(java.awt.event.MouseEvent evt) {  
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        MessageG M=new MessageG(this.admin);
        this.ManagerView.add(M);
        M.setVisible(true);        
    }    
    @Override
    public void FifthActionPerformed(java.awt.event.ActionEvent evt) {  

        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        Charge S=new Charge(this.admin);
        this.ManagerView.add(S);
        S.setVisible(true);
    }  

    @Override
    public void jLabel4MouseClicked(MouseEvent evt) {
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        Notification S=new Notification(this.admin);
        this.ManagerView.add(S);
        S.setVisible(true);
    }

}
