/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem;

import DB.DB_;
import java.util.HashMap;

/**
 *
 * @author emad
 */
public class DM extends Staff{
    String Region;
    
public Order OrderDetails(int Order_id)
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        
        HashMap <String , String> result = new HashMap<>();
        Order order = new Order();
        try {
              result = DB.Select("*", "order_of_item", "ID =" + Order_id);
              int DM_id=-1;
              if(result !=null)
              {
                 DM_id = Integer.parseInt(result.get("DM_ID"));
                 
              }
              if(DM_id != this.ID)
              {
                  return null;
              }  
              else{
                
                  
                  order.BidderID =Integer.parseInt(result.get("BidderID"));
                  order.AdminID = Integer.parseInt(result.get("AdminID"));
                  order.DmID = Integer.parseInt(result.get("DM_ID"));
                  order.AvailableTime_id = Integer.parseInt(result.get("Avilabletime_ID"));
                  order.ItemID = Integer.parseInt(result.get("Item_ID"));

              }
              
              return order;
        }catch(Exception e)
        {
          
        }
        return null;
    }
public boolean OrderDone (int order_ID)
   {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
      
        HashMap <String , String> result = new HashMap<>();
        HashMap <String , String> result2 = new HashMap<>();
        try {
             result = DB.Select("*", "order_of_item", "ID = " + order_ID);
             int DM_id = -1;
             int date_id =-1;
             if(result !=null)
             {
                DM_id = Integer.parseInt(result.get("DM_ID"));
                date_id = Integer.parseInt(result.get("Avilabletime_ID"));
             }
             if(DM_id != this.ID)
             {
                 return false;
             }else{
                 DB.Delete("order_of_item", "ID = " +order_ID);
                 DB.Delete("dm_work_table", "DATE_ID = " + "'"+date_id+"'" +"and DM_ID = " + "'"+DM_id+"'");
                 
                 result2 = DB.Select("Balance", "user", "User_ID = " + this.ID);
                 float balance = -1;
                 if(result2 != null)
                 {
                    balance = Float.parseFloat(result2.get("Balance"));
                 }
                 
                 float newbalance = balance + 20;
                 DB.Update("user", "Balance = " + newbalance , "User_ID = " + this.ID);
             }
             return true;
        }catch(Exception e)
        {
            System.err.println("Error " + e);
        }
            
          return false;  
   }
}
