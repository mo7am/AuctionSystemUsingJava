/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import auctionsystem.Bidder;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author emad
 */
public class BidderGUI extends ManagerHome{
    private Bidder bidder=null;
    public BidderGUI(Bidder B)
    {
        super();
        this.bidder=B;
        
     this.Third.setText("Search Item");
     this.Sixth.setText("Make Feedback");        
        this.First.setText("Suitable Time");
        this.Second.setText("My Items");
        this.Fourth.setVisible(true);
        this.Fourth.setText("Update Price");

        
    }

    @Override
    public void FirstActionPerformed(ActionEvent evt) {
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        EnterDate D=new EnterDate(this.bidder);
        this.ManagerView.add(D);
        D.setVisible(true);
    }

    @Override
    public void SecondActionPerformed(ActionEvent evt)
    {
        this.ManagerView.removeAll();
        this.ManagerView.revalidate();
        this.ManagerView.repaint();
        MyItems B=new MyItems(this.bidder);
        B.setVisible(true);
        this.ManagerView.add(B);        
    }    
    public void ThirdActionPerformed(ActionEvent evt)
    {
        this.ManagerView.removeAll();
        this.ManagerView.revalidate();
        this.ManagerView.repaint();
        SearchItem1 A=new SearchItem1(this.bidder,0);
        A.setVisible(true);
        this.ManagerView.add(A);
    }
    public void FourthActionPerformed(ActionEvent evt)
    {

    }
    public void FifthActionPerformed(java.awt.event.ActionEvent evt) {                                      
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        Charge S=new Charge(this.bidder);
        this.ManagerView.add(S);
        S.setVisible(true);
    }     
    public void SixthActionPerformed(ActionEvent evt)
    {
        this.ManagerView.removeAll();
        this.ManagerView.revalidate();
        this.ManagerView.repaint();
        FeedbackGUI A=new FeedbackGUI(this.bidder);
        A.setVisible(true);
        this.ManagerView.add(A);
    }

    @Override
    public void SeventhActionPerformed(ActionEvent evt) {
        //To change body of generated methods, choose Tools | Templates.
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        Profile S=new Profile(this.bidder);
        this.ManagerView.add(S);
        S.setVisible(true);        
    }
    
    public void MessageMouseClicked(java.awt.event.MouseEvent evt) {  
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        MessageG M=new MessageG(this.bidder);
        this.ManagerView.add(M);
        M.setVisible(true);        
    }   

    @Override
    public void jLabel4MouseClicked(MouseEvent evt) {
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        Notification S=new Notification(this.bidder.ID,0);
        this.ManagerView.add(S);
        S.setVisible(true);
    }
}
