/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 *
 * @author emad
 */
public class AddActor2 extends JInternalFrame{
        BasicArrowButton B=new BasicArrowButton(BasicArrowButton.EAST); 
        JButton  Submit=new JButton("Submit");
        ArrayList<String> Labels=new ArrayList<String>();
        ArrayList<String> Values=new ArrayList<String>();        
        JPanel All;
        static public int size;
        static public int x;        
        int Flag ;
                ArrayList<JTextField> T=new ArrayList<>();

    public AddActor2(ArrayList<String> Labels,ArrayList<String>Values,int x,int Flag)
    {
        this.Flag=Flag;
      ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);        
        this.x+=x;
        this.Labels=Labels;
        this.Values=Values;
        this.setSize(512,500);
        //this.setBounds(100, 100, 100, 100);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);  
        All=new JPanel(new GridLayout(11,1));
        All.setSize(510, 500);
        All.setBackground(Color.GRAY);

        //P.setBounds(50, 100, 200, 200);
        try
        {
        for(int i=this.x;i<this.x+10;i++)
        {
            JPanel P=new JPanel(new GridLayout(1,2));
            P.setBackground(Color.GRAY);
            JLabel B=new JLabel(Labels.get(i));
            JTextField R=new JTextField(Values.get(i));
            R.setFont(R.getFont().deriveFont(Font.BOLD, 14f));
            if(this.Flag==1)
            {
                R.setEditable(false);
            }
            R.setBackground(Color.LIGHT_GRAY);
            P.add(B);
            P.add(R);
            T.add(R);
            All.add(P);
            size=size+1;
            System.out.println(x);
        }
        }
        catch(Exception E)
                {
                size=Labels.size();
                }

        System.out.println(Labels.size()+"  "+size);
        if(size!=Labels.size())
        {
        B.setBounds(460,450, 30, 30);
        B.setBackground(Color.BLACK);
        this.add(B);
        this.B.addActionListener(new handler()); 
        }
        else
        {
            size=0;
            System.out.println(Flag);
            if(Flag==0)
            {
        Submit.setBackground(Color.BLACK); 
        Submit.setBounds(100, 100, 100, 100);
            this.All.add(Submit);
            }

        }
        
        this.add(All);
    }
public class handler implements ActionListener
{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            if(x.equals(B))
            {
                ManagerHome.ManagerView.removeAll();
                ManagerHome.ManagerView.repaint();
                ManagerHome.ManagerView.revalidate();
                AddActor2 C=new AddActor2(Labels,Values,10,Flag);
                ManagerHome.ManagerView.add(C);
                C.setVisible(true);
            }
        }
    
}      
    
}
