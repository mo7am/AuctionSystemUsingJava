/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import auctionsystem.DM;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author emad
 */
public class DMGUI extends ManagerHome{
    private DM dm;
    public DMGUI(DM M)
    {
        super();

        this.dm=M;
        this.Second.setVisible(false);
        this.First.setVisible(false);
        this.Third.setVisible(false);
        this.Fourth.setText("Submit Order");
        this.Sixth.setVisible(false);
    }


    @Override
    public void FourthActionPerformed(ActionEvent evt) {
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        SubmitOrder S=new SubmitOrder(this.dm);
        this.ManagerView.add(S);
        S.setVisible(true);            
    }
    public void SeventhActionPerformed(ActionEvent evt) {
        //To change body of generated methods, choose Tools | Templates.
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        Profile S=new Profile(this.dm);
        this.ManagerView.add(S);
        S.setVisible(true);        
    }
    @Override
    public void FifthActionPerformed(java.awt.event.ActionEvent evt) {  
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        Charge S=new Charge(this.dm);
        this.ManagerView.add(S);
        S.setVisible(true);
    }    
    public void MessageMouseClicked(java.awt.event.MouseEvent evt) {  
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        MessageG M=new MessageG(this.dm);
        this.ManagerView.add(M);
        M.setVisible(true);        
    }   
    @Override
    public void jLabel4MouseClicked(MouseEvent evt) {
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        Notification S=new Notification(this.dm.ID,2);
        this.ManagerView.add(S);
        S.setVisible(true);
    }    
}
