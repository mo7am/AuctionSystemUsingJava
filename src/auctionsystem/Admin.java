/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem;

import DB.DB_;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author emad
 */
public class Admin extends Staff {
    ArrayList<String>NotiContent=new ArrayList<String>();
    public Auction SearchAuction(int AuctionID,int DeptID)
    {
        return null;
    }
    public int Find_DM_Date_Order(int CountryID,int DateID)
    {

        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        int max=DB.SelectCount("User","User_ID");
        int min=DB.SelectMinimum("User","User_ID");
        ArrayList<Integer>DMIds=new ArrayList<>();
        for(int i=min;i<=max;i++)
        {
            HashMap<String,String>Result=DB.Select("User_ID","user","User_ID="+i+" and Country_ID="+CountryID+" and Type_User_id='3'");
            if(Result!=null)
            {
                DMIds.add(Integer.parseInt(Result.get("User_ID")));
            }
        }

        for(int i=0;i<DMIds.size();i++)
        {
            HashMap<String,String>Result=DB.Select("*","dm_work_table","DM_ID="+DMIds.get(i));
            if(Result==null)
            {
                return DMIds.get(i);
            }
        }

        for(int i=0;i<DMIds.size();i++)
        {
            HashMap<String,String>Result=DB.Select("*","dm_work_table","DM_ID="+DMIds.get(i) +" and DATE_ID<>"+DateID);
            if(Result!=null)
            {
                return DMIds.get(i);
            }
        }
        return -1;
    }
    public HashMap<String,Integer> Find_Bidder_Date_Order(int ItemId)
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String,Integer>H=null;
        HashMap <String,String>Result=DB.Select("*","user_avilable_time","Item_ID="+ItemId);
        if(Result!=null)
        {
        H=new HashMap<>();
        H.put("User_ID",Integer.parseInt(Result.get("User_ID")));
        H.put("Date_ID",Integer.parseInt(Result.get("Date_ID")));  
        }
        
        return H;
    }
   public boolean GiveOrder(Order order)
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap <String ,String > data = new HashMap();
        
        try {
              data.put("BidderID", "" + order.BidderID);
              data.put("AdminID", "" + order.AdminID);
              data.put("DM_ID", "" + order.DmID);
              data.put("Item_ID", "" + order.ItemID);
              data.put("Avilabletime_ID", "" + order.AvailableTime_id);
              
             DB.Insert("order_of_item", data);
             
             HashMap<String,String>Data2=new HashMap<>();
             Data2.put("DM_ID",""+order.DmID);
             Data2.put("DATE_ID",""+order.AvailableTime_id);
             DB.Insert("dm_work_table",Data2);
             
             History B=new History();
             B.DM_ID=order.DmID;
             B.Date=Sys.GetSystem().Get_Date_String(order.AvailableTime_id);
             B.ItemID=order.ItemID;
             B.User_ID=order.BidderID;
             this.MakeHistory(B);
             
             DB.Delete("user_avilable_time", "Date_ID = " + "'" +order.AvailableTime_id+ "'"+ "and User_ID = " + "'"+order.BidderID+"'");
             DB.Delete("details_Winner", "User_ID = " + "'"+order.BidderID+"'" +"and Item_ID = " + "'"+order.ItemID+"'");
           
             
             return true;
        }catch(Exception e)
        {
           
        }
        
        return false;
    }


    public ArrayList<Integer> Wait_Items()
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<Integer>Info=new ArrayList<>();
        int min=DB.SelectMinimum("user_avilable_time","ID");
        int max=DB.SelectCount("user_avilable_time","ID");
        for(int i=min;i<=max;i++)
        {
            HashMap<String,String>Result=DB.Select("*","user_avilable_time","ID="+i);
            if(Result!=null)
            {
                Info.add(Integer.parseInt(Result.get("Item_ID")));
            }
        }
        return Info;
    }
    

public History SearchHistory(int item_id)
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        History bill = new History();
        HashMap <String ,String > result = new HashMap();
        HashMap <String ,String > result2 = new HashMap();
        try{
              result = DB.Select("*", " bill ", "Item_ID = " + item_id);
              if(result !=null )
              {
                 bill.DM_ID=Integer.parseInt(result.get("DM_ID"));
                 int date = Integer.parseInt(result.get("Date_Id"));
                 result2 = DB.Select("Date", "date", "ID = "+date);
                 if(result2 != null )
                 {
                     bill.Date = result2.get("Date");
                 }
                 bill.User_ID = Integer.parseInt(result.get("User_ID"));
              }
            
              return bill;
        }catch(Exception e)
        {
           
        }
        
        return null;
    }
public boolean MakeHistory (History H)
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String ,String> data = new HashMap<>();
        HashMap<String ,String> date = new HashMap<>();
        HashMap <String , String> result = new HashMap<>();
        HashMap <String , String> result2 = new HashMap<>();
        try {
            
          data.put("Item_ID", ""+H.ItemID);
          result2 = DB.Select("ID", "date", "Date = " + "'"+H.Date+"'");
          int date_id =-1;
          if(result2!=null)
          {   date_id = Integer.parseInt(result2.get("ID"));
             
              data.put("Date_Id", ""+ date_id);
          }else
          {
             date.put("Date", H.Date);
             int id_date = DB.Insert("date", date);
             data.put("Date_Id",String.valueOf(id_date));
          }
          data.put("User_ID", ""+H.User_ID);
          data.put("DM_ID", ""+H.DM_ID);
          
            DB.Insert("bill", data);
            return true;
        }catch(Exception e)
        {
            System.err.println("Error " + e);
        }
     return false;
}
public String Attach ()
    {
         DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        
       HashMap <String , String > data = new HashMap();
       HashMap <String , String > result = new HashMap();
       
     
       try {
            result =DB.Select("Admin_ID", "Observers", "Admin_ID = " + this.ID);
           
            if(result!=null)
            {
              DB.Delete("Observers","Admin_ID="+this.ID);
              return "You Deleted Yourself from Manager Notification ";
            }else{
                data.put("Admin_ID", ""+this.ID);
                DB.Insert("Observers", data);
            }
           return "You Added yourself to Manager Notification";
       }catch(Exception e)
       {
          
       }
       return "";
    }

public int IsStateChanged()
{
    DB_ DB=DB_.Get_DB_controller();
    DB.Connect();
    HashMap<String,String> Result=DB.Select("Observer_id","observer","User_ID="+this.ID +" and State_id=2");
    if(Result!=null)
        return 1;
    else return 0;
}
 public String GetContent()
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        
       HashMap <String , String > result = new HashMap();
       HashMap <String , String > result2 = new HashMap();
       
     
       try {
           
             String state="Seen";
            int state_id=-1;
             result2 = DB.Select("State_id", "state", "State =" +"'"+state+"'");
             if(result2!=null)
             {
               state_id = Integer.parseInt(result2.get("State_id"));
             }
           result = DB.Select("Content", "Observer", "User_ID = " + this.ID +" and State_id=2");
           String Content = null;
           if(result!=null )
           {
               Content = result.get("Content");
           }
           DB.Update("Observer", "State_id = " +state_id , "User_ID = " + this.ID);
          return Content; 
       }catch(Exception e)
       {
          
       }
       return null;
    }
    
    

}
