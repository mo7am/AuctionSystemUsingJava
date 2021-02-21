package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import auctionsystem.Seller;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author emad
 */
public class SellerGUI extends ManagerHome{
    private Seller seller=null;
    public SellerGUI(Seller S)
    {
        super();
        this.seller=S;
        this.First.setText("My Items");
     this.Second.setText("Add Item");
     this.Third.setText("Search Item");
     this.Fourth.setText("Make Feedback");
     this.Sixth.setVisible(false);
 
    }
    

    @Override
    public void FirstActionPerformed(ActionEvent evt) {
        this.ManagerView.removeAll();
        this.ManagerView.revalidate();
        this.ManagerView.repaint();
        MyItems B=new MyItems(this.seller);
        B.setVisible(true);
        this.ManagerView.add(B);        
    }
    @Override
    public void SecondActionPerformed(ActionEvent evt)
    {
        this.ManagerView.removeAll();
        this.ManagerView.revalidate();
        this.ManagerView.repaint();
        AddItem A=new AddItem(this.seller);
        A.setVisible(true);
        this.ManagerView.add(A);
    }
    public void ThirdActionPerformed(ActionEvent evt)
    {
        this.ManagerView.removeAll();
        this.ManagerView.revalidate();
        this.ManagerView.repaint();
        SearchItem1 A=new SearchItem1(this.seller,1);
        A.setVisible(true);
        this.ManagerView.add(A);
    }
    public void FourthActionPerformed(ActionEvent evt)
    {
        this.ManagerView.removeAll();
        this.ManagerView.revalidate();
        this.ManagerView.repaint();
        FeedbackGUI A=new FeedbackGUI(this.seller);
        A.setVisible(true);
        this.ManagerView.add(A);
    }

    public void SixthActionPerformed(ActionEvent evt)
    {
        super.FifthActionPerformed(evt);
    }
    public void SeventhActionPerformed(ActionEvent evt) {
        //To change body of generated methods, choose Tools | Templates.
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        Profile S=new Profile(this.seller);
        this.ManagerView.add(S);
        S.setVisible(true);        
    }    
    public void MessageMouseClicked(java.awt.event.MouseEvent evt) {  
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        MessageG M=new MessageG(this.seller);
        this.ManagerView.add(M);
        M.setVisible(true);        
    }  
    public void FifthActionPerformed(java.awt.event.ActionEvent evt) {                                      
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        Charge S=new Charge(this.seller);
        this.ManagerView.add(S);
        S.setVisible(true);
    }    
    @Override
    public void jLabel4MouseClicked(MouseEvent evt) {
        this.ManagerView.removeAll();
        this.ManagerView.repaint();
        this.ManagerView.revalidate();
        Notification S=new Notification(this.seller.ID,1);
        this.ManagerView.add(S);
        S.setVisible(true);
    }    
}
